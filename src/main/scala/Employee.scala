import java.util.Scanner

class AskDetails(var username: String, var password: String) {
  def this() = {
    this("", "")

    val scanner = new Scanner(System.in)
    
    println("############# Log In ##############")
    println("Please Enter username:")
   var username = scanner.nextLine()
    println("Please Enter Password:")
   var password = scanner.nextLine()
 }
}
    
/**
 * @author jham
 */
class Employee {

  def GetEmployee {
val askdetails = new AskDetails
          askdetails
    val Database = new Database

    //if no connection is initiated it will create one
    try {
      if (Database.connection == null) {
        Database.connection

        val statement = Database.connection.createStatement()

        val sql = "SELECT username, password FROM Employee"

        // creates the statement, and run the select query
        val resultSet = statement.executeQuery(sql)

        //passing gathered column Data into variables
        while (resultSet next ()) {
          val username1 = resultSet.getString("username")
          val password1 = resultSet.getString("password")
          println(username1 + password1)

          if (username1.equalsIgnoreCase(askdetails.username) && password1.equalsIgnoreCase(askdetails.password)) {
            println("Logged in")
          } else {
            GetEmployee
          }
        }
      }
    } catch {

      case e: Throwable => e.printStackTrace

    }

  }

}