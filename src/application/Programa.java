package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do Quarto: ");
		int numero = input.nextInt();
		System.out.print("Data de entrada: ");
		Date entrada = sdf.parse(input.next());
		System.out.print("Data de saida: ");
		Date saida = sdf.parse(input.next());

		if (!saida.after(entrada)) {
			System.out.println("Erro na reserva: Data de saida anterior a data de entrada");
		} else {
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("");
			System.out.println("Reserva: " + reserva);

			System.out.println("");
			System.out.println("Entre com a data para atualizar reserva: ");
			System.out.print("Data de entrada: ");
			entrada = sdf.parse(input.next());
			System.out.print("Data de saida: ");
			saida = sdf.parse(input.next());

			String error = reserva.atualizandoDatas(entrada, saida);
			if (error != null) {
				System.out.println(error);
			}else {
				System.out.println("");
				System.out.println("Reserva: " + reserva);
			}
		}

		input.close();
	}

}
