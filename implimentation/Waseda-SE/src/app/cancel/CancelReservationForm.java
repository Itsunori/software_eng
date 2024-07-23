/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package app.cancel;

import app.AppException;

/**
 * Form class for Check-out Customer
 * 
 */
public class CancelReservationForm {

	private CancelReservationControl cancelReservationControl = new CancelReservationControl();

	private CancelReservationControl getReservationControl() {
		return cancelReservationControl;
	}

	private String reservationNumber;

	public void cancel() throws AppException {
		CancelReservationControl cancelReservationControl = getReservationControl();
		cancelReservationControl.cancel(reservationNumber);
		return;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

}
