package br.com.IHelp.Service;

import java.util.List;

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
		
		if(estadoDoServico.equals(DISPONIVEL)) {
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
}
