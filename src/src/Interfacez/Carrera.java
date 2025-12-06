package Interfacez;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Carrera {
    private JPanel mainPanel;
    private JTextField textNombreCarrera;
    private JComboBox comboBox1;
    private JTextField textFecha;
    private JButton crearCarreraButton;
    private JTable table1;
    private JButton agregarParticipanteButton;
    private JButton iniciarSimulacionButton;
    private JButton volverButton;

    public Carrera() {
        crearCarreraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        agregarParticipanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        iniciarSimulacionButton.addActionListener(new ActionListener() {
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
