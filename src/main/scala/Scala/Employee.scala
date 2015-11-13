/**
 * auther jham
 */

package Scala

import Scala.WarehouseApplication
import Scala.Database
//import default.Database

/**
 * @author jham
 */
class Employee(app: WarehouseApplication) {
  var _User: String = _
  var _Pass: String = _
  var login: Boolean = _

  def getUsername(): String = {
    _User
  }

  // employee password accessor
  def getPassword(): String = {
    _Pass
  }

  // Employee username mutator
  def setUsername(employeeUsername: String) {
    _User = employeeUsername
  }

  // Employee password mutator
  def setPassword(employeePassword: String) {
    _Pass = employeePassword
  }

  def Employee() {
  }

  def establishEmployee() {

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
          login = true

          // Print welcome message to user
          println("\nWelcome " + _User + ", you are now logged in.")
        } // User input doesn't match database
        else if (login(getUsername, getPassword, resultSet.getString(1), resultSet.getString(2)) == 1
          && !login) {

          // Set logged in flag to false
          login = false
        }
      }
      // If login fails
      if (!login) {

        // Print failed login error message
        println("Failed to Login\n Please try again.")

        app promptUserForLoginDetails

      }
      // close the connection
      resultSet close
    } catch {
      case e: Throwable => e.printStackTrace
    }
  }

  // Employee login function
  def login(Employeeusername: String, Employeepassword: String, dbUser: String,
            dbPass: String): Int = {

    // Create an encryption instance
    val encryption = new Encryption
    encryption checkMD5 (Employeepassword)

    // Run check
    if (Employeeusername.equalsIgnoreCase(dbUser) && encryption.getEncryption().equalsIgnoreCase(dbPass)) {
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

}