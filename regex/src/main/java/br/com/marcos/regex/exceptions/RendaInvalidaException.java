package br.com.marcos.regex.exceptions;

public class RendaInvalidaException extends RuntimeException {
    private String mensagem;

    public RendaInvalidaException(String mensagem){
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
