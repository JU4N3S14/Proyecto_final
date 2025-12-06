package Clases;

import java.util.ArrayList;

public class Carrera
{
private String nombreCarrera;
private double distancia; //metros o km
private ArrayList<Participante> participantes;

    public Carrera(String nombreCarrera, double distancia, ArrayList<Participante> participantes) {
        this.nombreCarrera = nombreCarrera;
        this.distancia= distancia;
        this.participantes = participantes;
    }
    public void agregarParticipante(Participante p) {
        participantes.add(p);
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public String getNombreCarrera() { return nombreCarrera; }
    public double getDistancia() { return distancia; }

    @Override
    public String toString() {
        return "Carrera{" +
                "Nombre='" + nombreCarrera + '\'' +
                ", Distancia=" + distancia +
                ", Participantes=" + participantes.size() +
                '}';
    }
}
