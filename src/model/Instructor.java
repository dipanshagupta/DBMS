package model;

/**
 * 
 * @author pooja
 *
 */

public class Instructor extends User {
	private String instructorId;
	private String officeAddress;
	
	public Instructor(String instructorId, User user, String officeAddress) {
		super(user);
		this.instructorId = instructorId;
		this.officeAddress = officeAddress;
	}

	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
}