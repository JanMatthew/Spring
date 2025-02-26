package org.example.psp_spring.controller;


import org.example.psp_spring.model.Departamento;
import org.example.psp_spring.model.Result;
import org.example.psp_spring.model.Usuario;
import org.example.psp_spring.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Logger;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    Logger logger = Logger.getLogger(DepartamentoController.class.getName());

    @GetMapping
    private ResponseEntity<?> getAll() {
        return ResponseEntity.ok(departamentoService.getAll());
    }

    @PostMapping
    private ResponseEntity<?> addDepartamento(@RequestBody Departamento departamento) {
        return ResponseEntity.ok(departamentoService.add(departamento));
    }

    @PutMapping
    private ResponseEntity<?> updateDepartamento(@RequestBody Departamento departamento) {
        return ResponseEntity.ok(departamentoService.update(departamento));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteDepartamento(@PathVariable Long id) throws Throwable {
        try {
            return ResponseEntity.ok(new Result.Success<>(departamentoService.delete(id)));
        }
        catch (Exception e) {
            return ResponseEntity.ok(new Result.Error(e.getMessage()) {
            });
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<?> procesarCSV(@RequestParam("file") MultipartFile file) {
        logger.info("Recibida peticion de procesar CSV");

        return ResponseEntity.ok(departamentoService.procesarCSV(file));

    }



}
