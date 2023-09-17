/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

/**
 *
 * @author llpad
 */

//A classe medico vai representar a tabela do banco de dados entidade JPA
@Table(name = "medicos")
@Entity(name = "Medicos")
@Getter//Lomboq gera os Getter automaticos
@NoArgsConstructor//Lomboq gera os constructor padrao sem argumentos JPA exige
@AllArgsConstructor//Lomboq cria um constructor que recebe todos os cammpos
@EqualsAndHashCode(of="id")//Gera o iquals e hashcode

public class Medico {
      
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    
    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
       this.nome = dados.nome();
       this.email = dados.email();
       this.telefone = dados.telefone();
       this.crm = dados.crm();
       this.especialidade = dados.especialidade();
       this.endereco = new Endereco(dados.endereco());
       
    }
    
    
}
