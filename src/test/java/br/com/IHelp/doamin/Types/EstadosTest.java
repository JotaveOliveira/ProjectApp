package br.com.IHelp.doamin.Types;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.IHelp.domain.Types.Estados.EstadosExist;

public class EstadosTest {

	@Test
	public void estadoSucessTest(){
		
		Boolean test = EstadosExist.servicoDisponivel("São Paulo");
		
		assertEquals(true, test);
	}
}
