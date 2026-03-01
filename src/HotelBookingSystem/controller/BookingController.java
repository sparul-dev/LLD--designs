package HotelBookingSystem.controller;

import HotelBookingSystem.Dto.BookingDto;
import HotelBookingSystem.service.BookingService;

public class BookingController {


    private BookingService bookingService;

    public BookingController(BookingService bs){
        this.bookingService = bs;
    }

    public void createBooking(BookingDto bookingDto){

        bookingService.createBooking(bookingDto);


    }
}
