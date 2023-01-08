package model;

import java.util.List;

public class Cliente {
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String nome;
	private String email;
	private String telefone;
	private String idade;
	private List<Venda> vendas;
	
	public Cliente(String nome, String email, String telefone, String idade) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.idade = idade;
	}

	
	
	public List<Venda> getVendas() {
		return vendas;
	}



	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", idade=" + idade + "]";
	}
	
	

}
