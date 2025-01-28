package org.example.psp_spring.service;

import org.example.psp_spring.model.Departamento;
import org.example.psp_spring.model.Usuario;
import org.example.psp_spring.respository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

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

}
