package br.com.IHelp.Types;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public enum EstadoServico {
	DISPONIVEL,
	INDISPONIVEL,
	CONCLUIDO,
	EM_ANDAMENTO,
	ENCERRADO;
	
	private static List<EstadoServico> estadoServico = Arrays.asList(EstadoServico.values());
	
	public static String disponibilidadeDoServico(Boolean servicoEstado) {
		
		String diponibilidade = servicoEstado.equals(true) ? estadoServico.get(0).toString()  : estadoServico.get(1).toString();
		
		return diponibilidade;
	}
}
