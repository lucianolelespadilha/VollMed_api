/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 *
 * @author llpad
 */
public record DadosEndereco(
        
        @NotBlank
        String logradouro,
        
        @NotBlank
        String bairro,
        
        @NotBlank
        @Pattern(regexp ="\\d{8}")
        String cep,
        
        @NotBlank
        String cidade,
        
        @NotBlank
        String uf,
        
        String numero,
        
        String complemento){
    
}
