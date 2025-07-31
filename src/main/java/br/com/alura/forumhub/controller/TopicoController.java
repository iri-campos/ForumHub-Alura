package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.curso.Curso;
import br.com.alura.forumhub.curso.CursoRepository;
import br.com.alura.forumhub.topico.*;
import br.com.alura.forumhub.usuario.Usuario;
import br.com.alura.forumhub.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
        //Verifica duplicidade
        boolean topicoExistente = topicoRepository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem());
        if (topicoExistente) {
            throw new IllegalArgumentException("Já existe um tópico com esse título.");
        }

        //Verifica existência de autor
        Usuario autor = usuarioRepository.findById(dados.idAutor())
                .orElseThrow(() -> new EntityNotFoundException("Autor com ID " + dados.idAutor() + " não encontrado."));

        //Verifica existência de curso
        Curso curso = cursoRepository.findById(dados.idCurso())
                .orElseThrow(() -> new EntityNotFoundException("Curso com ID " + dados.idCurso() + " não encontrado."));

        Topico topico = new Topico(dados.titulo(), dados.mensagem(), autor, curso);
        topicoRepository.save(topico);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<DadosDetalhamentoTopico> listar() {
        return topicoRepository.findAllByAtivoTrue().stream()
                .map(t -> new DadosDetalhamentoTopico(
                        t.getId(),
                        t.getTitulo(),
                        t.getMensagem(),
                        t.getDataCriacao(),
                        t.getStatus().name(),
                        t.getAutor().getNome(),
                        t.getCurso().getNome(),
                        t.getAtivo()
                )).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar(@PathVariable Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico com ID " + id + " não encontrado."));

        var dados = new DadosDetalhamentoTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus().name(),
                topico.getAutor().getNome(),
                topico.getCurso().getNome(),
                topico.getAtivo()
        );

        return ResponseEntity.ok(dados);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {

        var topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isEmpty()) {
            throw new EntityNotFoundException("Tópico com ID " + id + " não encontrado.");
        }

        //Evita duplicidade apenas se for outro tópico
        boolean topicoDuplicado = topicoRepository
                .existsByTituloAndMensagemAndIdNot(dados.titulo(), dados.mensagem(), id);

        if (topicoDuplicado) {
            throw new IllegalArgumentException("Já existe outro tópico com esse título e mensagem.");
        }

        var topico = topicoOptional.get();
        topico.setTitulo(dados.titulo());
        topico.setMensagem(dados.mensagem());

        return ResponseEntity.ok(new DadosDetalhamentoTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus().name(),
                topico.getAutor().getNome(),
                topico.getCurso().getNome(),
                topico.getAtivo()
        ));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isEmpty()) {
            throw new EntityNotFoundException("Tópico com id " + id + " não encontrado.");
        }

        var topico = topicoOptional.get();
        topico.excluir();

        return ResponseEntity.noContent().build();
    }

}
