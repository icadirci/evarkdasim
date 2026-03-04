package com.evarkdasim.evarkadasim_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cities",
        indexes = {
                @Index(name = "idx_city_name", columnList = "name") // Kolon adını name yaparsan burayı da güncelle
        }
)
@Getter
@Setter
@NoArgsConstructor // Parametresiz constructor şarttır (JPA için)
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "name")
    private String name;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<District> districts = new ArrayList<>();
}