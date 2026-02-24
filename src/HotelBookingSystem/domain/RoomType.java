package HotelBookingSystem.domain;

import HotelBookingSystem.Enum.BedType;

import java.util.UUID;

public class RoomType {

    private UUID id;
    private String name;
    private int totalCount;
    private BedType bedType;
    private double basePrice;
    private  boolean isActive;
    private UUID hotelId;
    private int capacity;


    public RoomType( String name, int totalCount, BedType bedType, double basePrice, boolean isActive, UUID hotelId, int capacity) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.totalCount = totalCount;
        this.bedType = bedType;
        this.basePrice = basePrice;
        this.isActive = isActive;
        this.hotelId = hotelId;
        this.capacity = capacity;
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

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UUID getHotelId() {
        return hotelId;
    }

    public void setHotelId(UUID hotelId) {
        this.hotelId = hotelId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }





    //    public Pricing getPricePerNight() {
//        return pricePerNight;
//    }
//
//    public void setPricePerNight(Pricing pricePerNight) {
//        this.pricePerNight = pricePerNight;
//    }
}
