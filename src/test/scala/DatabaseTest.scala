

import Scala.Database
import javafx.application.Application
import Scala.WarehouseApplication
import Scala.Product
import Scala.Employee
import Scala.Encryption
import Scala.TravellingAlgorithm
import Scala.PurchaseOrder
import Scala.Order
import Scala.OrderLine

class DatabaseTest extends Test {

  /**
   * Test the connection to the database
   */
  def ConnectionTest {
    "Calling connection" should "return a database connection which is not null" in
      {
        // create an object
        val database: Database = new Database
        database.connection should not be (null)
      }
    it should "make connection to Database" in
      {
        // create an object
        val database: Database = new Database
        database.connection.getMetaData.getURL should be("jdbc:mysql://localhost/mydb")
      }
  }

    def AlgorithmTest {
    "The algorithm" should "return the quickest route for the order collection within the warehouse" in
      {
        val Orderid1 = "5"
        // create an object
        val TravellingAlgorithm: TravellingAlgorithm = new TravellingAlgorithm
        val test = (TravellingAlgorithm.quickestRoute(Orderid1))
        test should be("5")
      }
    it should "Return" in {
      val Database = new Database
      val Orderid1 = "5"
      val TravellingAlgorithm: TravellingAlgorithm = new TravellingAlgorithm
      TravellingAlgorithm.quickestRoute(Orderid1).toString() should be("""Best Route to take for Order 5
        Location d100 Product: Yellow Gnome  Quantity: 3 """)


    }

  }

  
   def ProductsTest {
    "The product method" should "return a list of products" in
      {
       
        // create an object
        val Product: Product = new Product
        val test = (Product.GetProducts)
        test should not be (null)
      }
    it should "Return" in {
       val Product: Product = new Product
        val test = (Product.GetProducts)
        assert(test(0).equals("ID: 1  Name: Gnome  Description: Gnome  Price: 10 Stock Level 125"))
        assert(test.length > 0)
    }
  }
   def PurchaseOrderTest{
      "The product method" should "return a list of purchase orders" in
      {
       
        // create an object
        val Purchaseorder: PurchaseOrder = new PurchaseOrder
        val test = (Purchaseorder.GetPurchaseOrders)
        test should not be (null)
      }
    it should "Return a" in {
      val Purchaseorder: PurchaseOrder = new PurchaseOrder
        val test = (Purchaseorder.GetPurchaseOrders)
        assert(test(0).equals("ID = 1 Date = 05/11/2015 Order Status = Delivered Employee ID = 1"))
        assert(test.length > 0)
    }
  }

    def OrderTest{
      "The product method" should "return a list of customer orders" in
      {
       
        // create an object
        val order: Order = new Order("")
        val test = (order.GetOrders)
        test should not be (null)
      }
    it should "Return  Customer Orders" in {
      val order: Order = new Order("")
        val test = (order.GetOrders)
        assert(test(0).equals("ID = 1 Date = 05/11/2015 Order Status = Processing Employee ID = 1"))
        assert(test.length > 0)
    }
  }
    def OrderLineTest{
      "The product method" should "return a list of products in a customer order" in
      {
       
        // create an object
        val order: OrderLine = new OrderLine
        val test = (order.GetOrderLine("3"))
        test should not be (null)
      }
    it should "Return  Customer Order Specifics" in {
      val order: OrderLine = new OrderLine
        val test = (order.GetOrderLine("1"))
        assert(test(0).equals("Order ID: 1  Product: Blue Gnome  Quantity: 1"))
        assert(test.length > 0)
        assert(test.length == 4)
    }
  }

  // Do tests
  ConnectionTest
  OrderLineTest
  ProductsTest
  PurchaseOrderTest
  OrderTest
}
