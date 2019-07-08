/**
 * 
 */
package br.gov.serpro.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 *
 */
@Getter
@Setter
@Entity
public class DemoEntidade {
	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private Long versao;
	
	@CPF
	private String cpf;
	
	@NotBlank(message = "{nome.embranco}")
	private String nome;
}
