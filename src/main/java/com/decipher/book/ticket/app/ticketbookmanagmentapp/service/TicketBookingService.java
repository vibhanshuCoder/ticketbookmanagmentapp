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

    public Iterable<Ticket> getAllTickets() {

        return ticketBookingDao.findAll();
    }

    public void deleteTicket(Integer ticketId) {
         ticketBookingDao.deleteById(ticketId);
    }


    public Ticket updateTicket(Integer ticketId, String newEmail)
    {
         Ticket ticketFromDb = ticketBookingDao.findById(ticketId).get(); //Fetching ticket form database
         ticketFromDb.setEmail(newEmail); // set value of new email in email field
        return ticketBookingDao.save(ticketFromDb); //updating new email in Database

    }
}

