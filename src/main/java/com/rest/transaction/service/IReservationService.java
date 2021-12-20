package com.rest.transaction.service;

import com.rest.transaction.model.Reservation;

public interface IReservationService {

    void scheduleReservation(Reservation reservation);

    void cancelReservation(Reservation reservation);

}
