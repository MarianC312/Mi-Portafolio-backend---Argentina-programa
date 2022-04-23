/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ar.com.efecesoluciones.Portafolio.service;

import ar.com.efecesoluciones.Portafolio.model.Sobremi;
import java.util.List;

/**
 *
 * @author Lojito
 */
public interface ISobremiService {
    public List<Sobremi> verSobremi();
    public Sobremi crearSobremi(Sobremi sobremi);
    public boolean eliminarSobremi(Long id);
    public Sobremi editarSobremi(Sobremi sobremi);
    public List<Sobremi> verSobremiPorIdPersona(Long id);
}
