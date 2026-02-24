package HotelBookingSystem;

import HotelBookingSystem.Dto.RoomTypeAvailability;
import HotelBookingSystem.Enum.BedType;
import HotelBookingSystem.Enum.BookingStatus;
import HotelBookingSystem.Enum.PaymentStatus;
import HotelBookingSystem.Enum.Rating;
import HotelBookingSystem.controller.SearchController;
import HotelBookingSystem.domain.Booking;
import HotelBookingSystem.domain.DateRange;
import HotelBookingSystem.domain.Hotel;
import HotelBookingSystem.domain.RoomType;
import HotelBookingSystem.repository.BookingRepository;
import HotelBookingSystem.repository.HotelRepository;
import HotelBookingSystem.repository.RoomTypeRepository;
import HotelBookingSystem.service.InventoryService;
import HotelBookingSystem.service.SearchService;

import java.util.List;
import java.util.UUID;


public class Main {


    public static void main(String[]args){

        Hotel hotel1 = new Hotel("Taj", Rating.FIVE);
        HotelRepository hotelRepository = new HotelRepository();
        RoomTypeRepository roomTypeRepository = new RoomTypeRepository();
        BookingRepository bookingRepository = new BookingRepository();

        RoomType roomType1 = new RoomType("deluxe", 5, BedType.TWIN, 1000.0 , true, hotel1.getId(), 2);
        RoomType roomType2 = new RoomType("deluxe-prime", 5, BedType.QUEEN, 2000.0 , true, hotel1.getId(), 2);
        RoomType roomType3 = new RoomType("Suite", 1, BedType.KING, 4000.0 , true, hotel1.getId(), 4);



        Booking booking1 = new Booking(hotel1.getId(), roomType3.getId(), UUID.randomUUID(),  4000, 4000, 1772668800000L ,
                1772409600000L, BookingStatus.CONFIRM, PaymentStatus.PENDING);

        bookingRepository.save(booking1);

        roomTypeRepository.save(roomType1);
        roomTypeRepository.save(roomType2);
        roomTypeRepository.save(roomType3);
        InventoryService inventoryService= new InventoryService(roomTypeRepository, bookingRepository);
        hotelRepository.save(hotel1);
        SearchService searchService = new SearchService(hotelRepository, inventoryService);
        SearchController searchController = new SearchController(searchService);
        List<RoomTypeAvailability> list = searchController.getHotelDetailsById(hotel1.getId(), new DateRange(1772323200000L , 1772668800000L));


        System.out.println(list.stream().map(curr -> curr.getName()).toList());
    }
}
