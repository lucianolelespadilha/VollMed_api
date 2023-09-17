/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author llpad
 */

@RestController//Mostra para o spring que essa classe e um controller
@RequestMapping("medicos")
public class MedicoController {
      
    @Autowired // Mecanismos de injeção de dependencias.  O SpringBoot vai instanciar e passar essa atibuto dentro da class controler
    private MedicoRepository repository;
    
    @PostMapping//Mostra a o spring que tipo de requisição vai chegar para o controller
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){//@RequestBody pegar o parametro do corpo da requisição
        
        repository.save(new Medico(dados));
                
    }
    
    
}
