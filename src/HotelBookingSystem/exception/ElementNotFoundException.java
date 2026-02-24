package HotelBookingSystem.exception;

public class ElementNotFoundException extends RuntimeException {



    public ElementNotFoundException(){
        super("Element not found!!");
    }

    public  ElementNotFoundException(String msg){
        super(msg);
    }



}
