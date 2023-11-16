package com.pasha.PokemonThymeleaf.controllers;

import com.pasha.PokemonThymeleaf.dto.PokemonDto;
import com.pasha.PokemonThymeleaf.models.Pokemon;
import com.pasha.PokemonThymeleaf.services.PokemonService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class PokemonController {
    private final PokemonService pokemonService;

    PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemons")
    public String listPokemons(Model model){
        List<PokemonDto> pokemons = pokemonService.findAllPokemons();
        model.addAttribute("pokemons", pokemons);
        return "pokemons-list";
    }

    @GetMapping("/pokemons/search")
    public String searchPokemons(@RequestParam(value = "query") String query, Model model){
        List<PokemonDto> pokemons = pokemonService.searchPokemons(query);
        model.addAttribute("pokemons", pokemons);
        return "pokemons-list";
    }

    @GetMapping("/pokemons/new")
    public String newPokemon(Model model){
        Pokemon pokemon = new Pokemon();
        model.addAttribute("pokemon", pokemon);
        return "pokemons-create";
    }

    @GetMapping("/pokemons/{id}")
    public String pokemonDetail(@PathVariable("id") Long id, Model model){
        PokemonDto pokemonDto = pokemonService.findPokemonById(id);
        model.addAttribute("pokemon", pokemonDto);
        return "pokemons-detail";
    }

    @PostMapping("/pokemons/new")
    public String savePokemon(
            @Valid @ModelAttribute("pokemon") PokemonDto pokemonDto,
            BindingResult result,
            Model model){
        if(result.hasErrors()){
            model.addAttribute("pokemon", pokemonDto);
            return "pokemons-create";
        }
        pokemonService.savePokemon(pokemonDto);
        return "redirect:/pokemons";
    }

    @GetMapping("/pokemons/{id}/edit")
    public String editPokemonForm(@PathVariable("id") Long id, Model model){
        PokemonDto pokemon = pokemonService.findPokemonById(id);
        model.addAttribute("pokemon",pokemon);
        return "pokemons-edit";
    }

    @PostMapping("/pokemons/{id}/edit")
    public String updatePokemon(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("pokemon") PokemonDto pokemon,
            BindingResult result
    ){
        if(result.hasErrors()){
            return "pokemons-edit";
        }
        pokemon.setId(id);
        pokemonService.updatePokemon(pokemon);
        return "redirect:/pokemons";
    }

    @DeleteMapping("/pokemons/{id}/delete")
    ResponseEntity<?> deletePokemon(@PathVariable("id") Long id){
        pokemonService.deletePokemonById(id);
        return ResponseEntity.noContent().build();
    }
}
