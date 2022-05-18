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
@CrossOrigin(origins = "http://localhost:4200/")
public class habilidadController {
    
    @Autowired
    private IHabilidadService habServ;

    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping ("/ver/habilidad")
    public ResponseEntity<List<Habilidad>> verHabilidades(){
        List<Habilidad> listaHabilidad = habServ.verHabilidad();
        //int listaSize = listaExperiencia.size();
        return new ResponseEntity<>(listaHabilidad, HttpStatus.OK);
    }
    
    @GetMapping ("/ver/habilidad/persona")
    public ResponseEntity<List<Habilidad>> verHabilidadPorIdPersona(@RequestParam("persona_id") Long persona_id){
        List<Habilidad> listaHabilidad = habServ.verHabilidadPorIdPersona(persona_id);
        return new ResponseEntity<>(listaHabilidad, HttpStatus.OK);
    }
    
    @PostMapping ("/nueva/habilidad")
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
    
    @DeleteMapping ("/eliminar/habilidad")
    public boolean borrarHabilidad(@RequestParam("habilidad_id") Long habilidad_id){
        return habServ.eliminarHabilidad(habilidad_id);
    }
    
    @PutMapping("/editar/habilidad")
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
