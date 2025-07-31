package br.com.alura.forumhub.resposta;

public record DadosCadastroResposta (
        String mensagem,
        Boolean solucao,
        Long idAutor,
        Long idTopico
){
}
