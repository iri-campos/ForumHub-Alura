package br.com.alura.forumhub.topico;

import br.com.alura.forumhub.curso.Curso;
import br.com.alura.forumhub.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.PENDENTE;

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Curso curso;

    private Boolean ativo = true;

    public Topico(@NotBlank String titulo, @NotBlank String mensagem, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
    }

    public void excluir() {
        this.ativo = false;
    }
}
