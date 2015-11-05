
import java.util.Scanner
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
       val scanner = new Scanner(System.in)

            System.out.println("\nWhich order do you want to view?");
        
        try{
          
          val OrderLine = new OrderLine
            OrderLine GetOrderLine(scanner nextLine() toString());
          } catch (NumberFormatException e){
            
            System.out.println("Failed to select a correct Order ID.");
  
          }
                 Database.connection close()
 
            } catch{
              
      case e => e.printStackTrace
    
            }
          }
      }