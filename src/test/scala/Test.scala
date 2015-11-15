

/**
 * @author jham
 */


import org.scalatest.Inspectors
import org.scalatest._

/**
 * @author callum
 * @description TestBase.scala is base abstract class for all of 
 *              my test classes. It has been implemented so
 *              that we don't have to inherit FlatSpec every
 *              test class.
 *              
 */
abstract class Test extends FlatSpec with Matchers
with OptionValues with Inside with Inspectors {
  
  /**
   * Class Constructor
   */
  def Testbase(){}
}