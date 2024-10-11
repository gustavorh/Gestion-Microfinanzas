package dev.gustavorh.gestionmicrofinanzas.controllers;

import dev.gustavorh.gestionmicrofinanzas.models.Banco;
import dev.gustavorh.gestionmicrofinanzas.services.BancoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bancos")
public class BancoController {
    private final BancoService bancoService;

    public BancoController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @GetMapping
    public List<Banco> findAll() {
        return bancoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Banco> bancoOptional = bancoService.findById(id);
        if (bancoOptional.isPresent()) {
            return ResponseEntity.ok(bancoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Banco banco, BindingResult bindingResult) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bancoService.save(banco));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Banco banco, BindingResult bindingResult, @PathVariable Long id) {
        Optional<Banco> bancoOptional = bancoService.update(id, banco);
        if (bancoOptional.isPresent()) {
            return ResponseEntity.ok(bancoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Banco> bancoOptional = bancoService.delete(id);
        if (bancoOptional.isPresent()) {
            return ResponseEntity.ok(bancoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
