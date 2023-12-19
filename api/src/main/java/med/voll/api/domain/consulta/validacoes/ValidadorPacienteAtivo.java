/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author llpad
 */
public class ValidadorPacienteAtivo implements InterfaceValidacao{
    
    private PacienteRepository repository;
    
   @Autowired
    private Paciente paciente;
    
    @Override
     public void validar(DadosAgendamentoConsulta dados){
         
         if(dados.idPaciente() == null){
             return;
         }
         
         var pacienteEstaAtivo=repository.findAtivoById(dados.idPaciente());
         
         if(!pacienteEstaAtivo){
             throw new ValidacaoException("Consulta não pode ser agendada com paciente excluido! ");
         }
         
     }
    
}
