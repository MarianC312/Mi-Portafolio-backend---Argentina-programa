/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.Controller;

import ar.com.efecesoluciones.Portafolio.model.Experiencia;
import ar.com.efecesoluciones.Portafolio.model.Persona;
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
public class personaController {
    
    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping ("/ver/persona")
    public Persona verPersonaPorId(@RequestParam("persona_id") Long persona_id){
        return persoServ.buscarPersona(persona_id);
    }
    
    @GetMapping ("/ver/personas")
    public ResponseEntity<List<Persona>> verPersonas(){
        List<Persona> listaPersona = persoServ.verPersonas();
        return new ResponseEntity<>(listaPersona, HttpStatus.OK);
    }
    
    @PostMapping ("/nueva/persona")
    public Persona agregarPersona(@RequestBody Persona pers){
        return persoServ.crearPersona(pers);
    }
    
    @DeleteMapping ("/eliminar/persona")
    public boolean eliminarPersona(@RequestParam("id") Long id){
        return persoServ.borrarPersona(id);
    }
    
    @PutMapping ("/editar/persona")
    public Persona editarPersona(@RequestBody Persona pers){
        return persoServ.editarPersona(pers);
    }
}
