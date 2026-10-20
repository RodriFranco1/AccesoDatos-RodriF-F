package org.example;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String rutaJson = "pokemon.json";
        String rutaInforme = "informe_pokemon.txt";

        try {
            List<Pokemon> lista = new CargadorJson().cargar(rutaJson);
            System.out.println("Pokémon cargados: " + lista.size());

            Estadisticas estadisticas = new Estadisticas(lista);
            new GeneradorInfo().generar(estadisticas, rutaInforme);

            System.out.println("Informe generado en: " + rutaInforme);
        } catch (IOException e) {
            System.err.println("Error al procesar los datos: " + e.getMessage());
        }
    }
}