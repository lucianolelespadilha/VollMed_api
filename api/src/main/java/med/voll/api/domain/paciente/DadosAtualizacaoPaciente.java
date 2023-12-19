/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;

/**
 *
 * @author llpad
 */
public record DadosAtualizacaoPaciente(
        
        @NotNull
        Long id,
        
        String nome,
        
        String telefone,
        
        @Valid
        DadosEndereco endereco) {

}
