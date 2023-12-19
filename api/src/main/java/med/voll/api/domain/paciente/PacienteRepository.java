/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package med.voll.api.domain.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author llpad
 */
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("""
                    select p.ativo
                    from Paciente p
                    where  p.id = : id
                     """)
    Boolean findAtivoById(Long idPaciente);

    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);

}
