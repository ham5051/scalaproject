
import scalafx.beans.property.ObjectProperty
import scalafx.beans.property.StringProperty

/**
 * auther Joshua ham
 */

class CustomerOrders( val pname_ :String, val quantity_ :String, val location_ :Int){


    val pname = new ObjectProperty[String](this, "pname", pname_)
    val quantity = new ObjectProperty[String](this, "quantity", quantity_)
    val location = new ObjectProperty[Int](this, "location", location_)
}