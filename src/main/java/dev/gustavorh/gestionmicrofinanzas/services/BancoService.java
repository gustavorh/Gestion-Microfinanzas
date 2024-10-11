package dev.gustavorh.gestionmicrofinanzas.services;

import dev.gustavorh.gestionmicrofinanzas.models.Banco;

import java.util.List;
import java.util.Optional;

public interface BancoService {
    List<Banco> findAll();
    Optional<Banco> findById(Long id);
    Banco save(Banco banco);
    Optional<Banco> deleteById(Banco banco); // Long id
}
