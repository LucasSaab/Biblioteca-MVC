package com.ger.biblioteca.biblioteca.controller;

import com.ger.biblioteca.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livro", new Livro());
        return "biblioteca/livros";
    }

    @GetMapping("/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "biblioteca/livros";
    }

    @PostMapping
    public String cadastrarLivro(@ModelAttribute Livro livro, Model model) {
        model.addAttribute("livro", livro);
        return "biblioteca/confirmacao-livro";
    }
}