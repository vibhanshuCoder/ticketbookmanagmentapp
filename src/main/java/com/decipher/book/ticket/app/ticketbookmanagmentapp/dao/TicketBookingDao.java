package com.decipher.book.ticket.app.ticketbookmanagmentapp.dao;

import com.decipher.book.ticket.app.ticketbookmanagmentapp.entities.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer>
{
//    DAO(Data access object) generic API(Application programming Interface) use to access data from databases.

    /*
    Native query refers to actual sql queries (referring to actual database objects) for study purpose only
   @Query(value = "SELECT * FROM ticket WHERE dest_station =:destStation", nativeQuery = true)
   */
    Iterable<Ticket> findByDestStation(String destStation);

    @Query(value = "SELECT * FROM ticket WHERE source_station =:sourceStation AND dest_station =:destStation", nativeQuery = true)
    Iterable<Ticket> findTicketsBetweenStation(String sourceStation, String destStation);

    @Query(value = "SELECT dest_station FROM ticket GROUP BY dest_station ORDER BY COUNT(dest_station) DESC LIMIT 1",nativeQuery = true)
    String findMostVisitedPlace();

    @Query(value = "select * from ticket where month(booking_date) =?1",nativeQuery = true)
    Iterable<Ticket> findTicketsByMonth(Integer bookingmont);

    @Query(value = "select * from ticket", nativeQuery = true)
    List<Ticket> findAllTickets(Pageable pageable);

}
