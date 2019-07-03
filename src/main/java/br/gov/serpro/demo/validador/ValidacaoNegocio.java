/**
 * 
 */
package br.gov.serpro.demo.validador;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * 
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public interface ValidacaoNegocio {
	public List<Optional<ViolacaoRestricao>> validar();
	public List<Supplier<Optional<ViolacaoRestricao>>> validadores();
}
