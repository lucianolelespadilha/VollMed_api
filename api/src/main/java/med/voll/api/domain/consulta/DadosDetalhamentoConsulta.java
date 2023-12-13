/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

/**
 *
 * @author llpad
 */
public record DadosDetalhamentoConsulta(
        Long id,  
        Long idMedico,
        Long idPaciente, 
        LocalDateTime data) {

}
