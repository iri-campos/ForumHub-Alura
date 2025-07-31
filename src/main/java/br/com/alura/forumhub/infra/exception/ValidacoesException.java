package br.com.alura.forumhub.infra.exception;

public class ValidacoesException extends RuntimeException{
    public ValidacoesException(String mensagem) {
        super(mensagem);
    }
}
