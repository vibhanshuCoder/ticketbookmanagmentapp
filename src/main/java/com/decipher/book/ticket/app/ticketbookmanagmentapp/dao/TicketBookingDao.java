package com.decipher.book.ticket.app.ticketbookmanagmentapp.dao;

import com.decipher.book.ticket.app.ticketbookmanagmentapp.entities.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface TicketBookingDao extends CrudRepository<Ticket, Integer>
{
    /*
 DAO(Data access object) generic API(Application programming Interface) use to access data from databases.
 */
    /*
    Native query refers to actual sql queries (referring to actual database objects) for study purpose only
   @Query(value = "SELECT * FROM ticket WHERE dest_station =:destStation", nativeQuery = true)
   */
    Iterable<Ticket> findByDestStation(String destStation);

    @Query(value = "FROM Ticket t WHERE t.sourceStation =:sourceStation AND t.destStation =:destStation")
    Iterable<Ticket> findTicketsBetweenStation(@Param("sourceStation") String sourceStation,@Param("destStation") String destStation);

    @Query(value = "SELECT dest_station FROM ticket GROUP BY dest_station ORDER BY COUNT(dest_station) DESC LIMIT 1",nativeQuery = true)
    String findMostVisitedPlace();
//                                                      -- parameterised qurey type " ?1 " --
    @Query(value = "select * from ticket where month(booking_date) =?1",nativeQuery = true)
    Iterable<Ticket> findTicketsByMonth(Integer bookingmonth);

    @Query(value = "select * from ticket", nativeQuery = true)
    Page<Ticket> findAllTickets(Pageable pageable);


}
