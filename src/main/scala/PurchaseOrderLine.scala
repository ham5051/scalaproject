import java.util.Scanner

/**
 * @author jham
 */
class PurchaseOrderLine {
  def GetPurchaseOrderLine(Orderid:String){
    
  val Database = new Database
  
       try{   if(Database.connection==null){
            Database.connection
       }
          
           val statement = Database.connection.createStatement()
           val sql =  ("SELECT purchaseorderid, productid, quantity FROM PurchaseOrderLine WHERE Purchaseorderid = " + Orderid)
      // creates the statement, and run the select query
    
           val resultSet = statement.executeQuery(sql)

      while ( resultSet.next() ) {
        val pid = resultSet.getString("purchaseorderid")
        val product = resultSet.getString("productid")
        val quantity = resultSet.getString("quantity")


        println("Order ID = " + pid + " Product ID = " + product + " Quantity = " + quantity)
            
               }
           
                 Database.connection close()
 
            } catch{
              
      case e => e.printStackTrace
    
            }
          }
  
  
   def NewPurchaseOrderLine(Orderid:String){
    
      val Database = new Database
  
       try{   if(Database.connection==null){
            Database.connection
       }
       }
          
           val statement = Database.connection.createStatement()
           println("Add Product ID:")
           val scanner = new Scanner(System.in)
        val productid = scanner.nextLine()
        println("Add Quantity:")
   
        val quantity = scanner.nextLine()
        
       }
}
