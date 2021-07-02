package VideoGameStoreApp;
/**
 * The purpose of this class it to maintain the protected instance variables for products
 * and these variables consists of the product name, price, console type, video game genre,
 * accessory type, condition status and the stock status. This class is a super class 
 * which the sub class will inherit certain characteristics from. This class additionally
 * has getter and setter methods for each variable so its accessible from outside this class
 * and also it contains the toString method that outputs the instance variables values.
 * @author Siddarath Kumar 19075068
 **/
public class Products {

	protected String productName;
	protected Double productPrice;
	protected ConsoleType consoleType;
	protected VideoGameGenres videoGameGenres;
	protected AccessoryType accessoryType;
	protected Condition conditionStatus;
	protected Stock stockStatus;
	
	/**
	 * This is a constructor for the Products class that contains input for all instance variables except the video game
	 * genre and accessory type to initialize the Product objects.
	 * @param productName the parameter represents the products name.
	 * @param productPrice the parameter represents the product price.
	 * @param consoleType the parameter represents the enumerated type ConsoleType which holds the different types of consoles.
	 * @param conditionStatus the parameter represents the enumerated type Condition which holds whether the product is new or pre-owned.
	 * @param stockStatus the parameter represents the enumerated type Stock which holds if the product is in stock or not.
	 * @return none.
	 * @author 19075068
	 **/
	public Products(String productName, Double productPrice, ConsoleType consoleType, Condition conditionStatus, Stock stockStatus)
	{
		this.productName = productName;
		this.productPrice = productPrice;
		this.consoleType = consoleType;
		this.conditionStatus = conditionStatus;
		this.stockStatus = stockStatus;
	}
	
	/**
	 * This is a constructor for the Products class that contains input for all instance variables except the console type
	 * and accessory type to initialize the Product objects.
	 * @param productName the parameter represents the products name.
	 * @param productPrice the parameter represents the product price. 
	 * @param videoGameGenres the parameter represents the enumerated type VideoGameGenres which holds the genre of the video game.
	 * @param conditionStatus the parameter represents the enumerated type Condition which holds whether the product is new or pre-owned.
	 * @param stockStatus the parameter represents the enumerated type Stock which holds if the product is in stock or not.
	 * @return none.
	 * @author 19075068
	 **/
	public Products(String productName, Double productPrice, VideoGameGenres videoGameGenres, Condition conditionStatus, Stock stockStatus)
	{
		this.productName = productName;
		this.productPrice = productPrice;
		this.videoGameGenres = videoGameGenres;
		this.conditionStatus = conditionStatus;
		this.stockStatus = stockStatus;
	}
	
	/**
	 * This is a constructor for the Products class that contains input for all instance variables except the console type
	 * and video game genre to initialize the Product objects.
	 * @param productName the parameter represents the products name.
	 * @param productPrice the parameter represents the product price.  
	 * @param accessoryType the parameter represents the enumerated type AccessoryType which holds the different types of accessories the product can be.
	 * @param conditionStatus the parameter represents the enumerated type Condition which holds whether the product is new or pre-owned. 
	 * @param stockStatus the parameter represents the enumerated type Stock which holds if the product is in stock or not.
	 * @return none.
	 * @author 19075068
	 **/
	public Products(String productName, Double productPrice, AccessoryType accessoryType, Condition conditionStatus, Stock stockStatus)
	{
		this.productName = productName;
		this.productPrice = productPrice;
		this.accessoryType = accessoryType;
		this.conditionStatus = conditionStatus;
		this.stockStatus = stockStatus;
	}
	
	/**
	 * This getProductName method will return the instance variable productName.
	 * The same concept applies to all the other get methods below.
	 * @param none.
	 * @return productName the instance variable.
	 * @author 19075068
	 **/
	public String getProductName()
	{
		return productName;
	}
	
	/**
	 * This setProductName method will update the value of the instance variable productName.
	 * The same concept applies to all the other set methods below.
	 * @param productName the parameter that represents the name of the product.
	 * @return none.
	 * @author 19075068
	 **/
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	
	public Double getProductPrice()
	{
		return productPrice;
	}
	
	public void setProductPrice(Double productPrice)
	{
		this.productPrice = productPrice;
	}
	
	public ConsoleType getConsoleType()
	{
		return consoleType;
	}
	
	public void setConsoleType(ConsoleType consoleType)
	{
		this.consoleType = consoleType;
	}
	
	public VideoGameGenres getVideoGamesGenres()
	{
		return videoGameGenres;
	}
	
	public void setVideoGameGenres(VideoGameGenres videoGameGenres)
	{
		this.videoGameGenres = videoGameGenres;
	}
	
	public AccessoryType getAccessoryType()
	{
		return accessoryType;
	}
	
	public void setAccessoryType(AccessoryType accessoryType)
	{
		this.accessoryType = accessoryType;
	}
	
	public Condition getConditionStatus()
	{
		return conditionStatus;
	}
	
	public void setConditionStatus(Condition conditionStatus)
	{
		this.conditionStatus = conditionStatus;
	}
	
	public Stock getStockStatus()
	{
		return stockStatus;
	}
	
	public void setStockStatus(Stock stockStatus)
	{
		this.stockStatus = stockStatus;
	}
	
	/**
	 * This toString method will return a string representation of Products class object.
	 * @param none.
	 * @return a string that outputs all the instance variable values for the products.
	 * @author 19075068
	 **/
	public String toString()
	{
		return "Product Name: " +this.productName+ " Price: $" +this.productPrice+ " Console Type: " +this.consoleType+
				" Condition: " +this.conditionStatus+ " Stock: " +this.stockStatus;
	}
	
}
