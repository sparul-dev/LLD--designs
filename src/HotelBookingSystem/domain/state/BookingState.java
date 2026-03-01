package HotelBookingSystem.domain.state;

import HotelBookingSystem.Enum.BookingStatus;
import HotelBookingSystem.domain.Booking;

public interface BookingState {

   Booking hold(Booking b);
   Booking confirm(Booking b );
    Booking checkIn(Booking b );
    Booking checkout(Booking b );
    Booking cancelBooking(Booking b );
    BookingStatus getState(Booking b);
}
