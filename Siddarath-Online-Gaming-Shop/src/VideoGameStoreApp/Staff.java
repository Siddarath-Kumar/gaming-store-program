package VideoGameStoreApp;
/**
 * This purpose of this class is to maintain the instance variables which is
 * the staff details for the staff. This method declares private instance variables
 * userName and password, it initializes the staff details and it creates getter and setter
 * methods so these variables are accessible in other classes. This class extends to the abstract class
 * Person and hence inherits its characteristics. This class also overrides the abstract method which will
 * show a special warning message to the staff.
 * @author Siddarath Kumar 19075068
 **/
public class Staff extends Person {

	private String userName;
	private String password;
	
	/**
	 * This is a constructor for the Staff class that contains input for all instance variables to initalise 
	 * the Staff objects. 
	 * @param firstName the parameter represents the first name of the staff.
	 * @param lastName the parameter represents the last name of the staff.
	 * @param userName the parameter represents the user name of the staff when they login.
	 * @param password the parameter represents the password the staff enters.
	 * @return none.
	 * @author 19075068
	 **/
	public Staff(String firstName, String lastName, String userName, String password)
	{
		super(firstName, lastName);
		this.userName = userName;
		this.password = password;
	}
	
	/**
	 * This getUsername method will return the instance variable userName.
	 * The same concept applies to all the other get methods below.
	 * @param none.
	 * @return userName the instance variable which represents the staffs user name for the login.
	 * @author 19075068
	 **/
	public String getUsername()
	{
		return userName;
	}
	
	/**
	 * This setUsername method will update the value of the instance variable userName.
	 * This same concept applies to all the other get methods below.
	 * @param userName the instance variables that represent the user name of the staffs login.
	 * @return none.
	 * @author 19075068
	 **/
	public void setUsername(String userName)
	{
		this.userName = userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * This is the abstract method inherited from the Person class. This method will
	 * output a special warning disclaimer message to the staff before they a granted access
	 * to view the store records.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	@Override
	public void showSpecialMessage() 
	{
		System.out.println("\n------------------------------------------------------------------------------------------------------------");
		System.out.println("                 Successful entry! You have been granted access to view the store records.");
		System.out.println("The following are the confidential details about the store that should not be distributed or tampered with.");
		System.out.println("           You as a staff member should abide these rules or else you may receive consequences.");
		System.out.println("------------------------------------------------------------------------------------------------------------\n");
	}
}
