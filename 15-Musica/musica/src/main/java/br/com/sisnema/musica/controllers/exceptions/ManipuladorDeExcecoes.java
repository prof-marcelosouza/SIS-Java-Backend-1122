package br.com.sisnema.musica.controllers.exceptions;

import br.com.sisnema.musica.services.exceptions.IntegridadeBD;
import br.com.sisnema.musica.services.exceptions.RecursoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
