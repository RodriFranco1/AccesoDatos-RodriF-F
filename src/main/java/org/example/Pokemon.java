package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pokemon {

    private final int id;
    private final String nombre;
    private final String tipo;
    private final int nivel;
    private final int ps;

    @JsonCreator
    public Pokemon(@JsonProperty("id") int id,
                   @JsonProperty("nombre") String nombre,
                   @JsonProperty("tipo") String tipo,
                   @JsonProperty("nivel") int nivel,
                   @JsonProperty("ps") int ps) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.ps = ps;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getNivel() { return nivel; }
    public int getPs() { return ps; }
}
