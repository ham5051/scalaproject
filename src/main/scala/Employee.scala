
import java.util.Scanner
//import default.Database


class AskDetails {
  
    val scanner = new Scanner(System.in)
 
    println("############# Log In ##############")
    println("Please Enter username:")
   val username = scanner.nextLine()
    println("Please Enter Password:")
   val password = scanner.nextLine()
   val GetEmployee = new Employee
         GetEmployee.GetEmployee(username, password)
}

    
/**
 * @author jham
 */
class Employee {
  
  var loggedIn : Boolean = false

  def GetEmployee(username: String, password: String) {

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

          if (username1.equalsIgnoreCase(username) && password1.equalsIgnoreCase(password) && !loggedIn) {
            // set flag to true
            loggedIn = true
            println("Logged in")
          } else if (!username1.equalsIgnoreCase(username) && password1.equalsIgnoreCase(password) && loggedIn){
            val AskDetails = new AskDetails
            AskDetails
            
          }
        }
      }
    } catch {

      case e: Throwable => e.printStackTrace

    }

  }

}