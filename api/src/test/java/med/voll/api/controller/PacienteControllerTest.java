/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package med.voll.api.controller;

import java.io.IOException;
import med.voll.api.domain.paciente.DadosCadastroPaciente;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.paciente.DadosDetalhamentoPaciente;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 *
 * @author llpad
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class PacienteControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    JacksonTester<DadosCadastroPaciente> dadosCadastroPacienteJson;

    @Autowired
    JacksonTester<DadosDetalhamentoPaciente> dadosDetalhamentoPacienteJson;

    @MockBean
    private PacienteRepository repository;

    @Test
    @DisplayName("Deveria devolver codigo 400 quando as informações estão invalidas")
    @WithMockUser
    void cadastrar_canario1() throws Exception {

        var response = mvc.perform(MockMvcRequestBuilders.post("/pacientes")).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando as informações estiverem validas.")
    @WithMockUser
    void agendar_canario2() throws IOException, Exception {
        var dadosCadastro = new DadosCadastroPaciente(
                "Luciano",
                "luciano@voll.med",
                "34984334229'", "00000000000 ",
                dadosEndereco()
        );
        
        when(repository.save(any())).thenReturn(new Paciente(dadosCadastro));
        
        var response = mvc.perform(MockMvcRequestBuilders
        .post("/pacientes")
        .contentType(MediaType.APPLICATION_JSON)
                .content(dadosCadastroPacienteJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "Travessa Senhor Neném",
                "Joaquim Querino",
                "75860000",
                "Quirinopolis",
                "GO",
                "2",
                null
        );
    }

}
