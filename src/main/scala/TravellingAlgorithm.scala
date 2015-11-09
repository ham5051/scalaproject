

/**
 * @author jham
 */
class TravellingAlgorithm {
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

  sql = ("SELECT customerorder.customerorderid, productname, quantity, location FROM customerorder, customerorderline, product, inventory
WHERE customerorder.customerorderid = customerorderline.customerorderid
AND customerorderline.productid = product.productid
and product.productid = inventory.iproductid
and customerorder.customerorderid = " + )
}
println(pid.sortBy { x => 10 })