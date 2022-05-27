/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.Controller;

import ar.com.efecesoluciones.Portafolio.model.Educacion;
import ar.com.efecesoluciones.Portafolio.model.Habilidad;
import ar.com.efecesoluciones.Portafolio.model.Persona;
import ar.com.efecesoluciones.Portafolio.service.IHabilidadService;
import ar.com.efecesoluciones.Portafolio.service.IPersonaService;
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
@RequestMapping("/habilidad")
public class habilidadController {
    
    @Autowired
    private IHabilidadService habServ;

    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping ("/ver")
    public ResponseEntity<List<Habilidad>> verHabilidades(){
        List<Habilidad> listaHabilidad = habServ.verHabilidad();
        //int listaSize = listaExperiencia.size();
        return new ResponseEntity<>(listaHabilidad, HttpStatus.OK);
    }
    
    @GetMapping ("/ver/persona")
    public ResponseEntity<List<Habilidad>> verHabilidadPorIdPersona(@RequestParam("persona_id") Long persona_id){
        List<Habilidad> listaHabilidad = habServ.verHabilidadPorIdPersona(persona_id);
        return new ResponseEntity<>(listaHabilidad, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/nueva")
    public ResponseEntity<Habilidad> agregarHabilidad(@RequestParam("persona_id") Long persona_id ,@RequestBody Habilidad hab){
        Persona per = persoServ.buscarPersona(persona_id);
        if(per != null){
            Habilidad habilidad = hab;
            habilidad.setPersona(per);
            habilidad = habServ.crearHabilidad(hab);
            return new ResponseEntity<>(habilidad, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(hab, HttpStatus.BAD_REQUEST);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/eliminar")
    public boolean borrarHabilidad(@RequestParam("habilidad_id") Long habilidad_id){
        return habServ.eliminarHabilidad(habilidad_id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public ResponseEntity<Habilidad> editarHabilidad(@RequestBody Habilidad hab, @RequestParam("persona_id") Long persona_id){
        Persona per = persoServ.buscarPersona(persona_id);
        if(per != null){
            Habilidad habilidad = hab;
            habilidad.setPersona(per);
            habilidad = habServ.editarHabilidad(hab);
            return new ResponseEntity<>(habilidad, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(hab, HttpStatus.BAD_REQUEST);
        }
    }
    
}
