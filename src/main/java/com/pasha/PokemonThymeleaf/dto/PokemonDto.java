package com.pasha.PokemonThymeleaf.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class PokemonDto {
    private Long id;
    @NotEmpty(message = "Pokemon name should not be empty.")
    private String name;
    @NotEmpty(message = "Photo link should not be empty.")
    private String photo;
    @NotEmpty(message = "Ability should not be empty.")
    private String ability;
    @NotEmpty(message = "Types should not be empty.")
    private String[] types;
    @NotEmpty(message = "Category should not be empty.")
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
