package br.com.IHelp.domain.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	private String nome;
	private String cpf;
	private String telefone;
	private String estado;
	
}
