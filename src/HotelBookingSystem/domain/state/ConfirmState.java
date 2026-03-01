package HotelBookingSystem.domain.state;

import HotelBookingSystem.Enum.BookingStatus;
import HotelBookingSystem.domain.Booking;

public class ConfirmState implements BookingState{

    @Override
    public Booking hold(Booking b) {
        throw new IllegalStateException("Booking is already confirmed");
    }

    @Override
    public Booking confirm(Booking b) {
        throw new IllegalStateException("Booking is already confirmed");
    }

    @Override
    public Booking checkIn(Booking b) {
      b.setBookingStatus(BookingStatus.CHECKED_IN);
      b.setBookingState(new ConfirmState());
      return b;
    }

    @Override
    public Booking checkout(Booking b) {
        throw new IllegalStateException("User has not checked in");
    }

    @Override
    public Booking cancelBooking(Booking b) {
        b.setBookingStatus(BookingStatus.CANCELLED);
        b.setBookingState(new CancelState());
        return b;
    }

    @Override
    public BookingStatus getState(Booking b) {
        return b.getBookingStatus();
    }
}
