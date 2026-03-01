package HotelBookingSystem.domain.state;

import HotelBookingSystem.Enum.BookingStatus;
import HotelBookingSystem.domain.Booking;

public class HoldState implements BookingState{

    @Override
    public Booking hold(Booking b) {
        throw new IllegalStateException("Already in hold state!!");
    }

    @Override
    public Booking confirm(Booking b) {
        b.setBookingStatus(BookingStatus.CONFIRM);
        b.setBookingState(new ConfirmState());
        return b;
    }

    @Override
    public Booking checkIn(Booking b) {
        throw new IllegalStateException("Cant checkin currently in hold state!");
    }

    @Override
    public Booking checkout(Booking b) {
        throw new IllegalStateException("Cant Checkout currently in hold state!");
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
