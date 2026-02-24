package HotelBookingSystem.domain;

public class DateRange {

    private long checkInDate;
    private long checkOutDate;

    public DateRange(long in , long out){
        this.checkInDate = in;
        this.checkOutDate = out;

    }

    public long getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(long checkInDate) {
        this.checkInDate = checkInDate;
    }

    public long getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(long checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
