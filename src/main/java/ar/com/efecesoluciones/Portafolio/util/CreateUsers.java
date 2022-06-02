package ar.com.efecesoluciones.Portafolio.util;

import ar.com.efecesoluciones.Portafolio.model.Persona;
import ar.com.efecesoluciones.Portafolio.seguridad.dto.NuevoUsuario;
import ar.com.efecesoluciones.Portafolio.seguridad.entity.Rol;
import ar.com.efecesoluciones.Portafolio.seguridad.entity.Usuario;
import ar.com.efecesoluciones.Portafolio.seguridad.enums.RolNombre;
import ar.com.efecesoluciones.Portafolio.seguridad.service.RolService;
import ar.com.efecesoluciones.Portafolio.seguridad.service.UsuarioService;
import ar.com.efecesoluciones.Portafolio.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CreateUsers implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    PersonaService personaService;

    @Override
    public void run(String... args) throws Exception {

        /* Descomentar para crear usuarios */

        Persona persona = new Persona(null, "Mariano", "Campos", null);
        personaService.crearPersona(persona);

        // Cambiar los parámetros para crear el usuario con los datos que quiera
        Usuario usuario = new Usuario("admin", "admin", "admin@admin.com",
                passwordEncoder.encode("admin"));
        usuario.setPersona(persona);

        Set<Rol> roles = new HashSet<>();

        // Agrega permisos de normal al usuario que voy a crear
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

        // Agrega permisos de administrador si quiero hacerlo admin
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());

        // Seteo los roles al usuario
        usuario.setRoles(roles);

        // Guardo el usuario en la db
        usuarioService.save(usuario);

    }
}
