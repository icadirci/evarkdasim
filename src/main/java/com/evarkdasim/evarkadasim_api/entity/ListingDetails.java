package com.evarkdasim.evarkadasim_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", unique = true)
    private Listing listing;

    @Column(columnDefinition = "TEXT") // @Lob yerine bu daha güvenlidir
    private String description;


}
