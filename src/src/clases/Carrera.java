package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Carrera
{
    private String nombre;
    private Categoria categoria;
    private LocalDate Fecha;
    private EstadoDeCarrera estado;

    private List<Participante> participantes;
    private List<Resultado> resultados;

    public Carrera(String nombre, Categoria categoria, LocalDate fecha, EstadoDeCarrera estado, List<Participante> participantes, List<Resultado> resultados) {
        this.nombre = nombre;
        this.categoria = categoria;
        Fecha = fecha;
        this.estado = estado;

        this.participantes = new ArrayList<>();
        this.resultados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public EstadoDeCarrera getEstado() {
        return estado;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }
    public void agregarParticipante(Participante p) {
        participantes.add(p);
    }

    public void agregarResultado(Resultado r) {
        resultados.add(r);
    }

    public void iniciar() {
        estado = EstadoDeCarrera.EN_CURSO;
    }

    public void finalizar() {
        estado = EstadoDeCarrera.TERMINADA;
    }
}