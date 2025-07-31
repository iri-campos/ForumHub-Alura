package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.usuario.DadosCadastroUsuario;
import br.com.alura.forumhub.usuario.DadosDetalhamentoUsuario;
import br.com.alura.forumhub.usuario.Usuario;
import br.com.alura.forumhub.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }

    @GetMapping
    public List<DadosDetalhamentoUsuario> listar() {
        return repository.findAll().stream()
                .map(u -> new DadosDetalhamentoUsuario(u.getId(), u.getNome(), u.getEmail()))
                .toList();
    }
}

