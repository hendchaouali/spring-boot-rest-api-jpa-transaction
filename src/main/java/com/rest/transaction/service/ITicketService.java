package com.rest.transaction.service;

import com.rest.transaction.model.Ticket;

import java.util.List;

public interface ITicketService {

    List<Ticket> getAllTickets();

    void saveTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    Ticket getTicketById(Long id);

    void deleteTicketById(Long id);
}
