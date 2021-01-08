package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		try {

			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "papajohn");
			Statement myStmt = myConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("Press 1 to log in, 2 to sign up or 3 to exit: ");

			for(;;) {

				System.out.print("Enter command: ");
				int x = sc.nextInt();
				sc.nextLine();

				switch(x) {

				case 1:
					//myStmt.executeUpdate("delete from registrations2 where ABS(DATEDIFF(DATE_FORMAT(DepartureTime, '%Y-%m-%d'),CURDATE())) >= 14");
					System.out.println("Please enter your id:");
					String id = sc.nextLine();
					System.out.println("Please enter your pass:");
					String pass = sc.nextLine();
					ResultSet myRs = myStmt.executeQuery("select * from EntryInfos2 where id = '" + id + "' and pass = '" + pass + "'");

					if(myRs.next() == true) {

						Account acc = new Account(myRs.getString("id"), myRs.getString("Email"), myRs.getString("Pass"));
						System.out.println("Press 1 to add entry, 2 if you found possitive or 3 to exit: ");

						for(;;) {

							System.out.println("Enter command: ");
							int command = sc.nextInt();
							sc.nextLine();

							switch(command) {

							case 1:
								System.out.println("Enter location: ");
								String place = sc.nextLine();
								System.out.println("Enter location's postal code: ");
								int TK = sc.nextInt();
								sc.nextLine();
								System.out.println("Enter address: ");
								String address = sc.nextLine();
								System.out.println("Enter arrival time in YYYY-MM-DD HH:MM form: ");
								String arrivalTime = sc.nextLine();
								System.out.println("Enter departure time in YYYY-MM-DD HH:MM form: ");
								String departureTime = sc.nextLine();
								System.out.println("Did you wear mask?");
								String wearingMask = sc.nextLine();
								myStmt.executeUpdate("insert into EntryInfos2 (ID, Email, Pass, Place, address, TK, ArrivalTime, DepartureTime, wearingMask) "
										+ "values ('" + acc.getId() + "', '" + acc.getEmail() + "', '" + acc.getPass() + "', '" + place + "', '" + address + "', '" + TK + "', '" + arrivalTime + "', '" + departureTime + "', '" + wearingMask + "');");
								break;
							case 2:
								acc.testedPossitive();
								break;
							case 3:
								return;
							default:
								System.out.println("Press 1 to add entry, 2 if you found possitive or 3 to exit: ");
							}
						}

					} else {
						System.out.println("You are not registered. Please sing up first!");
						break;
					}

				case 2:
					//myStmt.executeUpdate("delete from registrations2 where ABS(DATEDIFF(DATE_FORMAT(DepartureTime, '%Y-%m-%d'),CURDATE())) >= 14");
					System.out.println("Please enter your id:");
					String id2 = sc.nextLine();
					System.out.println("Please enter your email:");
					String email = sc.nextLine();
					System.out.println("Please enter a pass:");
					String pass2 = sc.nextLine();
					ResultSet myRs2 = myStmt.executeQuery("select * from EntryInfos2 where id = '" + id2 + "'");

					if(myRs2.next() == false) {

						Account acc2 = new Account(id2, email, pass2);

						System.out.println("Press 1 to add entry, 2 if you found possitive or 3 to exit: ");

						for(;;) {

							System.out.println("Enter command: ");
							int command = sc.nextInt();
							sc.nextLine();

							switch(command) {

							case 1:
								System.out.println("Enter location: ");
								String place = sc.nextLine();
								System.out.println("Enter location's postal code: ");
								int TK = sc.nextInt();
								sc.nextLine();
								System.out.println("Enter address: ");
								String address = sc.nextLine();
								System.out.println("Enter arrival time in YYYY-MM-DD HH:MM form: ");
								String arrivalTime = sc.nextLine();
								System.out.println("Enter departure time in YYYY-MM-DD HH:MM form: ");
								String departureTime = sc.nextLine();
								System.out.println("Did you wear mask?");
								String wearingMask = sc.nextLine();
								myStmt.executeUpdate("insert into EntryInfos2 (ID, Email, Pass, Place, address, TK, ArrivalTime, DepartureTime, wearingMask) "
										+ "values ('" + acc2.getId() + "', '" + acc2.getEmail() + "', '" + acc2.getPass() + "', '" + place + "', '" + address + "', '" + TK + "', '" + arrivalTime + "', '" + departureTime + "', '" + wearingMask + "');");
								break;
							case 2:
								acc2.testedPossitive();
								break;
							case 3:
								return;
							default:
								System.out.println("Press 1 to add entry, 2 if you found possitive or 3 to exit: ");
							}
						}

					} else {
						System.out.println("You are already registered! Please sign in");
					}
					break;
				case 3:
					return;
				default:
					System.out.println("Press 1 to log in, 2 to sign up or 3 to exit: ");
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}


