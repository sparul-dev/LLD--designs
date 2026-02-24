package HotelBookingSystem.domain;

import HotelBookingSystem.Enum.BedType;

import java.util.UUID;

public class RoomType {

    private UUID id;
    private String name;
    private Long totalCount;
    private BedType bedType;
    private double basePrice;


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

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
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

    //    public Pricing getPricePerNight() {
//        return pricePerNight;
//    }
//
//    public void setPricePerNight(Pricing pricePerNight) {
//        this.pricePerNight = pricePerNight;
//    }
}
