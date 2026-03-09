package com.evarkdasim.evarkadasim_api.service.listing;

import com.evarkdasim.evarkadasim_api.dto.request.listing.CreateListingRequest;
import com.evarkdasim.evarkadasim_api.dto.response.listing.CreateListingResponse;
import com.evarkdasim.evarkadasim_api.dto.response.listing.MyListingResponse;
import com.evarkdasim.evarkadasim_api.entity.*;
import com.evarkdasim.evarkadasim_api.exception.BusinessException;
import com.evarkdasim.evarkadasim_api.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ListingService {
    private final ListingRepository listingRepository;
    private final CityRepository cityRepository;
    private final DistrictRepository districtRepository;
    private final NeighborhoodRepository neighborhoodsRepository;


    @Transactional(readOnly = true)
    public Page<MyListingResponse> getAllMyListing(User user, int page){
        int pageSize = 10;
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("createdAt").descending());
        Page<Listing> listingsPage = listingRepository.findAllByUserIdWithCityDistrict(user.getId(),pageable);

        if (page > listingsPage.getTotalPages() && listingsPage.getTotalPages() > 0) {
            throw new BusinessException("İstediğiniz sayfa mevcut değil. Toplam sayfa: " + listingsPage.getTotalPages());
        }
        return listingsPage
                .map(MyListingResponse::fromEntity);
    }

    @Transactional
    public CreateListingResponse create(CreateListingRequest request, User user) {
        boolean isValidLocation = listingRepository.validateLocationHierarchy(
                request.cityId(),
                request.districtId(),
                request.neighborhoodId()
        );

        if (!isValidLocation) {
            throw new BusinessException("Seçilen mahalle, ilçe veya şehir hiyerarşisi hatalı.");
        }
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
