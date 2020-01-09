package br.com.IHelp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.IHelp.Entities.PrestaServico;
import br.com.IHelp.Repository.PrestaServicoRepository;
import br.com.IHelp.Types.EstadoServico;
import br.com.IHelp.Types.Estados;

@Service
public class PrestaServicoService {

	@Autowired
	private PrestaServicoRepository prestaServicoRepository;
	
	private static final String DISPONIVEL = "DISPONIVEL";
	
	public List<PrestaServico> pegaPrestadoresServico(){
		
		return prestaServicoRepository.findAll();
	}
	
	public PrestaServico inserirUsuario(PrestaServico prestaServico) {
		
		Boolean estado = Estados.servicoDisponivel(prestaServico.getEstado().toString());
		
		String estadoDoServico = EstadoServico.disponibilidadeDoServico(estado);
		
		if(estadoDoServico.equals(DISPONIVEL)) {
			return prestaServicoRepository.save(prestaServico);
		}else {
			return null;
		}
	}
}
