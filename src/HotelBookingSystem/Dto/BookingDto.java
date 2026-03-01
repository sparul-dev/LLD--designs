package HotelBookingSystem.Dto;

import java.util.UUID;

public class BookingDto {

    private UUID hotelId;
    private UUID roomTypeId;
    private  UUID userId;
    private Long checkInDate;
    private Long checkOutDate;
    private Double totalAmount;
    private Double avgPricePerNight;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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

    public Long getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Long checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Long checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Double getAvgPricePerNight() {
        return avgPricePerNight;
    }

    public void setAvgPricePerNight(Double avgPricePerNight) {
        this.avgPricePerNight = avgPricePerNight;
    }
}
