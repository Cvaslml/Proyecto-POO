package vista;
import javax.swing.*;
import modelo.SalaCine;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalaCineGUI extends JFrame {
    private SalaCine salaCine;
    private JButton[] asientosButtons;

    public SalaCineGUI(SalaCine salaCine) {
        this.salaCine = salaCine;
        asientosButtons = new JButton[100];
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(" Administración de Sala de Cine "  + salaCine.getNombrePelicula());
        setSize(800, 600);
        setLayout(new GridLayout(10, 10));

        for (int i = 0; i < 100; i++) {
            asientosButtons[i] = new JButton(String.valueOf(i + 1));
            asientosButtons[i].setEnabled(!salaCine.getAsientos()[i]);
            asientosButtons[i].addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    button.setBackground(Color.GRAY);
                    int numeroAsiento = Integer.parseInt(button.getText()) - 1;

                    if (salaCine.isAsientoReservado(numeroAsiento)) {
                        salaCine.liberarAsiento(numeroAsiento);
                        button.setBackground(Color.GREEN);
                        JOptionPane.showMessageDialog(null, "Sé liberó el asiento número " + (numeroAsiento + 1));
                    } else {
                        salaCine.reservarAsiento(numeroAsiento);
                        button.setBackground(Color.RED);
                        double precio = salaCine.getPrecioAsiento(numeroAsiento);
                        JOptionPane.showMessageDialog(null, "Se vendió la boleta del asiento " + (numeroAsiento + 1) + " por $" + precio);
                    }
                }
            });
            add(asientosButtons[i]);
        }

        setVisible(true);
    }
}
