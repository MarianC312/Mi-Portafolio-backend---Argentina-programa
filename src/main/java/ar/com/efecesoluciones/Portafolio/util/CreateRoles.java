package ar.com.efecesoluciones.Portafolio.util;

import ar.com.efecesoluciones.Portafolio.seguridad.entity.Rol;
import ar.com.efecesoluciones.Portafolio.seguridad.enums.RolNombre;
import ar.com.efecesoluciones.Portafolio.seguridad.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        /* Descomentar para crear roles
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
        */
    }
}
