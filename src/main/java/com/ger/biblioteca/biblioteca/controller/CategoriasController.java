package com.ger.biblioteca.biblioteca.controller;

import com.ger.biblioteca.biblioteca.model.Categorias;
import com.ger.biblioteca.biblioteca.repository.CategoriasRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

    private final CategoriasRepository categoriasRepository;

    public CategoriasController(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categoriasRepository.findAll());
        return "categorias/lista";
    }

    @GetMapping("/novo")
    public String novaCategoria(Model model) {
        model.addAttribute("categoria", new Categorias());
        return "categorias/form";
    }

    @PostMapping
    public String cadastrarCategoria(@ModelAttribute("categoria") Categorias categoria) {
        categoriasRepository.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model) {
        Categorias categoria = categoriasRepository.findById(id).orElseThrow();
        model.addAttribute("categoria", categoria);
        return "categorias/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirCategoria(@PathVariable Long id) {
        categoriasRepository.deleteById(id);
        return "redirect:/categorias";
    }
}
