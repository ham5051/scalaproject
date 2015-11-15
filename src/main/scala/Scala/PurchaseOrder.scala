package Scala

import java.util.Scanner
import java.util.Date
import java.text.SimpleDateFormat
import scala.collection.mutable.ListBuffer
/**
 * @author jham
 */
class PurchaseOrder {

  //method gets all purchase orders from the database
  def GetPurchaseOrders: ListBuffer[String] = {

    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection
      }

      val statement = Database.connection.createStatement()

      val sql = "SELECT purchaseorderid, date, status, employeeid FROM PurchaseOrder"
      // creates the statement, and run the select query

      //run sql query
      val resultSet = statement.executeQuery(sql)
      var POArray = new ListBuffer[String]
      
      println("Purchase Orders")
      //passing gathered column Data into variables
      def recursion {
        if (resultSet.next()) {
          val pid = resultSet.getString("purchaseorderid")
          val date = resultSet.getString("date")
          val status = resultSet.getString("status")
          val empid = resultSet.getString("employeeid")

          //print out information gathered from the database
          val output = "ID = " + pid + " Date = " + date + " Order Status = " + status + " Employee ID = " + empid
          
          POArray += (output)
          recursion
        }
      }
      recursion
      POArray

    } catch {

      case e: Throwable =>
        {
          e.printStackTrace
          null
        }
    }
  }

  def Read(i: Int, POArray: ListBuffer[String]): Unit = {

    // If not at the end of the list
    if (i < POArray.length) {
      println(POArray(i))

      // i++
      Read(i + (1), POArray)
    }
  }

  def displayPurchaseOrders: Unit = {
    val Array = GetPurchaseOrders
    // i = 0
    Read(0, Array)
  }
  
