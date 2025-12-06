package Interfacez;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Participante {
    public JPanel mainPanel;
    public JTextField textNombre;
    public JTextField textEdad;
    public JTextField textDocumento;
    public JComboBox comboBox1;
    public JButton registarButton;
    public JButton eliminarButton;
    public JButton buscarButton;
    public JButton volverButton;
    public JTable table1;


    public JPanel getMainPanel() {
        return this.mainPanel;
    }
}
