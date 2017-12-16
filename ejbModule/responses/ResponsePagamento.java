package responses;

public class ResponsePagamento extends ResponsePagamentoAbstract{

	private String valor;
	private String protocolo;
	
	private ValidaPagamentoService validaPagamentoService;
	
	public ResponsePagamento(String valor, String nomeJms) {
		super(nomeJms);
		String[] split = valor.split(";");
		this.valor = split[0];
		this.protocolo = split[1];
	}
	
	@Override
	public boolean isSucessPagto() {
		return validaPagamentoService.isPagamentoValido(this.valor);
	}
	
	@Override
	public String getProtocolo(){
		return this.protocolo;
	}

	public ValidaPagamentoService getValidaPagamentoService() {
		return validaPagamentoService;
	}

	public void setValidaPagamentoService(ValidaPagamentoService validaPagamentoService) {
		this.validaPagamentoService = validaPagamentoService;
	}
}
