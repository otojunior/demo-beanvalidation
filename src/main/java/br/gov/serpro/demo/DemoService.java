/**
 * 
 */
package br.gov.serpro.demo;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

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
		try {
			repositorio.save(entidade);
		} catch (Exception e) {
			tratarConstraintViolationException(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	private void tratarConstraintViolationException(Exception e) {
		if (e instanceof TransactionSystemException) {
			TransactionSystemException tex = (TransactionSystemException)e;
			Throwable root = tex.getRootCause();
			if (root instanceof ConstraintViolationException) {
				ConstraintViolationException cex = (ConstraintViolationException)root;
				throw cex;
			}
		}
	}
}
