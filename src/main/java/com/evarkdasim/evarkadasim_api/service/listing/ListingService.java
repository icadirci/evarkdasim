package com.evarkdasim.evarkadasim_api.service.listing;

import com.evarkdasim.evarkadasim_api.dto.request.listing.CreateListingRequest;
import com.evarkdasim.evarkadasim_api.dto.response.listing.CreateListingResponse;
import com.evarkdasim.evarkadasim_api.dto.response.listing.MyListingResponse;
import com.evarkdasim.evarkadasim_api.entity.*;
import com.evarkdasim.evarkadasim_api.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingService {
    private final ListingRepository listingRepository;
    private final CityRepository cityRepository;
    private final DistrictRepository districtRepository;
    private final NeighborhoodRepository neighborhoodsRepository;

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<MyListingResponse> getAllMyListing(User user){
        return listingRepository.findAllByUserIdWithCityDistrict(user.getId())
                .stream()
                .map(MyListingResponse::fromEntity)
                .toList();
    }

    public CreateListingResponse create(CreateListingRequest request, User user) {
        City city = cityRepository.getReferenceById(request.cityId());
        District district = districtRepository.getReferenceById(request.districtId());
        Neighborhood neighborhood = neighborhoodsRepository.getReferenceById(request.neighborhoodId());
        Listing listing = new Listing();
        listing.setTitle(request.title());
        listing.setPrice(request.price());
        listing.setUser(user);
        listing.setGenderPreference(request.genderPreference());
        listing.setCity(city);
        listing.setDistrict(district);
        listing.setRoomCount(request.roomCount());
        listing.setNeighborhood(neighborhood);
        ListingDetails details = new ListingDetails();
        details.setDescription(request.description());
        details.setListing(listing);
        listing.setDetails(details);
        Listing savedListing = listingRepository.save(listing);
        return CreateListingResponse.fromEntity(savedListing);
    }
}
