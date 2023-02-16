package model;

import java.util.Date;
import java.util.List;

public class Venda {

	private Long id;
	private Cliente cliente;
	private Date dataVenda;
	private StatusVenda statusVenda;
	private List<Item> itens;
	private Double totalVenda;
	

	@Override
	public String toString() {
		return "Venda [id=" + id + ", cliente=" + cliente + ", dataVenda=" + dataVenda + ", statusVenda=" + statusVenda
				+ ", itens=" + itens + ", totalVenda=" + totalVenda + "]";
	}

	public Venda(Cliente cliente, Date dataVenda, StatusVenda statusVenda, List<Item> itens, Double totalVenda) {
		super();
		this.cliente = cliente;
		this.dataVenda = dataVenda;
		this.statusVenda = statusVenda;
		this.itens = itens;
		this.totalVenda = totalVenda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public void setStatusVenda(StatusVenda statusVenda) {
		this.statusVenda = statusVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public StatusVenda getStatusVenda() {
		return statusVenda;
	}
	
	public Double getTotalVenda() {
		return totalVenda;
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
