package VideoGameStoreApp;
/**
 * This class maintains the file input and output methods. This class contains
 * methods that will write customer, staff and product sold details onto to a file
 * and this class also contains methods that will read the information stored onto each 
 * of these files.
 * @author Siddarath Kumar 19075068
 **/
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInputOutputs {

	/**
	 * This method will use the PrintWriter and FileWriter class to write the customer details into the
	 * text file "customersWhoPurchased.txt".
	 * @param firstName the parameter represents the first name of the customer.
	 * @param lastName the parameter represents the customers last name.
	 * @param mobile the parameter represents the mobile number of the customer.
	 * @param email the parameter represents the email address of the customer.
	 * @param deliveryAddressNumber the parameter represents the delivery address number of the customer.
	 * @param deliveryAddress the parameter represents the delivery address of the customer
	 * @return none.
	 * @author 19075068
	 **/
	public void writeCustomerDetails (String firstName, String lastName, int mobile, String email, String deliveryAddressNumber, String deliveryAddress)
	{
		try 
		{
			PrintWriter out = new PrintWriter(new FileWriter("customersWhoPurchased.txt", true));
			out.println("First Name: " +firstName);			
			out.println("Last Name: " +lastName);
			out.println("Mobile number: " +mobile);
			out.println("Email: " +email);
			out.println("Devliery address: " +deliveryAddressNumber+ " " +deliveryAddress);
			out.println(" ");
			out.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: Cannot open file for writing");
		}
		catch(IOException e)
		{
			System.out.println("Error: Cannot write to file");
		}
	}
	
	/**
	 * This method will use the PrintWriter class and FileWriter class to write the purchased
	 * products from the store in the "soldProducts.txt" text file so the store monitor the sold products.
	 * @param purchasedProducts the parameter represents the ArrayList object of the CustomerShoppingCart class.
	 * @param firstName the parameter represents the first name of the customer.
	 * @param lastName the parameter represents the customers last name.
	 * @return none.
	 * @author 19075068
	 **/
	public void writePurchasedProducts (ArrayList<CustomerShoppingCart> purchasedProducts, String firstName, String lastName)
	{
		try 
		{
			PrintWriter out = new PrintWriter(new FileWriter("soldProducts.txt", true));
			
			out.println(firstName+ " " +lastName+ " has purchased the following.........................................");
			for (CustomerShoppingCart itemDetails: purchasedProducts)
			{
				out.println(itemDetails);
			}
			out.println(" ");
			out.close();
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: Cannot open file for writing");
		}
		catch(IOException e)
		{
			System.out.println("Error: Cannot write to file");
		}
	}
	
	/**
	 * This method will use the PrintWriter and FileWriter class to write the staff details into the
	 * text file "StaffEntryRecords.txt" to monitor and keep track details of what staff use the staff mode.
	 * @param firstName the parameter represents the first name of the staff.
	 * @param lastName the parameter represents the staffs last name.
	 * @param userName the parameter represents the staffs user name.
	 * @return none.
	 * @author 19075068
	 **/
	public void writeStaffEntry(String firstName, String lastName, String userName)
	{
		try 
		{
			PrintWriter out = new PrintWriter(new FileWriter("StaffEntryRecords.txt", true));
			out.println("First Name: " +firstName);
			out.println("Last Name: " +lastName);
			out.println("Username: " +userName);
			out.println(" ");
			out.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: Cannot open file for writing");
		}
		catch(IOException e)
		{
			System.out.println("Error: Cannot write to file");
		}
	}
	
	/**
	 * This method will use the PrintWriter and FileWriter class to write the customer receipt into the
	 * text file "customerReceipt.txt". This method also calculates the discounted and total price the customer
	 * has to pay and puts it in the receipt along with the customer details received from the parameters in a
	 * nice manner. 
	 * @param products the parameter represents the ArrayList object of the CustomerShoppingCart class.
	 * @param firstName the parameter represents the first name of the customer.
	 * @param lastName the parameter represents the customers last name.
	 * @param mobile the parameter represents the mobile number of the customer.
	 * @param deliveryAddressNumber the parameter represents the delivery address number of the customer.
	 * @param deliveryAddress the parameter represents the delivery address of the customer
	 * @param email the parameter represents the email address of the customer.
	 * @param age the parameter represent the age of the customer.
	 * @param items the parameter represents the object of the CustomerShoppingCart class.
	 * @return none.
	 * @author 19075068
	 **/
	public void writeCustomerReceipt(ArrayList<CustomerShoppingCart> products, String firstName, String lastName, int mobile,String deliveryAddressNumber, String deliveryAddress, String email, int age, CustomerShoppingCart items)
	{
		try 
		{
			PrintWriter out = new PrintWriter(new FileWriter("customerReceipt.txt"));
			
			double totalCost = items.totalCost(products);
			double discount = items.calculateDiscount(age, totalCost);
			double totalDiscountedCost = totalCost - discount;
			
			NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
			out.println("================================= CUSTOMER RECEIPT ==================================");
			out.println("Customer Name: " +firstName + " " +lastName);
			out.println("Email: " +email);
			out.println("Mobile Number: "+mobile);
			out.println("Delivery Address: " +deliveryAddressNumber+ " " + deliveryAddress);
			out.println("Age: " +age);
			out.println("-------------------------------------------------------------------------------------");
			out.println("                              Items you have purchased                               ");
			out.println("-------------------------------------------------------------------------------------");
			for (CustomerShoppingCart pItems: products)
			{
				out.println(pItems);
			}
			out.println("-------------------------------------------------------------------------------------");
			out.println("Customers over 50 receive a 20% discount, customers under 20 receive a 15% discount");
			out.println("                                                                               ");
			out.println("Total cost excluding discount: " +currencyFormat.format(totalCost));
			out.println("Discount received: " +currencyFormat.format(discount));
			out.println("                                                                               ");
			out.println("Total cost: " +currencyFormat.format(totalDiscountedCost));
			out.println("=====================================================================================\n");
			out.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error: Cannot open file for writing");
		}
		catch(IOException e)
		{
			System.out.println("Error: Cannot write to file");
		}
	}
	
	/**
	 * This method will read the text file that contains the customers who have purchased from the
	 * store and then outputs those customer details stored in that text file that to the console.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public void readCustomerDetails()
	{
		try
		{
			Scanner reader = new Scanner(new FileReader("customersWhoPurchased.txt"));
			while (reader.hasNext())
			{
				System.out.println(reader.nextLine());
			}
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FileNotFoundException");
		}
	}
	
	/**
	 * This method will read the text file that contains purchased products from the store and then
	 * outputs those details consisting of the product name, price and condition that is stored in that text 
	 * file that to the console.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public void readPurchasedProducts()
	{
		try
		{
			Scanner reader = new Scanner(new FileReader("soldProducts.txt"));
			while (reader.hasNext())
			{
				System.out.println(reader.nextLine());
			}
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FileNotFoundException");
		}
	}
	
	/**
	 * This method will read the text file that contains the staff who have logged into the staff mode
	 * outputs those staff details such as their name and user name to the console.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public void readStaffEntry()
	{
		try
		{
			Scanner reader = new Scanner(new FileReader("StaffEntryRecords.txt"));
			while (reader.hasNext())
			{
				System.out.println(reader.nextLine());
			}
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FileNotFoundException");
		}
	}
	
	/**
	 * This method will read the text file that contains the current customer receipt and
	 * outputs those details such as their personal details, products purchased and discount and total
	 * to pay to the console.
	 * @param none.
	 * @return none.
	 * @author 19075068
	 **/
	public void readCustomerReceipt()
	{
		try
		{
			Scanner reader = new Scanner(new FileReader("customerReceipt.txt"));
			while (reader.hasNext())
			{
				System.out.println(reader.nextLine());
			}
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FileNotFoundException");
		}
	}
}
