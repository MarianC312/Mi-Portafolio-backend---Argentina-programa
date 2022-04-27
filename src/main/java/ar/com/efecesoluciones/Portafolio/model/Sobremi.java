/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author Lojito
 */
@Getter @Setter
@Entity
public class Sobremi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String icono;
    private String titulo;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "persona_id", nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    //@JsonIgnoreProperties({"hibernateLaziInitializer", "handler"})
    @JsonInclude(JsonInclude.Include.ALWAYS)
    //@JsonIgnore
    private Persona persona;

    public Sobremi() {
    }

    public Sobremi(Long id, String icono, String titulo, Persona persona) {
        this.id = id;
        this.icono = icono;
        this.titulo = titulo;
        this.persona = persona;
    }
    
    
}
