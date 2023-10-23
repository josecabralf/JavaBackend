package com.example.modelo_parcial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor // Lombok genera constructor con/sin argumentos
@Entity(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private long filmId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    private String releaseYear;

    @Column(name = "language_id")
    private Short languageId;

    @Column(name = "original_language_id")
    private Short originalLanguageId;

    @Column(name = "rental_duration")
    private short rentalDuration;

    @Column(name = "rental_rate")
    private double rentalRate;

    @Column(name = "length")
    private short length;

    @Column(name = "replacement_cost")
    private double replacementCost;

    @Column(name = "rating")
    private String rating;

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update")
    private Date lastUpdate;

    @OneToMany(mappedBy = "film")
    private List<Inventory> inventories;
}
