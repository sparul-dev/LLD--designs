package HotelBookingSystem.domain.state;

import HotelBookingSystem.Enum.BookingStatus;
import HotelBookingSystem.domain.Booking;

public class CancelState implements  BookingState{

    @Override
    public Booking hold(Booking b) {
       throw new IllegalStateException("booking is cancelled");
    }

    @Override
    public Booking confirm(Booking b) {
        throw new IllegalStateException("booking is cancelled");
    }

    @Override
    public Booking checkIn(Booking b) {
        throw new IllegalStateException("booking is cancelled");
    }

    @Override
    public Booking checkout(Booking b) {
        throw new IllegalStateException("booking is cancelled");
    }

    @Override
    public Booking cancelBooking(Booking b) {
        throw new IllegalStateException("booking is cancelled");
    }

    @Override
    public BookingStatus getState(Booking b) {
        throw new IllegalStateException("booking is cancelled");
    }
}
