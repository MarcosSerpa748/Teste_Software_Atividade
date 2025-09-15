package br.com.marcos.regex.exceptions;

public class CPFInvalidoExeption extends RuntimeException {
    private String mensagem;

    public CPFInvalidoExeption(String mensagem){
        this.mensagem =mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
