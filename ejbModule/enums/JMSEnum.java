package enums;

public enum JMSEnum {
	
	PAGAMENTOS("jms/pagamentos"),
	PEDIDOS("jms/pedidos"),
	RESPOSTA_PAGAMENTOS("jms/noticias");
	
	private String nome;
	
	private JMSEnum(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
