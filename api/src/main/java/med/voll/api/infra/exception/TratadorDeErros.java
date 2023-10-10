/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author llpad
 */
@RestControllerAdvice
public class TratadorDeErros {

    //Anotação para dizer ao Spring que sempre que houver uma exception EntityNotFoundException e para chamar esse metodo tratar erro 404
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {

        var erros = ex.getFieldErrors();
        
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());

    }
    
    private record DadosErroValidacao(String campo, String mensagem){
        
       public DadosErroValidacao(FieldError erro){
           this(erro.getField(), erro.getDefaultMessage());
       }
        
    }

}
