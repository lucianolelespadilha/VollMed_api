/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.paciente;

import med.voll.api.endereco.DadosEndereco;

/**
 *
 * @author llpad
 */
public record DadosCadastroPaciente(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {
    
}
