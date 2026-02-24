package HotelBookingSystem.service;

import HotelBookingSystem.Dto.RoomTypeAvailability;
import HotelBookingSystem.domain.DateRange;
import HotelBookingSystem.domain.Hotel;
import HotelBookingSystem.domain.RoomType;
import HotelBookingSystem.exception.ElementNotFoundException;
import HotelBookingSystem.repository.HotelRepository;
import HotelBookingSystem.repository.RoomTypeRepository;

import java.util.*;

public class SearchService {

    private HotelRepository hotelRepository;

    private InventoryService inventoryService;

    public SearchService(HotelRepository hotelRepository , InventoryService inventoryService){
        this.hotelRepository = hotelRepository;
        this.inventoryService= inventoryService;
    }

    public List<Hotel> getAllHotels(String city, String country){
        return hotelRepository.findAll(city , country);
    }

    public List<RoomTypeAvailability> getHotelDetailsById(UUID id, DateRange dateRange){
        try{

            Optional<Hotel> hotelOp = hotelRepository.findById(id);
            if(hotelOp.isEmpty()) throw  new ElementNotFoundException("Hotel not found for id : " + id);
            Hotel hotel = hotelOp.get();

            HashMap<RoomType, Integer> availableRoomTypes = inventoryService.getAvailableRoomTypes(hotel.getId(), dateRange);

            List<RoomTypeAvailability> roomTypeAvailabilities = new ArrayList<>();

            for(RoomType roomType: availableRoomTypes.keySet()){
                RoomTypeAvailability roomTypeAvailability  = new RoomTypeAvailability(

                        roomType.getHotelId(),
                        roomType.getId(),
                        10.0,
                        roomType.getCapacity(),
                        roomType.getBedType(),
                        availableRoomTypes.get(roomType),
                        roomType.getName()

                );
                roomTypeAvailabilities.add(roomTypeAvailability);
            }


            return roomTypeAvailabilities;





        }catch (Exception e){
            e.getMessage();
            throw e;
        }
    }
}
