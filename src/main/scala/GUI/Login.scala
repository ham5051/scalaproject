package GUI
import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.Scene.sfxScene2jfx
import scalafx.scene.control.Label
import scalafx.scene.layout.GridPane
import scalafx.stage.Stage.sfxStage2jfx
import scalafx.geometry.Insets
import scalafx.scene.layout.HBox
import scalafx.scene.text.Text
import scalafx.scene.image.Image
import scalafx.scene.image.ImageView
import scalafx.scene.control.Button
import scalafx.event.ActionEvent
import scalafx.scene.control.PasswordField
import scalafx.scene.control.TextField
import javafx.scene.shape.Rectangle
import javafx.scene.paint.ImagePattern
import scalafx.application.JFXApp.PrimaryStage
import Scala.Employee

/**
 * @author jham
 */
class Login (stage: PrimaryStage) {
  stage title = "Warehouse Order Tracking System"
  stage width = 300
  stage height = 400   
  
  val username = new TextField()
    {
   
      promptText = "Username: "
    }
}
      