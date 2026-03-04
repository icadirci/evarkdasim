package com.evarkdasim.evarkadasim_api.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ListingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id") // Fiziksel kolon burada oluşur!
    private Listing listing;

    @Column(columnDefinition = "TEXT") // @Lob yerine bu daha güvenlidir
    private String description;


}
