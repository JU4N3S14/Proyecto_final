package Clases;

import java.util.ArrayList;

public class Estadistica {

    public static Participante obtenerGanador(ArrayList<Participante> lista) {
        Participante ganador = null;

        for (Participante p : lista) {
            if (ganador == null || p.getTiempoCarrera() < ganador.getTiempoCarrera()) {
                ganador = p;
            }
        }
        return ganador;
    }

    public static double promedioTiempo(ArrayList<Participante> lista) {
        if (lista.isEmpty()) return 0;

        double suma = 0;
        for (Participante p : lista) suma += p.getTiempoCarrera();
        return suma / lista.size();
    }
}
