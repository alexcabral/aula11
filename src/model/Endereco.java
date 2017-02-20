package model;

public class Endereco {

	private Integer idEndereco;
	private String rua;
	private String cidade;
	private String cep;
	public Endereco(Integer idEndereco, String rua, String cidade, String cep) {
		super();
		this.idEndereco = idEndereco;
		this.rua = rua;
		this.cidade = cidade;
		this.cep = cep;
	}
	public Endereco() {
		super();
	}
	public Integer getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
}
