package com.decipher.book.ticket.app.ticketbookmanagmentapp.jsonClass;


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
