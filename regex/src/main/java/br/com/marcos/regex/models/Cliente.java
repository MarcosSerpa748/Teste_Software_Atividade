package br.com.marcos.regex.models;

import br.com.marcos.regex.exceptions.CPFInvalidoExeption;
import br.com.marcos.regex.exceptions.MenorIdadeException;
import br.com.marcos.regex.exceptions.NomeInvalidoException;
import br.com.marcos.regex.exceptions.RendaInvalidaException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private Integer renda;
    private static final DateTimeFormatter FOMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public  Cliente(String nome,String cpf,LocalDate nascimento,Integer renda) {
        if (nome.length()>5 && nome.matches("^[a-zA-ZÀ-ú\\\\s]+$")){
            this.nome = nome;
        }else{
            throw new NomeInvalidoException("Nome com menos de 5 caracteres ou números foram inseridos!");
        }
        if (cpf.matches("^\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}$")) {
            this.cpf = cpf;
        }else {
            throw new CPFInvalidoExeption("CPF inválido!");
        }
      if (getIdade(nascimento)>18){
          this.nascimento = nascimento;
      }else{
          throw new MenorIdadeException("Menor de idade!");
      }
        if(renda>1200&&renda<15000){
            this.renda = renda;
        }else{
            throw new RendaInvalidaException("Renda fora dos requisitos!");
        }
    }
    public static Cliente gerarObjeto(Scanner sc){
        System.out.println("Digite seu nome:");
        var nome = sc.nextLine();
        System.out.println("Digite seu CPF:");
        var CPF = sc.nextLine();
        System.out.println("Digite o dia, o mês, e o ano de seu nascimento:");
        var dia = sc.nextInt();
        var mes = sc.nextInt();
        var ano = sc.nextInt();
        System.out.println("Digite o valor de sua renda:");
        var renda = sc.nextInt();

        return new Cliente(nome,CPF,LocalDate.of(ano,mes,dia),renda);
    }
    public int getIdade(LocalDate nascimento){
        return Period.between(nascimento,LocalDate.now()).getYears();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getRenda() {
        return renda;
    }

    public void setRenda(Integer renda) {
        this.renda = renda;
    }

    @Override
    public String toString() {
        return "nome:"+getNome()+"\n"+
                "CPF:"+getCpf()+"\n"+
                "Data de nscimento:"+getNascimento().format(FOMATADOR)+"\n"+
                "Renda:R$"+getRenda();
    }
}
