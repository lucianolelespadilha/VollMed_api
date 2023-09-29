/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package med.voll.api.medico;

/**
 *
 * @author llpad
 */
public record DadosListagemMedico(
        
        String nome,
        
        String email,
        
        String crm,
        
        Especialidade especialidade
        
        ) {
    
    public DadosListagemMedico(Medico medico){
        
        this(medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade());
    }
    

}
