/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package med.voll.api.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author llpad
 */
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
