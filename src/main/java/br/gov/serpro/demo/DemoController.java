/**
 * 
 */
package br.gov.serpro.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.otojunior.validadornegocio.validador.ValidacaoNegocioException;
import br.org.otojunior.validadornegocio.validador.ViolacaoRestricao;

/**
 * @author Oto Soares Coelho Junior (oto.coelho-junior@serpro.gov.br)
 *
 */
@RestController
public class DemoController {
	@Autowired
	private MessageSource source;
	
	@Autowired
	private DemoService service;
	
	/**
	 * 
	 * @param entidade
	 * @return
	 */
	@PostMapping("/demo")
	public ResponseEntity<Void> inserir(@Valid @RequestBody final DemoEntidade entidade) {
		entidade.setCpf("01456231651");
		service.inserir(entidade);
		return ResponseEntity.created(null).build();
	}
	
	/**
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidacaoNegocioException.class)
	public Map<String, List<String>> handleBusinessValidationExceptions(final ValidacaoNegocioException ex) {
		List<String> mensagens = ex.getViolacoes()
			.stream()
			.map(this::interpolar)
			.collect(Collectors.toList());
		return Collections.singletonMap("erros", mensagens);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(TransactionSystemException.class)
	public Map<String, List<String>> handle(TransactionSystemException ex) {
		ConstraintViolationException root = (ConstraintViolationException)ex.getRootCause();
		final List<String> mensagens = root.getConstraintViolations()
			.stream()
			.map(ConstraintViolation::getMessage)
			.collect(Collectors.toList());
		return Collections.singletonMap("erros", mensagens);
	}
	
	/**
	 * 
	 * @param violacao
	 * @return
	 */
	private String interpolar(ViolacaoRestricao violacao) {
		return source.getMessage(
			violacao.getMensagem(),
			violacao.getArgumentos().toArray(),
			LocaleContextHolder.getLocale());
	}
}
