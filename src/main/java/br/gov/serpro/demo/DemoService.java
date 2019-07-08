/**
 * 
 */
package br.gov.serpro.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import br.org.otojunior.validadornegocio.validador.Validador;

/**
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 *
 */
@Service
public class DemoService {
	@Autowired private ApplicationContext ctx;
	@Autowired private Validador validador;
	@Autowired private DemoRepositorio repositorio;
	
	/**
	 * 
	 * @param entidade
	 */
	public void inserir(DemoEntidade entidade) {
		final DemoValidacaoNegocio validacaoNegocio = ctx.getBean(
			DemoValidacaoNegocio.class,
			entidade);
		//validador.validar(validacaoNegocio);
		repositorio.save(entidade);
	}
}
