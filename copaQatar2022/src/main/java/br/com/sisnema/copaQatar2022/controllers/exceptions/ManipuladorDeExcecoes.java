package br.com.sisnema.copaQatar2022.controllers.exceptions;

import br.com.sisnema.copaQatar2022.services.exceptions.IntegridadeBD;
import br.com.sisnema.copaQatar2022.services.exceptions.RecursoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ManipuladorDeExcecoes {

    @ExceptionHandler(RecursoNaoEncontrado.class)
    public ResponseEntity<ErroPadrao> entidadeNaoEncontrada(RecursoNaoEncontrado e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao erro = new ErroPadrao();
        erro.setTimestamp(Instant.now());
        erro.setStatus(status.value()); // 404
        erro.setError("ERRO NA REQUISIÇÃO (ID não encontrado) - 404!");
        erro.setMessage(e.getMessage()); // Erro da camada do Service
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(IntegridadeBD.class)
    public ResponseEntity<ErroPadrao> integridadeDB(IntegridadeBD e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroPadrao erro = new ErroPadrao();
        erro.setTimestamp(Instant.now());
        erro.setStatus(status.value()); // 400
        erro.setError("ERRO NA REQUISIÇÃO (Integridade do BD) - 400!");
        erro.setMessage(e.getMessage()); // Erro da camada do Service
        erro.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDeValidacao> validacao(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ErroDeValidacao erroDeValidacao = new ErroDeValidacao();
        erroDeValidacao.setTimestamp(Instant.now());
        erroDeValidacao.setStatus(status.value()); // 422
        erroDeValidacao.setError("EXCEÇÃO NA VALIDAÇÃO - BEANS VALIDATION!");
        erroDeValidacao.setMessage(e.getMessage()); // Erro da camada do Service
        erroDeValidacao.setPath(request.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            erroDeValidacao.AddErro(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(erroDeValidacao);
    }

}
