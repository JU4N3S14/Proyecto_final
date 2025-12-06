package Controladores;

import Interfacez.Carrera;
import Interfacez.MenuPrincipal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


import Clases.Participante;

public class CarreraControlador {

    private Carrera vista;  // Vista (Interfacez.Carrera)
    private JFrame frame;

    // Lista de carreras de la clase
    private ArrayList<Clases.Carrera> carreras = new ArrayList<>();

    public CarreraControlador(Carrera vista, JFrame frame){
        this.vista = vista;
        this.frame = frame;

        configurarTabla();
        initListeners();
    }

    private void initListeners(){


        vista.crearCarreraButton.addActionListener(e -> crearCarrera());

        vista.agregarParticipanteButton.addActionListener(e -> {
            Interfacez.Participante vistaParticipante = new Interfacez.Participante();
            new ParticipanteControlador(vistaParticipante, frame);

            frame.setContentPane(vistaParticipante.getMainPanel());
            frame.revalidate();
            frame.repaint();
        });


        vista.iniciarSimulacionButton.addActionListener(e ->
                JOptionPane.showMessageDialog(null,"Simulacion aun no")
        );

        vista.volverButton.addActionListener(e -> {
            MenuPrincipal menu = new MenuPrincipal();
            new MenuPrincipalControlador(menu, frame);
            frame.setContentPane(menu.getMainPanel());
            frame.revalidate();
            frame.repaint();
        });
    }

    private void configurarTabla(){
        String[] columnas = {"Nombre carrera","Distancia km","Participantes"};
        vista.table1.setModel(new DefaultTableModel(columnas,0));
    }

    private void crearCarrera(){

        String nombre = vista.textNombreCarrera.getText();
        double distancia = Double.parseDouble((String) vista.comboBox1.getSelectedItem());

        if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(null,"el nombre no puede ir vacio");
            return;
        }


        Clases.Carrera c = new Clases.Carrera( nombre, distancia);
        carreras.add(c);

        actualizarTabla();
        vista.textNombreCarrera.setText("");

        JOptionPane.showMessageDialog(null,"Carrera registrada");
    }

    private void actualizarTabla(){
        DefaultTableModel model = (DefaultTableModel) vista.table1.getModel();
        model.setRowCount(0);

        for(Clases.Carrera c : carreras){
            model.addRow(new Object[]{
                    c.getNombreCarrera(), c.getDistancia(), c.getParticipantes().size()
            });
        }
    }
}
