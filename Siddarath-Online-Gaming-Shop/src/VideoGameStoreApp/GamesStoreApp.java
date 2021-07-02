package VideoGameStoreApp;
/**
 * This is the main driver class of the game store application.
 * This class only contains the main method which will run the 
 * program by making objects of the classes and calling the necessary
 * methods.
 * @author Siddarath Kumar 19075068
 **/
import java.util.ArrayList;

public class GamesStoreApp 
{
	/**
	 * This is the main method which controls the flow of the whole application.
	 * This method declares the instance variables which controls the loop of the programs
	 * and creates the objects of the CustomerShoppingCart, FileInputOutputs, 
	 * ShopGraphics and UserMenuSelection class. The program then uses a do while loop 
	 * where it repeats calling methods from different classes to run the program in order.
	 * @param args which is a string parameter.
	 * @return none.
	 * @author 19075068
	 **/
	public static void main(String[] args) 
	{
		int modeSelection;
		int subMenuSelection = 0;
		int returnHome;
		
		ArrayList<CustomerShoppingCart> shoppingCart = new ArrayList<CustomerShoppingCart>();
		FileInputOutputs storeFiles = new FileInputOutputs();
		ShopGraphics graphics = new ShopGraphics();
		UserMenuSelection menu = new UserMenuSelection();
		
		do
		{
			returnHome = 0;
			graphics.banner();
			modeSelection = menu.homeScreen(graphics); // Based on the users input it will output the specific graphics
			returnHome = menu.customerMenu(shoppingCart,modeSelection, subMenuSelection, graphics, storeFiles); // Calls the customerMenu class from the userMenuSelection class
			modeSelection = 0;
			subMenuSelection = 0;
		}while(returnHome == 6); // Will end the program once 6 is returned 
	}
}
