package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearCarrera {
    private JPanel mainPanel;
    private JTextField txtNombreCarrera;
    private JComboBox comboxCategoria;
    private JTextField texDistancia;
    private JTextField textFecha;
    private JButton crearCarreraButton;
    private JButton volverButton;
    private JLabel lblNombreCarrera;
    private JLabel lblCategoria;
    private JLabel lblDistancia;
    private JLabel lblFecha;

    public CrearCarrera() {
        crearCarreraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
