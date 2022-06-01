package br.com.alura.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.alura.springSecurity.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
