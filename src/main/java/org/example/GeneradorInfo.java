package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GeneradorInfo {

    public void generar(Estadisticas est, String ruta) throws IOException {
        String igual = "=".repeat(25);
        String guion = "-".repeat(25);
        StringBuilder sb = new StringBuilder();

        sb.append(igual).append("\n");
        sb.append(" INFORME DE POKÉMON\n");
        sb.append(igual).append("\n");
        sb.append("Total de Pokémon: ").append(est.totalPokemon()).append("\n");
        sb.append(String.format(Locale.US, "Nivel medio: %.2f%n", est.nivelMedio()));
        sb.append(String.format(Locale.US, "PS medios: %.2f%n", est.psMedios()));

        sb.append("Pokémon con mayor nivel:\n");
        est.pokemonMayorNivel().ifPresent(p ->
                sb.append(p.getNombre()).append(" (Nivel ").append(p.getNivel()).append(")\n"));

        sb.append("Pokémon con más PS:\n");
        est.pokemonMayorPs().ifPresent(p ->
                sb.append(p.getNombre()).append(" (PS ").append(p.getPs()).append(")\n"));

        sb.append(guion).append("\n");
        sb.append("POKÉMON POR TIPO\n");
        sb.append(guion).append("\n");

        Map<String, Long> conteos = est.contarPorTipo();
        Map<String, List<String>> nombres = est.nombresPorTipo();

        for (Map.Entry<String, Long> entrada : conteos.entrySet()) {
            String tipo = entrada.getKey();
            sb.append(tipo).append(": ").append(entrada.getValue()).append("\n");
            for (String nombre : nombres.get(tipo)) {
                sb.append(nombre).append("\n");
            }
            sb.append("\n");
        }

        Files.writeString(Path.of(ruta), sb.toString(), StandardCharsets.UTF_8);
    }
}