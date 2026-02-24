package HotelBookingSystem.domain;

import java.util.Date;
import java.util.UUID;

public class Pricing {

    private UUID Id;
    private UUID roomTypeId;
    private double pricePerNight;
    private UUID seasonId;


    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public UUID getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(UUID roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public UUID getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(UUID seasonId) {
        this.seasonId = seasonId;
    }
}


