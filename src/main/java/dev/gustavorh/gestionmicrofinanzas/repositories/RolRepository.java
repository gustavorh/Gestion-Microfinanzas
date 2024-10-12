package dev.gustavorh.gestionmicrofinanzas.repositories;

import dev.gustavorh.gestionmicrofinanzas.models.Rol;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolRepository extends CrudRepository<Rol, Long> {
    Optional<Rol> findByNombre(String name);
}
