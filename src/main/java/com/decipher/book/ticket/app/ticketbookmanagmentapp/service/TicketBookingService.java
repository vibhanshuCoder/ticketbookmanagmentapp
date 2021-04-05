package com.decipher.book.ticket.app.ticketbookmanagmentapp.service;

import com.decipher.book.ticket.app.ticketbookmanagmentapp.DTO.TicketDOT;
import com.decipher.book.ticket.app.ticketbookmanagmentapp.dao.TicketBookingDao;
import com.decipher.book.ticket.app.ticketbookmanagmentapp.entities.Ticket;
import com.decipher.book.ticket.app.ticketbookmanagmentapp.jsonClass.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Iterable<Ticket> getAllTickets()
    {
        return ticketBookingDao.findAll();
    }

    public void deleteTicket(Integer ticketId)
    {
        ticketBookingDao.deleteById(ticketId);
    }

    public Ticket updateTicket(Integer ticketId, String newEmail)
    {
        Ticket ticketFromDb = ticketBookingDao.findById(ticketId).get(); //Fetching ticket form database
        ticketFromDb.setEmail(newEmail); // set value of new email in email field
        return ticketBookingDao.save(ticketFromDb); //updating new email in Database
    }

    public Iterable<Ticket> ticketsByDestStation(String destStation)
    {
        return ticketBookingDao.findByDestStation(destStation);
    }

    public Iterable<Ticket> ticketsBetweenStation(String sourceStation, String destStation)
    {
        return ticketBookingDao.findTicketsBetweenStation(sourceStation,destStation);
    }

    public JsonResponse favPlace()
    {
        JsonResponse jsonResponse =new JsonResponse();
        jsonResponse.setFavPlace(ticketBookingDao.findMostVisitedPlace());
        return jsonResponse;
    }

    public List<TicketDOT> bookedTicketOnMonth(int bookingDate)
    {
        List<TicketDOT> dotList = new ArrayList<>();
        Iterable<Ticket> ticketsByMonth = ticketBookingDao.findTicketsByMonth(bookingDate);
        for (Ticket i : ticketsByMonth) {
            TicketDOT ticketDOT= new TicketDOT();
            ticketDOT.setPassengerName(i.getPassengername());
            ticketDOT.setSourceStation(i.getSourceStation());
            ticketDOT.setDestStation(i.getDestStation());
            dotList.add(ticketDOT);
        }

        return dotList;
    }

    public Page<Ticket> pagedTickets(Integer pageNo, Integer pageSize, String sortby)
    {
        String[] inp = sortby.split("\\,");
        Page<Ticket> sorted = ticketBookingDao.findAllTickets(PageRequest.of(pageNo, pageSize, Sort.by(inp).ascending()));
        return sorted;
    }




}

