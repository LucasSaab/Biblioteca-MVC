package com.ger.biblioteca.biblioteca.controller;

import com.ger.biblioteca.biblioteca.model.Livro;
import com.ger.biblioteca.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    //http://localhost:8080/livros
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livro", new Livro());
        return "biblioteca/livros";
    }

    // Salva e redireciona direto para a página da lista
    @PostMapping
    public String cadastrarLivro(@ModelAttribute Livro livro) {
        livroRepository.save(livro);
        return "redirect:/livros/lista"; // Redireciona para /livros/lista
    }

    // Leva para a lista de livros: http://localhost:8080/livros/lista
    @GetMapping("/lista")
    public String listarLivros(Model model) {
        List<Livro> listaLivros = livroRepository.findAll();
        model.addAttribute("livros",listaLivros);
        return "biblioteca/livrosLista";
    }

    @GetMapping("/excluir/{id}")
    public String excluirLivro ( @PathVariable Long id){
        livroRepository.deleteById(id);
        return "redirect:/livros/lista";
    }
}