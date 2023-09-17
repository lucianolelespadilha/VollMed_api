/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author llpad
 */
@Embeddable
@Getter//Lomboq gera os Getter automaticos
@NoArgsConstructor//Lomboq gera os constructor padrao sem argumentos GPA exige
@AllArgsConstructor//Lomboq cria um constructor que recebe todos os cammpos
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    /**
     *
     * @param dados
     */
    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();        
        this.uf = dados.uf();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        
    }
    
}
