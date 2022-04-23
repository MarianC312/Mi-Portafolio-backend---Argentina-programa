/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import ar.com.efecesoluciones.Portafolio.model.Sobremi;
import ar.com.efecesoluciones.Portafolio.repository.SobremiRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lojito
 */
@Service
public class SobremiService implements ISobremiService {
    
    @Autowired
    public SobremiRepository sobRepo;

    @Override
    public List<Sobremi> verSobremi() {
        return sobRepo.findAll();
    }

    @Override
    public Sobremi crearSobremi(Sobremi sobremi) {
        return sobRepo.save(sobremi);
    }

    @Override
    public boolean eliminarSobremi(Long id) {
        try{
            sobRepo.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Sobremi editarSobremi(Sobremi sobremi) {
        return sobRepo.save(sobremi);
    }

    @Override
    public List<Sobremi> verSobremiPorIdPersona(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
