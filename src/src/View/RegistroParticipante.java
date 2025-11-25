package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroParticipante {
    private JPanel mainPanel;
    private JTextField textNombre;
    private JComboBox comboCategoria;
    private JTextField textNumeroDeCorredor;
    private JButton registarButton;
    private JButton volverButton;

    public RegistroParticipante() {
        registarButton.addActionListener(new ActionListener() {
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
