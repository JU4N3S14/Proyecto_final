package Clases;

public class Resultados
{
    private Participante ganador;
    private double promedioTiempo;

    public Resultados(Participante ganador, double promedioTiempo) {
        this.ganador = ganador;
        this.promedioTiempo = promedioTiempo;
    }

    public Participante getGanador()
    {
        return ganador;
    }
    public double getPromedioTiempo()
    { return promedioTiempo;
    }

    @Override
    public String toString() {
        return "Resultados{" +
                "Ganador=" + ganador.getNombre() +
                ", PromedioTiempo=" + promedioTiempo +
                '}';
    }
}
