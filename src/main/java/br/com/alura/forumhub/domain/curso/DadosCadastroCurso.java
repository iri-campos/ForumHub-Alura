package br.com.alura.forumhub.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCurso(
        @NotBlank
        String nome,

        String categoria
) {
}
