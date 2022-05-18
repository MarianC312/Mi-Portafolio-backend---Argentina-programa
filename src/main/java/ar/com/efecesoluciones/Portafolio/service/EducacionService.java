/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import ar.com.efecesoluciones.Portafolio.model.Educacion;
import ar.com.efecesoluciones.Portafolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Lojito
 */
@Service
public class EducacionService implements IEducacionService {
    
    @Autowired
    public EducacionRepository eduRepo;

    @Override
    public List<Educacion> verEducacion() {
        return eduRepo.findAll();
    }

    @Override
    public Educacion crearEducacion(Educacion edu) {
        return eduRepo.save(edu);
    }

    @Override
    public boolean eliminarEducacion(Long id) {
        try{
            eduRepo.deleteById(id);
            return true;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error al ejecutar acción.", e);
        }
    }

    @Override
    public Educacion editarEducacion(Educacion edu) {
        return eduRepo.save(edu);
    }

    @Override
    public List<Educacion> verEducacionPorIdPersona(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
