package com.pasha.PokemonThymeleaf.repositories;

import com.pasha.PokemonThymeleaf.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
