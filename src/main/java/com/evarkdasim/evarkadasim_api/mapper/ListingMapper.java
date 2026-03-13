package com.evarkdasim.evarkadasim_api.mapper;

import com.evarkdasim.evarkadasim_api.dto.response.listing.ListingFilterResponse;
import com.evarkdasim.evarkadasim_api.entity.Listing;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ListingMapper {

    @Mapping(target = "cityName", source = "city.name")
    @Mapping(target = "districtName", source = "district.name")
    ListingFilterResponse toFilterResponse(Listing listing);

    List<ListingFilterResponse> toFilterResponseList(List<Listing> listings);
}