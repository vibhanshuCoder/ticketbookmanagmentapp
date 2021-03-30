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
        SpringApplication.run(TicketBookManagmentAppApplication.class, args);
    }

}
