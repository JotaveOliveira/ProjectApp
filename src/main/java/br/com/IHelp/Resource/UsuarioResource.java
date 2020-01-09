package br.com.IHelp.Resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.IHelp.Entities.Usuario;
import br.com.IHelp.Service.UsuarioService;

@Controller
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping(value = "/usuarios")
	public ResponseEntity<List<Usuario>> pegaTudo() {

		List<Usuario> listaUsuario = usuarioService.pegaUsuarios();
		
		return ResponseEntity.ok().body(listaUsuario);
	}
	
	@PostMapping(value = "/cadastraUsuario")
	public ResponseEntity<Usuario> cadastraUsuario(@RequestBody Usuario usuario){
		usuario = usuarioService.inserirUsuario(usuario);
		
		return ResponseEntity.ok().body(usuario);
		
	}
}
