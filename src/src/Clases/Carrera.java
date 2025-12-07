package Clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Carrera implements Serializable {

    private String nombreCarrera;
    private double distancia;
    private ArrayList<Participante> participantes;


    public Carrera(String nombreCarrera, double distancia) {
        this.nombreCarrera = nombreCarrera;
        this.distancia = distancia;
        this.participantes = new ArrayList<>();
    }

    // Getters
    public String getNombreCarrera()
    {
        return nombreCarrera;
    }
    public double getDistancia()
    {
        return distancia;
    }
    public ArrayList<Participante> getParticipantes()
    {
        return participantes;
    }

    public void agregarParticipante(Participante p){
        participantes.add(p);
    }

    @Override
    public String toString() {
        return nombreCarrera + " ("+distancia+" km)";
    }
}
