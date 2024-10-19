package dev.gustavorh.gestionmicrofinanzas.controllers;

import dev.gustavorh.gestionmicrofinanzas.models.Banco;
import dev.gustavorh.gestionmicrofinanzas.services.BancoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/api/bancos")
public class BancoController {
    private final BancoService bancoService;

    public BancoController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("titulo", "Ver Bancos");
        model.addAttribute("bancos", bancoService.findAll());
        return "bancos";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Banco> bancoOptional = bancoService.findById(id);
        if (bancoOptional.isPresent()) {
            return ResponseEntity.ok(bancoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/crear-banco")
    public String create(Model model) {
        Banco banco = new Banco();
        model.addAttribute("titulo", "Crear Banco");
        model.addAttribute("banco", banco);
        return "crear-banco";
    }

    @PostMapping("/crear-banco")
    public String save(@Valid @ModelAttribute("banco") Banco banco, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {}
        bancoService.save(banco);
        return "redirect:/api/bancos";
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
