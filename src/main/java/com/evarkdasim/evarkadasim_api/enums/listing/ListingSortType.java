package com.evarkdasim.evarkadasim_api.enums.listing;

import lombok.Getter;
import org.springframework.data.domain.Sort;

@Getter
public enum ListingSortType {
    NEWEST("createdAt", Sort.Direction.DESC),
    OLDEST("createdAt", Sort.Direction.ASC),
    PRICE_ASC("price", Sort.Direction.ASC),
    PRICE_DESC("price", Sort.Direction.DESC);

    private final String fieldName;
    private final Sort.Direction direction;

    ListingSortType(String fieldName, Sort.Direction direction) {
        this.fieldName = fieldName;
        this.direction = direction;
    }
}