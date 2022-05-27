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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ar.com.efecesoluciones.Portafolio.service.IPersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Lojito
 */
@RestController
@CrossOrigin(origins = {"https://netlify.app/", "https://marianocampos.netlify.app/", "localhost", "http://localhost", "http://localhost:4200/"})
@RequestMapping("/experiencia")
public class experienciaController {
    @Autowired
    private IExperienciaService expServ;

    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping ("/ver")
    public ResponseEntity<List<Experiencia>> verExperiencias(){
        List<Experiencia> listaExperiencia = expServ.verExperiencias();
        //int listaSize = listaExperiencia.size();
        return new ResponseEntity<>(listaExperiencia, HttpStatus.OK);
    }
    
    @GetMapping ("/ver/persona")
    public ResponseEntity<List<Experiencia>> verExperienciasPorIdPersona(@RequestParam("persona_id") Long persona_id){
        List<Experiencia> listaExperiencia = expServ.verExperienciasPorIdPersona(persona_id);
        return new ResponseEntity<>(listaExperiencia, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/nueva")
    public ResponseEntity<Experiencia> agregarExperiencia(@RequestParam("persona_id") Long persona_id ,@RequestBody Experiencia exp){
        Persona per = persoServ.buscarPersona(persona_id);
        if(per != null){
            Experiencia experiencia = exp;
            experiencia.setPersona(per);
            experiencia = expServ.crearExperiencia(exp);
            return new ResponseEntity<>(experiencia, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(exp, HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/eliminar")
    public boolean borrarExperiencia(@RequestParam("experiencia_id") Long experiencia_id){
        return expServ.eliminarExperiencia(experiencia_id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia exp, @RequestParam("persona_id") Long persona_id){
        Persona per = persoServ.buscarPersona(persona_id);
        if(per != null){
            Experiencia experiencia = exp;
            experiencia.setPersona(per);
            experiencia = expServ.editarExperiencia(exp);
            return new ResponseEntity<>(experiencia, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(exp, HttpStatus.BAD_REQUEST);
        }
    }
}
