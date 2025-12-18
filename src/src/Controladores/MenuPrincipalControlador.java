package Controladores;

import Interfacez.MenuPrincipal;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import Interfacez.Participante;
import Interfacez.Carrera;
import Interfacez.Simulacion;
import Interfacez.Resultados;
import Interfacez.Estadisticas;

public class MenuPrincipalControlador {

    private MenuPrincipal vista;
    private JFrame frameContenedor;
    private Clases.Carrera carreraSeleccionada;

    // lista global donde se guardan todas las carreras de la aplicacion
    private List<Clases.Carrera> listaGlobalCarreras;

    // Constructor original
    public MenuPrincipalControlador(MenuPrincipal vista, JFrame frameContenedor) {
        this(vista, frameContenedor, new ArrayList<>());
    }

    // Constructor menu pricipal
    public MenuPrincipalControlador(MenuPrincipal vista, JFrame frameContenedor, List<Clases.Carrera> listaGlobalCarreras) {
        this.vista = vista;
        this.frameContenedor = frameContenedor;
        this.listaGlobalCarreras = listaGlobalCarreras;
        initListeners();
    }

    private void initListeners() {

        // participantes
        vista.gestionParticipantesButton.addActionListener(e -> {
            Participante p = new Participante();
            new ParticipanteControlador(p, frameContenedor);
            cambiarVista(p.getMainPanel());
        });

        // carrreas
        vista.ventanaCarrerasButton.addActionListener(e -> {
            Carrera carreraVista = new Carrera();
            new CarreraControlador(carreraVista, frameContenedor, listaGlobalCarreras);
            cambiarVista(carreraVista.getMainPanel());
        });

        // simulacion
        vista.simulacionButton.addActionListener(e -> {
            if (listaGlobalCarreras == null || listaGlobalCarreras.isEmpty()) {
                JOptionPane.showMessageDialog(
                        frameContenedor,
                        "Porfavor antes seleccione una carrera"
                );
                return;
            }

            // Tomamos la última carrera (la más reciente / simulada)
            Clases.Carrera carrera = listaGlobalCarreras.getLast();

            if (carrera.getParticipantes().isEmpty()) {
                JOptionPane.showMessageDialog(
                        frameContenedor,
                        "La carrera no tiene participantes"
                );
                return;
            }

            Simulacion sim = new Simulacion();
            new SimulacionControlador(sim, frameContenedor, carrera);
            cambiarVista(sim.getMainPanel());


        });

        // resultados
        vista.mostarPodiosButton.addActionListener(e -> {
            Resultados res = new Resultados();
            new ResultadosControlador(res, frameContenedor, null, listaGlobalCarreras);
            cambiarVista(res.getMainPanel());
        });

        // estadisticas
        vista.estadisticasButton.addActionListener(e -> {
            Estadisticas est = new Estadisticas();
            new EstadisticaControlador(est, frameContenedor, listaGlobalCarreras);
            System.out.println(est.getMainPanel());
            cambiarVista(est.getMainPanel());
        });

        // salir
        vista.salirButton.addActionListener(e -> System.exit(0));
    }

    private void cambiarVista(JPanel nuevaVista) {
        frameContenedor.setContentPane(nuevaVista);
        frameContenedor.revalidate();
        frameContenedor.repaint();
    }

    public void setCarreraSeleccionada(Clases.Carrera carrera) {
        this.carreraSeleccionada = carrera;
    }

    public List<Clases.Carrera> getListaGlobalCarreras() {
        return listaGlobalCarreras;
    }


}
