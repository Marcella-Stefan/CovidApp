package bitsplease;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;

/**
  * This class describe an <i>account</i> of a user and also contains the methods in order to find the contacts of 
  * a case and send them @see Email
  */
public class Account {

    private String id;
    private String email;
    private String pass;

    private final Connection conn = getConnection();

    /**
     * Account constructor with all fields as parameters.
     * @param id the ID of the person that own the Account.
     * @param email the Email of the person that own the Account.
     * @param pass the Account password.
     */
    public Account(String id, String email, String pass) {
	this.id = id;
	this.email = email;
	this.pass = pass;
    }

    /**
     * Get the ID of the person that own the Account.
     * @return the ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Get the Email of the person that own the Account.
     * @return the Email.
     */
    public String getEmail() {
        return email;
    }

    //Default so that none can access the passwords outside of the package.
    /**
     * Get the password of the Account.
     * @return the password.
     */
    String getPass() {
        return pass;
    }

    /**
     * Get a Connection for the Database.
     * @return a reference to a Connection object for our database.
     */
    public static Connection getConnection() {
        try {
            Connection myConn = DriverManager.getConnection(
                    "jdbc:mysql://bx5dhcaayjasymxlbqnv-mysql.services.clever-cloud.com:3306/bx5dhcaayjasymxlbqnv", 
                    "upgqdkjbuxi1rzhv", "MjK3Kurgj39wpP8wIpAu");
            return myConn;
        } catch (SQLException e) {
            //This error will occur if we run the program without internet connection.
            JOptionPane.showMessageDialog(null, "Unable to connect to the database!","Error",2);
            System.exit(1);
        } 
        return null;
    }

    /** 
     * Finds all the entries of the case.
     * @return a ResultSet that contains all the entries of the case.
     * @throws SQLException throws SQLException.
     */
    public ResultSet getCaseEntries() throws SQLException {
    	Statement myStmt = conn.createStatement();
	ResultSet myRs = myStmt.executeQuery("select * from EntryInfos where id = '" + id + "'");
	return myRs;
    }

    // The lines of the query are bigger than it should because we don't want to break 
    // the logic, its already complicated enough.
    /** Finds all the contacts of a single case entry.
     * @return a PreparedStatement that can be used to find all the contacts of a single case entry.
     * @throws SQLException throws SQLException.
     */
    public PreparedStatement getEntryContacts() throws SQLException {
        //The HOUR(TIMEDIFF('Datetime', 'Datetime')) >= 1 is needed in case the contact is exactly 1, 2, 3 hours etc...
        PreparedStatement myStmt = conn.prepareStatement("SELECT Email FROM EntryInfos WHERE (id != ? AND place = ? AND address = ? AND TK = ? AND ("
		    	+ "( ArrivalTime < ? AND DepartureTime > ? AND ( MINUTE(TIMEDIFF(DepartureTime, ?)) >= 1 OR HOUR(TIMEDIFF(DepartureTime, ?)) >= 1 ) ) OR\r\n"
		    	+ "( DepartureTime > ? AND ArrivalTime < ? AND ( MINUTE(TIMEDIFF(?, ArrivalTime)) >= 1 OR HOUR(TIMEDIFF(?, ArrivalTime)) >= 1 ) ) OR\r\n"
		    	+ "( ( ArrivalTime BETWEEN ? AND ?) AND ( DepartureTime BETWEEN ? AND ? ) AND\r\n"
		    	+ "( MINUTE(TIMEDIFF(ArrivalTime, DepartureTime)) >= 1 OR HOUR(TIMEDIFF(ArrivalTime, DepartureTime)) >= 1 ) )\r\n"
		    	+ ") )");
    	return myStmt;
    }

    /** Initialize the PreparedStatement of @see #getEntryContacts method.
     * @param myStmt the PreparedStatement of @see #getEntryContacts method.
     * @param id the ID of the person that owns the account.
     * @param place the place that the user of the account has been.
     * @param address the address of the place that the user of the account has been.
     * @param tk the postal code of the address.
     * @param arrivalTime the time that the user of the account arrived at that place.
     * @param departureTime the time that the user of the account leave that place.
     * @throws SQLException throws SQLException.
     */
    public void initPrepStmt(PreparedStatement myStmt, String id, String place, String address, int tk,
    		String arrivalTime, String departureTime) throws SQLException {

    	myStmt.setString(1, id);
    	myStmt.setString(2, place);
    	myStmt.setString(3, address);
    	myStmt.setInt(4, tk);
    	myStmt.setString(5, arrivalTime);
    	myStmt.setString(6, arrivalTime);
    	myStmt.setString(7, arrivalTime);
    	myStmt.setString(8, arrivalTime);
    	myStmt.setString(9, departureTime);
    	myStmt.setString(10, departureTime);
    	myStmt.setString(11, departureTime);
    	myStmt.setString(12, departureTime);
    	myStmt.setString(13, arrivalTime);
    	myStmt.setString(14, departureTime);
    	myStmt.setString(15, arrivalTime);
    	myStmt.setString(16, departureTime);
    }

