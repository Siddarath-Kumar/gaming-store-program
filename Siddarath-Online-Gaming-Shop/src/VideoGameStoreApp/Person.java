package VideoGameStoreApp;
/**
 * This is an abstract class Person that declares the instances
 * variables of a persons first and last name. It includes the get and
 * set methods for these instance variables and an abstract method called
 * showSpecialMessage which gets overridden by the sub classes. This abstract
 * is a super class which the sub class inherits details from such as the instance
 * variables and the abstract methods.
 * @author Siddarath Kumar 19075068
 **/
public abstract class Person {

	protected String firstName;
	protected String lastName;
	
	/**
	 * This is a constructor for the Person class that initialises the first and last
	 * name of a person.
	 * @param firstName the parameter represents the first name of a person.
	 * @param lastName the parameter represents the surname of a person.
	 * @return none.
	 * @author 19075068
	 **/
	public Person(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * This getFirstName method will return the instance variable firstName.
	 * The same concept applies to all the other get methods below.
	 * @param none.
	 * @return firstName the variable that represents the firstName of a person.
	 * @author 19075068
	 **/
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * This setFirstName method will update the value of the instance variable firstName.
	 * This same concept applies to all the other set methods below.
	 * @param firstName the String parameter that represents the firstName of a person.
	 * @return none.
	 * @author 19075068
	 **/
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	/**
	 * The showSpecialMessage below is an abstract method which will be
	 * overridden by the sub classes with a special message related to their class.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public abstract void showSpecialMessage();
}
