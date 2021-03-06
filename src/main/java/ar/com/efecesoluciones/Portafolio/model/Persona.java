/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

/**
 *
 * @author Lojito
 */
@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    @Nullable
    private String imagen;
    @Nullable
    private String facebook;
    @Nullable
    private String instagram;
    @Nullable
    private String twitter;
    @Nullable
    private String cafecito;
    @Nullable
    private String email;
    @Nullable
    private String telefono;
    
    public Persona(){
        
    }
  
    public Persona(Long id, String nombre, String apellido, String imagen){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
    }
    
    
    
    //@OneToMany()
    //private ArrayList<Experiencia> experienciaLaboral;
    
    //@OneToMany()
    //private ArrayList<Sobremi> sobremi;
}
