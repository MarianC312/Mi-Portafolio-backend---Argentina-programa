/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.Controller;

import ar.com.efecesoluciones.Portafolio.model.Persona;
import ar.com.efecesoluciones.Portafolio.model.Sobremi;
import ar.com.efecesoluciones.Portafolio.service.IPersonaService;
import ar.com.efecesoluciones.Portafolio.service.ISobremiService;
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
public class sobremiController {
    
    @Autowired
    private ISobremiService sobremiServ;
    
    @Autowired
    private IPersonaService persoServ;
    
    @GetMapping ("/ver/sobremi")
    public ResponseEntity<List<Sobremi>> verSobremi(){
        List<Sobremi> listaSobremi = sobremiServ.verSobremi();
        return new ResponseEntity<>(listaSobremi, HttpStatus.OK);
    }
    
    @PostMapping ("/nueva/sobremi")
    public ResponseEntity<Sobremi> agregarSobremi(@RequestParam("persona_id") Long persona_id, @RequestBody Sobremi sobremi){
        Persona per = persoServ.buscarPersona(persona_id);
        if(per != null){
            Sobremi aptitud = sobremi;
            aptitud.setPersona(per);
            aptitud = sobremiServ.crearSobremi(sobremi);
            return new ResponseEntity<>(aptitud, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(sobremi, HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping ("/eliminar/sobremi")
    public boolean eliminarSobremi(@RequestParam("sobremi_id") Long sobremi_id){
        return sobremiServ.eliminarSobremi(sobremi_id);
    }
    
    @PutMapping ("/editar/sobremi")
    public ResponseEntity<Sobremi> editarSobremi(@RequestBody Sobremi sobremi, @RequestParam("persona_id") Long persona_id){
        Persona per = persoServ.buscarPersona(persona_id);
        if(per != null){
            Sobremi aptitud = sobremi;
            aptitud.setPersona(per);
            aptitud = sobremiServ.editarSobremi(sobremi);
            return new ResponseEntity<>(aptitud, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(sobremi, HttpStatus.BAD_REQUEST);
        }
    }
}
