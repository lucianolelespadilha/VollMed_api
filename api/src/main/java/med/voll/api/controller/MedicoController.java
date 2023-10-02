/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.controller;

import jakarta.validation.Valid;
import java.util.List;
import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.medico.DadosCadastroMedico ;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){// o metodo nao pode ser void porque ele tem que retornar a List dos medicos.
        
        return repository.findAll(paginacao).map(DadosListagemMedico::new);// Metodo findAll retorna uma lista
        
    }
    
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        
        var medico = repository.getReferenceById(dados.id());
        
        medico.atualizarInformacoes(dados);
        
    }
    
    @DeleteMapping
    public void excluir(@RequestBody @Valid ){
        
    
    
}
