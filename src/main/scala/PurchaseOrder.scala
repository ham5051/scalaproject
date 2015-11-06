import java.util.Scanner
import java.lang.NumberFormatException

/**
 * @author jham
 */
class PurchaseOrder {

  //method gets all purchase orders from the database
  def GetPurchaseOrders {

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
      println("Purchase Orders")
      //passing gathered column Data into variables
      while (resultSet.next()) {
        val pid = resultSet.getString("purchaseorderid")
        val date = resultSet.getString("date")
        val status = resultSet.getString("status")
        val empid = resultSet.getString("employeeid")
          
        //print out information gathered from the database
        println("ID = " + pid + " Date = " + date + " Order Status = " + status +
          " Employee ID = " + empid)

      }
      Database.connection close ()

    } catch {

      case e => e.printStackTrace

    }
  }
  
    //method gets all purchase orders from the database
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
        println("ID = " + Orderid1 + " Date = " + date1 + " Order Status = " + status1 + " Employee ID = " + empid1)
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
          case _ => println("choose valid option")
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

      case e => e.printStackTrace

    }
  }

  //method to update order status
  def dispatched(Orderid1: String) {
    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection

      }
      
      //updates the customer order table
      val statement = Database.connection.createStatement()
      val sql = ("UPDATE PurchaseOrder SET status = 'Dispatched' WHERE purchaseorderid = " + Orderid1)
      statement.executeUpdate(sql);
    }
  }

  //method to update order status
  def Confirmed(Orderid1: String) {
    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection

      }
      //updates the customer order table
      val statement = Database.connection.createStatement()
      val sql = ("UPDATE PurchaseOrder SET status = 'Confirmed' WHERE purchaseorderid = " + Orderid1)
      statement.executeUpdate(sql);
    }
  }

  //method to update order status
  def Processing(Orderid1: String) {
    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection

      }
            //updates the customer order table
      val statement = Database.connection.createStatement()
      val sql = ("UPDATE PurchaseOrder SET status = 'Processing' WHERE purchaseorderid = " + Orderid1)
      statement.executeUpdate(sql);
    }
  }

  //method to update order status
  def Delivered(Orderid1: String) {
    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection

      }

      val statement = Database.connection.createStatement()
      val sql = ("UPDATE PurchaseOrder SET status = 'Delivered' WHERE purchaseorderid = " + Orderid1)
      statement.executeUpdate(sql);
    }
  }
}







/**
 * @author jham


  //method gets all purchase orders from the database
  def ChangeOrderStatus {

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

      val sql1 = ("SELECT customerorderid, date, status, employeeid FROM CustomerOrder Where customerorderid = " + id)

      // creates the statement, and run the select query
      val resultSet1 = statement.executeQuery(sql1)

      //passing gathered column Data into variables
      while (resultSet1.next()) {
        val Orderid1 = resultSet1.getString("customerorderid")
        val date1 = resultSet1.getString("date")
        val status1 = resultSet1.getString("status")
        val empid1 = resultSet1.getString("employeeid")

        //print out information gathered from the database
        println("ID = " + Orderid1 + " Date = " + date1 + " Order Status = " + status1 + " Employee ID = " + empid1)
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
          case _ => println("choose valid option")
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

      case e => e.printStackTrace

    }
  }

  //method to update order status
  def dispatched(Orderid1: String) {
    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection

      }
      
      //updates the customer order table
      val statement = Database.connection.createStatement()
      val sql = ("UPDATE CustomerOrder SET status = 'Dispatched' WHERE customerorderid = " + Orderid1)
      statement.executeUpdate(sql);
    }
  }

  //method to update order status
  def Confirmed(Orderid1: String) {
    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection

      }
      //updates the customer order table
      val statement = Database.connection.createStatement()
      val sql = ("UPDATE CustomerOrder SET status = 'Confirmed' WHERE customerorderid = " + Orderid1)
      statement.executeUpdate(sql);
    }
  }

  //method to update order status
  def Processing(Orderid1: String) {
    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection

      }
            //updates the customer order table
      val statement = Database.connection.createStatement()
      val sql = ("UPDATE CustomerOrder SET status = 'Processing' WHERE customerorderid = " + Orderid1)
      statement.executeUpdate(sql);
    }
  }

  //method to update order status
  def Delivered(Orderid1: String) {
    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection

      }

      val statement = Database.connection.createStatement()
      val sql = ("UPDATE CustomerOrder SET status = 'Delivered' WHERE customerorderid = " + Orderid1)
      statement.executeUpdate(sql);
    }
  }

}
 */