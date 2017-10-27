package utils;

public class StringUtils {

	/** USER **/
	//Access the user class
	public static final String GET_USER = "SELECT user_id as userId, name as name, email as email FROM user";
	//Update User name
	public static final String UPDATE_USER_NAME = "UPDATE user SET name = ? WHERE user_id = ?";
	//Update User Password
	public static final String UPDATE_USER_PASSWORD = "UPDATE user SET password = ? WHERE user_id = ?";
	
	//Prepared Statement for Login
	public static final String LOGIN = "SELECT * from user WHERE user_id = ? AND password = ?";
	//Check if the user is a student
	public static final String CHECK_STUDENT = "SELECT * FROM student std where std.student_id = ?";
	//Check if student is TA
	public static final String CHECK_TA = "SELECT * FROM teaching_assistant ta where ta.ta_id = ?";
	//Obtain instructor details
	public static final String GET_INSTRUCTORS = "SELECT * FROM instructor instr where instr.instructor_id = ?";
	//Obtain all courses
	public static final String GET_COURSES = "SELECT * FROM course where course_code = ?";
	public static final String GET_EXERCISE_BY_COURSE = "SELECT * FROM homework where course_id = ?";
	public static final String GET_EXERCISE_BY_ID = "SELECT * FROM homework where homework_id = ?";
	public static final String GET_TA_FOR_COURSE = 
			"SELECT t.ta_id as ta_id "
			+ "FROM teaching_assistant_assists t, teaching_assistant ta "
			+ "where t.ta_id = ta.ta_id and t.course_id = ?";
	
	
	
	/** STUDENTS **/
	//Get Students' details
	public static final String GET_STUDENTS = "SELECT * FROM student stu where stu.student_id = ?";
	
	//Get Students' details
	public static final String UPDATE_STUDENTS = "SELECT * FROM student stu where stu.student_id = ?";
	
	//Get courses for a student
	public static final String GET_COURSES_BY_STUDENTS = "SELECT * FROM Gradiance.enrollment e "
			+"JOIN Gradiance.course c ON  e.course_id=c.course_id "
			+"WHERE e.student_id = ?";
	
	//Get past exercise by course
	public static final String GET_PAST_EXERCISES_BY_COURSE = "SELECT * FROM homework where course_id = ? AND deadline < ?";

	//Get current exercise by course
	public static final String GET_CURRENT_EXERCISES_BY_COURSE = "SELECT * FROM homework where course_id = ? AND posted_date <= ? AND deadline >= ?";
	
	//Get report by homework
	public static final String GET_REPORT_BY_EXERCISE = "SELECT * FROM report r WHERE r.student_id = ? AND r.homework_id = ?";
	
}
