package com.ger.biblioteca.biblioteca.controller;

import com.ger.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("autor", new Autor());
        return "biblioteca/autor";
    }

    @GetMapping("/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "biblioteca/autor";
    }

    @PostMapping
    public String cadastrarAutor(@ModelAttribute Autor autor, Model model) {
        model.addAttribute("autor", autor);
        return "biblioteca/confirmacao-autor";
    }
}