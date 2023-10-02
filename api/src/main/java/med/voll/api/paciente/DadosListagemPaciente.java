/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package med.voll.api.paciente;

/**
 *
 * @author llpad
 */
public record DadosListagemPaciente(
        String nome,
        String emal,
        String cpf,
        String telefone) {

    public DadosListagemPaciente(Paciente paciente) {
        this(
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf(),
                paciente.getTelefone());
    }
}
