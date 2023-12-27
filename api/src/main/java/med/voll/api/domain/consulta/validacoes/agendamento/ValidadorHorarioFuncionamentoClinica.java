/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.domain.consulta.validacoes;

import java.time.DayOfWeek;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

/**
 *
 * @author llpad
 */
@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    @Override
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        // metodo   getDayOfWeek pega o dia da semana equals procura o dia no caso SUNDAY
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        // getHour pega a hora 
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;

        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesDaAberturaDaClinica || depoisDoEncerramentoDaClinica) {
            throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica! ");
        }

    }

}
