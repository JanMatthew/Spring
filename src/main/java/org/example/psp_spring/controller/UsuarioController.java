package org.example.psp_spring.controller;

import org.example.psp_spring.model.Result;
import org.example.psp_spring.model.Usuario;
import org.example.psp_spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    private ResponseEntity<?> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @PostMapping
    private ResponseEntity<?> addUser(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.add(usuario));
    }

    @PutMapping
    private ResponseEntity<?> updateUser(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.update(usuario));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteUser(@PathVariable Long id) throws Throwable {
        try {
            return ResponseEntity.ok(new Result.Success<>(usuarioService.delete(id)));
        }
        catch (Exception e) {
            return ResponseEntity.ok(new Result.Error(e.getMessage()) {
            });
        }
    }

}
