package Controladores;

import Interfacez.MenuPrincipal;
import Interfacez.Resultados;
import Clases.Carrera;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class ResultadosControlador {

    private Resultados vista;
    private JFrame frame;
    private Carrera carrera;
    private List<Carrera> listaGlobalCarreras; // <-- Se agrega


    public ResultadosControlador(Resultados vista, JFrame frame, Carrera carrera, List<Carrera> listaGlobalCarreras) {
        this.vista = vista;
        this.frame = frame;
        this.carrera = carrera;
        this.listaGlobalCarreras = listaGlobalCarreras;

        if(carrera != null){
            cargarGanadores();
            cargarTabla();
        }

        initListeners();
    }

    private void initListeners() {

        // volver a ventana carreras
        vista.volverButton.addActionListener(e -> {
            MenuPrincipal menu = new MenuPrincipal();
            new MenuPrincipalControlador(menu, frame);
            frame.setContentPane(menu.getMainPanel());
            frame.revalidate();
            frame.repaint();
        });

        vista.exportarTxtButton.addActionListener(e -> exportarResultados());
    }

    // el top 3 del podio
    private void cargarGanadores(){
        List<Clases.Participante> lista = carrera.getParticipantes();
        lista.sort((a,b)->Double.compare(a.getTiempoCarrera(),b.getTiempoCarrera()));

        if(lista.size() > 0) vista.labelGanador.setText(lista.get(0).getNombre());
        if(lista.size() > 1) vista.labelSegundo.setText(lista.get(1).getNombre());
        if(lista.size() > 2) vista.labelTercero.setText(lista.get(2).getNombre());
    }

    // tabla de posiciones
    private void cargarTabla() {
        String[] columnas = {"Posicion", "Participante", "Documento", "Tiempo (min)"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        vista.table1.setModel(modelo);

        List<Clases.Participante> lista = carrera.getParticipantes();
        lista.sort((a, b) -> Double.compare(a.getTiempoCarrera(), b.getTiempoCarrera()));

        int pos=1;
        for (Clases.Participante p : lista) {
            modelo.addRow(new Object[]{pos++, p.getNombre(), p.getDocumento(), p.getTiempoCarrera()});
        }
    }

    // exportar txt
    private void exportarResultados() {
        try {
            FileWriter fw = new FileWriter("resultados_" + carrera.getNombreCarrera() + ".txt");
            PrintWriter pw = new PrintWriter(fw);

            pw.println("Resultados - " + carrera.getNombreCarrera());
            pw.println("======================================\n");

            int pos=1;
            for (Clases.Participante p : carrera.getParticipantes()) {
                pw.println(pos++ + ". " + p.getNombre() + " - " + p.getTiempoCarrera() + " min");
            }
            pw.close();

            JOptionPane.showMessageDialog(frame,"Archivo txt exportado exitosamente");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(frame,"Error al guardar archivo");
        }
    }
}
