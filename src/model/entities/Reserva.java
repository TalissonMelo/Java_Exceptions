package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {

	private Integer numero;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}
	
	public Reserva(Integer numero, Date entrada, Date saida) throws DomainException {
		if(!saida.after(entrada)) {
			throw new DomainException("Data de saida deve ser posterior a de entrada");
		}
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
	
	public void atualizandoDatas(Date entrada, Date saida) throws DomainException {
		Date nova = new Date();
		if (entrada.before(nova) && saida.before(nova)) {
			throw new DomainException("Datas incorretas. Datas para atualização devem ser futuras.");
		}
		if (!saida.after(entrada)) {
			throw new DomainException("Data de entrada tem que ser anterior a data de saida.");
		}
		this.entrada = entrada;
		this.saida = saida;
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
