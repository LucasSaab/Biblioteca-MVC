package com.ger.biblioteca.biblioteca.controller;

import com.ger.biblioteca.biblioteca.model.Categorias;
import com.ger.biblioteca.biblioteca.repository.CategoriasRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

    private final CategoriasRepository categoriasRepository;

    public CategoriasController(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    //http://localhost:8080/categorias
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", new Categorias());
        return "biblioteca/categorias";
    }

    // Salva e redireciona direto para a página da lista
    @PostMapping
    public String cadastrarLivro(@ModelAttribute Categorias categorias) {
        categoriasRepository.save(categorias);
        return "redirect:/categorias/lista"; // Redireciona para /livros/lista
    }

    // Leva para a lista de livros: http://localhost:8080/livros/lista
    @GetMapping("/lista")
    public String listarCategorias(Model model) {
        List<Categorias> listaCategorias = categoriasRepository.findAll();
        model.addAttribute("categorias",listaCategorias);
        return "biblioteca/categoriasLista";
    }

    @GetMapping("/excluir/{id}")
    public String excluirLivro ( @PathVariable Long id){
        categoriasRepository.deleteById(id);
        return "redirect:/categorias/lista";
    }
}
