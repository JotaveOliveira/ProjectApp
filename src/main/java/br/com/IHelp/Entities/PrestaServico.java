package br.com.IHelp.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "presta_servico")
public class PrestaServico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cpf_cnpj_presta_servico")
	private String cpf_cnpj;
	
	@Column(name = "nome_presta_servico")
	private String nome;
	
	@Column(name = "estado_presta_servico")
	private String estado;
	
	@Column(name = "email_presta_servico")
	private String email;
	
	@Column(name = "data_nascimento_presta_servico")
	private Date dataNascimento;
}
