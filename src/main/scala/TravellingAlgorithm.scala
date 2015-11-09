

/**
 * @author jham
 */
class TravellingAlgorithm (Orderid: String) {
  val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection
      }

      val statement = Database.connection.createStatement()

      val  sql = ("SELECT productname, quantity, location FROM customerorderline, product, inventory WHERE customerorderline.productid = product.productid and product.productid = inventory.iproductid and customerorderline.customerorderid = " + Orderid)
      //run sql query
      val resultSet = statement.executeQuery(sql)
      println("Best Route to take for Order " + Orderid)
      //passing gathered column Data into variables
      while (resultSet.next()) {
        val pname = resultSet.getString("productname")
        val quantity = resultSet.getString("quantity")
        val location = resultSet.getInt("location")

        println("Location " + location.)// + " Product: " + pname + "  Quantity: " + quantity)
        //print out information gathered from the database
       
      }

}
  catch {

      case e: Throwable => e.printStackTrace

    }
}


class CustomerOrders( val pname:String, )
