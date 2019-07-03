/**
 * 
 */
package br.gov.serpro.demo.validador;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public abstract class AbstractValidacaoNegocio implements ValidacaoNegocio {
	/**
	 * 
	 */
	public abstract List<Supplier<List<ViolacaoRestricao>>> validadores();
	
	/**
	 * 
	 */
	@Override
	public List<List<ViolacaoRestricao>> validar() {
		return Validador.validadores(validadores());
	}
}
