/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.controller;

import jakarta.validation.Valid;
import java.util.List;
import med.voll.api.domain.medico.DadosAtualizacaoMedico;
import med.voll.api.domain.medico.DadosCadastroMedico;
import med.voll.api.domain.medico.DadosDetalhamentoMedico;
import med.voll.api.domain.medico.DadosListagemMedico;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.paciente.DadosDetalhamentoPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
    //Para devolver o codigo 201 e preciso declarar um obejto UriComponentsBuilder para criar uma uri.
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {//@RequestBody pegar o parametro do corpo da requisição

        var medico = new Medico(dados);

        repository.save(medico);

        //O metodo uriBuilder cria automaticamente um uri mais e preciso passar na variavel path o complemento
        //buildAndExpand faz gerar de forma automatica a id no banco de dados toUri cria automadicamente o objeto Uri
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        //O metodo ResponseEntity.created que retorne o 201 pede uma uril e uma lista de informação.
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));

    }

    @GetMapping    // Usamos a interface page para fazer a paginaçao @PageableDefault premite configurar quantas consultas vao aparecer e ordenalas pelo nome
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {// o metodo nao pode ser void porque ele tem que retornar a List dos medicos.

        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);// Metodo findAll retorna uma lista

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {

        var medico = repository.getReferenceById(dados.id());

        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));

    }

    @Transactional
    @DeleteMapping("/{id}")// As chaves idicam que o parametro e dinamico
    public ResponseEntity excluir(@PathVariable Long id) {//@PathVariable indica para o Spring que o parametro id e o mesmo parametro dinamido que sera passado na URL

        var medico = repository.getReferenceById(id);

        medico.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {

        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
}
