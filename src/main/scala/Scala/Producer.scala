package Scala

import javax.jms._
import org.apache.activemq.ActiveMQConnection
import org.apache.activemq.ActiveMQConnectionFactory
/**
 * auther jham
 * This function sends out information to a receiver in a different application.
 */
object Producer {

  def main(args: Array[String]): Unit = {
    val prod: Producer = new Producer
    prod RunProducer ("1")
  }
}

class Producer {

  //instantiates the default location for the server
  val activeMqUrl: String = ActiveMQConnection.DEFAULT_BROKER_URL
  
  //topic name is the point which the listener will also be looking for within the default broker location
  val topicName: String = "TOPIC_NAME"

  def RunProducer(productid: String) {

    /**
     * jham
     * sets up connection factory in the server
     */
    val connectionFactory: ConnectionFactory = new ActiveMQConnectionFactory(activeMqUrl)
   
    /**
     * starts the connection
     */
    val connection: Connection = connectionFactory.createConnection
    connection.start
    
    //starts new session within the server
    val session: Session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
    
    //sets the destination to the topic name
    val destination: Destination = session.createTopic(topicName)
    
    //produces the message packet for the producer to be sent to
    val messageProducer: MessageProducer = session.createProducer(destination)
    
    //initiates damaged product message
    val Product = new Product
    val dam = Product.output(productid)

    //message is generated within the session
    val textMessage: TextMessage = session.createTextMessage("\nDamage Report: " + dam.toString())
    
   // sends message 
    for (i <- 0 until 1) {
      messageProducer.send(textMessage)
      println("Message sent to Management: " + textMessage.getText + "")
    }
    //closes connection
    connection.close
  }
}  
  

