package br.com.alura.forumhub.domain.resposta;

import br.com.alura.forumhub.domain.topico.Topico;
import br.com.alura.forumhub.domain.autor.Autor;
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
    private Autor autor;

    @ManyToOne
    private Topico topico;

    public Resposta(String mensagem, Boolean solucao, Autor autor, Topico topico) {
        this.mensagem = mensagem;
        this.solucao = solucao;
        this.autor = autor;
        this.topico = topico;
    }
}
