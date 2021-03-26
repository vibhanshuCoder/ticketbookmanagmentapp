package com.decipher.book.ticket.app.ticketbookmanagmentapp.service;

import com.decipher.book.ticket.app.ticketbookmanagmentapp.dao.TicketBookingDao;
import com.decipher.book.ticket.app.ticketbookmanagmentapp.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingService {

    @Autowired
    private TicketBookingDao ticketBookingDao;
    public Ticket createTicket(Ticket ticket)
    {
        return ticketBookingDao.save(ticket);
    }
    public Ticket getTicketById(Integer ticketId)
    {
        return ticketBookingDao.findById(ticketId).get();
    }
}

