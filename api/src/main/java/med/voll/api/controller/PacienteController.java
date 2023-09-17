/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.controller;

import med.voll.api.paciente.DadosCadastroPaciente;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author llpad
 */
@RestController
@RequestMapping("pacientes")
public class PacienteController {
    
    public void cadastrar(@RequestBody DadosCadastroPaciente dados){
        
    }
    
}
