/**
 * 
 */
package br.gov.serpro.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.gov.serpro.demo.validador.AbstractValidacaoNegocio;
import br.gov.serpro.demo.validador.ViolacaoRestricao;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class DemoValidacaoNegocio extends AbstractValidacaoNegocio {
	@Override
	public List<Supplier<Optional<ViolacaoRestricao>>> validadores() {
		return Arrays.asList(
			this::validarRegraNegocio01,
			this::validarRegraNegocio02);
	}
	
	/**
	 * 
	 * @return
	 */
	public Optional<ViolacaoRestricao> validarRegraNegocio01() {
		// regra 1
		return Optional.of(ViolacaoRestricao.of("erro1"));
	}
	
	/**
	 * 
	 * @return
	 */
	public  Optional<ViolacaoRestricao> validarRegraNegocio02() {
		// regra 1
		return Optional.of(ViolacaoRestricao.of("erro2"));
	}
}
