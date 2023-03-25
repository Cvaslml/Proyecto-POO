public class SalaCine {

    int aforo;
    int butacasOcupadas;
    String tituloPelicula;
    double precioEntrada;

    //Método Constructor
    public SalaCine() {
        aforo = 100;
        butacasOcupadas = 0;
        tituloPelicula = "";
        precioEntrada = 5.0;
    }

    //Métodos set
    //Método setAforo
    public void setAforo(int afo) {
        aforo = afo;
    }

    //Método setButacasOcupadas
    public void setButacasOcupadas(int ocu) {
        butacasOcupadas = ocu;
    }

    //Método setTituloPelicula
    public void setTituloPelicula(String peli) {
        tituloPelicula = peli;
    }

    //Método setPrecioEntrada
    public void setPrecioEntrada(double entra) {
        precioEntrada = entra;
    }

    //Método setButacasLibres
    public void setButacasLibres(int lib) {
        int ocu;

        ocu = aforo - lib;
        butacasOcupadas = ocu;
    }

    //Métodos get
    //Método getAforo
    public int getAforo() {
        return aforo;
    }

    //Método getButacasOcupadas
    public int getButacasOcupadas() {
        return butacasOcupadas;
    }

    //Método getTituloPelicula
    public String getTituloPelicula() {
        return tituloPelicula;
    }

    //Método getPrecioEntrada
    public double getPrecioEntrada() {
        return precioEntrada;
    }

    //Método getButacasLibres
    public int getButacasLibres() {
        int lib;
        lib = aforo - butacasOcupadas;
        return lib;
    }

    //Método getPorcentajeOcupacion
    public double getPorcentajeOcupacion() {
        double porc;
        porc = (double) butacasOcupadas * 100.0 / (double) aforo;
        return porc;
    }

    //Método getIngresosSala
    public double getIngresosSala() {
        double ingre;
        ingre = butacasOcupadas * precioEntrada;
        return ingre;
    }

    //Métodos de orden
    //Método vaciarSala
    public void vaciarSala() {
        butacasOcupadas = 0;
        tituloPelicula = "";
    }

    //Método entraUno
    public void entraUno() {
        butacasOcupadas++;
    }

}
