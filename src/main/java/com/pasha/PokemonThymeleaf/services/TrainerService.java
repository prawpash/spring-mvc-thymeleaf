package com.pasha.PokemonThymeleaf.services;

import com.pasha.PokemonThymeleaf.dto.TrainerDto;
import com.pasha.PokemonThymeleaf.models.Trainer;

import java.util.List;

public interface TrainerService {
    List<TrainerDto> findAllTrainers();

    Trainer saveTrainer(TrainerDto trainerDto);
}
