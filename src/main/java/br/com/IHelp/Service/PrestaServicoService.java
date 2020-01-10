package br.com.IHelp.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.IHelp.Entities.PrestaServico;
import br.com.IHelp.Repository.PrestaServicoRepository;
import br.com.IHelp.Types.EstadoServico;
import br.com.IHelp.Types.Estados;

@Service
public class PrestaServicoService {

	@PersistenceContext
	 private EntityManager entityManager;
	
	@Autowired
	private PrestaServicoRepository prestaServicoRepository;
	
	private static final String DISPONIVEL = "DISPONIVEL";
	
	public List<PrestaServico> pegaPrestadoresServico(){
		
		return prestaServicoRepository.findAll();
	}
	
	public PrestaServico inserirUsuario(PrestaServico prestaServico) {
		
		Boolean estado = Estados.servicoDisponivel(prestaServico.getEstado().toString());
		String estadoDoServico = EstadoServico.disponibilidadeDoServico(estado);
		Boolean verificaEmail = verificaSeExisteEmail(prestaServico);
		
		if(estadoDoServico.equals(DISPONIVEL) && verificaEmail.equals(false)) {
			return prestaServicoRepository.save(prestaServico);
		}else {
			return null;
		}
	}
	
	public List<PrestaServico> listaEmail(){
	    TypedQuery<PrestaServico> query = entityManager.createQuery("select email_presta_servico from presta_servico", PrestaServico.class);
	    return query.getResultList();
	  }
	
	public List<PrestaServico> listaCnpj(){
	    TypedQuery<PrestaServico> query = entityManager.createQuery("select cnpj_presta_servico from presta_servico", PrestaServico.class);
	    return query.getResultList();
	  }
	
	public Boolean verificaSeExisteEmail(PrestaServico prestaServico) {
		String email = listaEmail().stream()
										 .filter(p -> p.getEmail().toString().trim().toLowerCase().equals(prestaServico.getEmail().toString().trim().toLowerCase()))
										 .map(p -> p.getEmail().toString())
										 .collect(Collectors.joining("* "));
		
		Boolean exist = email.isEmpty() ? false : true;
		
		return exist;
	}
}

