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
        /* Descomentar para crear roles:
        Al crear más roles se debe agregar la etiqueta.

        Si querés crear más roles recordá agregar la etiqueta
        @PreAuthorize("hasRole('nombreROL')") antes de cada acción
        en los controladores para dar esos nuevos permisos.

        En este proyecto el administrador accede a todos las acciones
        en los endpoints de los controladores (CRUD completo)
        mientras que el usuario 'USER' solo accede a los de
        visualización. Aunque globalmente todos los endpoints con
        /ver se encuentran permitidos desde la clase MainSecurity en
        los antMatchers (es decir que no necesitas estar logueado para
        ver el contenido).
        */

        /*
        // Rol de administrador
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        rolService.save(rolAdmin);

        // Rol de usuario (por defecto)
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolUser);

         */



    }
}
