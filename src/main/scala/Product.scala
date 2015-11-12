import java.sql.DriverManager
import java.util.Scanner
import java.sql.Connection
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author jham
 */
class Product {
  //method for getting a list of all products from the database
  def GetProducts {

    //initiates new database connection
    val Database = new Database

    //if no connection is initiated it will create one
    try {

      if (Database.connection == null) {
        Database.connection
      }

      val statement = Database.connection.createStatement()

      val sql = "SELECT productid, productname, description, price, stocklevel FROM Product, Inventory WHERE inventory.iproductid = product.productid"
      // create the statement, and run the select query

      //run sql query
      val resultSet = statement.executeQuery(sql)

      //passing gathered column Data into variables
      while (resultSet.next()) {
        val pid = resultSet.getString("productid")
        val pname = resultSet.getString("productname")
        val pdescription = resultSet.getString("description")
        val price = resultSet.getString("price")
        val img = resultSet.getString("stocklevel")
        println("ID: " + pid + "  Name: " + pname + "  Description: " + pdescription +
          "  Price: " + price + " Stock Level " + img)

      }
           val scanner = new Scanner(System.in)
        println("Remove Damaged Stock? y/n")
    val choice = scanner.nextLine()

    if (choice.equalsIgnoreCase("y")) {
       println("Which Product Has been Damaged?")
      val choice = scanner.nextLine().toString()
      DamagedStock(choice)
      val producer = new Producer
       producer.RunProducer(choice)
    } else
      Application   

    } catch {

      case e: Throwable => e.printStackTrace
    }
  }
  
  def output(productid: String):String ={
    //get current date time with Date()
    val date = (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date))
    "Product " + productid + " was damaged on " + date
  }
  
  /**
   * jham
   * method for removing damaged Stock
   */
  def DamagedStock(productid: String) {
    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection

      }
      //updates the customer order table
      val statement = Database.connection.createStatement()
      val sql = ("UPDATE Inventory SET stocklevel = stocklevel -1 WHERE iproductid = " + productid)
      statement.executeUpdate(sql);
            output(productid)
    } catch {
      case t: Throwable => t.printStackTrace() // TODO: handle error
    }
  }
  
}