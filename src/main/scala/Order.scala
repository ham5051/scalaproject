
import java.util.Scanner
import java.lang.NumberFormatException
/**
 * @author jham
 */
class Order {

  //method gets all purchase orders from the database
  def GetOrders {

    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection
       
      }

      val statement = Database.connection.createStatement()

      val sql = "SELECT customerorderid, date, status, employeeid FROM CustomerOrder"

      // creates the statement, and run the select query
      val resultSet = statement.executeQuery(sql)

      //passing gathered column Data into variables
      while (resultSet.next()) {
        val Orderid = resultSet.getString("customerorderid")
        val date = resultSet.getString("date")
        val status = resultSet.getString("status")
        val empid = resultSet.getString("employeeid")

        //print out information gathered from the database
        println("ID = " + Orderid + " Date = " + date + " Order Status = " + status +
          " Employee ID = " + empid)

      }

      val scanner = new Scanner(System.in)

      println("\nWhich order do you want to view?");

      try {

        //method for selecting which order you want to look at
        
        val scanner = new Scanner(System.in)
        val OrderLine = new OrderLine
        OrderLine.GetOrderLine(scanner.nextLine().toString())
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
}