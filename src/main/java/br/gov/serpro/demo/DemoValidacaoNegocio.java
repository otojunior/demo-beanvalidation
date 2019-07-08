/**
 * 
 */
package br.gov.serpro.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.org.otojunior.validadornegocio.validador.AbstractValidacaoNegocio;
import br.org.otojunior.validadornegocio.validador.ViolacaoRestricao;

/**
 * @author Oto Soares Coelho Junior (otojunior@gmail.com)
 *
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DemoValidacaoNegocio extends AbstractValidacaoNegocio {
	@SuppressWarnings("unused")
	private DemoEntidade entidade;
	
	/**
	 * 
	 * @param entidade
	 */
	public DemoValidacaoNegocio(DemoEntidade entidade) {
		this.entidade = entidade;
	}
	
	/**
	 * 
	 */
	@Override
	public List<Supplier<List<ViolacaoRestricao>>> validadores() {
		return Arrays.asList(
			this::validarRegraNegocio01,
			this::validarRegraNegocio02);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<ViolacaoRestricao> validarRegraNegocio01() {
		return Collections.singletonList(ViolacaoRestricao.of("erro1"));
	}
	
	/**
	 * 
	 * @return
	 */
	public  List<ViolacaoRestricao> validarRegraNegocio02() {
		return Collections.singletonList(ViolacaoRestricao.of("erro2"));
	}
}
