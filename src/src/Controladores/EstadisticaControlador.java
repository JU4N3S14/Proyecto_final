package Controladores;

import Interfacez.Estadisticas;
import javax.swing.*;
import Clases.Carrera;
import Clases.Participante;
import java.util.*;

public class EstadisticaControlador {

    private Estadisticas vista;
    private JFrame frame;
    private List<Carrera> listaCarreras;

    public EstadisticaControlador(Estadisticas vista, JFrame frame, List<Carrera> listaCarreras){
        this.vista = vista;
        this.frame = frame;
        this.listaCarreras = listaCarreras;

        initListeners();
    }

    private void initListeners() {
        // boton volver
        vista.volverButton.addActionListener(e -> {
            Interfacez.MenuPrincipal menu = new Interfacez.MenuPrincipal();
            new MenuPrincipalControlador(menu, frame);
            frame.setContentPane(menu.getMainPanel());
            frame.revalidate();
            frame.repaint();
        });

        // boton calcular estadísticas
        vista.calcularEstadisticasButton.addActionListener(e -> calcularEstadisticas());
    }


    //boton calcular estadisticas

    private void calcularEstadisticas() {

        if(listaCarreras == null || listaCarreras.isEmpty()){
            JOptionPane.showMessageDialog(frame,"No hay carreras registradas");
            return;
        }

        // Participante con mas podios
        Map<String, Integer> podios = new HashMap<>();
        for(Carrera c : listaCarreras){
            List<Participante> p = c.getParticipantes();
            p.sort(Comparator.comparingDouble(Participante::getTiempoCarrera));

            if(p.size()>0) podios.merge(p.get(0).getNombre(),1,Integer::sum); // 1 lugar
            if(p.size()>1) podios.merge(p.get(1).getNombre(),1,Integer::sum); // 2 lugar
            if(p.size()>2) podios.merge(p.get(2).getNombre(),1,Integer::sum); // 3 lugar
        }

        String topPodios = podios.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("Ninguno");

        vista.labelPodios.setText(topPodios);


        // pato mas rapido promedio
        Map<String, List<Double>> tiempos = new HashMap<>();

        for(Carrera c : listaCarreras){
            for(Participante p : c.getParticipantes()){
                tiempos.computeIfAbsent(p.getNombre(), k -> new ArrayList<>()).add(p.getTiempoCarrera());
            }
        }

        String masRapido = tiempos.entrySet().stream()
                .min(Comparator.comparingDouble(e -> e.getValue().stream().mapToDouble(d -> d).average().orElse(Double.MAX_VALUE)))
                .map(Map.Entry::getKey).orElse("Ninguno");

        double promedio = tiempos.get(masRapido).stream().mapToDouble(d->d).average().orElse(0);

        vista.labelPomedio.setText(masRapido + " (" + String.format("%.2f",promedio) + " min)");


        //Tiempo promedio general
        double totalTiempos = tiempos.values().stream()
                .flatMap(List::stream)
                .mapToDouble(d->d).sum();

        int totalParticipaciones = tiempos.values().stream().mapToInt(List::size).sum();

        double promedioGeneral = totalTiempos / totalParticipaciones;
        vista.labelGeneral.setText(String.format("%.2f min",promedioGeneral));


        //  total de participantes
        vista.LabelTotal.setText(String.valueOf(tiempos.keySet().size()));
    }
}
