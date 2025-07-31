package br.com.alura.forumhub.domain.resposta;

public record DadosCadastroResposta (
        String mensagem,
        Boolean solucao,
        Long idAutor,
        Long idTopico
){
}
