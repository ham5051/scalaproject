package GUI

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle
import scalafx.application.JFXApp.PrimaryStage

/**
 * @author jham
 */
object Main extends JFXApp {

    stage = new PrimaryStage
    
    val login= new Login(stage)
   
    login 
    
  
}

