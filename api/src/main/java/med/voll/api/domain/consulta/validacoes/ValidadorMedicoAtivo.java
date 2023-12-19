    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;

/**
 *
 * @author llpad
 */


public class ValidadorMedicoAtivo implements InterfaceValidacao{

    private MedicoRepository repository;

    
    @Override
    public void validar(DadosAgendamentoConsulta dados) {

        //escolha medico opcional
        if (dados.idMedico() == null) {
            return;
        }
        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());

        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com Médico excluido! ");
        }
    }
}
