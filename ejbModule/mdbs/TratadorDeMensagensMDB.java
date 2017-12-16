package mdbs;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName="jms/noticias")
public class TratadorDeMensagensMDB implements MessageListener{

	@Override
	public void onMessage(Message message) {

		try {
			TextMessage msg = (TextMessage) message;
			System.out.println(msg.getText());
		} catch (JMSException e) {
			System.out.println("erro");
		}
	}

}
