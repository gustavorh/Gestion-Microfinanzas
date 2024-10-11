package dev.gustavorh.gestionmicrofinanzas.repositories;

import dev.gustavorh.gestionmicrofinanzas.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
