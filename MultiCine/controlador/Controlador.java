package controlador;

import modelo.SalaCine;
import vista.SalaCineGUI;

public class Controlador {
    private SalaCine salaCine;
    private SalaCineGUI salaCineGUI;

    public Controlador() {
        SalaCine salaCine = new SalaCine(" Spider-Man: No Way Home");
        salaCineGUI = new SalaCineGUI(salaCine);
    }

    public static void main(String[] args) {
        new Controlador();
    }
}