package HotelBookingSystem.controller;

import HotelBookingSystem.Dto.RoomTypeAvailability;
import HotelBookingSystem.domain.DateRange;
import HotelBookingSystem.domain.Hotel;
import HotelBookingSystem.service.SearchService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService hs){
        this.searchService = hs;
    }

    public List<Hotel> getAllHotels(String city,String country){
        return searchService.getAllHotels(city , country);
    }

    public List<RoomTypeAvailability> getHotelDetailsById(UUID id, DateRange dateRange){
        return searchService.getHotelDetailsById(id, dateRange);
    }
}
