

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
}