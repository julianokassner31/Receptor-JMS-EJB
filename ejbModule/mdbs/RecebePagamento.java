package mdbs;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import enums.JMSEnum;
import responses.ResponsePagamento;
import responses.ValidaPagamentoService;
import responses.ValidaPagamentoServiceLocal;

@MessageDriven(mappedName="jms/pagamentos")
public class RecebePagamento implements MessageListener{

	@EJB
	protected ValidaPagamentoServiceLocal validaPagamentoServiceLocal;
	
	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("Recebendo pagamento...");
			TextMessage msg = (TextMessage) message;
			ResponsePagamento rs = new ResponsePagamento(msg.getText(), JMSEnum.RESPOSTA_PAGAMENTOS.getNome());
			rs.setValidaPagamentoService(validaPagamentoServiceLocal);
			rs.response();
			
		} catch (JMSException e) {
			System.out.println("erro ao processar pagamento");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
