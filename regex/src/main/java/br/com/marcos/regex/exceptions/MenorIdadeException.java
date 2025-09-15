package br.com.marcos.regex.exceptions;

public class MenorIdadeException extends RuntimeException {
    private String mensagem;

    public MenorIdadeException(String mensagem){
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
