/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.Controller;

import ar.com.efecesoluciones.Portafolio.model.Experiencia;
import java.util.List;
import ar.com.efecesoluciones.Portafolio.model.Persona;
import ar.com.efecesoluciones.Portafolio.service.IExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ar.com.efecesoluciones.Portafolio.service.IPersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lojito
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class experienciaController {
    
    //@Autowired
    //private IPersonaService persoServ;
    @Autowired
    private IExperienciaService expServ;
    
    
    @GetMapping ("/ver/experiencias")
    public ResponseEntity<List<Experiencia>> verExperiencias(){
        List<Experiencia> listaExperiencia = expServ.verExperiencias();
        //int listaSize = listaExperiencia.size();
        return new ResponseEntity<>(listaExperiencia, HttpStatus.OK);
        
    }
    
    @PostMapping ("/nueva/experiencia")
    public Experiencia agregarExperiencia(@RequestBody Experiencia exp){
        return expServ.crearExperiencia(exp);
    }
    
    @DeleteMapping ("/borrar/experiencia")
    public boolean borrarExperiencia(@RequestParam("id") Long id){
        return expServ.eliminarExperiencia(id);
    }
    
    @PutMapping("/editar/experiencia")
    public Experiencia editarExperiencia(@RequestBody Experiencia exp){
        return expServ.editarExperiencia(exp);
    }
}
