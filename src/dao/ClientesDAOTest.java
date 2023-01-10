package dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Cliente;

public class ClientesDAOTest {

	@Test
	public void test() {
		
		Banco.inicia();
		
		ClientesDAO cd = new ClientesDAO();
		
		Cliente c = cd.getClienteById(1L);
		
		assertEquals("Adauto", c.getNome());
		
	}

}
