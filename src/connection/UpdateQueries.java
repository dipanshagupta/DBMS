package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Course;
import model.Homework;
import model.User;
import utils.StringUtils;

public class UpdateQueries {
	
	public static void addTAToCourse(String ta, int course) {
		Connection connection = new ConnectionManager().getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement(StringUtils.ADD_TA_TO_COURSE);
			pst.setString(1, ta);
			pst.setInt(2, course);
			int result = pst.executeUpdate();
			if(result == 0) {
				System.out.println("Some unknown error occured");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close(connection);
		}
		System.out.println("Success!");
	}
	
	public static void addCourse(Course course) {
		Connection connection = new ConnectionManager().getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement(StringUtils.ADD_COURSE);
			pst.setInt(1, course.getCourse_id());
			pst.setString(2, course.getName());
			pst.setString(3, course.getCourseCode());
			pst.setString(4, course.getDepartment());
			pst.setInt(5, course.getMax_students_allowed());
			pst.setString(6, course.getLevel());
			pst.setString(7, course.getStartDate());
			pst.setString(8, course.getEndDate());
			int result = pst.executeUpdate();
			if(result == 0) {
				System.out.println("Some unknown error occured");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close(connection);
		}
		System.out.println("Success!");
	}
	
	public static void addStudentToCourse(String student, int course) {
		Connection connection = new ConnectionManager().getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement(StringUtils.ADD_STUDENT_TO_COURSE);
			pst.setString(1, student);
			pst.setInt(2, course);
			int result = pst.executeUpdate();
			if(result == 0) {
				System.out.println("Some unknown error occured");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close(connection);
		}
		System.out.println("Success!");
	}
	
	public static void dropStudentFromCourse(String student, int course) {
		Connection connection = new ConnectionManager().getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement(StringUtils.DROP_STUDENT_FROM_COURSE);
			pst.setString(1, student);
			pst.setInt(2, course);
			int result = pst.executeUpdate();
			if(result == 0) {
				System.out.println("Some unknown error occured");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close(connection);
		}
		System.out.println("Success!");
	}

	public static void addHomework(Homework hw) {
		Connection connection = new ConnectionManager().getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement(StringUtils.ADD_HOMEWORK);
			pst.setInt(1, hw.getHomeworkId());
			pst.setString(2, hw.getName());
			pst.setString(3, hw.getPostedDate());
			pst.setString(4, hw.getDeadline());
			pst.setInt(5, hw.getAllowedAttempts());
			pst.setInt(6, hw.getCorrectPoints());
			pst.setInt(7, hw.getIncorrectPoints());
			pst.setInt(8, hw.getCourseId());
			int result = pst.executeUpdate();
			if(result == 0) {
				System.out.println("Some unknown error occured");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close(connection);
		}
		
	}
	
	public static void updateUserName(User user, String name) {
		Connection connection = new ConnectionManager().getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement(StringUtils.UPDATE_USER_NAME);
			pst.setString(1, name);
			pst.setString(2, user.getUserId());
			int result = pst.executeUpdate();
			if(result == 0) {
				System.out.println("Some issue....");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close(connection);
		}
		
	}
	
	public static void updateUserPassword(User user, String passwd) {
		Connection connection = new ConnectionManager().getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement(StringUtils.UPDATE_USER_PASSWORD);
			pst.setString(1, passwd);
			pst.setString(2, user.getUserId());
			int result = pst.executeUpdate();
			if(result == 0) {
				System.out.println("Some issue....");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close(connection);
		}
	}
	
	public static void close(Connection connection) {
		try {
			connection.close();
			} catch (SQLException e) {
				System.out.println("Failed to close connection");
			}
	}
}
