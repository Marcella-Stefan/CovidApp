package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;  
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Account {

    private String id;
    private String email;
    private String pass;

    public Account(String id, String email, String pass) {
	this.email = email;
	this.id = id;
	this.pass = pass;
    }

    public String getId() {
	return id;
    }

    public String getEmail() {
	return email;
    }

    public String getPass() {
	return pass;
    }

    public static Connection getConnection() {
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "papajohn");
            return myConn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to connect to the database!","Error",2);
            System.exit(1);
        } 
        return null;
    }

    public ResultSet getCaseEntries() throws SQLException {
    	Statement myStmt = getConnection().createStatement();
	    ResultSet myRs = myStmt.executeQuery("select * from EntryInfos2 where id = '" + id + "'");
	    return myRs;
    }

    public List<String> getEmailOfContacts(ResultSet myRs) throws SQLException {
    	List<String> emails = new ArrayList<>();

    	PreparedStatement myStmt2 = getConnection().prepareStatement("select Email from EntryInfos2 where (id != ? and place = ? and address = ? and TK = ? and "
	    		+ "( ( ArrivalTime < ? AND DepartureTime > ? AND ( MINUTE(TIMEDIFF(DepartureTime, ?)) >=10 OR HOUR(TIMEDIFF(DepartureTime, ?)) >= 1 ) ) OR\r\n" + 
	    		"( DepartureTime > ? AND ArrivalTime < ? AND ( MINUTE(TIMEDIFF(?, ArrivalTime)) >=10 OR HOUR(TIMEDIFF(?, ArrivalTime)) >= 1 ) ) OR\r\n" + 
	    		"( ( ArrivalTime BETWEEN ? AND ?) AND ( DepartureTime BETWEEN ? AND ? ) "
	    		+ "AND ( MINUTE(TIMEDIFF(ArrivalTime, DepartureTime)) >=10 OR HOUR(TIMEDIFF(ArrivalTime, DepartureTime)) >= 1 ) )\r\n" + 
	    		" ) )");

	    while (myRs.next()) {

	    	//I take the data from every entry of the case and put them at the suitable ?
	    	String id = myRs.getString("id");
	    	String place = myRs.getString("place");
	    	String address = myRs.getString("address");
	    	int tk = myRs.getInt("tk");
	    	String arrivalTime = myRs.getString("ArrivalTime");
	    	String departureTime = myRs.getString("DepartureTime");
	    	System.out.println(arrivalTime);
	    	System.out.println(departureTime);
	    	myStmt2.setString(1, id);
	    	myStmt2.setString(2, place);
	    	myStmt2.setString(3, address);
	    	myStmt2.setInt(4, tk);
	    	myStmt2.setString(5, arrivalTime);
	    	myStmt2.setString(6, arrivalTime);
	    	myStmt2.setString(7, arrivalTime);
	    	myStmt2.setString(8, arrivalTime);
	    	myStmt2.setString(9, departureTime);
	    	myStmt2.setString(10, departureTime);
	    	myStmt2.setString(11, departureTime);
	    	myStmt2.setString(12, departureTime);
	    	myStmt2.setString(13, arrivalTime);
	    	myStmt2.setString(14, departureTime);
	    	myStmt2.setString(15, arrivalTime);
	    	myStmt2.setString(16, departureTime);
	    	ResultSet names2 = (myStmt2.executeQuery());

	    	addEmailsOfContacts(names2, emails);
	    }
	    return emails;
    }

    public List<String> addEmailsOfContacts(ResultSet rs, List<String> emails) throws SQLException {
    	while(rs.next()) {
    		emails.add(rs.getString("email"));
    	}
    	return emails;
    }

    public List<String> removeDuplicateEmails(List<String> emails) {
    	List<String> emailsWithoutDuplicates = emails.stream()
	    	     .distinct()
	    	     .collect(Collectors.toList());
    	return emailsWithoutDuplicates;
    }

    public void sendInformativeEmails(List<String> emailsWithoutDuplicates) throws AddressException, MessagingException {
    	Email mail = new Email(emailsWithoutDuplicates);
	    mail.setupServerProperties();
		mail.draftEmail();
		mail.sendEmail();
    }

    public void testedPossitive() {
    	try {
			ResultSet caseEntries = getCaseEntries();
			List<String> emailsOfContacts = getEmailOfContacts(caseEntries);
			List<String> emailsWithoutDuplicates = removeDuplicateEmails(emailsOfContacts);
			for (int j = 0 ; j < emailsWithoutDuplicates.size() ; j++) {
		    	System.out.println(emailsWithoutDuplicates.get(j));
		    }
			sendInformativeEmails(emailsWithoutDuplicates);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
    		e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
