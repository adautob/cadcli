package model;

import java.util.Date;
import java.util.List;

public class Cliente {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private Date dataNasc;
	private Status status;
	private List<Venda> vendas;

	public Cliente() {
	}

	public Cliente(Long id, String nome, String email, String telefone, Date dataNasc) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", data =" + dataNasc + "]";
	}

}
