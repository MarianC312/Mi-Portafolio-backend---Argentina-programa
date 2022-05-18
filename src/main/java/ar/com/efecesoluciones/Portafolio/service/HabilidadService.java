/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import ar.com.efecesoluciones.Portafolio.model.Habilidad;
import ar.com.efecesoluciones.Portafolio.repository.HabilidadRepository;
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
public class HabilidadService implements IHabilidadService {

    @Autowired
    public HabilidadRepository habRepo;
    
    @Override
    public List<Habilidad> verHabilidad() {
        return habRepo.findAll();
    }

    @Override
    public Habilidad crearHabilidad(Habilidad hab) {
        return habRepo.save(hab);
    }

    @Override
    public boolean eliminarHabilidad(Long id) {
        try{
            habRepo.deleteById(id);
            return true;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error al ejecutar acción.", e);
        }
    }

    @Override
    public Habilidad editarHabilidad(Habilidad hab) {
        return habRepo.save(hab);
    }

    @Override
    public List<Habilidad> verHabilidadPorIdPersona(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
