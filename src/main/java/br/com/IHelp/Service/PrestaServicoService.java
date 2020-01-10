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
		Boolean verificaCnpj = verificaSeExisteCnpj(prestaServico);
		
		if(estadoDoServico.equals(DISPONIVEL)) {
			if(verificaCnpj.equals(false)&& verificaEmail.equals(false)) {
				return prestaServicoRepository.save(prestaServico);
			}else{
				return null;
			}
		}else {
			return null;//503
		}
	}
	
	public List<String> listaEmail(){
	    TypedQuery<String> query = entityManager.createQuery("select email from PrestaServico", String.class);
	    return query.getResultList();
	  }
	
	public List<String> listaCnpj(){
	    TypedQuery<String> query = entityManager.createQuery("select cnpj from PrestaServico", String.class);
	    return query.getResultList();
	  }
	
	public Boolean verificaSeExisteEmail(PrestaServico prestaServico) {
		String email = listaEmail().stream()
										 .filter(p -> p.toLowerCase().equals(prestaServico.getEmail().toLowerCase()))
										 .collect(Collectors.joining(". "));
		
		Boolean exist = email.isEmpty() ? false : true;
		
		return exist;
	}
	
	public Boolean verificaSeExisteCnpj(PrestaServico prestaServico) {
		String email = listaCnpj().stream()
										 .filter(p -> p.toLowerCase().equals(prestaServico.getCnpj().toLowerCase()))
										 .collect(Collectors.joining(". "));
		
		Boolean exist = email.isEmpty() ? false : true;
		
		return exist;
	}
}

