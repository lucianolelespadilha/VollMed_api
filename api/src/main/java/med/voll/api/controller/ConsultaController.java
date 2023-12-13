/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.consulta.AgendaDeConsultas;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author llpad
 */

@RestController
@RequestMapping("consultas")
public class ConsultaController {
    
    @Autowired
    private AgendaDeConsultas agenda;
    
    @PostMapping
    @Transactional 
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){
     agenda.agendar(dados);
                return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null,null));
        
    }
    
    
    
}
