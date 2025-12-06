package Controladores;

import Interfacez.Participante;
import Interfacez.MenuPrincipal;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ParticipanteControlador {

    private Participante vista;
    private JFrame frame;


    public static ArrayList<Clases.Participante> lista = new ArrayList<>();

    public ParticipanteControlador(Participante vista, JFrame frame) {
        this.vista = vista;
        this.frame = frame;

        configurarTabla();
        initListeners();
        actualizarTabla();
    }

    private void initListeners() {

        vista.registarButton.addActionListener(e -> registrar());
        vista.buscarButton.addActionListener(e -> buscar());
        vista.eliminarButton.addActionListener(e -> eliminar());

        vista.volverButton.addActionListener(e -> {
            MenuPrincipal menu = new MenuPrincipal();
            new MenuPrincipalControlador(menu, frame);

            frame.setContentPane(menu.getMainPanel());
            frame.revalidate();
            frame.repaint();
        });
    }

    private void configurarTabla() {
        String[] columnas = {"Nombre", "Edad", "Documento", "Categoría", "Tiempo"};
        vista.table1.setModel(new DefaultTableModel(columnas, 0));
    }

    private void registrar() {
        String nombre = vista.textNombre.getText();
        String edadTxt = vista.textEdad.getText();
        String documento = vista.textDocumento.getText();
        String categoria = (String) vista.comboBox1.getSelectedItem();

        if (nombre.isEmpty() || edadTxt.isEmpty() || documento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            return;
        }

        try {
            int edad = Integer.parseInt(edadTxt);

            Clases.Participante p = new Clases.Participante(nombre, edad, categoria, documento);
            lista.add(p);

            actualizarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Participante registrado");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Edad invalida");
        }
    }

    private void buscar() {
        String doc = JOptionPane.showInputDialog("Documento a buscar:");
        for (Clases.Participante p : lista) {
            if (p.getDocumento().equals(doc)) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: " + p.getNombre() +
                                "\nEdad: " + p.getEdad() +
                                "\nCategoria: " + p.getCategoria());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No existe.");
    }

    private void eliminar() {
        String doc = JOptionPane.showInputDialog("Documento a eliminar:");
        for (Clases.Participante p : lista) {
            if (p.getDocumento().equals(doc)) {
                lista.remove(p);
                actualizarTabla();
                JOptionPane.showMessageDialog(null, "Eliminado");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontro");
    }

    private void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) vista.table1.getModel();
        model.setRowCount(0);

        for (Clases.Participante p : lista) {
            model.addRow(new Object[]{
                    p.getNombre(), p.getEdad(), p.getDocumento(),
                    p.getCategoria(), p.getTiempoCarrera()
            });
        }
    }

    private void limpiarCampos() {
        vista.textNombre.setText("");
        vista.textEdad.setText("");
        vista.textDocumento.setText("");
    }
}