//select order to view
  def selectPurchaseOrder {
    val scanner = new Scanner(System.in)
    println("\nWhich order do you want to view?");

    try {
      //method for selecting which order you want to look at

      val PurchaseOrderLine = new PurchaseOrderLine
      PurchaseOrderLine.GetPurchaseOrderLine(scanner.nextLine().toString())
    } catch {

      case e: Throwable =>
        {
          e.printStackTrace
          println("Failed to select a correct Order ID.")

        }
    }
  }

  /**
   * method gets all purchase orders from the database with nested functions for implementing each action
   */
  def ChangePurchaseOrderStatus {

    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection

      }

      val scan = new Scanner(System.in)
      System.out.println("\n Select an Order ID")
      val id = Integer.parseInt(scan.nextLine())

      val statement = Database.connection.createStatement()

      val sql1 = ("SELECT purchaseorderid, date, status, employeeid FROM PurchaseOrder Where purchaseorderid = " + id)

      // creates the statement, and run the select query
      val resultSet1 = statement.executeQuery(sql1)

      //passing gathered column Data into variables
      while (resultSet1.next()) {
        val Orderid1 = resultSet1.getString("purchaseorderid")
        val date1 = resultSet1.getString("date")
        val status1 = resultSet1.getString("status")
        val empid1 = resultSet1.getString("employeeid")

        //print out information gathered from the database
        println("Purchas OrderID: " + Orderid1 + " Date: " + date1 + " Order Status: " + status1 + " Employee ID: " + empid1)
        println("\nWould You like to change the Status?")
        println("#1 Change to Confirmed")
        println("#2 Change to Processing")
        println("#3 Change to Dispatched")
        println("#4 Change to Delivered")
        println("#5 Exit")

        //scan the next line to choose option
        val scanner = new Scanner(System.in)
        val line: String = scanner.nextLine()

        line match {
          case "1" => Confirmed(Orderid1)
          case "2" => Processing(Orderid1)
          case "3" => dispatched(Orderid1)
          case "4" => Delivered(Orderid1)
          case _   => println("choose valid option")
        }

        //method to update order status
        def Confirmed(Orderid1: String) {
          //updates the customer order table
          val statement = Database.connection.createStatement()
          val sql = ("UPDATE PurchaseOrder SET status = 'Confirmed' WHERE purchaseorderid = " + Orderid1)
          statement.executeUpdate(sql);
        }

        //method to update order status
        def Processing(Orderid1: String) {
          //updates the customer order table
          val statement = Database.connection.createStatement()
          val sql = ("UPDATE PurchaseOrder SET status = 'Processing' WHERE purchaseorderid = " + Orderid1)
          statement.executeUpdate(sql);
        }

        //method to update order status
        def dispatched(Orderid1: String) {
          //updates the customer order table
          val statement = Database.connection.createStatement()
          val sql = ("UPDATE PurchaseOrder SET status = 'Dispatched' WHERE purchaseorderid = " + Orderid1)
          statement.executeUpdate(sql);
        }

        //method to update order status
        def Delivered(Orderid1: String) {
          //updates the customer order table
          val statement = Database.connection.createStatement()
          val sql = ("UPDATE PurchaseOrder SET status = 'Delivered' WHERE purchaseorderid = " + Orderid1)
          statement.executeUpdate(sql);
          val purchaseorder = new PurchaseOrder
          purchaseorder purchaseorderstock (Orderid1)
        }

      }
      try {

      } catch {
        case e: Throwable =>
          e printStackTrace ()
          println("Failed to select a correct Order ID.");

      }
      Database.connection close ()

    } catch {

      case e: Throwable => e.printStackTrace

    }
  }

  /**
   * jham
   * method for getting stock levels for each purchase order
   */
  def purchaseorderstock(Orderid1: String) {
    val Database = new Database
    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection
      }

      val scan = new Scanner(System.in)

      val statement = Database.connection.createStatement()

      val sql1 = (" SELECT purchaseorderline.productid, quantity, purchaseorderid FROM Product, Inventory, purchaseorderline WHERE inventory.iproductid = product.productid AND product.productid = purchaseorderline.productid and purchaseorderid = '" + Orderid1 + "'")

      // creates the statement, and run the select query
      val resultSet1 = statement.executeQuery(sql1)

      //passing gathered column Data into variables
      while (resultSet1.next()) {
        val productid = resultSet1.getInt("purchaseorderline.productid")
        val quantity = resultSet1.getInt("quantity")
        val orderid = resultSet1.getString("purchaseorderid")

        val purchaseorder = new PurchaseOrder
        purchaseorder updateTable (quantity, productid)

      }
      try {

      } catch {
        case e: Throwable =>
          e printStackTrace ()
          println("Failed to select a correct Order ID.");

      }
      Database.connection close ()

    } catch {

      case e: Throwable => e.printStackTrace

    }
  }

  /**
   * jham
   * method for updating stock levels for each purchase order
   */
  def updateTable(quantity: Int, productid: Int) {
    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection

      }

      val statement = Database.connection.createStatement()
      val sql = ("UPDATE Inventory SET stocklevel = stocklevel + " + quantity + " WHERE iproductid = " + productid)
      statement.executeUpdate(sql);
      println("Added " + quantity + " of Product " + productid + " to stock level")
    } catch {
      case t: Throwable => t.printStackTrace() // TODO: handle error
    }

  }

  /**
   * Method for adding new stock deliveries
   */

  def AddPurchaseOrder {
    //get current date time with Date()
    val date = (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date))
    val status: String = ("Ordered")
    val Database = new Database
    val scanner = new Scanner(System.in)
    val purchaseOrderLine = new PurchaseOrderLine
    //if no connection is initiated it will create one
    try {
      if (Database.connection == null)
        Database.connection
      println("Add New Purchase Order")
      //scan the next line to choose option
      println("Employee ID?")
      val empid = scanner.nextInt()
      println("Inserting Records Into Table...")
      val statement = Database.connection.createStatement()
      val sql = ("INSERT INTO PurchaseOrder (date, status, employeeid) VALUES('" + date + "','" + status + "'," + empid + ")")
      statement.executeUpdate(sql);

    } catch {
      case t: Throwable => t.printStackTrace()
    }

    val Database2 = new Database

    val sql1 = ("SELECT purchaseorderid, date, status, employeeid FROM PurchaseOrder Where date = '" + date + "'")

    val statement1 = Database2.connection.createStatement()
    // creates the statement, and run the select query
    val resultSet1 = statement1.executeQuery(sql1)

    //passing gathered column Data into variables
    while (resultSet1.next()) {
      val Orderid = resultSet1.getString("purchaseorderid")
      val empid = resultSet1.getString("employeeid")
      println("Inserted Values \n" + " OrderID: " + Orderid + " Date and Time: " + date + " Status: " + status + " EmployeeID: " + empid)
      val PurchaseOrderLine = new PurchaseOrderLine
      PurchaseOrderLine NewPurchaseOrderLine (Orderid)
    }

  }

}

