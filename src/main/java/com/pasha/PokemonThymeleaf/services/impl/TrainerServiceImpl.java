package com.pasha.PokemonThymeleaf.services.impl;

import com.pasha.PokemonThymeleaf.dto.TrainerDto;
import com.pasha.PokemonThymeleaf.models.Trainer;
import com.pasha.PokemonThymeleaf.repositories.TrainerRepository;
import com.pasha.PokemonThymeleaf.services.TrainerService;

import java.util.List;
import java.util.stream.Collectors;

public class TrainerServiceImpl implements TrainerService {
    private final TrainerRepository trainerRepository;

    TrainerServiceImpl(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }
    @Override
    public List<TrainerDto> findAllTrainers() {
        List<Trainer> trainers = trainerRepository.findAll();
        return trainers.stream().map(this::mapToTrainerDto).collect(Collectors.toList());
    }

    @Override
    public Trainer saveTrainer(TrainerDto trainerDto) {
        Trainer trainer = mapToTrainer(trainerDto);
        return trainerRepository.save(trainer);
    }

    private TrainerDto mapToTrainerDto(Trainer trainer){
        return TrainerDto.builder()
                .id(trainer.getId())
                .name(trainer.getName())
                .address(trainer.getAddress())
                .createdAt(trainer.getCreatedAt())
                .updatedAt(trainer.getUpdatedAt())
                .build();
    }

    private Trainer mapToTrainer(TrainerDto trainerDto){
        return Trainer.builder()
                .id(trainerDto.getId())
                .name(trainerDto.getName())
                .address(trainerDto.getAddress())
                .createdAt(trainerDto.getCreatedAt())
                .updatedAt(trainerDto.getUpdatedAt())
                .build();
    }
}
