/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.Controller;

import ar.com.efecesoluciones.Portafolio.model.Educacion;
import ar.com.efecesoluciones.Portafolio.model.Persona;
import ar.com.efecesoluciones.Portafolio.service.IEducacionService;
import ar.com.efecesoluciones.Portafolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lojito
 */
@RestController
@CrossOrigin(origins = {"https://netlify.app/", "https://marianocampos.netlify.app/", "localhost", "http://localhost", "http://localhost:4200/"})
public class educacionController {
    
    @Autowired
    private IEducacionService eduServ;

    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping ("/ver/educacion")
    public ResponseEntity<List<Educacion>> verEducacion(){
        List<Educacion> listaEducacion = eduServ.verEducacion();
        //int listaSize = listaExperiencia.size();
        return new ResponseEntity<>(listaEducacion, HttpStatus.OK);
    }
    
    @GetMapping ("/ver/educacion/persona")
    public ResponseEntity<List<Educacion>> verEducacionPorIdPersona(@RequestParam("persona_id") Long persona_id){
        List<Educacion> listaEducacion = eduServ.verEducacionPorIdPersona(persona_id);
        return new ResponseEntity<>(listaEducacion, HttpStatus.OK);
    }
    
    @PostMapping ("/nueva/educacion")
    public ResponseEntity<Educacion> agregarEducacion(@RequestParam("persona_id") Long persona_id ,@RequestBody Educacion edu){
        Persona per = persoServ.buscarPersona(persona_id);
        if(per != null){
            Educacion educacion = edu;
            educacion.setPersona(per);
            educacion = eduServ.crearEducacion(edu);
            return new ResponseEntity<>(educacion, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(edu, HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping ("/eliminar/educacion")
    public boolean borrarEducacion(@RequestParam("educacion_id") Long educacion_id){
        return eduServ.eliminarEducacion(educacion_id);
    }
    
    @PutMapping("/editar/educacion")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion edu, @RequestParam("persona_id") Long persona_id){
        Persona per = persoServ.buscarPersona(persona_id);
        if(per != null){
            Educacion educacion = edu;
            educacion.setPersona(per);
            educacion = eduServ.editarEducacion(edu);
            return new ResponseEntity<>(educacion, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(edu, HttpStatus.BAD_REQUEST);
        }
    }
    
}
