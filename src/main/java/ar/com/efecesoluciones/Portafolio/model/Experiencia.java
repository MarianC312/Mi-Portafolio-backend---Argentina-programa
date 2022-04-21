/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
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
    private Boolean estado;

    public Experiencia() {
    }

    public Experiencia(Long id, String titulo, String periodo, String logo, String descripcion, Boolean estado) {
        this.id = id;
        this.titulo = titulo;
        this.periodo = periodo;
        this.logo = logo;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    
    
}
