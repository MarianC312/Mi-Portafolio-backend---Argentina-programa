/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import ar.com.efecesoluciones.Portafolio.model.Educacion;
import java.util.List;

/**
 *
 * @author Lojito
 */
public interface IEducacionService {
    public List<Educacion> verEducacion();
    public Educacion crearEducacion(Educacion edu);
    public boolean eliminarEducacion(Long id);
    public Educacion editarEducacion(Educacion edu);
    public List<Educacion> verEducacionPorIdPersona(Long id);
}
