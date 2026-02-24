package HotelBookingSystem.Dto;

import HotelBookingSystem.Enum.BedType;

import java.util.UUID;

public class RoomTypeAvailability {

    private UUID id;
    private UUID hotelId;
    private UUID roomTypeId;
    private double pricePerNight;
    private int capacity;
    private BedType bedType;
    private int totalCount;
    private String name;

    public RoomTypeAvailability( UUID hotelId, UUID roomTypeId, double pricePerNight, int capacity, BedType bedType, int totalCount, String name) {
        this.id = UUID.randomUUID();
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.bedType = bedType;
        this.totalCount = totalCount;
        this.name= name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getHotelId() {
        return hotelId;
    }

    public void setHotelId(UUID hotelId) {
        this.hotelId = hotelId;
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

    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
