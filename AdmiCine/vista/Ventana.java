package vista;

import modelo.Pelicula;
import modelo.Sala;
import modelo.SalaCine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private SalaCine salaCine;
    private JComboBox<String> salaComboBox;
    private JButton[] asientosComunesButtons;
    private JButton[] asientosPreferencialesButtons;
    private JLabel precioLabel;

    public Ventana(SalaCine salaCine) {
        this.salaCine = salaCine;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("AdmiCine");
        setLayout(new BorderLayout());

        // Panel superior
        JPanel panelSuperior = new JPanel();
        JLabel salaLabel = new JLabel("Sala:");
        salaComboBox = new JComboBox<>();
        for (Sala sala : salaCine.getSalas()) {
            salaComboBox.addItem(sala.getNombre());
        }
        JButton crearSalaButton = new JButton("Crear Sala");
        crearSalaButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String nombreSala = JOptionPane.showInputDialog("Ingrese el nombre de la sala:");
                if (nombreSala != null && !nombreSala.isEmpty()) {
                    Pelicula pelicula = crearPelicula();
                    Sala sala = new Sala(nombreSala, pelicula);
                    salaCine.agregarSala(sala);
                    salaComboBox.addItem(nombreSala);
                }
            }
        });

        panelSuperior.add(salaLabel);
        panelSuperior.add(salaComboBox);
        panelSuperior.add(crearSalaButton);

        add(panelSuperior, BorderLayout.NORTH);

        // Panel central
        JPanel panelCentral = new JPanel(new GridLayout(2, 1));

        JPanel asientosComunesPanel = new JPanel(new GridLayout(8, 10));
        asientosComunesButtons = new JButton[80];
        for (int i = 0; i < asientosComunesButtons.length; i++) {
            JButton button = new JButton("C" + (i + 1));
            button.addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    int numeroAsiento = Integer.parseInt(button.getText().substring(1)) - 1;
                    Sala sala = salaCine.getSalas().get(salaComboBox.getSelectedIndex());
                    if (!sala.getAsientosComunes()[numeroAsiento]) {
                        sala.reservarAsientoComun(numeroAsiento);
                        button.setBackground(Color.RED);
                        actualizarPrecio();
                    } else {
                        sala.liberarAsientoComun(numeroAsiento);
                        button.setBackground(null);
                        actualizarPrecio();
                    }
                }
            });
            asientosComunesPanel.add(button);
            asientosComunesButtons[i] = button;
        }

        JPanel asientosPreferencialesPanel = new JPanel(new GridLayout(4, 5));
        asientosPreferencialesButtons = new JButton[20];
        for (int i = 0; i < asientosPreferencialesButtons.length; i++) {
            JButton button = new JButton("P" + (i + 1));
            button.addActionListener(new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    int numeroAsiento = Integer.parseInt(button.getText().substring(1)) - 1;
                    Sala sala = salaCine.getSalas().get(salaComboBox.getSelectedIndex());
                    if (!sala.getAsientosPreferenciales()[numeroAsiento]) {
                        sala.reservarAsientoPreferencial(numeroAsiento);
                        button.setBackground(Color.RED);
                        actualizarPrecio();
                    } else {
                        sala.liberarAsientoPreferencial(numeroAsiento);
                        button.setBackground(null);
                        actualizarPrecio();
                    }
                }
            });
            asientosPreferencialesPanel.add(button);
            asientosPreferencialesButtons[i] = button;
        }

        panelCentral.add(asientosComunesPanel);
        panelCentral.add(asientosPreferencialesPanel);

        add(panelCentral, BorderLayout.CENTER);

        // Panel inferior
        JPanel panelInferior = new JPanel();
        JLabel precioTextoLabel = new JLabel("Precio por asiento: $");
        precioLabel = new JLabel("0");
        panelInferior.add(precioTextoLabel);
        panelInferior.add(precioLabel);

        add(panelInferior, BorderLayout.SOUTH);

        // Configuración de la ventana
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Pelicula crearPelicula() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título de la película:");
        double precioComun = 10000.0; // Precio estimado de $10.000 para asientos comunes
        double precioPreferencial = 20000.0; // Precio estimado de $20.000 para asientos preferenciales
        return new Pelicula(titulo, precioComun, precioPreferencial);
    }

    private void actualizarPrecio() {
        Sala sala = salaCine.getSalas().get(salaComboBox.getSelectedIndex());
        boolean[] asientosComunes = sala.getAsientosComunes();
        boolean[] asientosPreferenciales = sala.getAsientosPreferenciales();
        double precioTotal = 0.0;

        for (int i = 0; i < asientosComunes.length; i++) {
            if (asientosComunes[i]) {
                precioTotal += sala.getPelicula().getPrecioComun();
            }
        }

        for (int i = 0; i < asientosPreferenciales.length; i++) {
            if (asientosPreferenciales[i]) {
                precioTotal += sala.getPelicula().getPrecioPreferencial();
            }
        }

        precioLabel.setText(String.valueOf(precioTotal));
    }
}
