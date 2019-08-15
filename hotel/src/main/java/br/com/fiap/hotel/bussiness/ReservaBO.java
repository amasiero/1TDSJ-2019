package br.com.fiap.hotel.bussiness;

import java.util.Date;

import br.com.fiap.hotel.model.entities.Reserva;

public class ReservaBO {

	public boolean validarCheckout(Reserva r) {
		// Checkout maior que data atual
		return r.getCheckout().after(new Date());
	}
	
	public boolean validarCheckinCheckout(Reserva r) {
		return r.getCheckin().before(r.getCheckout());
	}
}
