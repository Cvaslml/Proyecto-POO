package ejecutable;
import modelo.SalaCine;
import vista.Ventana;

public class Test {
    public static void main(String[] args) {
        SalaCine miSalaCine = new SalaCine();
        Ventana miVentana = new Ventana(miSalaCine);
    }
}