package ComIN.comIN;

public class Pessoa {
	private String nome;
	private String apelido;
	
	
	public Pessoa(String nome,String apelido){
		this.nome = nome;
		this.apelido = apelido;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
}
