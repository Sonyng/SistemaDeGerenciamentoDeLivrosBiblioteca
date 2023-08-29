package com.SistemaDeLivos.demo.Controllers;

import com.SistemaDeLivos.demo.Models.Emprestimo;
import com.SistemaDeLivos.demo.Models.Entity.Livro;
import com.SistemaDeLivos.demo.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Livros")
public class LivroController {
    
  @Autowired
    private final LivroService livroService;

  
    public LivroController(LivroController livroController, LivroService livroService) {
        this.livroService = livroService;

    }

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listarlivros();
    }

    @GetMapping("/{id}")
    public Livro buscarLivroPorId(@PathVariable int id) {
        return livroService.buscarLivroPorId(id);
    }

    @PostMapping
    public Livro adicionarLivro(@RequestBody Livro livro) {
        return livroService.adicionarLivro(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable int id, @RequestBody Livro livro) {
        return livroService.atualizarLivro(id, livro);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable int id) {
        livroService.deletarLivro(id);
    }

    @PostMapping("/{id}/Detalhes_Emprestimo")
    public Emprestimo EmprestarLivros(
            @PathVariable int id,
            @RequestParam String nomePessoa,
            @RequestParam String cpfPessoa,
            @RequestParam int EnderecoID) {
        return LivroService.EmprestarLivros(id, nomePessoa, cpfPessoa, EnderecoID);
}

}
