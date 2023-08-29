package com.SistemaDeLivos.demo.Repository;

import com.SistemaDeLivos.demo.Models.Entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

}
