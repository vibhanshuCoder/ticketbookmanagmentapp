package com.decipher.book.ticket.app.ticketbookmanagmentapp.dao;

import com.decipher.book.ticket.app.ticketbookmanagmentapp.entities.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {



}
