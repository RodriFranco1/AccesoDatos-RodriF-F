package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CargadorJson {

    public List<Pokemon> cargar(String ruta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(ruta), new TypeReference<List<Pokemon>>() {});
    }
}