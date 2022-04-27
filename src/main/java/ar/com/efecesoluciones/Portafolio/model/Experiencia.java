/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.springframework.lang.Nullable;

/**
 *
 * @author Lojito
 */
@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titulo;
    
    private String periodo;
    
    @Nullable
    private String logo;
    
    @Nullable
    private String descripcion;
    
    
    //CascadeType.PERSIST permite borrar el elemento sin requerir borrar
    //todo como lo hace ALL...
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "persona_id", nullable = true)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    //@JsonIgnoreProperties({"hibernateLaziInitializer", "handler"})
    @JsonInclude(JsonInclude.Include.ALWAYS)
    //@JsonIgnore
    private Persona persona;

    public Experiencia() {
    }

    public Experiencia(Long id, String titulo, String periodo, String logo, String descripcion, Persona persona) {
        this.id = id;
        this.titulo = titulo;
        this.periodo = periodo;
        this.logo = logo;
        this.descripcion = descripcion;
        this.persona = persona;
    }
    
    public void setPersona(Persona pers){
        this.persona = pers;
    }
    
}
