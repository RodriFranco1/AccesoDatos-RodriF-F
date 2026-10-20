package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Estadisticas {

    private final List<Pokemon> pokemon;

    public Estadisticas(List<Pokemon> pokemon) {
        this.pokemon = List.copyOf(pokemon);
    }

    public int totalPokemon() {
        return pokemon.size();
    }

    public double nivelMedio() {
        return pokemon.stream().mapToInt(Pokemon::getNivel).average().orElse(0);
    }

    public double psMedios() {
        return pokemon.stream().mapToInt(Pokemon::getPs).average().orElse(0);
    }

    public Optional<Pokemon> pokemonMayorNivel() {
        return pokemon.stream().max(Comparator.comparingInt(Pokemon::getNivel));
    }

    public Optional<Pokemon> pokemonMayorPs() {
        return pokemon.stream().max(Comparator.comparingInt(Pokemon::getPs));
    }

    public Map<String, Long> contarPorTipo() {
        return pokemon.stream()
                .collect(Collectors.groupingBy(Pokemon::getTipo, TreeMap::new, Collectors.counting()));
    }

    public Map<String, List<String>> nombresPorTipo() {
        return pokemon.stream()
                .collect(Collectors.groupingBy(Pokemon::getTipo, TreeMap::new,
                        Collectors.mapping(Pokemon::getNombre, Collectors.toList())));
    }
}