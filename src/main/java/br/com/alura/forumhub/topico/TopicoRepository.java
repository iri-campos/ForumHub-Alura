package br.com.alura.forumhub.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensagem(@NotBlank String titulo, @NotBlank String mensagem);

    boolean existsByTituloAndMensagemAndIdNot(@NotBlank String titulo, @NotBlank String mensagem, Long id);

    List<Topico> findAllByAtivoTrue();
}
