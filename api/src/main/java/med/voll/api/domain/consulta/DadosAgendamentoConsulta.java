/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import med.voll.api.domain.medico.Especialidade;

/**
 *
 * @author llpad
 */
public record DadosAgendamentoConsulta(
        
        Long idMedico,
        
        @NotNull
        Long idPaciente,
        
        @NotNull
        @Future // A data tem que ser no futuro
        LocalDateTime data,
        
        Especialidade especialidade) {

}
