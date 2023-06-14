package modelo;

public class Sala {
    private String nombre;
    private Pelicula pelicula;
    private boolean[] asientosComunes;
    private boolean[] asientosPreferenciales;

    public Sala(String nombre, Pelicula pelicula) {
        this.nombre = nombre;
        this.pelicula = pelicula;
        this.asientosComunes = new boolean[80];
        this.asientosPreferenciales = new boolean[20];
    }

    public String getNombre() {
        return nombre;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public boolean[] getAsientosComunes() {
        return asientosComunes;
    }

    public boolean[] getAsientosPreferenciales() {
        return asientosPreferenciales;
    }

    public void reservarAsientoComun(int numeroAsiento) {
        asientosComunes[numeroAsiento] = true;
    }

    public void liberarAsientoComun(int numeroAsiento) {
        asientosComunes[numeroAsiento] = false;
    }

    public void reservarAsientoPreferencial(int numeroAsiento) {
        asientosPreferenciales[numeroAsiento] = true;
    }

    public void liberarAsientoPreferencial(int numeroAsiento) {
        asientosPreferenciales[numeroAsiento] = false;
    }
}
