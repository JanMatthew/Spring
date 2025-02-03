package org.example.psp_spring.service;

import org.example.psp_spring.model.Departamento;
import org.example.psp_spring.model.Usuario;
import org.example.psp_spring.respository.DepartamentoRepository;
import org.example.psp_spring.respository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Departamento> getAll() {
        return departamentoRepository.findAll();
    }

    public Departamento add(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento update(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento delete(Long id) throws Throwable {
        Departamento d = departamentoRepository.findById(id).orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                try {
                    throw new Exception("EL departamento con id " + id + " no existe");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        departamentoRepository.delete(d);
        return d;
    }

    public List<Departamento> procesarCSV(MultipartFile file) {
        List<Departamento> departamentos = new ArrayList<>();
        try(InputStream is = file.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            br.lines().
                    map(l -> Departamento.builder()
                            .descripcion(l)
                            .build())
                    .forEach(d -> departamentos.add(d)
                    );

            return departamentoRepository.saveAll(departamentos);

        }catch (Exception e){
           throw new RuntimeException(e);
        }
    }
}
