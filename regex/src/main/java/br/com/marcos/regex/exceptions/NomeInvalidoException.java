package br.com.marcos.regex.exceptions;

public class NomeInvalidoException extends RuntimeException {
    private String mensagem;

    public NomeInvalidoException(String mensagem){
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
