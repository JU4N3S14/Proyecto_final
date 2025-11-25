package Controlador;

import View.VentanaPrincipal;
import javax.swing.*;

public class VentanaPrincipalControlador {

    private VentanaPrincipal vista;

    public VentanaPrincipalControlador(VentanaPrincipal vista) {
        this.vista = vista;

        inicializarListeners();
    }

    private void inicializarListeners() {

        // Crear carrera
        vista.crearCarreraButton.addActionListener(e -> {
            // Aquí abrirás la ventana CrearCarreraView
            JOptionPane.showMessageDialog(null, "Abrir ventana: Crear Carrera");
        });

        // Registrar participante
        vista.registarParticipanteButton.addActionListener(e -> {
            // Abrir ventana RegistrarParticipanteView
            JOptionPane.showMessageDialog(null, "Abrir ventana: Registrar Participante");
        });

        // Lista de participantes
        vista.listaDeParticipanteButton.addActionListener(e -> {
            // Abrir ventana ListaParticipantesView
            JOptionPane.showMessageDialog(null, "Abrir ventana: Lista de Participantes");
        });

        // Buscar participante
        vista.buscarParticipanteButton.addActionListener(e -> {
            // Abrir ventana BuscarParticipanteView
            JOptionPane.showMessageDialog(null, "Abrir ventana: Buscar Participante");
        });

        // Simular carrera
        vista.simularCarreraButton.addActionListener(e -> {
            // Abrir ventana SimulacionView
            JOptionPane.showMessageDialog(null, "Abrir ventana: Simular Carrera");
        });

        // Resultados
        vista.resultadosButton.addActionListener(e -> {
            // Abrir ventana ResultadosView
            JOptionPane.showMessageDialog(null, "Abrir ventana: Resultados");
        });

        // Exportar resultados
        vista.exportarResultadosButton.addActionListener(e -> {
            // Abrir ventana ExportarResultadosView
            JOptionPane.showMessageDialog(null, "Abrir ventana: Exportar Resultados");
        });

        // Salir
        vista.salirButton.addActionListener(e -> {
            System.exit(0);
        });
    }
}