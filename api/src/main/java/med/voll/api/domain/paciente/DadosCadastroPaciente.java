/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.paciente;

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
public record DadosCadastroPaciente(
        
        @NotBlank
        String nome, 
        
        @NotBlank
        @Email
        String email, 
        
        @NotBlank
        String telefone, 
        
        @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,
        
        @NotNull
        @Valid
        DadosEndereco endereco
        
        ) {
    
}
