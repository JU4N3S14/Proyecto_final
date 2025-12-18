package Controladores;

import Clases.Carrera;
import Clases.Participante;
import Interfacez.Simulacion;
import Interfacez.MenuPrincipal;
import Simulacion.PanelCarrera;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;


public class SimulacionControlador
{
    private Simulacion vista;
    private JFrame frame;
    private Carrera carrera;

    private PanelCarrera panelCarrera;
    private Timer timer;
    private long inicio;



    public SimulacionControlador(Simulacion vista, JFrame frame, Carrera carrera) {
        this.vista = vista;
        this.frame = frame;
        this.carrera = carrera;

        panelCarrera = new PanelCarrera(carrera.getParticipantes());
        vista.panelPista.setLayout(new BorderLayout());
        vista.panelPista.add(panelCarrera);

        initTimer();
        initListeners();
    }

    private void initTimer(){
        timer = new Timer (40, e ->{
            panelCarrera.mover();
            panelCarrera.repaint();

            if(panelCarrera.isFinalizada()){
                timer.stop();
                calcularTiempos();
                JOptionPane.showMessageDialog(frame, "Ganador: " + panelCarrera.getGanador().getNombre());
            }
        });
    }

    private void initListeners(){
        vista.iniciarButton.addActionListener(e -> {
            inicio = System.currentTimeMillis();
            timer.start();
        });

        vista.pausaButton.addActionListener(e -> timer.stop());

        vista.reiniciarButton.addActionListener(e -> {
            panelCarrera.reiniciarCarrera();
            timer.stop();
        });

        vista.volverButton.addActionListener(e -> {
            MenuPrincipal menu = new MenuPrincipal();
            new MenuPrincipalControlador(menu, frame);
            frame.setContentPane(menu.getMainPanel());
            frame.revalidate();
            frame.repaint();
        });
    }

    private void calcularTiempos(){
        long fin = System.currentTimeMillis();
        double tiempoTotalMin = (fin - inicio) / 60000.0;

        Random rand = new Random();
        List<Participante> lista = carrera.getParticipantes();


        for(Participante p : carrera.getParticipantes()){
            double variacion = 0.9 + (1.1 - 0.9) * rand.nextDouble(); // entre 0.9 y 1.1
            double tiempoFinal = tiempoTotalMin * variacion;
            p.setTiempoCarrera(tiempoFinal);
        }
    }

}
