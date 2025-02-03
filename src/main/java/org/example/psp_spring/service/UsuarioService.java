package org.example.psp_spring.service;

import org.example.psp_spring.ConfigProperties;
import org.example.psp_spring.model.Usuario;
import org.example.psp_spring.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ConfigProperties configProperties;

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


    public String procesarImagen(Long id,MultipartFile file){
        Usuario u = usuarioRepository.findById(id).get();
        Date d = new Date();
        String fileName = id+".jpg";
        u.setFoto("usuarios/"+fileName);
        usuarioRepository.save(u);
        String ruta = configProperties.getConfigValue("root.path.images");
        try(InputStream is = file.getInputStream()){
            Files.copy(is,Path.of(ruta + "/usuarios/" + id.toString() + "_" + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e) {
            throw new RuntimeException("Error al procesar la imagen", e);
        }
        return u.getFoto();
    }
}
