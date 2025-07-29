package com.senac.biblioteca.controllers;

import com.senac.biblioteca.entities.Livro;
import java.util.*;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    List<Livro> lista;

    public LivrosController(List<Livro> lista) {
        Livro livro1 = new Livro(1, "Cinderela", 20.00);
        Livro livro2 = new Livro(2, "Procurando Nemo", 20.00);
        Livro livro3 = new Livro(3, "Pequeno Principe", 20.00);
        lista.add(livro1);
        lista.add(livro2);
        lista.add(livro3);
        this.lista = lista;
    }


    @GetMapping("")
    public List<Livro> listar() {
        return lista;
    }

    @GetMapping("/{idLivro}")
    public Livro buscarLivro(@PathVariable Integer idLivro) {
        for (Livro livro : lista) {
            if (Objects.equals(livro.getId(), idLivro)) {
                return livro;
            }
        }
        return null;
    }

    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        livro.setId(new Random().nextInt(100));
        return livro;
    }

    @PutMapping("/{idLivro}")
    public Livro editarLivro(@PathVariable Integer idLivro,
                             @RequestBody Livro livro) {
        for (Livro editar : lista) {
            if (editar.getId().equals(idLivro)) {
                editar.setNome(livro.getNome());
                editar.setPreco(livro.getPreco());
                return editar;
            }
        }
        return null;
    }

    @DeleteMapping("/{idLivro}")
    public Livro deletarLivro(@PathVariable Integer idLivro) {
        for (Livro deletar : lista) {
            if (deletar.getId().equals(idLivro)) {
                lista.remove(deletar);
                return deletar;
            }
        }
        return null;
    }

}