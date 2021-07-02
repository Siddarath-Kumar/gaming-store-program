package VideoGameStoreApp;
/**
 * The purpose of this class is to create the menu of the accessory products
 * by adding the details about this product into the array list. This class
 * inherits the required characteristics/variables/methods from the Products class since this class is a 
 * subclass. This class also implements the comparable interface which is used in this class to 
 * sorts the accessory menu by price. Additionally, this AccessoryMenu class also includes static output 
 * methods and toString methods which output the array list in a legible manner. 
 * @author Siddarath Kumar 19075068
 **/
import java.util.ArrayList;
import java.util.Collections;

public class AccessoryMenu extends Products implements Comparable<AccessoryMenu> {

	/**
	 * This is a constructor for the AccessoryMenu class that contains input for all instance variables from the Products class except the video game
	 * genre and the console type to initialize the AccessoryMenu objects. This constructor uses the super class (Products) to get the required
	 * characteristics in order to initialize the AccessoryMenu objects.
	 * @param productName the parameter represents the products name.
	 * @param productPrice the parameter represents the product price.  
	 * @param accessoryType the parameter represents the enumerated type AccessoryType which holds the different types of accessories the product can be.
	 * @param conditionStatus the parameter represents the enumerated type Condition which holds whether the product is new or pre-owned. 
	 * @param stockStatus the parameter represents the enumerated type Stock which holds if the product is in stock or not.
	 * @return none.
	 * @author 19075068
	 **/
	public AccessoryMenu(String productName, Double productPrice, AccessoryType accessoryType, Condition conditionStaus, Stock stockStatus)
	{
		super(productName, productPrice, accessoryType,conditionStaus, stockStatus); // Calls the super class Products and inherits the specified characteristics
	}
	
	/**
	 * This toString method will return a string representation of the AccessoryMenu class object.
	 * This method uses the string.format technique to make the menu look more organized in a column format.
	 * @param none.
	 * @return a string that outputs all the instance variable values for the AccessoryMenu class.
	 * @author 19075068
	 **/
	public String toString()
	{
		String output = String.format("%-30s","Product Name: " +this.getProductName()+ "  "); // String.format is used to format the accessory menu in columns
		output += String.format("%-20s","Price: $" + this.getProductPrice());
		output += String.format("%-30s","Accessory type: "+ this.getAccessoryType());
		output += String.format("%-20s","Condition: "+ this.getConditionStatus());
		output += String.format("%-20s","In stock: "+ this.getStockStatus()+ "\n");
		return output;	
	}
	
	/**
	 * This method will compare the price of the accessory products in the array list. This method uses the comparable interface.
	 * @param o the parameter which an instance variable of the class AccessoryMenu.
	 * @return an integer value which compares the product prices.
	 * @author 19075068
	 **/
	public int compareTo(AccessoryMenu o)
	{
		return this.getProductPrice().compareTo(o.getProductPrice());
	}
	
	/**
	 * This static method outputMenu will create an object of the AccessoryMenu class and assign it to values which are
	 * information about the accessory products from the store. The method then adds these objects to the array list
	 * and then sorts the array list from the products with the lowest price at the start of the index and the higher 
	 * priced items at the top of the index. This method then finally outputs the array list that stores the information
	 * about the accessory products along with a unique item number which the customer can then later refer to.
	 * @param none.
	 * @return accessories the array list that holds all the console products information.
	 * @author 19075068
	 **/
	public static ArrayList<AccessoryMenu> outputMenu()
	{
		AccessoryMenu accessory1 = new AccessoryMenu("PS4 Controller                ", 70.00, AccessoryType.CONTROLLERS,Condition.NEW, Stock.YES);
		AccessoryMenu accessory2 = new AccessoryMenu("Xbox One Controller           ", 70.00, AccessoryType.CONTROLLERS, Condition.NEW, Stock.YES);
		AccessoryMenu accessory3 = new AccessoryMenu("2 WII Controllers             ", 80.00, AccessoryType.CONTROLLERS, Condition.NEW, Stock.YES);
		AccessoryMenu accessory4 = new AccessoryMenu("Black Gaming headset          ", 50.00, AccessoryType.OTHER, Condition.NEW, Stock.YES);
		AccessoryMenu accessory5 = new AccessoryMenu("12 Months Online membership   ", 65.00, AccessoryType.VOUCHERS, Condition.NEW, Stock.YES);
		AccessoryMenu accessory6 = new AccessoryMenu("2 Metre HDMI Cable            ", 15.00, AccessoryType.WIRES, Condition.NEW, Stock.YES);
		AccessoryMenu accessory7 = new AccessoryMenu("$30 Steam Gift cards          ", 30.00, AccessoryType.VOUCHERS, Condition.NEW, Stock.YES);
		
		ArrayList<AccessoryMenu> accessories = new ArrayList<AccessoryMenu>(); // Creating the array list object
		accessories.add(accessory1); // Storing details into the array list object
		accessories.add(accessory2);
		accessories.add(accessory3);
		accessories.add(accessory4);
		accessories.add(accessory5);
		accessories.add(accessory6);
		accessories.add(accessory7);
		
		Collections.sort(accessories); // Sorts the array list storing the products from lowest to highest price
		for(AccessoryMenu items: accessories)
		{
			System.out.println("|" +accessories.indexOf(items) + "| - " +items);  // Prints out the accessory menu formatted with its index number at the front
		}
		
		return accessories;
	}
}
