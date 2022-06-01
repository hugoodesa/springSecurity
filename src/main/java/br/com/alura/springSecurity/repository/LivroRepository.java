package br.com.alura.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.alura.springSecurity.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
