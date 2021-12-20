package com.rest.transaction.service;

import com.rest.transaction.model.Ticket;
import com.rest.transaction.repository.TicketRepository;
import com.rest.transaction.web.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements ITicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found ticket with id = " + id));
    }

    @Override
    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketRepository.findById(ticket.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Not found ticket with id = " + ticket.getId()));
        ticketRepository.save(ticket);
    }


    @Override
    public void deleteTicketById(Long id) {
        ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found ticket with id = " + id));
        ticketRepository.deleteById(id);
    }
}
