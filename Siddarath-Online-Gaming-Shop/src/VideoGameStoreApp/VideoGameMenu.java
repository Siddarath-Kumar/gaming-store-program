package VideoGameStoreApp;
/**
 * This class creates the menu of the video games product by adding the details about these
 * products into the array list. This class inherits the required characteristics/variables/methods
 * from the products class since this class is a subclass. This class also implements the comparable
 * interfaced used to help sort the video games menu. This class also has static output methods and a to
 * string method that will output the array list in a readable manner.
 * @author Siddarath Kumar 19075068
 **/
import java.util.ArrayList;
import java.util.Collections;

public class VideoGameMenu extends Products implements Comparable<VideoGameMenu> {

	/**
	 * This is a constructor for the VideoGameMenu class that contains input for all instance variables from the Products class except the console type
	 * and accessory type to initialize the VideoGameMenu objects. This constructor uses the super class (Products) to get the required
	 * characteristics in order to initialize the VideoGameMenu objects.
	 * @param productName the parameter represents the products name.
	 * @param productPrice the parameter represents the product price. 
	 * @param videoGameGenres the parameter represents the enumerated type VideoGameGenres which holds the genre of the video game.
	 * @param conditionStatus the parameter represents the enumerated type Condition which holds whether the product is new or pre-owned.
	 * @param stockStatus the parameter represents the enumerated type Stock which holds if the product is in stock or not.
	 * @return none.
	 * @author 19075068
	 **/
	public VideoGameMenu(String productName, Double productPrice, VideoGameGenres videoGameGenres, Condition conditionStatus, Stock stockStatus)
	{
		super(productName, productPrice,videoGameGenres, conditionStatus, stockStatus); // Calls the super class Products and inherits the specified characteristics
	}
	
	/**
	 * This toString method will return a string representation of the VideoGameMenu class object.
	 * This method uses the string.format technique to make the menu look more organized in a column format.
	 * @param none.
	 * @return a string that outputs all the instance variable values for the VideoGameMenu class.
	 * @author 19075068
	 **/
	public String toString()
	{
		String output = String.format("%-27s","Product Name: " +this.getProductName()+ "  "); // String.format is used to format the video game menu in columns
		output += String.format("%-20s","Price: $" + this.getProductPrice());
		output += String.format("%-27s","Game Genre: " + this.getVideoGamesGenres());
		output += String.format("%-25s","Condition: "+ this.getConditionStatus());
		output += String.format("%-20s","In stock: "+ this.getStockStatus()+ "\n");
		return output;
	}
	
	/**
	 * This method will compare the price of video game products in the array list. This method uses the comparable interface.
	 * @param o the parameter which an instance variable of the class VideoGameMenu.
	 * @return an integer value which compares the product prices.
	 * @author 19075068
	 **/
	public int compareTo(VideoGameMenu o)
	{
		return this.getProductPrice().compareTo(o.getProductPrice());
	}
	
	/**
	 * This static method outputMenu will create an object of the class and assign it to values which are
	 * information about the video game products from the store. The method then adds these objects to the array list
	 * and then sorts the array list from the products with the lowest price at the start of the index and the higher 
	 * priced items at the top of the index. This method then finally outputs the array list which stores the details
	 * about the video game products along with a unique item number which the customer can then later refer to.
	 * @param none.
	 * @return videoGames the array list that holds all the video games products details.
	 * @author 19075068
	 **/
	public static ArrayList<VideoGameMenu> outputMenu()
	{
		VideoGameMenu game1 = new VideoGameMenu("FIFA 21 for PS4               ", 80.00, VideoGameGenres.SPORTS, Condition.NEW, Stock.YES);
		VideoGameMenu game2 = new VideoGameMenu("HALO Remastered for Xbox One  ", 65.00, VideoGameGenres.SHOOTING, Condition.NEW, Stock.YES);
		VideoGameMenu game3 = new VideoGameMenu("Pokemon Go for Nintendo Switch", 50.00, VideoGameGenres.ADVENTURE, Condition.NEW, Stock.YES);
		VideoGameMenu game4 = new VideoGameMenu("Spider-Man adventures for PS3 ", 40.00, VideoGameGenres.ACTION, Condition.PREOWNED, Stock.YES);
		VideoGameMenu game5 = new VideoGameMenu("Sims 4 for Xbox 360           ", 30.00, VideoGameGenres.SIMULATION, Condition.PREOWNED, Stock.YES);
		VideoGameMenu game6 = new VideoGameMenu("Plants vs Zombies for PS3     ", 20.00, VideoGameGenres.STRATEGY, Condition.PREOWNED, Stock.YES);
		VideoGameMenu game7 = new VideoGameMenu("Wii Sports for Wii            ", 40.00, VideoGameGenres.SPORTS, Condition.PREOWNED, Stock.YES);
		
		ArrayList<VideoGameMenu> videoGames = new ArrayList<VideoGameMenu>(); // Creating the array list object
		videoGames.add(game1); // Storing details into the array list object
		videoGames.add(game2);
		videoGames.add(game3);
		videoGames.add(game4);
		videoGames.add(game5);
		videoGames.add(game6);
		videoGames.add(game7);
		
		Collections.sort(videoGames); // Sorts the array list storing the products from lowest to highest price
		for (VideoGameMenu items: videoGames)
		{
			System.out.println("|" +videoGames.indexOf(items) + "| - " +items); // Prints out the video games menu formatted with its index number at the front
		}
		
		return videoGames;
	}
}
