

/**
 * @author jham
 */
class Order {
  def GetOrders{
    
  val Database = new Database
  
       try{   if(Database.connection==null){
            Database.connection
       }
          
           val statement = Database.connection.createStatement()
           val sql =  "SELECT customerorderid, date, status, employeeid FROM CustomerOrder"
      // create the statement, and run the select query
    
           val resultSet = statement.executeQuery(sql)

      while ( resultSet.next() ) {
        val pid = resultSet.getString("customerorderid")
        val pname = resultSet.getString("date")
        val pdescription = resultSet.getString("status")
        val price = resultSet.getString("employeeid")

        println("ID = " + pid + " Name = " + pname + " Description = " + pdescription + 
            " Price = " + price)
            
               }
    
 
            } catch{
              
      case e => e.printStackTrace
    
            }
          }
      }