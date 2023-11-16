package com.pasha.PokemonThymeleaf.repositories;

import com.pasha.PokemonThymeleaf.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    @Query(value = "SELECT * FROM pokemons p WHERE p.name ILIKE CONCAT('%',:query,'%')", nativeQuery = true)
    List<Pokemon> searchPokemons(String query);
}
