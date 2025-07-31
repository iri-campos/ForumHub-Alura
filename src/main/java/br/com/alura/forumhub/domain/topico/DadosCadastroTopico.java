package br.com.alura.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroTopico(
        @NotBlank(message = "O título é obrigatório.")
        String titulo,

        @NotBlank(message = "A mensagem é obrigatória.")
        String mensagem,

        @NotNull(message = "O autor é obrigatório.")
        Long idAutor,

        @NotNull(message = "O curso é obrigatório.")
        Long idCurso) {
}
