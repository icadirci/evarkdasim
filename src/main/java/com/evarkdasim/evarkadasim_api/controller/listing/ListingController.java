package com.evarkdasim.evarkadasim_api.controller.listing;

import com.evarkdasim.evarkadasim_api.dto.request.listing.CreateListingRequest;
import com.evarkdasim.evarkadasim_api.dto.response.listing.CreateListingResponse;
import com.evarkdasim.evarkadasim_api.entity.Listing;
import com.evarkdasim.evarkadasim_api.entity.User;
import com.evarkdasim.evarkadasim_api.service.listing.ListingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/listings")
@RequiredArgsConstructor
public class ListingController {
    private final ListingService listingService;

    @GetMapping("/my-listings")
    public ResponseEntity<List<Listing>> getAllMyListing(@AuthenticationPrincipal User user){
        return ResponseEntity.ok().body(listingService.getAllMyListing(user));
    }

    @PostMapping
    public ResponseEntity<CreateListingResponse> create(@Valid @RequestBody CreateListingRequest createListingRequest, @AuthenticationPrincipal User user) {
        CreateListingResponse response = listingService.create(createListingRequest, user);
        return ResponseEntity.ok().body(response);
    }
}
