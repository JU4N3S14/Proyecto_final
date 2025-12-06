package Interfacez;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Estadisticas {
    private JPanel Estadisticas;
    public JButton calcularEstadisticasButton;
    public JButton volverButton;
    private JPanel mainPanel;

    public Estadisticas() {
        calcularEstadisticasButton.addActionListener(new ActionListener() {
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
