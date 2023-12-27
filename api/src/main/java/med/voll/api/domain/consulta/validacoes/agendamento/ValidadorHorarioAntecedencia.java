/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.domain.consulta.validacoes;

import java.time.Duration;
import java.time.LocalDateTime;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author llpad
 */
@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{

    

    @Override
    public void validar(DadosAgendamentoConsulta dados) {

        //Pega a data da consulta
        var dataConsulta = dados.data();

        //LocalDateTime.now pega a hora de agora 
        var agora = LocalDateTime.now();
        //Pega a diferença em minutos entre hora AGORA  e DATACONSULTA
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos! ");
        }
    }

    

}
