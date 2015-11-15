package Scala
import scala.collection.mutable.ListBuffer
import java.util.Scanner

/**
 * @author jham
 */
class OrderLine {

  /**
   * method for selecting customer orders
   */
  def selectOrder {
    val scanner = new Scanner(System.in)

    println("\nWhich order do you want to view?");

    try {
      val scanner = new Scanner(System.in)
      //method for selecting which order you want to look at
       val choice = scanner.nextLine().toString()
      GetOrderLine(choice)
      displayOrderLine(choice)
    } catch {
      case e: Throwable =>
        e printStackTrace ()
        println("Failed to select a correct Order ID.");

    }
  }

  def GetOrderLine(Orderid: String): ListBuffer[String] = {

    val Database = new Database

    try {
      if (Database.connection == null) {
        Database.connection
      }
      var Array = new ListBuffer[String]
      val statement = Database.connection.createStatement()
      val sql = ("SELECT customerorderid, productname, quantity FROM CustomerOrderLine, Product WHERE customerorderline.productid = product.productid AND customerorderid = " + Orderid)
      // creates the statement, and run the select query

      val resultSet = statement.executeQuery(sql)

      def recursion {
        if (resultSet.next()) {
          val pid = resultSet.getString("customerorderid")
          val product = resultSet.getString("productname")
          val quantity = resultSet.getString("quantity")

          val output = "Order ID: " + pid + "  Product: " + product + "  Quantity: " + quantity
          Array += (output)
          recursion
        }
      }
      recursion
      Array

    } catch {

      case e: Throwable =>
        {
          e.printStackTrace
          null
        }
    }
  }

  def Read(i: Int, Array: ListBuffer[String]): Unit = {

    // If not at the end of the list
    if (i < Array.length) {
      println(Array(i))

      // i++
      Read(i + (1), Array)
    }
  }

  def displayOrderLine(orderid: String): Unit = {
    val Array = GetOrderLine(orderid)
    // i = 0
    Read(0, Array)
  }

}