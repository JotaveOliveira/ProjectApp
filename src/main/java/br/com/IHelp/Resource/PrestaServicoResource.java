package br.com.IHelp.Resource;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.IHelp.Entities.PrestaServico;
import br.com.IHelp.Types.EstadoServico;
import br.com.IHelp.Types.Estados;

@Controller
public class PrestaServicoResource {

	private static final String INDISPONIVEL = "INDISPONIVEL";
	
	@GetMapping(value="/prestadoresServico")
	public ResponseEntity<PrestaServico> pegaTudo(){
		
		PrestaServico prestaServico = new PrestaServico("12.123.1233/0001-12", "Auto Elétrica Marilia", "Curitiba", "AutoEletrica@gmail.com", new Date(21/12/2012));
		
		Boolean estado = Estados.servicoDisponivel(prestaServico.getEstado());
		
		String estadoDoServiço = EstadoServico.disponibilidadeDoServico(estado);
		
		if(estadoDoServiço.equals(INDISPONIVEL)) {
			return null;
		}else {
			return ResponseEntity.ok().body(prestaServico);
		}
		
	}
}
