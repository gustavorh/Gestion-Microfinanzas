package dev.gustavorh.gestionmicrofinanzas.repositories;

import dev.gustavorh.gestionmicrofinanzas.models.Banco;
import org.springframework.data.repository.CrudRepository;

public interface BancoRepository extends CrudRepository<Banco, Long> {
}
