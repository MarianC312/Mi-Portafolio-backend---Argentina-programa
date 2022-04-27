/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import java.util.List;
import ar.com.efecesoluciones.Portafolio.model.Persona;

/**
 *
 * @author Lojito
 */
public interface IPersonaService {
    
    public List<Persona> verPersonas();
    public Persona crearPersona(Persona per);
    public boolean borrarPersona(Long id);
    public Persona buscarPersona(Long id);
    public Persona editarPersona(Persona per);
}
