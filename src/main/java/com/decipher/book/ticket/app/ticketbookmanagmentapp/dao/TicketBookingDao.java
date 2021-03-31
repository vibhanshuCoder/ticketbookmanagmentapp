package com.decipher.book.ticket.app.ticketbookmanagmentapp.dao;

import com.decipher.book.ticket.app.ticketbookmanagmentapp.entities.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer>
{
    // Native query refers to actual sql queries (referring to actual database objects) for study purpose only
//   @Query(value = "SELECT * FROM ticket WHERE dest_station =:destStation", nativeQuery = true)
    public Iterable<Ticket> findByDestStation(String destStation);

    @Query(value = "SELECT * FROM ticket WHERE source_station =:sourceStation AND dest_station =:destStation", nativeQuery = true)
    Iterable<Ticket> findTicketsBetweenStation(String sourceStation, String destStation);



}
