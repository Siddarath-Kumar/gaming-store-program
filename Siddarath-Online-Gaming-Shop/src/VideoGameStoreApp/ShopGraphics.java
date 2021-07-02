package VideoGameStoreApp;
/**
 * This class contains the graphics of the online video game store.
 * It is organized in methods with each method containing the relevant
 * message and graphics for the introduction, menus and transitions.
 * Each method is called in the main and the UserMenuSelection class where
 * required.
 * @author Siddarath Kumar 19075068
 **/
public class ShopGraphics {
	
	/**
	 * This method will output to the console the banner of the store with the homescreen 
	 * modes for the user to choose from using print statements.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public void banner()
	{
		System.out.println("===============================================================================");
		System.out.println("||                                                                           ||");
		System.out.println("||                       WELCOME TO GAMING LEGENDS!!!                        ||");
		System.out.println("||                    We sell legendary gaming products                      ||");
		System.out.println("===============================================================================");
		
		System.out.println("\nPress 1 for Customer access");
		System.out.println("Press 2 for Staff access");
		System.out.println("Press 3 to exit online shop\n");

	}
	
	/**
	 * This method will use print statements to output to the console the customer home screen with
	 * the customer menu where they are displayed to either view a menu, view the cart, remove items
	 * from the cart, proceed to checkout and go back to the main menu.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public void customerHomeScreen()
	{
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("          Greetings to the GAMING LEGENDS VIDEO GAME STORE!!!!                 ");
		System.out.println("  We are a new video game store that provides low prices with the best quality ");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Please choose from the following options to view or purchase specific menu items \n");
		System.out.println("Press 1 to go to the Console menu");
		System.out.println("Press 2 to go to the Video Games menu");
		System.out.println("Press 3 to go to the Accessory menu");
		System.out.println("Press 4 to go to view or remove items from your shopping cart");
		System.out.println("Press 5 to proceed to checkout");
		System.out.println("Press 6 to go back to the home screen\n");
	}
	
	/**
	 * This method will use print statements to output to the user the staff home screen banner that will
	 * output a special warning message.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public void staffHomeScreen()
	{
		System.out.println("\n-------------------------------------------------------------------------------");
		System.out.println("                     Welcome to the staff access mode                            ");
		System.out.println("                         Authorised Personnel only!!!                            ");
		System.out.println("                Please enter the following details to continue!!!                ");
		System.out.println("-------------------------------------------------------------------------------");
	
	}
	
	/**
	 * This method will use print statements to output to the user the staff menu.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public void staffMenu()
	{
		System.out.println("Press 1 to view customers who have purchased with us");
		System.out.println("Press 2 to view the items that have been sold");
		System.out.println("Press 3 to view details of the staff who have accessed this mode");
		System.out.println("Press 4 to quit and return to the main menu");
	}
	
	/**
	 * This method will use print statements to output to the user the banner for the video games console menu.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public void consoleBanner()
	{
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("                                           Video Games Console Menu - sorted by price from lowest to highest                               ");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	/**
	 * This method will use print statements to output to the user the banner for the video games menu.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public void videoGamesBanner()
	{
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("                                              Video Games Menu- sorted by price from lowest to highest                                   ");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	/**
	 * This method will use print statements to output to the user the banner for the video games accessory menu.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public void accessoriesBanner()
	{
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("                                              Accessories Menu- sorted by price from lowest to highest                                 ");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------\n");
	}
}
