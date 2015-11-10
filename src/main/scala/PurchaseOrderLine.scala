import java.util.Scanner

/**
 * @author jham
 */
class PurchaseOrderLine {
  def GetPurchaseOrderLine(Orderid: String) {

    val Database = new Database

    try {
      if (Database.connection == null) {
        Database.connection
      }

      val statement = Database.connection.createStatement()
      val sql = ("SELECT purchaseorderid, productname, quantity FROM PurchaseOrderLine, product WHERE purchaseorderline.productid = product.productid AND Purchaseorderid = " + Orderid)
      // creates the statement, and run the select query

      val resultSet = statement.executeQuery(sql)

      while (resultSet.next()) {
        val pid = resultSet.getString("purchaseorderid")
        val product = resultSet.getString("productname")
        val quantity = resultSet.getString("quantity")

        println("Order ID: " + pid + "  Product: " + product + "  Quantity: " + quantity)

      }

      Database.connection close ()

    } catch {

      case e: Throwable => e.printStackTrace

    }
  }

  def NewPurchaseOrderLine(Orderid: String) {

    val Database = new Database

    try {
      if (Database.connection == null) {
        Database.connection
      }
    } catch {
      case t: Throwable => t.printStackTrace()
    }
    println("Add Products and their Quantities to Purchase Order: ")
    val statement = Database.connection.createStatement()
    println("Add Product ID:")
    val scanner = new Scanner(System.in)
    val productid = scanner.nextLine()
    println("Add Quantity:")

    val quantity = scanner.nextLine()

    println("Inserting records into the table...");
    val sql = "INSERT INTO purchaseorderline VALUES (" + Orderid + "," + productid + "," + quantity + ")"
    statement.executeUpdate(sql)
    println("Inserted Values.")
    println("Order ID: " + Orderid + " Product ID: "  + productid + " Quantity: " + quantity)

    println("Add another Purchase Order Line? y/n")
    val choice = scanner.nextLine()

    if (choice.equalsIgnoreCase("y")) {
      NewPurchaseOrderLine(Orderid)
    } else
      App

  }

}

