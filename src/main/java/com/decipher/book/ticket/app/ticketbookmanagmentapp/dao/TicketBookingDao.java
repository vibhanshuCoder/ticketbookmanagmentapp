package com.decipher.book.ticket.app.ticketbookmanagmentapp.dao;

import com.decipher.book.ticket.app.ticketbookmanagmentapp.entities.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {

//    @Query(SELECT t FROM ticket WHERE t.destStation = ?)
    public Iterable<Ticket> findAllByDestStation(String destStation);


}
