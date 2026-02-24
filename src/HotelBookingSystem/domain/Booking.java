package HotelBookingSystem.domain;

import HotelBookingSystem.Enum.BookingStatus;
import HotelBookingSystem.Enum.PaymentStatus;

import java.util.Date;
import java.util.UUID;

public class Booking {

    private UUID id;
    private UUID hotelId;
    private UUID roomTypeId;
    private UUID roomId;
    private double totalAmount;
    private double pricePerNight;
    private Long checkInDate;
    private Long checkOutDate;
    private BookingStatus bookingStatus;
    private PaymentStatus paymentStatus;


    public Booking(UUID hotelId, UUID roomTypeId, UUID roomId, double totalAmount, double pricePerNight, Long checkOutDate, Long checkInDate, BookingStatus bookingStatus, PaymentStatus paymentStatus) {
        this.hotelId = hotelId;
        this.roomTypeId = roomTypeId;
        this.roomId = roomId;
        this.totalAmount = totalAmount;
        this.pricePerNight = pricePerNight;
        this.checkOutDate = checkOutDate;
        this.checkInDate = checkInDate;
        this.bookingStatus = bookingStatus;
        this.paymentStatus = paymentStatus;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Long getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Long checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Long getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Long checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
