package VideoGameStoreApp;
/**
 * This is an interface class which is implemented
 * by the UserMenuSelection class. This interface class
 * contains all the methods that the UserMenuSelection class
 * must use and implement.
 * @author Siddarath Kumar 19075068
 **/
import java.util.ArrayList;

public interface MenuSelection {

	public char addOrReturn(String menuType);
	
	public int homeScreen(ShopGraphics graphics);
	
	public int customerMenu(ArrayList<CustomerShoppingCart> shoppingCart, int modeSelection, int menuModeSelection, ShopGraphics graphics, FileInputOutputs storeFiles);
	
	public int staffMenu(ShopGraphics graphics, FileInputOutputs storeFiles, int menuModeSelection);
	
	public Customer enterCustomerDetails();
	
	public Staff enterStaffDetails(Staff staffUser);
	
	public int makePayment();
	
	public void returnPress();
}
