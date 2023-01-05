package model;

import java.util.Date;
import java.util.List;

public class Venda {
	
	private Long id;
	private Cliente cliente;
	private Date dataVenda;
	private List<Item> itens;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Date getDataVenda() {
		return dataVenda;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	

}
