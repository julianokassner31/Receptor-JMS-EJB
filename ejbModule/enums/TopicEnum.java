package enums;

public enum TopicEnum {
	
	NOTICIAS("jsm/noticias");
	
	private String nome;
	
	private TopicEnum(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
