import java.sql.DriverManager
import java.sql.Connection

/**
 * @author jham
 */
class Database {
  // connect to the database named "mysql" on the localhost
  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://localhost/mydb"
  val username = "root"
  val password = "password"

  // there's probably a better way to do this
  var connection: Connection = null

  try {
    // make the connection
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)

  } catch {
    case e: Throwable => e.printStackTrace
  }

}
