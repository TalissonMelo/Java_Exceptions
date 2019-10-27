package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Número do Quarto: ");
			int numero = input.nextInt();
			System.out.print("Data de entrada: ");
			Date entrada = sdf.parse(input.next());
			System.out.print("Data de saida: ");
			Date saida = sdf.parse(input.next());
	
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("");
			System.out.println("Reserva: " + reserva);
	
			System.out.println("");
			System.out.println("Entre com a data para atualizar reserva: ");
			System.out.print("Data de entrada: ");
			entrada = sdf.parse(input.next());
			System.out.print("Data de saida: ");
			saida = sdf.parse(input.next());
	
			reserva.atualizandoDatas(entrada, saida);
			System.out.println("");
			System.out.println("Reserva: " + reserva);
		} catch (ParseException e) {
			System.out.println("Data invalida!");
		} catch (DomainException e) {
			System.out.println("Erro na reserva :" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro inesperado.");
		}

		input.close();
	}

}