    /** 
     * Adds to the given list the emails from the given ResultSet.
     * @param rs a ResultSet that contains the mails of the contacts from a single case entry.
     * @param emails a list to which we will add the mails of the ResultSet.
     * @return the list it receives with the mails from the ResultSet added.
     * @throws SQLException throws SQLException.
     */
    public List<String> addEmailsOfContacts(ResultSet rs, List<String> emails) throws SQLException {
    	while(rs.next()) {
            emails.add(rs.getString("email"));
    	}
    	return emails;
    }

    /**
     * Loops through every entry of the case, find its contacts @see #getEntryContacts and
     * add their emails in a list @see #addEmailsOfContacts.
     * @param myRs a ResultSet that contains all the entries of the case @see #getCaseEntries.
     * @return a list that contains the mails of all the users that had contacts with the case.
     * @throws SQLException throws SQLException.
     */
    public List<String> getEmailOfContacts(ResultSet myRs) throws SQLException {
    	List<String> emails = new ArrayList<>();
        PreparedStatement myStmt = getEntryContacts();

	    while (myRs.next()) {
	    	//It takes the data from each entry of the case etries in order to init the preparedStmt.
	    	String id = myRs.getString("id");
	    	String place = myRs.getString("place");
	    	String address = myRs.getString("address");
	    	int tk = myRs.getInt("tk");
	    	String arrivalTime = myRs.getString("ArrivalTime");
	    	String departureTime = myRs.getString("DepartureTime");

	    	initPrepStmt(myStmt, id, place, address, tk, arrivalTime, departureTime);

	    	ResultSet currEntryContEmails = (myStmt.executeQuery());

	    	addEmailsOfContacts(currEntryContEmails, emails);
	    }
	    return emails;
    }

    /**
     * Remove the duplicate emails from the given list.
     * @param emails a list that contain all the mails of the case contacts.
     * @return the list it receives without duplicates.
     */
    public List<String> removeDuplicateEmails(List<String> emails) {
    	List<String> emailsWithoutDuplicates = emails.stream()
	    	     .distinct()
	    	     .collect(Collectors.toList());
    	return emailsWithoutDuplicates;
    }

    /**
     * Shows a message if the list is empty.
     * @param emailsOfContacts a list that contains the email of the users that had contacts with a case.
     */
    public void messageIfNoContacts(List<String> emailsOfContacts) {
        if (emailsOfContacts.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You haven't contact with any of our registered members!\n                         Thank you for help!");
            System.exit(0);
        }
    }

    /**
     * Get the subject of the informative email.
     * @return the email subject.
     */
    public String mailSubject() {
        return "CovidApp Warning";
    }

    /**
     * Contain the body of the informative email.
     * @return the email body.
     */
    public String mailBody() {
        return "Dear user,\n"
                + "With this email we would like to inform you that you have probably been "
                + "in contact with a confirmed case of COVID-19. As we cannot know your "
                + "exact degree of exposure to the virus, we would suggest that you get "
                + "tested for SARS-CoV-2.\n"
                + "Thank you for the preference.";
    }

    /** 
     * Sends the emails to the contacts of the case.
     * @param emailsWithoutDuplicates a list that contain the emails without duplicates.
     * @throws AddressException throws AddressException.
     * @throws MessagingException throws MessagingException.
     */
    public void sendInformativeEmails(List<String> emailsWithoutDuplicates) 
            throws AddressException, MessagingException {
    	Email mail = new Email(emailsWithoutDuplicates);
	mail.setupServerProperties();
	mail.draftEmail(mailSubject(), mailBody());
	mail.sendEmail();
    }

    /**
     * Closes the Connection with the Database.
     */
    public void closeConnection() {
        try {
           conn.close();
       } catch (SQLException e) {

       }
    }

    /**
     * This method call all the other methods of the Class with the right order to achieve the desired result.
     * (Inform all the users that had contacts with a case).
     */
    public void testedPositive() {
    	try {
            ResultSet caseEntries = getCaseEntries();
            List<String> emailsOfContacts = getEmailOfContacts(caseEntries);
            messageIfNoContacts(emailsOfContacts);
            List<String> emailsWithoutDuplicates = removeDuplicateEmails(emailsOfContacts);
            sendInformativeEmails(emailsWithoutDuplicates);
            closeConnection();
        } catch (SQLException e) {

	} catch (MessagingException e) {

	} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "We are sorry, something went wrong!","Error",2);
            //exit(0) is used when we close the program without having an error.
            System.exit(1);
	}
    }
}