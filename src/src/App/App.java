package App;

import View.VentanaPrincipal;
import Controlador.VentanaPrincipalControlador;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        // rcomendacion estandar para swing:
        SwingUtilities.invokeLater(() -> {

            // 1. crear la vista
            VentanaPrincipal vista = new VentanaPrincipal();

            // 2. crear el controlador
            new VentanaPrincipalControlador(vista);

            // 3. crear la ventana que contendra el panel principal
            JFrame frame = new JFrame("DuckApp Pro");
            frame.setContentPane(vista.getMainPanel());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null); // centrar
            frame.setVisible(true);
        });
    }
}