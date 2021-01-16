package bitsplease;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;

/**
 * This class send the emails every 5 minutes.
 */
public class EmailSender {

    private static Connection conn = getConnection();

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
     * Contain the subject of the informative email.
     * @return the email subject.
     */
    public static String mailSubject() {
        return "CovidApp Warning";
    }

    /**
     * Contain the body of the informative email.
     * @return the email body.
     */
    public static String mailBody() {
        return "Dear user,\n"
                + "With this email we would like to inform you that you have probably been "
                + "in contact with a confirmed case of COVID-19. As we cannot know your "
                + "exact degree of exposure to the virus, we would suggest that you get "
                + "tested for SARS-CoV-2.\n"
                + "Thank you for the preference.";
    }

    /**
     * Gets the emails from the database and add them in a List.
     * @return the list with the emails of the users we must inform.
     * @throws SQLException 
     */
    public static List<String> getEmails() throws SQLException {
        List<String> emailsFromDB = new ArrayList<>();

        PreparedStatement prStmt = conn.prepareStatement("DELETE FROM Emails Where Email = ?");

        Statement myStmt = conn.createStatement();
        ResultSet myRs = myStmt.executeQuery("SELECT Email FROM Emails");
        while (myRs.next()) {
            String currEmail = myRs.getString("Email");
            emailsFromDB.add(currEmail);

            prStmt.setString(1, currEmail);
            prStmt.executeUpdate();
        }

        return emailsFromDB;
    }

    /**
     * Remove the duplicate emails from the given list.
     * @param emails a list that contain all the mails of the case contacts.
     * @return the list it receives without duplicates.
     */
    public static List<String> removeDuplicateEmails(List<String> emails) {
    	List<String> emailsWithoutDuplicates = emails.stream()
	    	     .distinct()
	    	     .collect(Collectors.toList());
    	return emailsWithoutDuplicates;
    }

    /** 
     * Sends the emails to the contacts of the case.
     * @param emailsWithoutDuplicates a list that contain the emails without duplicates.
     * @throws AddressException throws AddressException.
     * @throws MessagingException throws MessagingException.
     */
    public static void sendInformativeEmails(List<String> emailsWithoutDuplicates) 
            throws AddressException, MessagingException {
    	Email mail = new Email(emailsWithoutDuplicates);
	mail.setupServerProperties();
	mail.draftEmail(mailSubject(), mailBody());
	mail.sendEmail();
    }

    /**
     * Gets the email bodies from the database and add them in a List.
     * @return the list with the email bodies of the users questions/complaints.
     * @throws SQLException 
     */
    public static List<String> getEmailsTowardUs() throws SQLException {
        List<String> emailsFromDB = new ArrayList<>();

        PreparedStatement prStmt = conn.prepareStatement("DELETE FROM EmailsTowardUs Where EmailTowardUs = ?");

        Statement myStmt = conn.createStatement();
        ResultSet myRs = myStmt.executeQuery("SELECT EmailTowardUs FROM EmailsTowardUs");
        while (myRs.next()) {
            String currEmail = myRs.getString("EmailTowardUs");
            emailsFromDB.add(currEmail);

            prStmt.setString(1, currEmail);
            prStmt.executeUpdate();
        }

        return emailsFromDB;
    }

    /**
     * Sends the emails (questions/complaints) from the users to us.
     * @param emailbodies a list that contain the email bodies.
     * @throws AddressException
     * @throws MessagingException 
     */
    public static void sendEmailsFromContactUs(List<String> emailbodies)
            throws AddressException, MessagingException {

        List<String> ourEmail = new ArrayList<>();
        ourEmail.add("informant4565@gmail.com");

        Email mail = new Email(ourEmail);
	for (int i = 0; i < emailbodies.size(); i++) {
            mail.setupServerProperties();
            mail.draftEmail("ContactUs", emailbodies.get(i));
            mail.sendEmail();
        }
    }

    /**
     * Checks if the database connection is alive.
     */
    public static void checkConnection() {
        try {
            if ((conn == null) || !conn.isValid(1)) {
                conn = getConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            conn = null;
        }
    }
    /**
     * Executes the methods of the class in order to send the emails.
     * @param args 
     */
    public static void main(String[] args) {
        try {
            while (true) {
                checkConnection();
                List<String> emailsFromDB = getEmails();
                if (!emailsFromDB.isEmpty()) {
                    List<String> emailsWithoutDuplicates = removeDuplicateEmails(emailsFromDB);
                    sendInformativeEmails(emailsWithoutDuplicates);
                }

                List<String> emailsTowardUsFromDB = getEmailsTowardUs();
                if (!emailsTowardUsFromDB.isEmpty()) {
                    sendEmailsFromContactUs(emailsTowardUsFromDB);
                }

                Thread.sleep(30000);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
