/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import ar.com.efecesoluciones.Portafolio.model.Proyecto;
import ar.com.efecesoluciones.Portafolio.repository.EducacionRepository;
import ar.com.efecesoluciones.Portafolio.repository.ProyectoRepository;
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
public class ProyectoService implements IProyectoService {

    @Autowired
    public ProyectoRepository proyRepo;
    
    @Override
    public List<Proyecto> verProyecto() {
        return proyRepo.findAll();
    }

    @Override
    public Proyecto crearProyecto(Proyecto proy) {
        return proyRepo.save(proy);
    }

    @Override
    public boolean eliminarProyecto(Long id) {
        try{
            proyRepo.deleteById(id);
            return true;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error al ejecutar acción.", e);
        }
    }

    @Override
    public Proyecto editarProyecto(Proyecto proy) {
        return proyRepo.save(proy);
    }

    @Override
    public List<Proyecto> verProyectoPorIdPersona(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
