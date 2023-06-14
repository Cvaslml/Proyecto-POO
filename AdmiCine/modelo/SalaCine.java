package modelo;

import java.util.ArrayList;
import java.util.List;

public class SalaCine {
    private List<Sala> salas;

    public SalaCine() {
        salas = new ArrayList<>();
    }

    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    public List<Sala> getSalas() {
        return salas;
    }
}
