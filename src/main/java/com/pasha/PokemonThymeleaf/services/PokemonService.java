package com.pasha.PokemonThymeleaf.services;

import com.pasha.PokemonThymeleaf.dto.PokemonDto;
import com.pasha.PokemonThymeleaf.models.Pokemon;

import java.util.List;

public interface PokemonService {
    List<PokemonDto> findAllPokemons();
    Pokemon savePokemon(PokemonDto pokemon);

    Pokemon savePokemon(Long trainerId, PokemonDto pokemon);
    PokemonDto findPokemonById(Long id);

    void updatePokemon(PokemonDto pokemon);

    void deletePokemonById(Long id);

    List<PokemonDto> searchPokemons(String query);
}
