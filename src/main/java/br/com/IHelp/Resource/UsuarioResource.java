package br.com.IHelp.Resource;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.IHelp.Entities.Usuario;

@Controller
public class UsuarioResource {
	
	@GetMapping(value = "/usuarios")
	public ResponseEntity<Usuario> pegaTudo(){
		Usuario user = new Usuario("Carla", "234.234.323.32", "2342-3234", "Carla@gmail.com", new Date(12/02/2000), "São Paulo");
		return ResponseEntity.ok().body(user);
		
	}
}
