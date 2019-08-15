package br.com.fiap.hotel.model.entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private long nroQuarto;
	private Date checkin;
	private Date checkout;
	
	public Reserva(long nroQuarto, Date checkin, Date checkout) {
		this.nroQuarto = nroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public long getNroQuarto() {
		return nroQuarto;
	}
	
	public void setNroQuarto(long nroQuarto) {
		this.nroQuarto = nroQuarto;
	}
	
	public Date getCheckin() {
		return checkin;
	}
	
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	
	public Date getCheckout() {
		return checkout;
	}
	
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	
	public long getPeriodo() {
		long diferenca = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
}
