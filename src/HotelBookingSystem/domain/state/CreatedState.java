package HotelBookingSystem.domain.state;

import HotelBookingSystem.Enum.BookingStatus;
import HotelBookingSystem.domain.Booking;

public class CreatedState implements BookingState{
    @Override
    public Booking hold(Booking booking) {
        booking.setBookingStatus(BookingStatus.HELD);
        booking.setBookingState(new HoldState());
        return booking;
    }

    @Override
    public Booking confirm(Booking b) {
        throw new IllegalStateException();
    }

    @Override
    public Booking checkIn(Booking b) {
        throw new IllegalStateException("Cant checking before confirming");
    }

    @Override
    public Booking checkout(Booking b) {
        throw new IllegalStateException("Cant Checkout before Checkin");
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
