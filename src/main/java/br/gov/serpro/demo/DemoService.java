/**
 * 
 */
package br.gov.serpro.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import br.gov.serpro.demo.validador.Validador;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Service
public class DemoService {
	@Autowired private ApplicationContext ctx;
	@Autowired private Validador validador;
	
	/**
	 * 
	 */
	public void executar(DemoEntidade entidade) {
		validador.validar(ctx.getBean(DemoValidacaoNegocio.class, entidade));
	}
}
