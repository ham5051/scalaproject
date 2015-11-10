import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import java.util.Scanner


//main application to run and test methods
object App {
  def main(args: Array[String]) {
   

    val AskDetails = new AskDetails
    AskDetails
   
 
      while (true) {

        println("\n###################################")
        println("# Warehouse Order Tracking System #")
        println("###################################")
        println("##### Please Choose an option #####")
        println("###################################")
        println("#1 Products")
        println("#2 Orders")
        println("#3 Change Customer Order Status")
        println("#4 View Purchase Orders")
        println("#5 Change Purchae Order Status")
        println("#6 Add New Purchase Order")
        println("#7 Warehouse Layout Map")
        println("#8 System Exit")
        println("#6 Add New Purchase Order")

        val scanner = new Scanner(System.in)
        val line: String = scanner.nextLine()
        line match {
          case "1" =>
            val Products = new Product
            Products GetProducts
          case "2" =>
            val Order = new Order
            Order GetOrders
          case "3" =>
            val Order = new Order
            Order ChangeOrderStatus
          case "4" => 
            val PurchaseOrder = new PurchaseOrder
            PurchaseOrder GetPurchaseOrders
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
             case "8" =>  println("Goodbye")
                        System.exit(0)
             case "9" => 
            val PurchaseOrder = new PurchaseOrder
            PurchaseOrder purchaseorderstock("1")
                        
          case _ => println("choose valid option")
          
        }
      }
    
  //  }
  }
}
