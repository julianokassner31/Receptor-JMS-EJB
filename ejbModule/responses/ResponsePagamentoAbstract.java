package responses;

import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

public abstract class ResponsePagamentoAbstract{

	private static final String JMS_K19_FACTORY = "jms/K19Factory";
	private String nomeJms;
	
	public ResponsePagamentoAbstract(String nomeJms) {
		this.nomeJms = nomeJms;
	}
	
	public void response() throws Exception{
		
		InitialContext ic = new InitialContext();
		
		ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/K19DurableFactory");
		
		Topic topic = (Topic) ic.lookup(nomeJms);
		
		Connection conn = factory.createConnection();
		
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		MessageProducer sender = session.createProducer(topic);
		
		TextMessage message = session.createTextMessage();
		
		message.setStringProperty("pagamento", getProtocolo());
		
		if(isSucessPagto()){
			message.setText("Pagamento recebido com sucesso, Protocolo:"+getProtocolo());
			message.setBooleanProperty(getProtocolo(), true);
		
		}else{
			message.setText("Pagamento não recebido, Protocolo:"+getProtocolo());
			message.setBooleanProperty(getProtocolo(), false);
			
		}
		
		sender.send(message);
		
		sender.close();
		
		session.close();
		
		conn.close();
	}
	
	public abstract boolean isSucessPagto();

	public abstract String getProtocolo();
}
