/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.medico.DadosCadastroMedico;
import med.voll.api.domain.medico.Especialidade;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.DadosCadastroPaciente;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.endereco.DadosEndereco;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

/**
 *
 * @author llpad
 */
@DataJpaTest // Quando queremos testar uma alguma coisa da camada de percistencia como o repository
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //Diz para o spring usar o banco de dados do projeto e nao o de memoria
@ActiveProfiles("test")//Diz ao spring para usar o banco de dados vollmed_api_test
class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired // A class TestEntityManager será usado para salvar o medico,paciente e consulta
    private TestEntityManager em;

    @Test
    @DisplayName("Devolve null quando o unico medico  cadastrado não esta disponivel na data.")
    void escolherMedicoAleatorioLivreNaDataCenario1() {

        //given ou arrange
        //Cria a variavel data para mudar a data eo horario da consulta
        var proximaSegundaAs10 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10, 0);

        var medico = cadastrarMedico("Medico", "medico@voll.med", "123456", Especialidade.CARDIOLOGIA);
        var paciente = cadastrarPaciente("Paciente", "paciente@voll.med", "00000000000");
        cadastrarConsulta(medico, paciente, proximaSegundaAs10);

        //when ou act 
        //Cria uma consulta passando uma variavel no parametro data
        var medicoLivre = medicoRepository.escolherMedicoAleatorioLivreNaData(Especialidade.CARDIOLOGIA, proximaSegundaAs10);

        //then ou assert
        //O metodo assertThat vai ser usado para devolver null
        assertThat(medicoLivre).isNull();

    }

    @Test
    @DisplayName("Devolve devolver medico quando ele estiver disponivel na data.")
    void escolherMedicoAleatorioLivreNaDataCenario2() {

        //given ou arrange
        //Cria a variavel data para mudar a data eo horario da consulta
        var proximaSegundaAs10 = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).atTime(10, 0);

        var medico = cadastrarMedico("Medico", "medico@voll.med", "123456", Especialidade.CARDIOLOGIA);

        //when ou act 
        //Cria uma consulta passando uma variavel no parametro data
        var medicoLivre = medicoRepository.escolherMedicoAleatorioLivreNaData(Especialidade.CARDIOLOGIA, proximaSegundaAs10);

        //then ou assert
        //O metodo assertThat vai ser usado para devolver null
        assertThat(medicoLivre).isEqualTo(medico);

    }

    private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
        em.persist(new Consulta(null, medico, paciente, data, null));

    }

    private Medico cadastrarMedico(String nome, String email, String crm, Especialidade especialidade) {
        var medico = new Medico(dadosMedico(nome, email, crm, especialidade));
        em.persist(medico);
        return medico;
    }

    private Paciente cadastrarPaciente(String nome, String email, String cpf) {
        var paciente = new Paciente(dadosPaciente(nome, email, cpf));
        em.persist(paciente);
        return paciente;
    }

    private DadosCadastroMedico dadosMedico(String nome, String email, String crm, Especialidade especialidade) {
        return new DadosCadastroMedico(
                nome,
                email,
                "61999999999",
                crm,
                especialidade,
                dadosEndereco()
        );
    }

    private DadosCadastroPaciente dadosPaciente(String nome, String email, String cpf) {
        return new DadosCadastroPaciente(
                nome,
                email,
                "61999999999",
                cpf,
                dadosEndereco()
        );

    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua xpto",
                "bairro",
                "0000000",
                "Brasilia",
                "DF",
                null,
                null
        );

    }
}
