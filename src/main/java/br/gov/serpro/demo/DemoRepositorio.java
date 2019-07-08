/**
 * 
 */
package br.gov.serpro.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
public interface DemoRepositorio extends JpaRepository<DemoEntidade, Long> {

}
