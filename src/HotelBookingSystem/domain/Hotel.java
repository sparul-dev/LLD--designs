package HotelBookingSystem.domain;

import HotelBookingSystem.Enum.Rating;

import java.util.UUID;


public class Hotel {

    private UUID id;
    private String name;
    private Location location;
    private Rating rating;

    public Hotel( String mame, Rating rating) {
        this.id = UUID.randomUUID();
        this.name = mame;
        this.rating = rating;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String mame) {
        this.name = mame;
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
