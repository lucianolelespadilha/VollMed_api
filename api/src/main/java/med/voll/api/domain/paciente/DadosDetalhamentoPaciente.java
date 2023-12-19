package med.voll.api.paciente;


import med.voll.api.endereco.Endereco;
import med.voll.api.domain.paciente.Paciente;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
/**
 *
 * @author llpad
 */
public record DadosDetalhamentoPaciente(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone,
        Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente) {

        this(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf(),
                paciente.getTelefone(),
                paciente.getEndereco());

    }

}
