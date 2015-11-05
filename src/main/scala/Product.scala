import java.sql.DriverManager
import java.sql.Connection

/**
 * @author jham
 */
class Product {
  //method for getting a list of all products from the database
  def GetProducts {

    
    val Database = new Database
    
    //if no connection is initiated it will create one
    try {

      if (Database.connection == null) {
        Database.connection
      }
      
      val statement = Database.connection.createStatement()
      
      val sql = "SELECT productid, productname, description, price, img FROM Product"
      // create the statement, and run the select query

      //run sql query
      val resultSet = statement.executeQuery(sql)

      //passing gathered column Data into variables
      while (resultSet.next()) {
        val pid = resultSet.getString("productid")
        val pname = resultSet.getString("productname")
        val pdescription = resultSet.getString("description")
        val price = resultSet.getString("price")
        val img = resultSet.getString("img")
        println("ID = " + pid + " Name = " + pname + " Description = " + pdescription +
          " Price = " + price + " Image = " + img)

      }
    } catch {

      case e => e.printStackTrace

    }

  }
}