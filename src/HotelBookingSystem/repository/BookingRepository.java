package HotelBookingSystem.repository;

import HotelBookingSystem.Enum.BookingStatus;
import HotelBookingSystem.domain.Booking;
import HotelBookingSystem.domain.DateRange;

import java.util.HashMap;
import java.util.UUID;

public class BookingRepository {

    HashMap<UUID, Booking> bookingMap = new HashMap<>();


    public void save(Booking booking){
        bookingMap.put(booking.getId(), booking);
    }


    public int findHeldBookingsCount(UUID hotelID , UUID roomTypeId, Long date){

        return bookingMap.values().stream()
                .filter(curr->
                        curr.getHotelId().equals(hotelID)
                        && curr.getRoomTypeId().equals(roomTypeId)
                        && curr.getBookingStatus().equals(BookingStatus.HELD)
                        && (curr.getCheckInDate()<=date && curr.getCheckOutDate()>=date)
                ).toList().size();
    }

    public int findConfirmedBookingCount(UUID hotelID , UUID roomTypeId, Long date){

        return bookingMap.values().stream()
                .filter(curr->
                        curr.getHotelId().equals(hotelID)
                                && curr.getRoomTypeId().equals(roomTypeId)
                                && curr.getBookingStatus().equals(BookingStatus.CONFIRM)
                                && (curr.getCheckInDate()<=date && curr.getCheckOutDate()>=date)
                ).toList().size();
    }


    public int findCheckedInBookingCount(UUID hotelID , UUID roomTypeId, Long date){

        return bookingMap.values().stream()
                .filter(curr->
                        curr.getHotelId().equals(hotelID)
                                && curr.getRoomTypeId().equals(roomTypeId)
                                && curr.getBookingStatus().equals(BookingStatus.CHECKED_IN)
                                && (curr.getCheckInDate()<=date && curr.getCheckOutDate()>=date)
                ).toList().size();
    }
}
