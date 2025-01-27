package org.example.psp_spring.service;

import org.example.psp_spring.model.Usuario;
import org.example.psp_spring.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.function.Supplier;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario add(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario delete(Long id) throws Throwable {
        Usuario u = usuarioRepository.findById(id).orElseThrow(new Supplier<Throwable>() {
           @Override
           public Throwable get() {
               try {
                   throw new Exception("EL usuario con id " + id + " no existe");
               } catch (Exception e) {
                   throw new RuntimeException(e);
               }
           }
        });
        usuarioRepository.delete(u);
        return u;
    }


}
