package model;

import java.util.Date;

public class Funcionario {

	private Integer idFuncionario;
	private String nome;
	private String email;
	private Date admissao;
	
	private Endereco endereco;
	
	public Funcionario(Integer idFuncionario, String nome, String email,
			Date admissao) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.email = email;
		this.admissao = admissao;
	}
	public Funcionario() {
		super();
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getAdmissao() {
		return admissao;
	}
	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}
	
	
	
}
