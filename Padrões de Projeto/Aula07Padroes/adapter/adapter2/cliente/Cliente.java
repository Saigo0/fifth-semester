package adapter2.cliente;

public class Cliente {

	private String nome;
	private String endereco;
	private String cep, estado, pais;
	
	public Cliente(String nome, String endereco, String cep, String estado, String pais) {
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.estado = estado;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getCep() {
		return cep;
	}

	public String getEstado() {
		return estado;
	}
	
	public String getPais() {
		return pais;
	}
	
	private ValidadorEndereco validadorEndereco;
	
	public void setValidadorEndereco(ValidadorEndereco validadorEndereco) {
		this.validadorEndereco = validadorEndereco;
	}
	
	public boolean ehEnderecoValido() {
		try {
			validadorEndereco.validar(this);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
