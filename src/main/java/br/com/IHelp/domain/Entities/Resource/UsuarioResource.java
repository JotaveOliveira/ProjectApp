package br.com.IHelp.domain.Entities.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.IHelp.domain.Entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	public ResponseEntity<Usuario> pegaTudo(){
		return null;
		
	}
}
