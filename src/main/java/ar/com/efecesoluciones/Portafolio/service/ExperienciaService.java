/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import ar.com.efecesoluciones.Portafolio.model.Experiencia;
import ar.com.efecesoluciones.Portafolio.model.Persona;
import ar.com.efecesoluciones.Portafolio.repository.ExperienciaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Lojito
 */
@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    public ExperienciaRepository expRepo;
    
    @Override
    public List<Experiencia> verExperiencias() {
        return expRepo.findAll();
    }

    @Override
    public Experiencia crearExperiencia(Experiencia exp) {
        return expRepo.save(exp);
    }

    @Override
    public boolean eliminarExperiencia(Long id) {
        try{
            expRepo.deleteById(id);
            return true;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error al ejecutar acción.", e);
        }
        
    }

    @Override
    public Experiencia editarExperiencia(Experiencia exp) {
        System.out.println(exp);
        return expRepo.save(exp);
    }

    @Override
    @EntityGraph(value = "experiencia.persona_id", type = EntityGraphType.FETCH)
    public List<Experiencia> verExperienciasPorIdPersona(Long id){ return null; };

}
