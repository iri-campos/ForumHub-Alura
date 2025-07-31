package br.com.alura.forumhub.domain.autor;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    public Autor(DadosCadastroAutor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
    }
}
