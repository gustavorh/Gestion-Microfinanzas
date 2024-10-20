package dev.gustavorh.gestionmicrofinanzas.services;

import dev.gustavorh.gestionmicrofinanzas.models.Banco;

import java.util.List;
import java.util.Optional;

public interface BancoService {
    List<Banco> findAll();
    Optional<Banco> findById(Long id);
    void save(Banco banco);
    Optional<Banco> update(Long id, Banco banco);
    Optional<Banco> delete(Long id); // Long id
}
