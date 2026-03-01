package HotelBookingSystem.repository;

import HotelBookingSystem.domain.RoomType;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RoomTypeRepository {

    HashMap <UUID, RoomType> hm = new HashMap<>();


    public void save(RoomType roomType){
        hm.put(roomType.getId(), roomType);
    }

    public List<RoomType> findByHotelId(UUID id){

        return hm.values().stream().filter(curr -> curr.getHotelId().equals(id)).toList();

    }


    public Optional<RoomType> findById(UUID id){
        return Optional.ofNullable(hm.get(id));
    }

}
