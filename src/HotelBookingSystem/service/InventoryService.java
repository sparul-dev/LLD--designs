package HotelBookingSystem.service;

import HotelBookingSystem.domain.DateRange;
import HotelBookingSystem.domain.RoomType;
import HotelBookingSystem.exception.ElementNotFoundException;
import HotelBookingSystem.repository.BookingRepository;
import HotelBookingSystem.repository.RoomTypeRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class InventoryService {

    private RoomTypeRepository roomTypeRepository;
    private BookingRepository bookingRepository;

    public InventoryService(RoomTypeRepository rtm, BookingRepository bookingRepository){
        this.roomTypeRepository = rtm;
        this.bookingRepository= bookingRepository;
    }

    public int getHeldBookingsCount(UUID hotelID , UUID roomTypeId,  long date){
       return bookingRepository.findHeldBookingsCount(hotelID, roomTypeId, date);
    }

    public int getConfirmBookingCount(UUID hotelID , UUID roomTypeId,  long date){
        return bookingRepository.findConfirmedBookingCount(hotelID, roomTypeId, date);
    }

    public int getCheckedInBookingCount(UUID hotelID , UUID roomTypeId,  long date){
        return bookingRepository.findCheckedInBookingCount(hotelID, roomTypeId, date);
    }



    public  HashMap<RoomType, Integer> getAvailableRoomTypes(UUID hotelId, DateRange dateRange){

        List<RoomType> roomTypes= roomTypeRepository.findByHotelId(hotelId);
        if(roomTypes.isEmpty()) throw  new ElementNotFoundException("no room type found");

        HashMap<RoomType, Integer> availableRoomTypes = new HashMap<>();

        for(RoomType currRoomType : roomTypes){

            int totalCount = currRoomType.getTotalCount();
            if(totalCount == 0) continue;
            int minAvailable = 1;

            for(long date = dateRange.getCheckInDate() ; date<= dateRange.getCheckOutDate() ; date+=86400000){ // adding one day

                int heldBookingCount = getHeldBookingsCount(hotelId, currRoomType.getId() , date);
                int confirmBookingCount = getConfirmBookingCount(hotelId, currRoomType.getId(), date);
                int checkedInBookingCount = getConfirmBookingCount(hotelId, currRoomType.getId(), date);

                int availableCount = totalCount - heldBookingCount- confirmBookingCount- checkedInBookingCount;

                minAvailable = Math.min(availableCount, minAvailable);
                if(minAvailable<=0) break;
            }

            if(minAvailable>0) availableRoomTypes.put(currRoomType, minAvailable);


        }

        return availableRoomTypes;



    }
}
