package com.evarkdasim.evarkadasim_api.controller.listing;

import com.evarkdasim.evarkadasim_api.dto.request.listing.CreateListingRequest;
import com.evarkdasim.evarkadasim_api.dto.response.listing.CreateListingResponse;
import com.evarkdasim.evarkadasim_api.dto.response.listing.MyListingResponse;
import com.evarkdasim.evarkadasim_api.entity.User;
import com.evarkdasim.evarkadasim_api.service.listing.ListingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Page<MyListingResponse>> getAllMyListing(@AuthenticationPrincipal User user,
                                                                   @RequestParam(defaultValue = "0") @Min(0) int page) {
        Page<MyListingResponse> response = listingService.getAllMyListing(user, page);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<CreateListingResponse> create(@Valid @RequestBody CreateListingRequest createListingRequest, @AuthenticationPrincipal User user) {
        CreateListingResponse response = listingService.create(createListingRequest, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
