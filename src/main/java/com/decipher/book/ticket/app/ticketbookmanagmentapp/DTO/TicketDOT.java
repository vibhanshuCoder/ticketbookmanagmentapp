package com.decipher.book.ticket.app.ticketbookmanagmentapp.DTO;

import com.decipher.book.ticket.app.ticketbookmanagmentapp.entities.Ticket;

public class TicketDOT {

   public TicketDOT() {
    }

    private String passengerName;
    private String sourceStation;
    private String destStation;



    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public String getDestStation() {
        return destStation;
    }

    public void setDestStation(String destStation) {
        this.destStation = destStation;
    }

    @Override
    public String toString() {
        return "TicketDOT{" +
                "passengerName='" + passengerName + '\'' +
                ", sourceStation='" + sourceStation + '\'' +
                ", destStation='" + destStation + '\'' +
                '}';
    }
}
