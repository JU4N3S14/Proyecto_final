package clases;

public class Resultado
{
    private Participante participante;
    private double tiempo; // tiempo en segundos
    private int posicion;  // 1, 2 o 3 si es podio

    public Resultado(Participante participante, double tiempo, int posicion) {
        this.participante = participante;
        this.tiempo = tiempo;
        this.posicion = posicion;
    }

    public Participante getParticipante()
    {
        return participante;
    }
    public double getTiempo() {
        return tiempo;
    }
    public int getPosicion()
    {
        return posicion;
    }

    public void setPosicion(int posicion)
    {
        this.posicion = posicion;
    }
}
