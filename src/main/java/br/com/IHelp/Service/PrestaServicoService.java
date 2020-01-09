package br.com.IHelp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.IHelp.Entities.PrestaServico;
import br.com.IHelp.Repository.PrestaServicoRepository;
import br.com.IHelp.Types.EstadoServico;
import br.com.IHelp.Types.Estados;

public class PrestaServicoService {

	@Autowired
	private PrestaServicoRepository prestaServicoRepository;
	
	private static final String INDISPONIVEL = "INDISPONIVEL";
	
	public List<PrestaServico> pegaPrestadoresServico(){
		
		return prestaServicoRepository.findAll();
	}
	
	public PrestaServico inserirUsuario(PrestaServico prestaServico) {
		
		Boolean estado = Estados.servicoDisponivel(prestaServico.getEstado());
		
		String estadoDoServico = EstadoServico.disponibilidadeDoServico(estado);
		
		if(estadoDoServico.equals(INDISPONIVEL)) {
			return null;
		}else {
			return prestaServicoRepository.save(prestaServico);
		}
	}
}
