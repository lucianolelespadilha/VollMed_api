/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package med.voll.api.controller;

import java.time.LocalDateTime;
import med.voll.api.domain.consulta.AgendaDeConsultas;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import med.voll.api.domain.medico.Especialidade;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
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
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters// Para adicionar o JacksonTester e preciso ter essa anotação na class
public class ConsultaControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private JacksonTester<DadosAgendamentoConsulta> dadosAgendamentoConsultaJson;
    
    @Autowired
    private JacksonTester<DadosDetalhamentoConsulta> dadosDetalhamentoConsultaJson;
    
    @MockBean
    private AgendaDeConsultas agendaDeConsultas; 
    
    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informações estiverem invalidas.")
    @WithMockUser// Fazer moc de usuario para simular usuario logado
    void agendar_cenario1() throws Exception {
        
        var response = mvc.perform(MockMvcRequestBuilders.post("/consultas")).andReturn().getResponse();
        
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
    
    @Test
    @DisplayName("Deveria devolver codigo http 200 quando as  informações estiverem validas.")
    @WithMockUser// Fazer moc de usuario para simular usuario logado
    void agendar_cenario2() throws Exception {
        
        var data = LocalDateTime.now().plusHours(1);
        var especialidade = Especialidade.CARDIOLOGIA;
        var dadosDetalhamento = new DadosDetalhamentoConsulta(null, 4l, 2l, data);
        
        Mockito.when(agendaDeConsultas.agendar(any())).thenReturn(dadosDetalhamento);
        
        var response = mvc
                .perform(MockMvcRequestBuilders
                        .post("/consultas")
                        .contentType(MediaType.APPLICATION_JSON)//Devemos passar um Json para simular a requisição contentType passa o cabeçalho json.
                        .content(dadosAgendamentoConsultaJson.write(
                                new DadosAgendamentoConsulta(4l , 2l, data, especialidade)
                        ).getJson())
                )
                .andReturn().getResponse();
        
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        
        var jsonEsperado = dadosDetalhamentoConsultaJson.write(
               dadosDetalhamento
        ).getJson(); 
        
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
    
}
