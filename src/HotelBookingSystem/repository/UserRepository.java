package HotelBookingSystem.repository;

import HotelBookingSystem.domain.User;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

public class UserRepository {

    HashMap<UUID, User> userMap = new HashMap<>();


    public Optional<User> findUserById(UUID id){
        return Optional.ofNullable(userMap.get(id));
    }
}
