package com.pasha.PokemonThymeleaf.services.impl;

import com.pasha.PokemonThymeleaf.dto.PokemonDto;
import com.pasha.PokemonThymeleaf.models.Pokemon;
import com.pasha.PokemonThymeleaf.models.Trainer;
import com.pasha.PokemonThymeleaf.repositories.PokemonRepository;
import com.pasha.PokemonThymeleaf.repositories.TrainerRepository;
import com.pasha.PokemonThymeleaf.services.PokemonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements PokemonService {
    private final PokemonRepository pokemonRepository;
    private final TrainerRepository trainerRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository, TrainerRepository trainerRepository) {
        this.pokemonRepository = pokemonRepository;
        this.trainerRepository = trainerRepository;
    }

    @Override
    public List<PokemonDto> findAllPokemons() {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        return pokemons.stream().map(this::mapToPokemonDto).collect(Collectors.toList());
    }

    @Override
    public Pokemon savePokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = mapToPokemon(pokemonDto);
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Pokemon savePokemon(Long trainerId, PokemonDto pokemonDto) {
        Trainer trainer = trainerRepository.findById(trainerId).get();
        Pokemon pokemon = mapToPokemon(pokemonDto);
        pokemon.setTrainer(trainer);
        return pokemonRepository.save(pokemon);
    }

    @Override
    public PokemonDto findPokemonById(Long id) {
        Pokemon pokemon = pokemonRepository.findById(id).get();
        return mapToPokemonDto(pokemon);
    }

    @Override
    public void updatePokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = mapToPokemon(pokemonDto);
        pokemonRepository.save(pokemon);
    }

    @Override
    public void deletePokemonById(Long id) {
        pokemonRepository.deleteById(id);
    }

    @Override
    public List<PokemonDto> searchPokemons(String query) {
        List<Pokemon> pokemons = pokemonRepository.searchPokemons(query);
        return pokemons.stream().map(this::mapToPokemonDto).collect(Collectors.toList());
    }

    private Pokemon mapToPokemon(PokemonDto pokemonDto){
        return Pokemon.builder()
                .id(pokemonDto.getId())
                .name(pokemonDto.getName())
                .photo(pokemonDto.getPhoto())
                .ability(pokemonDto.getAbility())
                .types(pokemonDto.getTypes())
                .category(pokemonDto.getCategory())
                .createdAt(pokemonDto.getCreatedAt())
                .updatedAt(pokemonDto.getUpdatedAt())
                .build();
    }
    private PokemonDto mapToPokemonDto(Pokemon pokemon){
        return PokemonDto.builder()
                .id(pokemon.getId())
                .name(pokemon.getName())
                .photo(pokemon.getPhoto())
                .ability(pokemon.getAbility())
                .types(pokemon.getTypes())
                .category(pokemon.getCategory())
                .createdAt(pokemon.getCreatedAt())
                .updatedAt(pokemon.getUpdatedAt())
                .build();
    }
}
