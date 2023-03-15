package com.projetoBar.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { HttpClientErrorException.Forbidden.class })
    protected ResponseEntity<Object> handleForbidden(HttpClientErrorException.Forbidden ex, WebRequest request) {
        // Crie um objeto de resposta personalizado
        String responseBody = "A solicitação foi legal, mas o servidor está recusando a responder a ela.";

        // Crie um objeto de resposta HTTP personalizado com o corpo de resposta e o código de status correto
        HttpStatus status = HttpStatus.FORBIDDEN;
        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), status, request);
    }
}
