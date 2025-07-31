package br.com.alura.forumhub.topico;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensagem
) {
}
