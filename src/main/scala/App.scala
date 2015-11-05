import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
//main application to run and test methods
object App {
  def main(args: Array[String]) {
    println("Hello World")

    val Product = new Product
    Product.GetProducts
    val Order = new Order
    Order.GetOrders
    val PurchaseOrder = new PurchaseOrder
   // PurchaseOrder.GetPurchaseOrders
  }
}