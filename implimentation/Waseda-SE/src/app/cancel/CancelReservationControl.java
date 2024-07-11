/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package app.cancel;

import java.util.Date;

import app.AppException;
import app.ManagerFactory;
import domain.reservation.ReservationException;
import domain.reservation.ReservationManager;
import domain.room.RoomException;
import domain.room.RoomManager;

/**
 * Control class for Check-out Customer
 * 
 */
public class CancelReservationControl {
	int availableQtyOfChange = 1;
	public void cancel(String reservationNumber) throws AppException {
		try {
			//Consume reservation
			ReservationManager reservationManager = getReservationManager();
			Date stayingDate = reservationManager.cacelReservation(reservationNumber);

			//Update number of available rooms
			RoomManager roomManager = getRoomManager();
			roomManager.updateRoomAvailableQty(stayingDate, availableQtyOfChange);
			return;
		}
		catch (ReservationException e) {
			AppException exception = new AppException("Failed to cancel", e);
			exception.getDetailMessages().add(e.getMessage());
			exception.getDetailMessages().addAll(e.getDetailMessages());
			throw exception;

		}
		catch (RoomException e) {
			AppException exception = new AppException("Failed to cancel", e);
			exception.getDetailMessages().add(e.getMessage());
			exception.getDetailMessages().addAll(e.getDetailMessages());
			throw exception;
		}
	}

	private ReservationManager getReservationManager() {
		return ManagerFactory.getInstance().getReservationManager();
	}

	private RoomManager getRoomManager() {
		return ManagerFactory.getInstance().getRoomManager();
	}
}
