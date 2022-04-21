/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import ar.com.efecesoluciones.Portafolio.model.Experiencia;
import java.util.List;

/**
 *
 * @author Lojito
 */
public interface IExperienciaService {
    public List<Experiencia> verExperiencias();
    public Experiencia crearExperiencia(Experiencia exp);
    public boolean eliminarExperiencia(Long id);
    public boolean editarExperiencia(Experiencia exp);
    
}
