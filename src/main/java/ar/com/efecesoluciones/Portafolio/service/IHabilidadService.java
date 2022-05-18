/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import ar.com.efecesoluciones.Portafolio.model.Habilidad;
import java.util.List;

/**
 *
 * @author Lojito
 */
public interface IHabilidadService {
    public List<Habilidad> verHabilidad();
    public Habilidad crearHabilidad(Habilidad hab);
    public boolean eliminarHabilidad(Long id);
    public Habilidad editarHabilidad(Habilidad hab);
    public List<Habilidad> verHabilidadPorIdPersona(Long id);
}
