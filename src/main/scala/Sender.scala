import org.apache.activemq.ActiveMQConnectionFactory
import javax.jms.Session
import javax.jms.DeliveryMode

/**
 * @author jham
 */
class Sender {
    val boardName = "OUT"
    
    def sendMessage{
      try {
        //create a connection factory
        val connFactory:ActiveMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost")
        
        //create a connection
        val connection = connFactory.createConnection()
        connection.start()
        
        //create a session
        val session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
        
        //create a topic
        val destination = session.createTopic(boardName)
        
        // Create a MessageProducer from the Session to the Topic or Queue
        val producer = session.createProducer(destination)
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT)
        
        //create a message
        val message = session.createObjectMessage("testing")
        
        //tell producer to send the message
        producer.send(message)
        
        session.close()
        connection.close()
      }
      catch{
        case jmse:Exception => jmse.printStackTrace()
      }
    }
    
}