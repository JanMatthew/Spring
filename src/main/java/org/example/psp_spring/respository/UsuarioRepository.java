package org.example.psp_spring.respository;

import org.example.psp_spring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@RequestMapping
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
