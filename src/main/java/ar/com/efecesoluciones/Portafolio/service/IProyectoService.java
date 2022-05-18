/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import ar.com.efecesoluciones.Portafolio.model.Proyecto;
import java.util.List;

/**
 *
 * @author Lojito
 */
public interface IProyectoService {
    public List<Proyecto> verProyecto();
    public Proyecto crearProyecto(Proyecto proy);
    public boolean eliminarProyecto(Long id);
    public Proyecto editarProyecto(Proyecto proy);
    public List<Proyecto> verProyectoPorIdPersona(Long id);
}
