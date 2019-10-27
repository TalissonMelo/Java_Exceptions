package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numero;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}
	
	public Reserva(Integer numero, Date entrada, Date saida) {
		super();
		this.numero = numero;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}
	
	public long duracao() {
		long dur = saida.getTime() - entrada.getTime();
		return TimeUnit .DAYS.convert(dur, TimeUnit.MILLISECONDS);
	}
	
	public String atualizandoDatas(Date entrada, Date saida) {
		Date nova = new Date();
		if (entrada.before(nova) && saida.before(nova)) {

			return "Erro na reserva: Data de renovação estão incorretas";

		}
		if (!saida.after(entrada)) {
			return "Erro na reserva: Data de saida posterior a data de entrada";

		}
		this.entrada = entrada;
		this.saida = saida;
		
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto número : " 
				+ numero 
				+ " \nData de entrada: "
				+ sdf.format(entrada)
				+ " \nData de saida : "
				+ sdf.format(saida)
				+ "\nTotal de "
				+ duracao()
				+ " dias";				
	}
}
