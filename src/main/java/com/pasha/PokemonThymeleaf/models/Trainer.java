package com.pasha.PokemonThymeleaf.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trainers")
public class Trainer {
    @Id
    @SequenceGenerator(
            name = "trainer_id_sequence",
            sequenceName = "trainer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trainer_id_sequence"
    )
    private Long id;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String address;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.REMOVE)
    private Set<Pokemon> pokemons = new HashSet<>();
}
