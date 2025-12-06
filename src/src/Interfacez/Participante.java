package Interfacez;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Participante {
    private JPanel mainPanel;
    private JTextField textNombre;
    private JTextField textEdad;
    private JTextField textDocumento;
    private JComboBox comboBox1;
    private JButton registarButton;
    private JButton eliminarButton;
    private JButton buscarButton;
    private JButton volverButton;
    private JTable table1;

    public Participante() {
        registarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buscarButton.addActionListener(new ActionListener() {
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
