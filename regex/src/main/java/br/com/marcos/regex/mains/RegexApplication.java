package br.com.marcos.regex.mains;

import br.com.marcos.regex.exceptions.CPFInvalidoExeption;
import br.com.marcos.regex.exceptions.MenorIdadeException;
import br.com.marcos.regex.exceptions.NomeInvalidoException;
import br.com.marcos.regex.exceptions.RendaInvalidaException;
import br.com.marcos.regex.models.Cliente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RegexApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RegexApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		try {
			var cliente1 = Cliente.gerarObjeto(sc);
			System.out.println(cliente1);
		}catch (NomeInvalidoException |CPFInvalidoExeption|MenorIdadeException|RendaInvalidaException ex){
			System.out.println(ex.getMessage());
		}


	}
}
