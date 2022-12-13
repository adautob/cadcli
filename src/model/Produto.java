package model;

public class Produto {
	private int Id;
	private String Descricao;
	private Double Preco;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public Double getPreco() {
		return Preco;
	}
	public void setPreco(Double preco) {
		Preco = preco;
	}	

}
