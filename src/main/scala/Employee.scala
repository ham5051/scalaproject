
import java.util.Scanner
//import default.Database

/**
 * @author jham
 */
class Employee(app : WarehouseOrderTrackingApplication) {
  var _employeeUsername : String = _
  var _employeePassword : String = _
  var loggedIn : Boolean = _

  
  /**
   * Default Class constructor
   */
  def Employee() {
  }


  def establishEmployees() {
    
    val Database = new Database
    // Create database instance & connection
   try {
      if (Database.connection == null) {
        Database.connection
      }
        val statement = Database.connection.createStatement()

      val sql = "SELECT username, password FROM Employee"
       val resultSet = statement.executeQuery(sql)
      
      // Loop through the database elements
      while (resultSet next) {
        
        // User input login details matches database
        if (login(getUsername, getPassword, resultSet.getString(1), resultSet.getString(2)) == 0) {
          
          // Set logged in flag to true
          loggedIn = true
          
          // Print welcome message to user
          println("\nWelcome " + _employeeUsername 
            + ", you are now logged in.")
        }
        // User input doesn't match database
        else if (login(getUsername, getPassword, resultSet.getString(1), resultSet.getString(2)) == 1
            && !loggedIn) {
          
          // Set logged in flag to false
          loggedIn = false
        }
      }
      // If login fails
      if (!loggedIn) {
        
        // Print failed login error message
        println("Failed to Login\n")
        
        app promptUserForLoginDetails

      }
      // close the connection
      resultSet close
    } catch {
        case e : Throwable => e.printStackTrace
  }
  }
   
  // Employee login function
  def login(username: String, password: String, dbUser: String,
            dbPass: String): Int = {

    // Run check
    if (username.equalsIgnoreCase(dbUser) && password.equalsIgnoreCase(dbPass)) {
      0
    } else {
      1
    }
  }
  // Employee login function
  def UserLogin(username: String, password: String, dbUser: String,
                dbPass: String): Int = {

    // Run check
    if (username.equalsIgnoreCase(dbUser) && password.equalsIgnoreCase(dbPass)) {
      0
    } else {
      1
    }
  }
  def getUsername() : String = {
    _employeeUsername
  }
  
  // employee password accessor
  def getPassword() : String = {
    _employeePassword
  }
  
  // Employee username mutator
  def setUsername(employeeUsername : String) {
    _employeeUsername = employeeUsername
  }
  
  // Employee password mutator
  def setPassword(employeePassword : String) {
    _employeePassword = employeePassword
  }

}