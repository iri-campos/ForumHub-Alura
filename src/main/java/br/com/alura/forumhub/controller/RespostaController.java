package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.resposta.DadosCadastroResposta;
import br.com.alura.forumhub.resposta.DadosDetalhamentoResposta;
import br.com.alura.forumhub.resposta.Resposta;
import br.com.alura.forumhub.resposta.RespostaRepository;
import br.com.alura.forumhub.topico.Topico;
import br.com.alura.forumhub.topico.TopicoRepository;
import br.com.alura.forumhub.usuario.Usuario;
import br.com.alura.forumhub.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("respostas")
public class RespostaController {
    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroResposta dados) {
        Usuario autor = usuarioRepository.findById(dados.idAutor())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        Topico topico = topicoRepository.findById(dados.idTopico())
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado"));

        Resposta resposta = new Resposta(dados.mensagem(), dados.solucao(), autor, topico);
        respostaRepository.save(resposta);
    }

    @GetMapping
    public List<DadosDetalhamentoResposta> listar() {
        return respostaRepository.findAll().stream()
                .map(r -> new DadosDetalhamentoResposta(
                        r.getId(),
                        r.getMensagem(),
                        r.getSolucao(),
                        r.getDataCriacao(),
                        r.getAutor().getNome(),
                        r.getTopico().getId()
                )).toList();
    }
}
