package com.pasha.PokemonThymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainerDto {
    private Long id;
    private String name;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
