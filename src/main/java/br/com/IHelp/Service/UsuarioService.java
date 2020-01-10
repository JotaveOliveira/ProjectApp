package br.com.IHelp.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.IHelp.Entities.Usuario;
import br.com.IHelp.Repository.UsuarioRepository;
import br.com.IHelp.Types.EstadoServico;
import br.com.IHelp.Types.Estados;

@Service
public class UsuarioService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static final String DISPONIVEL = "DISPONIVEL";
	
	public List<Usuario> pegaUsuarios(){
		
		return usuarioRepository.findAll();
	}
	
	public Usuario inserirUsuario(Usuario usuario) {
		
		Boolean estado = Estados.servicoDisponivel(usuario.getEstado().toString());
		
		String estadoDoServico = EstadoServico.disponibilidadeDoServico(estado);
		Boolean verificaEmail = verificaSeExisteEmail(usuario);
		Boolean verificaCpf = verificaSeExisteCpf(usuario);
		
		if(estadoDoServico.equals(DISPONIVEL)) {
			if(verificaCpf.equals(false)&& verificaEmail.equals(false)) {
				return usuarioRepository.save(usuario);
			}else{
				return null;
			}
		}else {
			return null;
		}
	}
	
	public List<String> listaEmail(){
		TypedQuery<String> query = entityManager.createQuery("select email from Usuario", String.class);
		return query.getResultList();
	}
	
	public List<String> listaCpf(){
		TypedQuery<String> query = entityManager.createQuery("select cpf from Usuario", String.class);
		return query.getResultList();
	}
	
	public Boolean verificaSeExisteEmail(Usuario usuario) {
		String email = listaEmail().stream()
										 .filter(p -> p.toLowerCase().equals(usuario.getEmail().toLowerCase()))
										 .collect(Collectors.joining(". "));
		
		Boolean exist = email.isEmpty() ? false : true;
		
		return exist;
	}
	
	public Boolean verificaSeExisteCpf(Usuario usuario) {
		String email = listaCpf().stream()
										 .filter(p -> p.toLowerCase().equals(usuario.getCpf().toLowerCase()))
										 .collect(Collectors.joining(". "));
		
		Boolean exist = email.isEmpty() ? false : true;
		
		return exist;
	}
}
