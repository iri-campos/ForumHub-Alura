package br.com.alura.forumhub.domain.resposta;

import java.time.LocalDateTime;

public record DadosDetalhamentoResposta(
        Long id,
        String mensagem,
        Boolean solucao,
        LocalDateTime dataCriacao,
        String autor,
        Long idTopico
) {
}
