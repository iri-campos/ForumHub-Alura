package br.com.alura.forumhub.resposta;

import br.com.alura.forumhub.topico.Topico;
import br.com.alura.forumhub.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "respostas")
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;
    private Boolean solucao;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    private Usuario autor;

    @ManyToOne
    private Topico topico;

    public Resposta(String mensagem, Boolean solucao, Usuario autor, Topico topico) {
        this.mensagem = mensagem;
        this.solucao = solucao;
        this.autor = autor;
        this.topico = topico;
    }
}
