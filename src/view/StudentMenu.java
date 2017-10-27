package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import connection.ConnectionManager;
import connection.FetchQueries;
import connection.UpdateQueries;
import model.Instructor;
import model.Student;
import model.User;
import utils.InputScanner;
import utils.Session;

public class StudentMenu {
	public void showMenu() {
		Scanner sc = InputScanner.getScanner();
		boolean flag = true;
		while (flag) {
			System.out.println("\n\n");
			System.out.println("******* STUDENT MENU *******");
			System.out.println("1. View profile");
			System.out.println("2. Edit profile");
			System.out.println("3. View courses");
			System.out.println("4. Log out");
			
			int choice = Integer.valueOf(sc.nextLine());
			switch(choice) {
			case 1:
				viewProfile();
				break;
			case 2:
				editProfile();
				break;
			case 3:
				break;
			case 4:
				Session.logOut();
				flag = false;
				break;
			default: 
				System.out.println("Invalid choice, please try again!");
				
			}
			
		}
		
		System.out.println("Goodbye!");
		
	}
	
	private void viewProfile() {
		User user = Session.getUser();
		Connection connection = new ConnectionManager().getConnection();
		Student stu = FetchQueries.getStudentDetails(connection,user);
		String level = (stu.getLevel().compareToIgnoreCase("u")==0 )?"Undergraduate":"Graduate";
		System.out.println("\n\n");
		System.out.println("************PROFILE************");
		System.out.println("Name:\t" + stu.getName());
		System.out.println("Email:\t" + stu.getEmail());
		System.out.println("ID:\t" + stu.getUserId());
		System.out.println("Level:\t" + level);
		System.out.println("************END************");
		System.out.println("\n\n");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Failed to close connection");
		}
		
	}
	
	private void editProfile() {
		Scanner sc = InputScanner.getScanner();
		User user = Session.getUser();
		Connection connection = new ConnectionManager().getConnection();
		Student old_stu = FetchQueries.getStudentDetails(connection,user);
		
		System.out.println("\n\nSTUDENT EDIT PROFILE");
		System.out.println("1. Edit Name");
		System.out.println("2. Edit Password");
		System.out.println("3. Go Back");

		int choice = Integer.valueOf(sc.nextLine());
		switch (choice) {
		case 1:
			System.out.println("\n\nPlease enter the new name:");
			String name = sc.nextLine();
			// Don't update if blank string is given
			if (name.length() > 0) {
				UpdateQueries.updateUserName(connection, user, name);
			}
			break;
		case 2:
			System.out.println("\n\nPlease enter the new password:");
			String passwd = sc.nextLine();
			// Don't update if blank string is given
			if (passwd.length() > 0) {
				UpdateQueries.updateUserPassword(connection, user, passwd);
			}
			break;
		case 3:
			break;
		default:
			System.out.println("Invalid choice, please try again!");
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Failed to close connection");
		}
	}
	
}