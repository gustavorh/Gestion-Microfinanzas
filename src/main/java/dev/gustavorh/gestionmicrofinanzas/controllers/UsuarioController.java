package dev.gustavorh.gestionmicrofinanzas.controllers;

import dev.gustavorh.gestionmicrofinanzas.models.Usuario;
import dev.gustavorh.gestionmicrofinanzas.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Usuario usuario, BindingResult bindingResult) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> register(@Valid @RequestBody Usuario usuario, BindingResult bindingResult) {
        usuario.setAdmin(false);

        return save(usuario, bindingResult);
    }
}
