package Interfacez;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Resultados {
    private JPanel mainPanel;
    private JTable table1;
    public JButton exportarTxtButton;
    public JButton volverButton;

    public Resultados() {
        exportarTxtButton.addActionListener(new ActionListener() {
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

    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
