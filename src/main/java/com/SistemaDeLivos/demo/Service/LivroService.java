package com.SistemaDeLivos.demo.Service;

import com.SistemaDeLivos.demo.Models.Emprestimo;
import com.SistemaDeLivos.demo.Models.Endereco;
import com.SistemaDeLivos.demo.Models.Entity.Livro;
import com.SistemaDeLivos.demo.Repository.EmprestimoRepository;
import com.SistemaDeLivos.demo.Repository.EnderecoRepository;
import com.SistemaDeLivos.demo.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LivroService{

    private final LivroRepository livroRepository;
    private final EmprestimoRepository emprestimoRepository;
    private final EnderecoRepository enderecoRepository;

@Autowired
    public LivroService(LivroRepository livroRepository, EmprestimoRepository emprestimoRepository, EnderecoRepository enderecoRepository) {
        this.livroRepository = livroRepository;
        this.emprestimoRepository = emprestimoRepository;
        this.enderecoRepository = enderecoRepository;
    }
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro buscarLivroPorId(int id) {
        return livroRepository.findById(id).orElse(null);
    }

    public Livro adicionarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro atualizarLivro(int id, Livro livro) {
        Livro livroExistente = livroRepository.findById(id).orElse(null);
        if (livroExistente != null) {
            livro.setId(id);
            return livroRepository.save(livro);
        }
        return null;
    }

    public void deletarLivro(int id) {
        livroRepository.deleteById(id);
    }

    public  Emprestimo EmprestarLivros(int id, String nomePessoa, String cpfPessoa, int enderecoID) {
        Livro livro = livroRepository.findById(id).orElse(null);
        Endereco endereco = enderecoRepository.findById(enderecoID).orElse(null);

        if (livro != null && endereco != null && !livro.isEmprestado()) {
            livro.setEmprestado(true);
            livroRepository.save(livro);

            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setLivro(livro);
            emprestimo.setNomePessoa(nomePessoa);
            emprestimo.setCpfPessoa(cpfPessoa);
            emprestimo.setEnderecoEmprestimo(endereco);
            emprestimo.setDataEmprestimo(LocalDate.now());
            return emprestimoRepository.save(emprestimo);
        }
        return null;
    }

    public List<Livro> listarlivros() {
        return null;
    }
}
