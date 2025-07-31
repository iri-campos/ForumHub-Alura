package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.curso.Curso;
import br.com.alura.forumhub.curso.CursoRepository;
import br.com.alura.forumhub.curso.DadosCadastroCurso;
import br.com.alura.forumhub.curso.DadosDetalhamentoCurso;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroCurso dados) {
        repository.save(new Curso(dados));
    }

    @GetMapping
    public List<DadosDetalhamentoCurso> listar() {
        return repository.findAll().stream()
                .map(c -> new DadosDetalhamentoCurso(c.getId(), c.getNome(), c.getCategoria()))
                .toList();
    }
}