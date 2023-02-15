package dao;

import model.Venda;

public class VendasDAO {

	public void SalvarVenda(Venda venda) {
		Long max = 0L;
		for (Venda ven : Banco.vendas) {
			if (ven.getId() > max)
				max = ven.getId();
		}
		venda.setId(++max);
		Banco.vendas.add(venda);

		System.out.println("A venda foi salva");

	}

}
