/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.Controller;

import ar.com.efecesoluciones.Portafolio.model.Educacion;
import ar.com.efecesoluciones.Portafolio.model.Persona;
import ar.com.efecesoluciones.Portafolio.model.Proyecto;
import ar.com.efecesoluciones.Portafolio.service.IEducacionService;
import ar.com.efecesoluciones.Portafolio.service.IPersonaService;
import ar.com.efecesoluciones.Portafolio.service.IProyectoService;
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
public class proyectoController {
    
    @Autowired
    private IProyectoService proyServ;

    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping ("/ver/proyecto")
    public ResponseEntity<List<Proyecto>> verProyecto(){
        List<Proyecto> listaProyecto = proyServ.verProyecto();
        //int listaSize = listaExperiencia.size();
        return new ResponseEntity<>(listaProyecto, HttpStatus.OK);
    }
    
    @GetMapping ("/ver/proyecto/persona")
    public ResponseEntity<List<Proyecto>> verProyectoPorIdPersona(@RequestParam("persona_id") Long persona_id){
        List<Proyecto> listaProyecto = proyServ.verProyectoPorIdPersona(persona_id);
        return new ResponseEntity<>(listaProyecto, HttpStatus.OK);
    }
    
    @PostMapping ("/nueva/proyecto")
    public ResponseEntity<Proyecto> agregarProyecto(@RequestParam("persona_id") Long persona_id ,@RequestBody Proyecto proy){
        Persona per = persoServ.buscarPersona(persona_id);
        if(per != null){
            Proyecto proyecto = proy;
            proyecto.setPersona(per);
            proyecto = proyServ.crearProyecto(proy);
            return new ResponseEntity<>(proyecto, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(proy, HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping ("/eliminar/proyecto")
    public boolean borrarProyecto(@RequestParam("educacion_id") Long educacion_id){
        return proyServ.eliminarProyecto(educacion_id);
    }
    
    @PutMapping("/editar/proyecto")
    public ResponseEntity<Proyecto> editarProyecto(@RequestBody Proyecto proy, @RequestParam("persona_id") Long persona_id){
        Persona per = persoServ.buscarPersona(persona_id);
        if(per != null){
            Proyecto proyecto = proy;
            proyecto.setPersona(per);
            proyecto = proyServ.editarProyecto(proy);
            return new ResponseEntity<>(proyecto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(proy, HttpStatus.BAD_REQUEST);
        }
    }
    
}
