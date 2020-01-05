package br.com.IHelp.domain.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrestaServico {
	
	private String cpf_cnpj;
	private String nome;
	private String estado;
}
