package com.decipher.book.ticket.app.ticketbookmanagmentapp.jasonClass;

import com.decipher.book.ticket.app.ticketbookmanagmentapp.dao.TicketBookingDao;
import com.decipher.book.ticket.app.ticketbookmanagmentapp.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;


public class JsonResponse
{

    private String favoPlace;

    public JsonResponse() {
    }

    public JsonResponse(String favoPlace) {
        this.favoPlace = favoPlace;
    }

    public String getFavPlace() {
        return favoPlace;
    }

    public void setFavPlace(String favoPlace) {
        this.favoPlace = favoPlace;
    }
}
