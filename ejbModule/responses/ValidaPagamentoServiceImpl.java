package responses;

import javax.ejb.Stateless;

@Stateless(mappedName="ejb/ValidaPagamentoService")
public class ValidaPagamentoServiceImpl implements ValidaPagamentoServiceRemote, ValidaPagamentoServiceLocal{

	@Override
	public boolean isPagamentoValido(String valor) {
		System.out.println(String.format("Valor = %s", valor));
		System.out.println("Verificando se pagamento está ok...");
		double parseDouble = Double.parseDouble(valor);
		if(parseDouble <= 0.0){
			System.out.println("Erro no pagamento!");
			return false;
		}
		System.out.println("pagamento ok!");
		return true;
	}


}
