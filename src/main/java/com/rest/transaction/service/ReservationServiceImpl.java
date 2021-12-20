package com.rest.transaction.service;

import com.rest.transaction.model.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService {

    private final IReleaseService releaseService;

    private final ITicketService ticketService;

    public ReservationServiceImpl(IReleaseService releaseService, ITicketService ticketService) {
        this.releaseService = releaseService;
        this.ticketService = ticketService;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void scheduleReservation(Reservation reservation) {
        ticketService.saveTicket(reservation.getTicket());
        if (reservation.getTicket().getCode().equals("012345")) {
            throw new RuntimeException("thowing exception to test transaction rollback");
        }
        releaseService.saveRelease(reservation.getRelease());

    }

    @Override
    public void cancelReservation(Reservation reservation) {
        ticketService.deleteTicketById(reservation.getTicket().getId());
        releaseService.deleteReleaseById(reservation.getRelease().getId());
    }
}
