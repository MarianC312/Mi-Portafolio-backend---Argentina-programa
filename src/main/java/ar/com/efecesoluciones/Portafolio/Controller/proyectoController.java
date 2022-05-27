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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Lojito
 */
@RestController
@CrossOrigin(origins = {"https://netlify.app/", "https://marianocampos.netlify.app/", "localhost", "http://localhost", "http://localhost:4200/"})
@RequestMapping("/proyecto")
public class proyectoController {
    
    @Autowired
    private IProyectoService proyServ;

    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping ("/ver")
    public ResponseEntity<List<Proyecto>> verProyecto(){
        List<Proyecto> listaProyecto = proyServ.verProyecto();
        //int listaSize = listaExperiencia.size();
        return new ResponseEntity<>(listaProyecto, HttpStatus.OK);
    }
    
    @GetMapping ("/ver/persona")
    public ResponseEntity<List<Proyecto>> verProyectoPorIdPersona(@RequestParam("persona_id") Long persona_id){
        List<Proyecto> listaProyecto = proyServ.verProyectoPorIdPersona(persona_id);
        return new ResponseEntity<>(listaProyecto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/nueva")
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

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/eliminar")
    public boolean borrarProyecto(@RequestParam("educacion_id") Long educacion_id){
        return proyServ.eliminarProyecto(educacion_id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
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
