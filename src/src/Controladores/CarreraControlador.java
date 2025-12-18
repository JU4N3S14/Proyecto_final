package Controladores;

import Interfacez.Carrera;
import Interfacez.MenuPrincipal;
import Persistencia.GestionArchivos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.List;

public class CarreraControlador {

    private Carrera vista;
    private JFrame frame;

    private final String RUTA = "carreras.dat";
    private List<Clases.Carrera> carreras; // lista global compartida

    public CarreraControlador(Carrera vista, JFrame frame, List<Clases.Carrera> listaGlobal){
        this.vista = vista;
        this.frame = frame;

        ArrayList<Clases.Carrera> cargadas = GestionArchivos.cargar(RUTA);

        if (cargadas != null && !cargadas.isEmpty()) {
            for(Clases.Carrera c : cargadas){
                if(!listaGlobal.contains(c)) listaGlobal.add(c);
            }
        }

        this.carreras = listaGlobal;

        configurarTabla();
        actualizarTabla();
        initListeners();
    }

    private void initListeners(){

        vista.crearCarreraButton.addActionListener(e -> crearCarrera());
        vista.agregarParticipanteButton.addActionListener(e -> agregarParticipante());
        vista.iniciarSimulacionButton.addActionListener(e -> iniciarSimulacion());

        vista.volverButton.addActionListener(e -> {
            MenuPrincipal menu = new MenuPrincipal();
            new MenuPrincipalControlador(menu, frame, carreras);
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
        String nombre = vista.textNombreCarrera.getText().trim();

        Object sel = vista.comboBox1.getSelectedItem();
        double distancia = 5.0;

        if (sel != null) {
            try {
                String s = sel.toString().replace("km","").replace(" ","").replace(",",".");
                distancia = Double.parseDouble(s);
            } catch (Exception ignored){}
        }

        if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(frame,"El nombre no puede ir vacío");
            return;
        }

        Clases.Carrera c = new Clases.Carrera(nombre, distancia);
        carreras.add(c);

        GestionArchivos.guardar(RUTA, new ArrayList<>(carreras));
        actualizarTabla();
        vista.textNombreCarrera.setText("");

        JOptionPane.showMessageDialog(frame,"Carrera registrada");
    }


    private void actualizarTabla(){
        DefaultTableModel model = (DefaultTableModel) vista.table1.getModel();
        model.setRowCount(0);

        for(Clases.Carrera c : carreras){
            model.addRow(new Object[]{
                    c.getNombreCarrera(),
                    c.getDistancia(),
                    c.getParticipantes().size()
            });
        }
    }


    private void agregarParticipante() {
        int fila = vista.table1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(frame, "Seleccione primero una carrera");
            return;
        }

        Clases.Carrera carreraSeleccionada = carreras.get(fila);

        ArrayList<Clases.Participante> global = ParticipanteControlador.lista;
        if (global == null || global.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay participantes registrados");
            return;
        }

        DefaultListModel<String> dlm = new DefaultListModel<>();
        for (Clases.Participante p : global) {
            dlm.addElement(p.getNombre() + " - " + p.getDocumento());
        }

        JList<String> jList = new JList<>(dlm);
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scroll = new JScrollPane(jList);
        scroll.setPreferredSize(new java.awt.Dimension(350,200));

        int option = JOptionPane.showConfirmDialog(frame, scroll,
                "Selecciona participantes", JOptionPane.OK_CANCEL_OPTION);

        if (option != JOptionPane.OK_OPTION) return;

        int[] indices = jList.getSelectedIndices();
        if (indices.length == 0) {
            JOptionPane.showMessageDialog(frame, "No seleccionó participantes");
            return;
        }

        int added = 0;
        for (int idx : indices) {
            Clases.Participante seleccionado = global.get(idx);

            boolean existe = carreraSeleccionada.getParticipantes().stream()
                    .anyMatch(p -> p.getDocumento().equals(seleccionado.getDocumento()));

            if (!existe) {
                carreraSeleccionada.agregarParticipante(seleccionado);
                added++;
            }
        }

        if (added > 0) {
            GestionArchivos.guardar(RUTA, new ArrayList<>(carreras));
            actualizarTabla();
            JOptionPane.showMessageDialog(frame, "Agregados " + added);
        } else JOptionPane.showMessageDialog(frame, "Todos ya estaban en la carrera");
    }


    private void iniciarSimulacion() {
        int fila = vista.table1.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(frame, "Seleccione una carrera");
            return;
        }

        Clases.Carrera carrera = carreras.get(fila);

        if (carrera.getParticipantes().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "No hay participantes en esta carrera");
            return;
        }

        Random rnd = new Random();
        double distancia = carrera.getDistancia();

        for (Clases.Participante p : carrera.getParticipantes()) {
            double factor = 8.0 + rnd.nextDouble() * 8.0;
            double tiempo = Math.round((distancia * factor / 60.0) * 100.0) / 100.0;
            p.setTiempoCarrera(tiempo);
        }

        Collections.sort(carrera.getParticipantes(), Comparator.comparingDouble(Clases.Participante::getTiempoCarrera));

        GestionArchivos.guardar(RUTA, new ArrayList<>(carreras));
        actualizarTabla();

        Interfacez.Resultados vistaResultados = new Interfacez.Resultados();
        new ResultadosControlador(vistaResultados, frame, carrera, carreras);

        frame.setContentPane(vistaResultados.getMainPanel());
        frame.revalidate();
        frame.repaint();
    }

}

