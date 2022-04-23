/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import ar.com.efecesoluciones.Portafolio.model.Experiencia;
import ar.com.efecesoluciones.Portafolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return false;
        }
        
    }

    @Override
    public Experiencia editarExperiencia(Experiencia exp) {
        return expRepo.save(exp);
    }

    @Override
    public List<Experiencia> verExperienciasPorIdPersona(Long id) {
        //return expRepo.findAllById(id);
        return null;
    }

}
