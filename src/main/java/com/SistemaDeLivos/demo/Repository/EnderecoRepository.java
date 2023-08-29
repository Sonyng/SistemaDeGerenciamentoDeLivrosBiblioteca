package com.SistemaDeLivos.demo.Repository;

import com.SistemaDeLivos.demo.Models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
