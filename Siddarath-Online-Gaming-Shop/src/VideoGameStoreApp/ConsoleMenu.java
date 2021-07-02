package VideoGameStoreApp;
/**
 * The purpose of this class is to create the menu of the console products
 * by adding the information about this product into the array list. This class
 * inherits the required characteristics/variables/methods from the Products class as this class is a 
 * subclass. This class also implements the comparable interface which is used to 
 * sort the console menu. Additionally, this ConsoleMenu class also includes static output methods and 
 * toString methods which output the array list in a legible manner. 
 * @author Siddarath Kumar 19075068
 **/
import java.util.ArrayList;
import java.util.Collections;

public class ConsoleMenu extends Products implements Comparable<ConsoleMenu>{
	
	/**
	 * This is a constructor for the ConsoleMenu class that contains input for all instance variables from the Products class except the video game
	 * genre and accessory type to initialize the ConsoleMenu objects. This constructor uses the super class (Products) to get the required
	 * characteristics in order to initialize the ConsoleMenu objects.
	 * @param productName the parameter represents the products name.
	 * @param productPrice the parameter represents the product price.
	 * @param consoleType the parameter represents the enumerated type ConsoleType which holds the different types of consoles.
	 * @param conditionStatus the parameter represents the enumerated type Condition which holds whether the product is new or pre-owned.
	 * @param stockStatus the parameter represents the enumerated type Stock which holds if the product is in stock or not.
	 * @return none.
	 * @author 19075068
	 **/
	public ConsoleMenu(String productName, Double productPrice, ConsoleType consoleType, Condition conditionStatus, Stock stockStatus)
	{
		super(productName, productPrice, consoleType, conditionStatus, stockStatus); // Calls the super class Products and inherits the specified characteristics
	}
	
	/**
	 * This toString method will return a string representation of the ConsoleMenu class object.
	 * This method uses the string.format technique to make the menu look more organized in a column format.
	 * @param none.
	 * @return a string that outputs all the instance variable values for the ConsoleMenu class.
	 * @author 19075068
	 **/
	public String toString()
	{
		String output = String.format("%-30s","Product Name: " +this.getProductName()+ "  "); // String.format is used to format the console menu in columns
		output += String.format("%-20s","Price: $" + this.getProductPrice());
		output += String.format("%-30s","Console type: "+ this.getConsoleType());
		output += String.format("%-25s","Condition: "+ this.getConditionStatus());
		output += String.format("%-20s","In stock: "+ this.getStockStatus()+ "\n");
		return output;
	}
	
	/**
	 * This method will compare the price of products in the array list. This method uses the comparable interface.
	 * @param o the parameter which an instance variable of the class ConsoleMenu.
	 * @return an integer value which compares the product prices.
	 * @author 19075068
	 **/
	public int compareTo(ConsoleMenu o)
	{
		return this.getProductPrice().compareTo(o.getProductPrice());
	}
	
	/**
	 * This static method outputMenu will create an object of the class and assign it to values which are
	 * information about the console products from the store. The method then adds these objects to the array list
	 * and then sorts the array list from the products with the lowest price at the start of the index and the higher 
	 * priced items at the top of the index. This method then finally outputs the array list that stores the information
	 * about the console products along with a unique item number which the customer can then later refer to.
	 * @param none.
	 * @return consoles the array list that holds all the console products information.
	 * @author 19075068
	 **/
	public static ArrayList<ConsoleMenu> outputMenu()
	{
		ConsoleMenu console1 = new ConsoleMenu("Playstation 3 500Gb console   ", 250.00, ConsoleType.PLAYSTATION, Condition.PREOWNED, Stock.YES);
		ConsoleMenu console2 = new ConsoleMenu("Playstation 4 1TB console     ", 500.00, ConsoleType.PLAYSTATION, Condition.NEW, Stock.YES);
		ConsoleMenu console3 = new ConsoleMenu("Xbox 360 250Gb console        ", 250.00, ConsoleType.XBOX, Condition.PREOWNED, Stock.YES);
		ConsoleMenu console4 = new ConsoleMenu("Xbox One 1TB console          ", 450.00, ConsoleType.XBOX, Condition.NEW, Stock.YES);
		ConsoleMenu console5 = new ConsoleMenu("Nintendo Switch console       ", 600.00, ConsoleType.NINTENDO, Condition.NEW, Stock.YES);
		
		ArrayList<ConsoleMenu> consoles = new ArrayList<ConsoleMenu>(); // Creating the array list object
		consoles.add(console1); // Storing details into the array list object
		consoles.add(console2);
		consoles.add(console3);
		consoles.add(console4);
		consoles.add(console5);
		
		Collections.sort(consoles); // Sorts the array list storing the products from lowest to highest price
		for (ConsoleMenu items: consoles)
		{
			System.out.println("|" +consoles.indexOf(items) + "| - " + items); // Prints out the console menu formatted with its index number at the front
		}
		
		return consoles;
	}
}
