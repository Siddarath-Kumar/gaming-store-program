package VideoGameStoreApp;
/**
 * This class maintains the instance variables for what the user purchases.
 * This class declares the instance variables of the purchase name, the price and 
 * the condition of the product. This class also includes the constructor initializing the
 * object, getter and setter methods and methods for clearing the array list, calculating the total 
 * cost and discount and methods to output the current items in the users shopping cart list.
 * @author Siddarath Kumar 19075068
 **/
import java.util.ArrayList;
import java.text.NumberFormat;

public class CustomerShoppingCart {

	private String purchaseName;
	private double price;
	private Condition conditionStatus;
	
	/**
	 * This constructor for this class will contain input parameter for all instance variables which will be
	 * used to initialize the CustomerShoppingCart objects.
	 * @param purchaseName the parameter represents the name of the product purchased/added to the cart.
	 * @param conditionStatus the parameter represents the condition of the product.
	 * @param price the parameter that represents the price of the product.
	 * @return none.
	 * @author 19075068
	 **/
	public CustomerShoppingCart(String purchaseName, Condition conditionStatus, double price)
	{
		this.purchaseName = purchaseName;
		this.conditionStatus = conditionStatus;
		this.price = price;
	}
	
	/**
	 * This is the default constructor that doesn't initialize instance variables.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public CustomerShoppingCart()
	{
		
	}
	
	/**
	 * This getPurchaseName method will return the instance variable purchaseName.
	 * The same concept applies to all the other get methods below.
	 * @param none.
	 * @return purchaseName the variable that represents the name of the product purchased/added to the cart.
	 * @author 19075068
	 **/
	public String getPurchaseName()
	{
		return purchaseName;
	}
	
	/**
	 * This setPurchaseName method will update the value of the instance variable purchaseName.
	 * This same concept applies to all the other set methods below.
	 * @param purchasName the String parameter represents the name of the product purchased/added to the cart.
	 * @return none.
	 * @author 19075068
	 **/
	public void setPurchaseName(String purchaseName)
	{
		this.purchaseName = purchaseName;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public Condition getConditionStatus()
	{
		return conditionStatus;
	}
	
	public void setConditionStatus(Condition conditionStatus)
	{
		this.conditionStatus = conditionStatus;
	}
	
	/**
	 * This method will clear and empty the customers shopping cart.
	 * @param products the parameter that represents an array list object of the CustomerShoppingCart class.
	 * @return none.
	 * @author 19075068
	 **/
	public void clearProducts(ArrayList<CustomerShoppingCart> products) 
	{
		products.clear();
		System.out.println("\nYou will now be redirected to the customer menu with an empty cart.");
	}
	
	/**
	 * This method will calculate the total cost of the items in the customers
	 * shopping cart without any discount applied and return the result back.
	 * @param products the parameter that represents an array list object of the CustomerShoppingCart class.
	 * @return totalPrice the instance variables that represents the total price.
	 * @author 19075068
	 **/
	public double totalCost(ArrayList<CustomerShoppingCart> products)
	{
		double totalPrice = 0.0;
		for (int i = 0; i < products.size(); i++) // A for loop is used to calculate the total price
		{
			totalPrice += products.get(i).getPrice();
		}
		
		return totalPrice;
	}
	
	/**
	 * This method output to the console the current items in the customers shopping cart
	 * and the current total price.
	 * @param products the parameter that represents an array list object of the CustomerShoppingCart class.
	 * @return none.
	 * @author 19075068
	 **/
	public void currentCartItems(ArrayList<CustomerShoppingCart> products)
	{
		System.out.println("\n--------------------------------------------------------------------------------------------------------");
		System.out.println("                                        Your current shopping cart");
		System.out.println("--------------------------------------------------------------------------------------------------------");
		int itemNumber = 0;
		for (CustomerShoppingCart itemDetails: products)
		{
			System.out.println("Cart item number: ["+itemNumber+"]  Product added: " +itemDetails.getPurchaseName()+ "  Price: $" +itemDetails.getPrice()+ "  Condition: "+itemDetails.getConditionStatus());
			itemNumber++;
		}
		System.out.println("\nCurrent total price: $" +totalCost(products));
		System.out.println("--------------------------------------------------------------------------------------------------------\n");
	}
	
	/**
	 * This method will calculate the discount using the customers age and then will
	 * return the discount amount.
	 * @param age the parameter that represents the customers age.
	 * @param totalPrice the parameter which represents the total cost without the discount applied.
	 * @return discountPrice the instance variable which represents the calculated discount.
	 * @author 19075068
	 **/
	public double calculateDiscount(int age, double totalPrice)
	{
		double discountPrice = 0.0;
		
		if (age < 20)
		{
			discountPrice = 0.15 * totalPrice;
		}
		else if (age > 50)
		{
			discountPrice = 0.2 * totalPrice;
		}
		
		return discountPrice;
	}
	
	/**
	 * This toString method will return a string representation of CustomerShoppingCart class object.
	 * @param none.
	 * @return a string that outputs all the instance variable values for the CustomerShoppingCart class.
	 * @author 19075068
	 **/
	public String toString()
	{
		return "Product purchased: " +this.purchaseName+ "  Price: $" +this.price+ "  Condition: " +this.conditionStatus;
	}
}
