package com.SistemaDeLivos.demo.Models;

import com.SistemaDeLivos.demo.Models.Entity.Livro;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Emprestimo {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "Livro_id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "Endereco_id")
    private Endereco EnderecoEmprestimo;

    private String nomePessoa;
    private String cpfPessoa;
    private LocalDate dataEmprestimo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Endereco getEnderecoEmprestimo() {
        return EnderecoEmprestimo;
    }

    public void setEnderecoEmprestimo(Endereco enderecoEmprestimo) {
        EnderecoEmprestimo = enderecoEmprestimo;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
}
