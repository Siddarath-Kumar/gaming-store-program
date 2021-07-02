package VideoGameStoreApp;
/**
 * The purpose of this class Customer is to maintain the instance variables which is
 * the customer details for the customer who visit the store. This method declares
 * private instance variables age, mobile, delivery address number and address, email and using
 * the super class it inherits the firstName, lastName and abstract methods from the Person
 * abstract class. This class also initializes the Customer object, it creates getter and setter
 * methods so that its variables accessible to the other classes. This class also overrides the 
 * abstract method which will show a special exiting message to the customer when they leave the store.
 * @author Siddarath Kumar 19075068
 **/
public class Customer extends Person{

	private int age;
	private int mobile;
	private String deliveryAddressNumber;
	private String deliveryAddress;
	private String email;
	
	/**
	 * This is a constructor for the Customer class that contains input for all instance variables to
	 * initialize the Customer objects.
	 * @param firstName the parameter represents the first name of the customer.
	 * @param lastName the parameter represents the last name of the customer.
	 * @param age the parameter represents the age of the customer.
	 * @param deliveryAddressNumber the parameter represents the delivery number of the customer.
	 * @param deliveryAddress the parameter represents the delivery address of the customer.
	 * @param email the parameter represents the email of the customer.
	 * @return none.
	 * @author 19075068
	 **/
	public Customer(String firstName, String lastName, int age, int mobile,String deliveryAddressNumber, String deliveryAddress, String email)
	{
		super(firstName, lastName);
		this.age = age;
		this.mobile = mobile;
		this.deliveryAddressNumber = deliveryAddressNumber;
		this.deliveryAddress = deliveryAddress;
		this.email = email;
	}
	
	/**
	 * This getAge method will return the instance variable age.
	 * The same concept applies to all the other get methods below.
	 * @param none.
	 * @return age the instance variable which represents the customers age they entered.
	 * @author 19075068
	 **/
	public int getAge()
	{
		return age;
	}
	
	/**
	 * This setAge method will update the value of the instance variable age.
	 * This same concept applies to all the other set methods below.
	 * @param age the integer parameter represents the age of the customer.
	 * @return none.
	 * @author 19075068
	 **/
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public int getMobile()
	{
		return mobile;
	}
	
	public void setMobile(int mobile)
	{
		this.mobile = mobile;
	}
	
	public String getDeliveryAddressNumber()
	{
		return deliveryAddressNumber;
	}
	
	public void setDeliveryAddressNumber(String deliveryAddressNumber)
	{
		this.deliveryAddressNumber = deliveryAddressNumber;
	}
	
	public String getDeliveryAddress()
	{
		return deliveryAddress;
	}
	
	public void setDeliveryAddress(String deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * This method will determine and output to the console whether the customer is applicable
	 * for a discount by using some conditions.
	 * @param age the integer parameter which represent the age of the customer.
	 * @return none.
	 * @author 19075068
	 **/
	public void discountApplicable(int age)
	{
		if (age <20)
		{
			System.out.println("You are eligible for a 15% discount!");
		}
		else if(age >50)
		{
			System.out.println("You are eligible for a 20% discount!");
		}
		else 
		{
			System.out.println("You are not eligble for a discount!");
		}
	}

	/**
	 * This is the abstract method inherited from the Person class. This method will
	 * output a special exiting message using customer details to the customer after 
	 * they have made a successful payment.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	@Override
	public void showSpecialMessage() {
		System.out.println("\nA digital receipt of your purchases have been emailed to " +this.getEmail()+ ".");
		System.out.println("Your items will be delivered in 3-5 working days at " +this.getDeliveryAddressNumber()+ " " +this.getDeliveryAddress()+ ".");
		System.out.println("Thank you " +this.getFirstName()+ " " +this.getLastName()+ " for buying our products, please come again!");
		
	}
}
