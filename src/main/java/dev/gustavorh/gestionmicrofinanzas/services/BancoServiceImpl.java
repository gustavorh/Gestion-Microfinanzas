package dev.gustavorh.gestionmicrofinanzas.services;

import dev.gustavorh.gestionmicrofinanzas.models.Banco;
import dev.gustavorh.gestionmicrofinanzas.repositories.BancoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BancoServiceImpl implements BancoService {
    private final BancoRepository bancoRepository;

    public BancoServiceImpl(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Banco> findAll() {
        return (List<Banco>) bancoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Banco> findById(Long id) {
        return bancoRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Banco banco) {
        bancoRepository.save(banco);
    }

    @Override
    @Transactional
    public Optional<Banco> update(Long id, Banco banco) {
        Optional<Banco> bancoOptional = bancoRepository.findById(id);
        if(bancoOptional.isPresent()) {
            Banco bancoDb = bancoOptional.orElseThrow();
            bancoDb.setNombre(banco.getNombre());
            bancoDb.setDireccion(banco.getDireccion());
            bancoDb.setTelefono(banco.getTelefono());
            bancoDb.setEmail(banco.getEmail());
            bancoDb.setTasaInteresBase(banco.getTasaInteresBase());
            bancoDb.setPrestamos(banco.getPrestamos());

            return Optional.of(bancoRepository.save(bancoDb));
        }
        return bancoOptional;
    }

    @Override
    @Transactional
    public Optional<Banco> delete(Long id) {
        // bancoRepository.findById(id)
        Optional<Banco> bancoOptional = bancoRepository.findById(id);
        bancoOptional.ifPresent(bancoRepository::delete);

        return bancoOptional;
    }
}
