package com.ger.biblioteca.biblioteca.repository;

import com.ger.biblioteca.biblioteca.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategoriasRepository extends JpaRepository <Categorias,Long> {
}
