/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.repository;

import ar.com.efecesoluciones.Portafolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lojito
 */
 @Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {
    
}
