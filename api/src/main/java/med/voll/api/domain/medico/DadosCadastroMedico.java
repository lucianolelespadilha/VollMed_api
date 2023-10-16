/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

/**
 *
 * @author llpad
 */
public record DadosCadastroMedico(
         
        @NotBlank
        String nome,
        
        @NotBlank 
        @Email
        String email,
        
        @NotBlank 
        String telefone,
        
        @NotBlank
        @Pattern(regexp="\\d{4,6}")        
        String crm, 
        
        @NotNull
        Especialidade especialidade, 
        
        @NotNull
        @Valid        
        DadosEndereco endereco 
        ){
    
}
