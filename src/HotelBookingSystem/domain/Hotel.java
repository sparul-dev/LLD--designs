package HotelBookingSystem.domain;

import java.util.UUID;

enum Rating{
    ONE, TWO, THREE, FOUR, FIVE
}

public class Hotel {

    private UUID id;
    private String mame;
    private Location location;
    private  Rating rating;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMame() {
        return mame;
    }

    public void setMame(String mame) {
        this.mame = mame;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
