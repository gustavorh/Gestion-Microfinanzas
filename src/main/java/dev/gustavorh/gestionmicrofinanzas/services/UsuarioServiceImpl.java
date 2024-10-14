package dev.gustavorh.gestionmicrofinanzas.services;

import dev.gustavorh.gestionmicrofinanzas.models.Rol;
import dev.gustavorh.gestionmicrofinanzas.models.Usuario;
import dev.gustavorh.gestionmicrofinanzas.repositories.RolRepository;
import dev.gustavorh.gestionmicrofinanzas.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    //private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository/*, PasswordEncoder passwordEncoder*/) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        //this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        if (usuario.isAdmin()) {
            Optional<Rol> optionalRoleAdmin = rolRepository.findByNombre("ROL_ADMIN");
            optionalRoleAdmin.ifPresent(usuario::setRol);
        } else {
            Optional<Rol> optionalRol = rolRepository.findByNombre("ROL_USER");
            optionalRol.ifPresent(usuario::setRol);
        }
        //usuario.setPasswordHash(passwordEncoder.encode(usuario.getPasswordHash()));

        return usuarioRepository.save(usuario);
    }
}
