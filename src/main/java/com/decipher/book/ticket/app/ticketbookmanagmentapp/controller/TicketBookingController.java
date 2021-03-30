package com.decipher.book.ticket.app.ticketbookmanagmentapp.controller;

import com.decipher.book.ticket.app.ticketbookmanagmentapp.entities.Ticket;
import com.decipher.book.ticket.app.ticketbookmanagmentapp.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void deleteTicket(@PathVariable("ticketId")Integer ticketId) {
        ticketBookingService.deleteTicket(ticketId);
    }
    @PutMapping(value = "/updateTicket/{ticketId}/{newEmail}")
    public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId, @PathVariable("newEmail") String newEmail)
    {
        return ticketBookingService.updateTicket(ticketId,newEmail);
    }



}
