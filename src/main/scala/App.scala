import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import java.util.Scanner

//main application to run and test methods
object App {
  def main(args: Array[String]) {

    
      while (true) {

        println("###################################")
        println("# Warehouse Order Tracking System #")
        println("###################################")
        println("##### Please Choose an option #####")
        println("###################################")
        println("#1 Products")
        println("#2 Orders")
        println("#3 Change Order Status")

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
          case _ => println("choose valid option")
        }
      }
    

  }
}