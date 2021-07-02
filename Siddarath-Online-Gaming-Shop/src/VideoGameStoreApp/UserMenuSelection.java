package VideoGameStoreApp;
/**
 * The UserMenuSelection class controls the user input of the whole
 * program and navigates what should happen to the user. This class contains 
 * 8 methods which each serve a purpose and consists of dealing 
 * with user input, printing out statements, and navigating to the other
 * methods in other classes to calculate, add and read details.
 * @author Siddarath Kumar 19075068
 **/
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserMenuSelection implements MenuSelection {
	
	Scanner scan = new Scanner(System.in);
	CustomerShoppingCart cartItems = new CustomerShoppingCart();

	/**
	 * This method will ask the user to input to either go to the customer menu, staff menu or
	 * to exit the shop. This method will keep on asking the user to enter a choice until a valid
	 * input is provided.
	 * @param graphics the parameter represents an object of the ShopGraphics class.
	 * @return modeChoice the integer instance variable which corresponding to what mode the user wants to go to.
	 * @author 19075068
	 **/
	public int homeScreen(ShopGraphics graphics) throws InputMismatchException
	{	
		int modeChoice = 0;
		boolean success = false;
		while(!success)
		{
			try // Using try and catch blocks to handle exceptions
			{
				System.out.println("Enter choice here: ");
				modeChoice = scan.nextInt();
				
				if (modeChoice == 1)
				{
					System.out.println("You will be directed to the customer menu!");
					success = true;
				}
				else if (modeChoice == 2)
				{
					graphics.staffHomeScreen();
					success = true;
				}
				else if (modeChoice == 3)
				{
					System.out.println("\nYou have chosen to exit the online shop. Thanks for shopping with us, Goodbye!");
					success = true;
				}
				else if (modeChoice !=1 || modeChoice !=2|| modeChoice !=3)
				{
					System.err.println("Invalid menu input. Please a enter choice in range."); // Show error message to console
					scan.nextLine(); // flushes the input buffer
				}
			}
			catch(InputMismatchException e)
			{
				System.err.println("Invalid menu input. Please enter choice again."); // Show error message to console
				scan.nextLine(); // flushes the input buffer
			}
		}
		
		return modeChoice;
	}
	
	/**
	 * This method will ask the user for a single character of 'A' or 'B' input for if they wanted to either
	 * proceed to add items to the cart/proceed to the checkout or to go back to the customer menu.
	 * @param menuType the string parameter represents a string either "addingtoCart" or "pruchasing".
	 * @return userChoice the variable which contains either the input A or B representing what the next action will be
	 * @author 19075068
	 **/
	public char addOrReturn(String menuType)
	{
		char userChoice = '?';
		boolean success = false;
		while(!success)
		{
			if (menuType.equals("addingtoCart"))
			{
				System.out.println("Press 'A' to add items to cart");
				System.out.println("Press 'B' to go back to the customer menu screen");
			}
			else if (menuType.equals("purchasing"))
			{
				System.out.println("Press 'A' to proceed to the checkout");
				System.out.println("Press 'B' to go back to the customer menu screen");
			}
			
			System.out.print("\nEnter choice here: ");
			userChoice = scan.next().charAt(0);
			
			if (Character.toString(userChoice).equalsIgnoreCase("A") || Character.toString(userChoice).equalsIgnoreCase("B"))
			{
				success = true;
			}
			else
			{
				System.err.println("Invalid choice. Please enter A or B.");
				scan.nextLine();
			}
		}
		return userChoice;
	}
	
	/**
	 * This method will manage how the customer menu interacts and works. This method will ask the user if they wanted to go to a sub menu,
	 * what sub menu of the customer menu they would like to go. Using the users input the program will manage what is shown to the console.
	 * If the user selects an option of the customer sub menu it will either show the specific menus, process adding the users items to a cart,
	 * remove specific items from the cart and also process the payment so the user can purchase the items they added to their cart.
	 * 
	 * @param shoppingCart the parameter is an object of the Array list of the shopping cart class containing the cart items.
	 * @param modeSelection the parameter represents the user input of what mode they selected.
	 * @param subMenuSelection the parameter represent the user input for what sub menu they selected.
	 * @param graphics the parameter is an object of the ShopGraphics class.
	 * @param storeFiles the parameter is an object of the FileInputOutputs class.
	 * @return subMenuSelection the integer of what sub menu option the the user selected to go to next. 
	 * @author 19075068
	 **/
	public int customerMenu(ArrayList<CustomerShoppingCart> shoppingCart, int modeSelection, int subMenuSelection, ShopGraphics graphics, FileInputOutputs storeFiles) throws InputMismatchException
	{
		int purchaseOptions;
		
		while (subMenuSelection != 6) // The customer menu will repeat until the user decided to press 6 and exit the loop back to the main menu
		{
			while (modeSelection == 1) // Loop occurs if the user decides to enter the customer mode
			{
				boolean success = false;
				while(!success)
				{
					try
					{
						graphics.customerHomeScreen();
						System.out.print("Enter choice here: ");
						subMenuSelection = scan.nextInt();  
						System.out.println();
						
						if (subMenuSelection >=1 && subMenuSelection <=6)
						{
							success = true;
						}
						else
						{
							System.err.println("Invalid menu. Please enter choice again.");
						}
					}
					catch(InputMismatchException e)
					{
						System.err.println("Invalid menu. Please enter choice again.");
						scan.next();
					}
				}
				
				if (subMenuSelection == 1) // Loop occurs when the user selects to go to the console menu
				{
					graphics.consoleBanner();
					ArrayList<ConsoleMenu> consoleMenu = ConsoleMenu.outputMenu();
					purchaseOptions = addOrReturn("addingtoCart");
					
					if (Character.toString(purchaseOptions).equalsIgnoreCase("B"))
					{
						System.out.println("You chose to return to the store menu screen");
					}
					else if (Character.toString(purchaseOptions).equalsIgnoreCase("A"))
					{
						int count = 0; 
						int itemToAdd = 0;
						int addNItems = findQuantityToAdd();
						
						while (count< addNItems)
						{
							try
							{
								System.out.println("Enter an item number (shown to the left) to add to the cart: ");
								itemToAdd = scan.nextInt(); 
								
								if (itemToAdd >= 0 && itemToAdd <=4)
								{
									CustomerShoppingCart itemDetails = new CustomerShoppingCart(consoleMenu.get(itemToAdd).getProductName(),consoleMenu.get(itemToAdd).getConditionStatus(),consoleMenu.get(itemToAdd).getProductPrice()); // Creates an object and initializes it with the chosen product details
									shoppingCart.add(itemDetails); // This adds the selected item to the shopping cart
									count++;
								}
								else
								{
									System.err.println("Invalid choice, product doesn't exist. Please try again!");
									scan.nextLine();
								}
							}
							catch(InputMismatchException e)
							{
								System.err.println("Invalid input. Please try again");
								scan.nextLine();
							}
						}
						cartItems.currentCartItems(shoppingCart);
						returnPress();
					}
				}
				else if (subMenuSelection == 2) // Loop occurs when the user selects to go to the video games menu
				{
					graphics.videoGamesBanner();
					ArrayList<VideoGameMenu> gamesMenu = VideoGameMenu.outputMenu();
					purchaseOptions = addOrReturn("addingtoCart");
					
					if (Character.toString(purchaseOptions).equalsIgnoreCase("B"))
					{
						System.out.println("You chose to return to the store menu screen");
					}
					else if (Character.toString(purchaseOptions).equalsIgnoreCase("A"))
					{
						int count = 0; 
						int itemToAdd = 0;
						int addNItems = findQuantityToAdd();
						
						while (count< addNItems)
						{
							try
							{
								System.out.println("Enter an item number (shown to the left) to add to the cart:");
								itemToAdd = scan.nextInt(); 
								
								if (itemToAdd >= 0 && itemToAdd <=6)
								{
									CustomerShoppingCart itemDetails = new CustomerShoppingCart(gamesMenu.get(itemToAdd).getProductName(),gamesMenu.get(itemToAdd).getConditionStatus(),gamesMenu.get(itemToAdd).getProductPrice()); // Creates an object and initializes it with the chosen product details
									shoppingCart.add(itemDetails); // This adds the selected item to the shopping cart
									count++;
								}
								else
								{
									System.err.println("Invalid choice, product doesn't exist. Please try again!");
									scan.nextLine();
								}
							}
							catch(InputMismatchException e)
							{
								System.err.println("Invalid input. Please try again");
								scan.nextLine();
							}
						}
						cartItems.currentCartItems(shoppingCart);
						returnPress();
					}
				}
				else if (subMenuSelection == 3) // Loop occurs when the user selects to go to the accessory menu
				{
					graphics.accessoriesBanner();
					ArrayList<AccessoryMenu> accessoriesMenu = AccessoryMenu.outputMenu();
					purchaseOptions = addOrReturn("addingtoCart");
					
					if (Character.toString(purchaseOptions).equalsIgnoreCase("B"))
					{
						System.out.println("You chose to return to the store menu screen");
					}
					else if (Character.toString(purchaseOptions).equalsIgnoreCase("A"))
					{
						int count = 0; 
						int itemToAdd = 0;
						int addNItems = findQuantityToAdd();
						
						while (count< addNItems)
						{
							try
							{
								System.out.println("Enter an item number (shown to the left) to add to the cart: ");
								itemToAdd = scan.nextInt(); 
								
								if (itemToAdd >= 0 && itemToAdd <=6)
								{
									CustomerShoppingCart itemDetails = new CustomerShoppingCart(accessoriesMenu.get(itemToAdd).getProductName(),accessoriesMenu.get(itemToAdd).getConditionStatus(), accessoriesMenu.get(itemToAdd).getProductPrice()); // Creates an object and initializes it with the chosen product details
									shoppingCart.add(itemDetails); // This adds the selected item to the shopping cart
									count++;
								}
								else
								{
									System.err.println("Invalid choice, product doesn't exist. Please try again!");
									scan.nextLine();
								}
							}
							catch(InputMismatchException e)
							{
								System.err.println("Invalid input. Please try again");
								scan.nextLine();
							}
						}
						cartItems.currentCartItems(shoppingCart);
						returnPress();
					}
				}
				else if(subMenuSelection == 4) // Loop occurs if the user selects to view or remove items from cart
				{
					if (cartItems.totalCost(shoppingCart) == 0)
					{
						System.out.println("You have not added anything to cart yet! You have been redirected to the customer menu");
					}
					else 
					{
						removeCartItems(cartItems, shoppingCart,subMenuSelection );
					}	
				}
				else if(subMenuSelection == 5) // Loop occurs if the user selects to proceed to checkout
				{	
					if (cartItems.totalCost(shoppingCart) == 0)
					{
						System.out.println("You have not added anything to cart yet! You have been redirected to the customer menu");
					}
					else if (cartItems.totalCost(shoppingCart) > 0)
					{
						cartItems.currentCartItems(shoppingCart);
						purchaseOptions = addOrReturn("purchasing");
						
						if (Character.toString(purchaseOptions).equals("B") || Character.toString(purchaseOptions).equals("b"))
						{
							System.out.println("You chose to return to the store menu screen");
						}
						else if (Character.toString(purchaseOptions).equals("A") || Character.toString(purchaseOptions).equals("a"))
						{
							Customer newCustomer = enterCustomerDetails();
							
							System.out.println("\nIf you are under 20 or over 50 years old, you are eligible for a discount!");
							newCustomer.discountApplicable(newCustomer.getAge());
							System.out.println("Your total amount to pay is: $" +(cartItems.totalCost(shoppingCart) - cartItems.calculateDiscount(newCustomer.getAge(), cartItems.totalCost(shoppingCart))));
							System.out.println("\nTo complete the purchase and pay, enter the following details...");
							
							int pinAttempt = makePayment();
							if (pinAttempt == 0)
							{
								System.out.println("You have been locked out of purchasing these items due to exceeding the number of incorrect attempts!");
								System.out.println("Your cart has now been erased, please start again!");
							}
							else 
							{
								System.out.println("\nYour payment has been successful! The following is your receipt!\n");
								storeFiles.writeCustomerReceipt(shoppingCart, newCustomer.getFirstName(), newCustomer.getLastName(), +newCustomer.getMobile(), newCustomer.getDeliveryAddressNumber(), newCustomer.getDeliveryAddress(), newCustomer.getEmail(), newCustomer.getAge(), cartItems);
								storeFiles.readCustomerReceipt(); // Line above writes customer receipt details into a text file and this line reads the text file
								newCustomer.showSpecialMessage();
								
								storeFiles.writeCustomerDetails(newCustomer.getFirstName(), newCustomer.getLastName(), newCustomer.getMobile(), newCustomer.getEmail(), newCustomer.getDeliveryAddressNumber(), newCustomer.getDeliveryAddress());
								storeFiles.writePurchasedProducts(shoppingCart, newCustomer.getFirstName(), newCustomer.getLastName());
							}
							cartItems.clearProducts(shoppingCart); // Clears items from the shopping cart
							returnPress();
						}
					}
				}
				else if(subMenuSelection == 6) // Occurs if the user decided to exit the customer menu
				{
					System.out.println("You chose to be redirected to the main menu.");
					modeSelection = 3;
				}
				
			}
			if (modeSelection == 2) // Occurs if the customer selects to access the staff menu
			{
				subMenuSelection = staffMenu(graphics, storeFiles, subMenuSelection); // Invoked the staff menu where the sub menus and user input occurs
				System.out.println("\nYou will now leave the staff mode!");
				modeSelection = 3;
			}
		}
		return subMenuSelection;
	}
				
	/**
	 * This method is triggered if the user decided to access the staff mode.
	 * This staff menu method will output the staff menu options and then ask the user to choose what option
	 * they prefer. If they user chooses to proceed this method calls another method which records the staff
	 * details and then it returns to the method where if the user is granted access to this mode they are able
	 * to choose and view the store records stored in the text file. The user at this points after viewing the details
	 * they want, they can exit this mode and they will return to the main menu.
	 * 
	 * @param graphics the parameter is an object of the ShopGraphics class.
	 * @param storeFiles the parameter is an object of the FileInputOutputs class 
	 * @param subMenuSelection the parameter represent the user input for what sub menu they selected.
	 * @return menuModeSelection the integer variables represents the value 6 so that it can return to the customer menu method and return to the main menu.
	 * @author 19075068
	 **/
	public int staffMenu(ShopGraphics graphics, FileInputOutputs storeFiles, int menuModeSelection) throws InputMismatchException
	{
		int nextStep = 0;
		String firstname = null, lastname = null, username = null, password = null;
		Staff staffUser = new Staff(firstname, lastname, username, password);
		boolean success = false;
		
		while(!success)
		{
			try
			{
				System.out.println("Press 1 to proceed to the staff menu");
				System.out.println("Press 2 to go back to main.");
				System.out.print("\nEnter your choice: ");
				nextStep = scan.nextInt();
				
				if (nextStep == 1 || nextStep == 2)
				{
					success = true;
				}
				else
				{
					System.err.println("Invalid menu input. Please try again.\n");
					scan.nextLine();
				}
				
			}
			catch(InputMismatchException e)
			{
				System.err.println("Invalid menu input. Please try again.\n");
				scan.nextLine();
			}
		}
		
		if (nextStep == 1) // If the user decides to proceed to the staff menu the following occurs
		{
			enterStaffDetails(staffUser);			
			if (staffUser.getPassword().equals("2020p2AUT")) // If the staff member enters the correct password the following loop occurs
			{
				staffUser.showSpecialMessage();
				storeFiles.writeStaffEntry(staffUser.getFirstName(), staffUser.getLastName(), staffUser.getUsername());
				int subMenuChoice =0;
				
				while (subMenuChoice !=4) // Until the user presses 4 to quit and exit to the main the loop will be run
				{
					try
					{
						graphics.staffMenu();
						System.out.print("\nEnter your choice: ");
						subMenuChoice = scan.nextInt();
						
						if (subMenuChoice == 1)
						{
							System.out.println("\nThe following are the details of the customers who have purchased with us ");
							System.out.println("----------------------------------------------------------------------------");
							storeFiles.readCustomerDetails();
							System.out.println("");
						}
						else if (subMenuChoice == 2)
						{
							System.out.println("\nThe following are the details of products we have sold ");
							System.out.println("--------------------------------------------------------");
							storeFiles.readPurchasedProducts();
							System.out.println("");
						}
						else if (subMenuChoice == 3)
						{
							System.out.println("\nThe following are the details of the staff who logged onto this mode ");
							System.out.println("---------------------------------------------------------------------");
							storeFiles.readStaffEntry();
							System.out.println("");
						}
						else if (subMenuChoice >4 || subMenuChoice <1)
						{
							System.err.println("Invalid menu input. Please try again.\n");
							scan.nextLine(); // flushes the input buffer
						}
					}
					catch(InputMismatchException e)
					{
						System.err.println("Invalid menu input. Please try again.\n");
						scan.nextLine(); // flushes the input buffer
					}
				}
				nextStep = 2;
			}
			else
			{
				System.out.println("\nIncorrect password entered. Access denied. You have been locked out!");
				nextStep = 2;
			}	
		}
		
		if (nextStep == 2)
		{
			menuModeSelection = 6;
		}
		
		return menuModeSelection;
	}
	
	/**
	 * This method will ask the staff to enter their first name, last name, password and the universal
	 * password and it will store it in the object of the Staff class. This method is called in the staff
	 * menu method.
	 * @param staffUser the parameter represents the object of Staff class.
	 * @return staffUser the updated object of the Staff class is returned.
	 * @author 19075068
	 **/
	public Staff enterStaffDetails(Staff staffUser)
	{
		System.out.println("Enter the following details to continue!\n");
		System.out.print("Enter your first name: ");
		staffUser.setFirstName(scan.next());
		System.out.print("Enter your last name: ");
		staffUser.setLastName(scan.next());
		System.out.print("Enter your username: ");
		staffUser.setUsername(scan.next());
		System.out.print("Enter the universal password (hint: its 2020p2AUT): ");
		staffUser.setPassword(scan.next());
		
		return staffUser;
	}
	
	/**
	 * This method will ask the user to enter their details in order to process the purchase.
	 * Once the user enters a value it is stored in the customer object. This method is called in the 
	 * customer menu method.
	 * @param none.
	 * @return newCustomer the updated object of the Customer class is returned with the details.
	 * @author 19075068
	 **/
	public Customer enterCustomerDetails()
	{
		String firstName = null, lastName = null, deliveryNumberLetter = null, deliveryAddress = null,email = null;
		int age = 0, mobile = 0;
		Customer newCustomer = new Customer(firstName, lastName, age, mobile,deliveryNumberLetter, deliveryAddress,email);
		
		System.out.println("\nTo pay for the following items please enter the following details");
		System.out.println("-----------------------------------------------------------------------------------------------------");
		System.out.println("Enter your first name: ");
		newCustomer.setFirstName(scan.next());
		System.out.println("Enter your last name: ");
		newCustomer.setLastName(scan.next());
		System.out.println("Enter your age: ");
		newCustomer.setAge(scan.nextInt());
		System.out.println("Enter your mobile number: ");
		newCustomer.setMobile(scan.nextInt());
		System.out.println("Enter your email address: ");
		newCustomer.setEmail(scan.next());
		System.out.print("Enter your delivery address number and letter (no spaces use hypens[-]): ");
		newCustomer.setDeliveryAddressNumber(scan.next());
		System.out.print("Enter your delivery address (no spaces use hypens[-]): ");
		newCustomer.setDeliveryAddress(scan.next());
		
		return newCustomer;
	}
	
	/**
	 * The make payment method will ask the user to enter payment details. The user will first be asked to enter their bank 
	 * account number and then they will be asked to enter 5 digit/letter pin number in order to successfully make their 
	 * payment.This method uses try and catch blocks to handle errors with exceptions. This method is called in the customer menu
	 * method.
	 * @param none.
	 * @return pinAttempts the integer variables returns the amount of attempts the customer used to identify the next step of the program.
	 * @author 19075068
	 **/
	public int makePayment() throws InputMismatchException
	{
		int accountNumber = 0;
		int pinAttempts = 3;
		String userPurchasePin;
		boolean done = false;
		boolean success = false;
		
		while(!success)
		{
			try
			{
				System.out.print("\nEnter your bank account number: ");
				accountNumber = scan.nextInt();
				success = true;
			}
			catch(InputMismatchException e)
			{
				System.err.println("Invalid input, enter digits only. Please try again.");
				scan.nextLine();
			}
		}
		
		do
		{
			System.out.print("Enter your 5 digit or letter pin: ");
			userPurchasePin = scan.next();
			
			if (userPurchasePin.length() <5 || userPurchasePin.length() >5)
			{
				pinAttempts--;
				System.out.println("Invalid pin input, you have " +pinAttempts +" attempts remaining!\n");
			}
			else if (userPurchasePin.length() == 5)
			{
				done = true;
			}
			
			if (pinAttempts == 0)
			{
				done = true;
			}
			
		}while(!done);
		
		return pinAttempts;
	}
	
	/**
	 * This method will ask the user to enter the number of items that they want to add to the cart and store
	 * that in a variable so it can return it to the customer menu method.
	 * @param none.
	 * @return addNItems the integer variable containing the number of items the user wants to add is returned.
	 * @author 19075068
	 **/
	public int findQuantityToAdd() throws InputMismatchException
	{
		int addNItems = 0;
		boolean success = false;
		
		while(!success)
		{
			try
			{
				System.out.print("\nEnter the number of items you will like add to the cart: ");
				addNItems = scan.nextInt();
				
				if (addNItems >0 && addNItems<11)
				{
					success = true;
				}
				else
				{
					System.err.println("Invalid input. You can only add up to 10 items at a time!");
					scan.nextLine();
				}
			}
			catch(InputMismatchException e)
			{
				System.err.println("Invalid input. Please try again.");
				scan.nextLine();
			}
		}
		return addNItems;
	}
	
	/**
	 * This method will ask the user if they would like to remove items from their current cart
	 * and it will call another method inside it that would remove that particular item if the
	 * customer wants to remove an item. If the user doesn't want to remove an item from the cart
	 * they will be directed back to the customer menu method.
	 * @param cartItems the parameter represents an object of the CustomerShoppingCart class.
	 * @param shoppingCart the parameter is an object of the Array list of the shopping cart class which contains the cart items.
	 * @param subMenuSelection the parameter represents the integer user input of what mode they selected.
	 * @return none.
	 * @author 19075068
	 **/
	public void removeCartItems(CustomerShoppingCart cartItems, ArrayList<CustomerShoppingCart> shoppingCart, int subMenuSelection)
	{
		char userRemoveItem = '?';
		int itemNumberToRemove;
		boolean done = false;
		
		do
		{
			System.out.println("The following is the current items in your cart!");
			System.out.println("--------------------------------------------------------------------------------------------------------");
			cartItems.currentCartItems(shoppingCart);
			
			System.out.print("Do you want to remove an item from the cart (Y or N): ");
			userRemoveItem = scan.next().charAt(0);
			
			if (Character.toString(userRemoveItem).equalsIgnoreCase("Y"))
			{
				System.out.print("Please enter the item number you want to remove: ");
				itemNumberToRemove = scan.nextInt();
				
				shoppingCart.remove(itemNumberToRemove);
				System.out.println("\nThe item you requested has been removed.");
			}
			else if (Character.toString(userRemoveItem).equalsIgnoreCase("N"))
			{
				done = true;
				returnPress();
				subMenuSelection = 6;
			}
			else
			{
				System.err.println("Invalid choice. Please try again.");
				scan.nextLine();
			}
		}while(!done);
	}
	
	/**
	 * This method will ask the user to press any key to return to the customer menu and
	 * once the user presses this, they will be returned back to start of the customer menu
	 * method where they are asked to choose from the sub menus.
	 * @param none.
	 * @return none
	 * @author 19075068
	 **/
	public void returnPress()
	{
		String exitPress;
		System.out.print("\nPress any key to return to the customer menu: ");
		exitPress = scan.next();
	}
}
