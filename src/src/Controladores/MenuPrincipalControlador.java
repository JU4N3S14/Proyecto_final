package Controladores;

import Interfacez.MenuPrincipal;
import javax.swing.*;
import java.awt.*;

import Interfacez.Participante;
import Interfacez.Carrera;
import Interfacez.Simulacion;
import Interfacez.Resultados;
import Interfacez.Estadisticas;


import Controladores.ParticipanteControlador;

public class MenuPrincipalControlador {

    private MenuPrincipal vista;
    private JFrame frameContenedor;

    public MenuPrincipalControlador(MenuPrincipal vista, JFrame frameContenedor) {
        this.vista = vista;
        this.frameContenedor = frameContenedor;
        initListeners();
    }

    private void initListeners() {

        // controlador partipante
        vista.gestionParticipantesButton.addActionListener(e -> {
            Participante p = new Participante();
            new ParticipanteControlador(p, frameContenedor);
            cambiarVista(p.getMainPanel());
        });

        vista.ventanaCarrerasButton.addActionListener(e -> {
            Carrera carreraVista = new Carrera();
            new CarreraControlador(carreraVista, frameContenedor);
            cambiarVista(carreraVista.getMainPanel());
        });


        vista.ventanaCarrerasButton.addActionListener(e -> {
            cambiarVista(new Carrera().getMainPanel());
        });

        vista.simulacionButton.addActionListener(e -> {
            cambiarVista(new Simulacion().getMainPanel());
        });

        vista.mostarPodiosButton.addActionListener(e -> {
            cambiarVista(new Resultados().getMainPanel());
        });

        vista.estadisticasButton.addActionListener(e -> {
            cambiarVista(new Estadisticas().getMainPanel());
        });

        vista.salirButton.addActionListener(e -> System.exit(0));
    }

    private void cambiarVista(JPanel nuevaVista) {
        frameContenedor.setContentPane(nuevaVista);
        frameContenedor.revalidate();
        frameContenedor.repaint();
    }
}
