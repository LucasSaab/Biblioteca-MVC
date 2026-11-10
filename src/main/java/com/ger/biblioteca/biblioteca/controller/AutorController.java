package com.ger.biblioteca.biblioteca.controller;

import com.ger.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private final List<Autor> listaAutor =  new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("autor", new Autor());
        return "biblioteca/autor";
    }

    @GetMapping("/lista")
    public String novoAutor(@ModelAttribute Autor autor) {
        listaAutor.add(autor);
        return "redirect:/autores/lista";
    }

    @PostMapping
    public String cadastrarAutor(@ModelAttribute Autor autor) {
        listaAutor.add(autor);
        return "biblioteca/autorLista";
    }
}