package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.autor.DadosCadastroAutor;
import br.com.alura.forumhub.domain.autor.DadosDetalhamentoAutor;
import br.com.alura.forumhub.domain.autor.Autor;
import br.com.alura.forumhub.domain.autor.AutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class AutorController {
    @Autowired
    private AutorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroAutor dados) {
        repository.save(new Autor(dados));
    }

    @GetMapping
    public List<DadosDetalhamentoAutor> listar() {
        return repository.findAll().stream()
                .map(u -> new DadosDetalhamentoAutor(u.getId(), u.getNome(), u.getEmail()))
                .toList();
    }
}

