

/**
 * @author jham
 */
class OrderLine {
  def GetOrderLine(Orderid:Int){
    
  val Database = new Database
  
       try{   if(Database.connection==null){
            Database.connection
       }
          
           val statement = Database.connection.createStatement()
           val sql =  "SELECT customerorderid, date, status, employeeid FROM CustomerOrder WHERE customerorderid = " + Orderid
      // creates the statement, and run the select query
    
           val resultSet = statement.executeQuery(sql)

      while ( resultSet.next() ) {
        val pid = resultSet.getString("customerorderid")
        val date = resultSet.getString("date")
        val status = resultSet.getString("status")
        val empid = resultSet.getString("employeeid")

        println("ID = " + pid + " Date = " + date + " Order Status = " + status + 
            " Employee ID = " + empid)
            
               }
           
                 Database.connection close()
 
            } catch{
              
      case e => e.printStackTrace
    
            }
          }
}