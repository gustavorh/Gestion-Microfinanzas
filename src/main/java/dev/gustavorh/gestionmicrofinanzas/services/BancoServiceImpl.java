package dev.gustavorh.gestionmicrofinanzas.services;

import dev.gustavorh.gestionmicrofinanzas.models.Banco;
import dev.gustavorh.gestionmicrofinanzas.repositories.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Banco save(Banco banco) {
        return bancoRepository.save(banco);
    }

    @Override
    @Transactional
    public Optional<Banco> deleteById(Banco banco) {
        // bancoRepository.findById(id)
        Optional<Banco> bancoOptional = bancoRepository.findById(banco.getIdBanco());
        bancoOptional.ifPresent(bancoRepository::delete);
        bancoRepository.delete(banco);

        return bancoOptional;
    }
}
