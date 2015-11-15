package Scala

import java.util.Scanner
import java.util.Date
import java.text.SimpleDateFormat
import scala.collection.mutable.ListBuffer

/**
 * @author jham
 */
class Product {
  //method for getting a list of all products from the database
  def GetProducts: ListBuffer[String] = {

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
      var productArray = new ListBuffer[String]

      def recursion {
        if (resultSet.next()) {
          //passing gathered column Data into variables
          val pid = resultSet.getString("productid")
          val pname = resultSet.getString("productname")
          val pdescription = resultSet.getString("description")
          val price = resultSet.getString("price")
          val img = resultSet.getString("stocklevel")
          val output = "ID: " + pid + "  Name: " + pname + "  Description: " + pdescription +
            "  Price: " + price + " Stock Level " + img
          productArray += (output)
          recursion
        }
      }

      recursion
      productArray

    } catch {

      case e: Throwable =>
        {
          e.printStackTrace
          null
        }
    }

  }

  def Read(i: Int, productArray: ListBuffer[String]): Unit = {

    // If not at the end of the list
    if (i < productArray.length) {
      println(productArray(i))

      // i++
      Read(i + (1), productArray)
    }
  }

  def displayProducts: Unit = {
    val productArray = GetProducts
    // i = 0
    Read(0, productArray)
  }

  def RemoveStock {
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
  }

  def output(productid: String): String = {
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