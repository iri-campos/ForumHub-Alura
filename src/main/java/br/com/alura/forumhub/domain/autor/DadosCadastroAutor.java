package br.com.alura.forumhub.domain.autor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAutor(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email
) {
}
