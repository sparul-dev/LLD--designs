package HotelBookingSystem.service;

import HotelBookingSystem.Dto.BookingDto;
import HotelBookingSystem.Enum.BookingStatus;
import HotelBookingSystem.Enum.PaymentStatus;
import HotelBookingSystem.domain.Booking;
import HotelBookingSystem.domain.RoomType;
import HotelBookingSystem.domain.User;
import HotelBookingSystem.domain.state.CreatedState;
import HotelBookingSystem.repository.BookingRepository;
import HotelBookingSystem.repository.RoomTypeRepository;
import HotelBookingSystem.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

public class BookingService {


    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private RoomTypeRepository roomTypeRepository;

    private BookingService(BookingRepository br, UserRepository userRepository, RoomTypeRepository roomTypeRepository){
        this.bookingRepository = br;
        this.userRepository = userRepository;
        this.roomTypeRepository= roomTypeRepository;
    }


    public void createBooking(BookingDto bookingDto){

        Optional<User> userOpt = userRepository.findUserById(bookingDto.getUserId());

        if(userOpt.isEmpty()){
            throw new RuntimeException("User does not exist");
        }

        Optional<RoomType> roomTypeOp = roomTypeRepository.findById(bookingDto.getRoomTypeId());

        if(roomTypeOp.isEmpty()){
            throw new RuntimeException("Room Type does not exist");
        }



        Booking booking = new Booking(
            bookingDto.getHotelId(),
            bookingDto.getRoomTypeId(),
            UUID.randomUUID(),
            bookingDto.getTotalAmount(),
            bookingDto.getAvgPricePerNight(),
            bookingDto.getCheckOutDate(),
            bookingDto.getCheckInDate(),
            BookingStatus.CREATED,
            PaymentStatus.PENDING
        );

        bookingRepository.save(booking);

    }
}
