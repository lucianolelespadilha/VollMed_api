/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package med.voll.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author llpad
 */
// São passados dois tipos de objetos primeiro o tipo entidade e segundo tipo do atributo da chave primaria da entidade
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico>findAllByAtivoTrue(Pageable paginacao);

}
