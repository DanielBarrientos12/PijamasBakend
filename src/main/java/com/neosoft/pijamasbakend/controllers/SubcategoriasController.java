package com.neosoft.pijamasbakend.controllers;

import com.neosoft.pijamasbakend.models.SubcategoriaDto;
import com.neosoft.pijamasbakend.entities.Subcategoria;
import com.neosoft.pijamasbakend.services.SubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategorias")
public class SubcategoriasController {

    @Autowired
    private SubcategoriaService subcategoriaService;

    @GetMapping
    public ResponseEntity<List<Subcategoria>> getAllSubcategorias() {
        return ResponseEntity.ok(subcategoriaService.getAllSubcategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subcategoria> findById(@PathVariable int id) {
        return ResponseEntity.ok(subcategoriaService.findById(id));
    }

    @GetMapping( "/categoria/{id}")
    public ResponseEntity<Iterable<Subcategoria>> getAllSubcategoriasByCategoria(@PathVariable int id) {
        return ResponseEntity.ok(subcategoriaService.findByCategoriaId(id));
    }

    @PostMapping("{id}")
    public ResponseEntity<Subcategoria> createSubcategoria(@PathVariable int id, @RequestBody SubcategoriaDto subcategoriaDto) {
        return ResponseEntity.ok(subcategoriaService.createSubcategoria(id, subcategoriaDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subcategoria> updateSubcategoria(@PathVariable int id, @RequestBody SubcategoriaDto subcategoriaDto) {
        return ResponseEntity.ok(subcategoriaService.updateSubcategoria(id, subcategoriaDto));
    }

    @DeleteMapping("/{id}")
    public void deleteSubcategoria(@PathVariable int id) {
        subcategoriaService.deleteSubcategoria(id);
    }

}
