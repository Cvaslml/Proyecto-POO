package modelo;

public class Pelicula {
    private String titulo;
    private double precioComun;
    private double precioPreferencial;

    public Pelicula(String titulo, double precioComun, double precioPreferencial) {
        this.titulo = titulo;
        this.precioComun = precioComun;
        this.precioPreferencial = precioPreferencial;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioComun() {
        return precioComun;
    }

    public double getPrecioPreferencial() {
        return precioPreferencial;
    }
}
