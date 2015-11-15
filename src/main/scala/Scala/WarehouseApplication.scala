package Scala

import scalafx.Includes._
import java.util.Scanner

//main application to run and test methods
object Application {
  def main(args: Array[String]) {

    // Instantiate the application class and run
    val app = new WarehouseApplication
    app runApp
  }
}

class WarehouseApplication {

  // Attributes
  val employee = new Employee(this)

  /**
   * Default Class Constructor
   */
  def WarehouseApplication() {
  }

  /**
   * Run the app
   */
  def runApp() {

    // Prompt the user for login details
    promptUserForLoginDetails

    // Create a run options flag
    val runOptions: Boolean = true

    while (runOptions) {
      // Prompt user for order display
      ProgramOptions
    }
  }

  /**
   * Prompt user for login details
   */
  def promptUserForLoginDetails() {

    // Prompt user for login details
    val scanner = new Scanner(System.in)

    println("############# Log In ##############")
    println("Please Enter username:")
    var username = scanner.nextLine()
    println("Please Enter Password:")
    var password = scanner.nextLine()

    // Initialise local employee and 
    // pass data to the class
    employee setUsername (username)
    employee setPassword (password)

    // Establish the employee login details
    // from the employee database.
    employee establishEmployee
  }

  /**
   * Prompt user for program order choice
   */
  def ProgramOptions() {
    while (true) {

      println("\n###################################")
      println("# Warehouse Order Tracking System #")
      println("###################################")
      println("##### Please Choose an option #####")
      println("###################################")
      println("#1 Products")
      println("#2 Customer Orders")
      println("#3 Change Customer Order Status")
      println("#4 View Purchase Orders")
      println("#5 Change Purchae Order Status")
      println("#6 Add New Purchase Order")
      println("#7 Warehouse Layout Map")
      println("#8 Remove Damaged Stock")
      println("#9 Log Out")
      println("#10 System Exit")

      /**
       * scanner with match case choices to trigger the methods
       */

      val scanner = new Scanner(System.in)
      val line: String = scanner.nextLine()
      line match {
        case "1" =>
          val Products = new Product
          Products displayProducts
        case "2" =>
          val Order = new Order("")
          Order displayOrders
          val SelectOrder = new OrderLine   
        SelectOrder.selectOrder
        case "3" =>
          val Order = new Order("")
          Order ChangeOrderStatus
        case "4" =>
          val PurchaseOrder = new PurchaseOrder
          PurchaseOrder displayPurchaseOrders 
           val PurchaseOrder1 = new PurchaseOrder
          PurchaseOrder1 selectPurchaseOrder
        case "5" =>
          val PurchaseOrder = new PurchaseOrder
          PurchaseOrder ChangePurchaseOrderStatus
        case "6" =>
          val PurchaseOrder = new PurchaseOrder
          PurchaseOrder AddPurchaseOrder
        case "7" =>
          val WarehouseImage = new WarehouseLayout
          println("Display Warehouse Layout Image")
          WarehouseImage showImage
        case "8" =>
          val Product = new Product
          Product RemoveStock
        case "9" =>
          println("Goodbye")
          promptUserForLoginDetails
        case "10" =>
          println("Goodbye")
          System.exit(0)
        case _ => println("choose valid option")

      }
    }
  }
}
