package com.pasha.PokemonThymeleaf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pokemons")
public class Pokemon {
    @Id
    @SequenceGenerator(
            name = "pokemon_id_sequence",
            sequenceName = "pokemon_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pokemon_id_sequence")
    private Long id;
    private String name;
    private String photo;
    private String ability;
    private String[] types;
    private String category;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne()
    @JoinColumn(name = "trainer_id", nullable = true)
    private Trainer trainer;
}
