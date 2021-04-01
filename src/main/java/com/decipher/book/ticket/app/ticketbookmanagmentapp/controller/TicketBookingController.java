package com.decipher.book.ticket.app.ticketbookmanagmentapp.controller;

import com.decipher.book.ticket.app.ticketbookmanagmentapp.DTO.TicketDOT;
import com.decipher.book.ticket.app.ticketbookmanagmentapp.entities.Ticket;
import com.decipher.book.ticket.app.ticketbookmanagmentapp.jasonClass.JsonResponse;
import com.decipher.book.ticket.app.ticketbookmanagmentapp.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketBookingController {

    @Autowired
    private TicketBookingService ticketBookingService;

    @PostMapping(value = "/createTicket")
    public Ticket createTicket(@RequestBody Ticket ticket)
    {
        return ticketBookingService.createTicket(ticket);
    }

    @GetMapping(value = "/ticket/{ticketId}")
    public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId)
    {
       return ticketBookingService.getTicketById(ticketId);
    }

    @GetMapping(value = "/alltickets")
    public Iterable<Ticket> getAllTickets()
    {
        return ticketBookingService.getAllTickets();
    }

    @DeleteMapping(value = "/deleteTicket/{ticketId}")
    public void deleteTicket(@PathVariable("ticketId")Integer ticketId)
    {
        ticketBookingService.deleteTicket(ticketId);
    }

    @PutMapping(value = "/updateTicket/{ticketId}/{newEmail}")
    public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId, @PathVariable("newEmail") String newEmail)
    {
        return ticketBookingService.updateTicket(ticketId,newEmail);
    }

    @GetMapping(value = "/ticketsByDestStation/{destStation}")
    public Iterable<Ticket> ticketsByDestStation(@PathVariable("destStation") String destStation)
    {
        return ticketBookingService.ticketsByDestStation(destStation);
    }

    @GetMapping(value ="/ticketsBetweenStation",params = {"sourceStation","destStation"})
    public Iterable<Ticket> ticketsBetweenStation(@RequestParam("sourceStation")String sourceStation,@RequestParam("destStation")String destStation)
    {
        return ticketBookingService.ticketsBetweenStation(sourceStation,destStation);
    }
    /*
    @GetMapping(value = "/favplace")
    public String favPlace()
    {
        return ticketBookingService.favPlace();
    }*/
    @GetMapping(value = "/favplace")
    public JsonResponse favPlace()
    {
        return ticketBookingService.favPlace();
    }

    @GetMapping(value = "/ticketsbymonth/{bookingDate}")
    public List<TicketDOT> bookedTickectOnMonth(@PathVariable("bookingDate")int bookingDate)
    {
        return ticketBookingService.bookedTicketOnMonth(bookingDate);
    }
}
