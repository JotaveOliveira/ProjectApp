package br.com.IHelp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.IHelp.Entities.Usuario;
import br.com.IHelp.Repository.UsuarioRepository;
import br.com.IHelp.Types.EstadoServico;
import br.com.IHelp.Types.Estados;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static final String INDISPONIVEL = "INDISPONIVEL";
	
	public List<Usuario> pegaUsuarios(){
		
		return usuarioRepository.findAll();
	}
	
	public Usuario inserirUsuario(Usuario usuario) {
		
		Boolean estado = Estados.servicoDisponivel(usuario.getEstado());
		
		String estadoDoServico = EstadoServico.disponibilidadeDoServico(estado);
		
		if(estadoDoServico.equals(INDISPONIVEL)) {
			return null;
		}else {
			return usuarioRepository.save(usuario);
		}
	}
}
