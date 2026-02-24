package HotelBookingSystem.repository;

import HotelBookingSystem.domain.Hotel;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class HotelRepository {

    HashMap<UUID, Hotel> hotelMap ;

    public HotelRepository(){
        hotelMap  = new HashMap<>();
    }


    public void save(Hotel hotel){
        hotelMap.put(hotel.getId(), hotel);
    }

    public List<Hotel> findAll(String city, String country){
        return hotelMap.values()
                .stream()
                .filter(curr ->
                        curr.getLocation().getCountry().equals(country) &&
                                (city==null || curr.getLocation().getCountry().equals(city))
                ).toList();
    }

    public Optional<Hotel> findById(UUID id){
        return  Optional.ofNullable(hotelMap.get(id));
    }
}
