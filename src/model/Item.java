package model;

public class Item {
	
	private Long id;
	private Long id_produto;
	private Integer quantidade;
	private Double preco;
	private Double total;
	
	
	
	public Item(Long id, Long id_produto, Integer quantidade, Double preco, Double total) {
		super();
		this.id = id;
		this.id_produto = id_produto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.total = total;
	}
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_produto() {
		return id_produto;
	}
	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}



}
