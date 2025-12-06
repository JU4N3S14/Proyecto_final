package Interfacez;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Carrera {
    public JPanel mainPanel;
    public JTextField textNombreCarrera;
    public JComboBox comboBox1;
    public JTextField textFecha;
    public JButton crearCarreraButton;
    public JTable table1;
    public JButton agregarParticipanteButton;
    public JButton iniciarSimulacionButton;
    public JButton volverButton;


    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
