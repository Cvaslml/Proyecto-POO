package modelo;
import java.util.Arrays;

public class SalaCine {
    private boolean[] asientos;
    private double[] precios;
    private String nombrePelicula;

    public SalaCine(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
        asientos = new boolean[100];
        Arrays.fill(asientos, false);
        precios = new double[100];
        Arrays.fill(precios, 10000);
    }


    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public boolean[] getAsientos() {
        return asientos;
    }

    public void reservarAsiento(int numeroAsiento) {
        asientos[numeroAsiento] = true;
    }

    public void liberarAsiento(int numeroAsiento) {
        asientos[numeroAsiento] = false;
    }

    public boolean isAsientoReservado(int numeroAsiento) {
        return asientos[numeroAsiento];
    }

    public double getPrecioAsiento(int numeroAsiento) {
        return precios[numeroAsiento];
    }

}