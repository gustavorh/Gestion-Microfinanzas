package dev.gustavorh.gestionmicrofinanzas.repositories;

import dev.gustavorh.gestionmicrofinanzas.models.Prestamo;
import org.springframework.data.repository.CrudRepository;

public interface PrestamoRepository extends CrudRepository<Prestamo, Long> {
}
