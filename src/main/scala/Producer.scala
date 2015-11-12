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

  val activeMqUrl: String = ActiveMQConnection.DEFAULT_BROKER_URL
  val topicName: String = "TOPIC_NAME"

  def RunProducer(productid: String) {

    val connectionFactory: ConnectionFactory = new ActiveMQConnectionFactory(activeMqUrl)
    val connection: Connection = connectionFactory.createConnection
    connection.start
    val session: Session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)
    val destination: Destination = session.createTopic(topicName)
    val messageProducer: MessageProducer = session.createProducer(destination)
    val Product = new Product
    val dam = Product.output(productid)

    val textMessage: TextMessage = session.createTextMessage("\nDamage Report: " + dam.toString())
    for (i <- 0 until 1) {
      messageProducer.send(textMessage)
      println("Message sent to Management: " + textMessage.getText + "")
    }
    connection.close
  }
}  
  

