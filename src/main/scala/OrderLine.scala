

/**
 * @author jham
 */
class OrderLine {
  
  def GetOrderLine(Orderid:String){
    
  val Database = new Database
  
       try{   if(Database.connection==null){
            Database.connection
       }
          
           val statement = Database.connection.createStatement()
           val sql =  ("SELECT customerorderid, productid, quantity FROM CustomerOrderLine WHERE customerorderid = " + Orderid)
      // creates the statement, and run the select query
    
           val resultSet = statement.executeQuery(sql)

      while ( resultSet.next() ) {
        val pid = resultSet.getString("customerorderid")
        val product = resultSet.getString("productid")
        val quantity = resultSet.getString("quantity")


        println("Order ID = " + pid + " Product ID = " + product + " Quantity = " + quantity)
            
               }
           
                 Database.connection close()
 
            } catch{
              
      case e: Throwable => e.printStackTrace
    
            }
          }
}