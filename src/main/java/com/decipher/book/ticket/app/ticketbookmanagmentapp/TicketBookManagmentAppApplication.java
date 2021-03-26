package com.decipher.book.ticket.app.ticketbookmanagmentapp;

import com.decipher.book.ticket.app.ticketbookmanagmentapp.entities.Ticket;
import com.decipher.book.ticket.app.ticketbookmanagmentapp.service.TicketBookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.Date;

@SpringBootApplication
public class TicketBookManagmentAppApplication {

    public static void main(String[] args)
    {
        ConfigurableApplicationContext applicationContext =SpringApplication.run(TicketBookManagmentAppApplication.class, args);
        TicketBookingService ticketBookingService = applicationContext.getBean("ticketBookingService", TicketBookingService.class);
        Ticket ticket = new Ticket();
        ticket.setBookingDate(new Date());
        ticket.setDestStation("Kota");
        ticket.setSourceStation("jaipur");
        ticket.setPassengername("vibhanshu sen");
        ticket.setEmail("vibhanshusen@gmail.com");
        ticketBookingService.createTicket(ticket);
    }

}
