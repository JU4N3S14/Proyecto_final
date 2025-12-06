package App;

import javax.swing.*;
import Interfacez.MenuPrincipal;
import Controladores.MenuPrincipalControlador;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestor de Carreras");
        MenuPrincipal menu = new MenuPrincipal();

        new MenuPrincipalControlador(menu, frame);

        frame.setContentPane(menu.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
