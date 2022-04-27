/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import java.util.List;
import ar.com.efecesoluciones.Portafolio.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import ar.com.efecesoluciones.Portafolio.repository.PersonaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lojito
 */

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    public PersonaRepository persoRepo;
    
    @Override
    public List<Persona> verPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public Persona crearPersona(Persona per) {
        return persoRepo.save(per);
    }

    @Override
    public boolean borrarPersona(Long id) {
        try{
            persoRepo.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Persona buscarPersona(Long id) {
        return persoRepo.findById(id).get();
    }

    @Override
    public Persona editarPersona(Persona per) {
        return persoRepo.save(per);
    }
    
}
