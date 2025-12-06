package Clases;

public class Participante
{
private String nombre;
private int edad;
private String Categoria; // niño, joven ,adulto
private double tiempoCarrera; //tiempo que paso en la simulacion

    //controladores
    public Participante(String nombre, int edad, String categoria, double tiempoCarrera) {
        this.nombre = nombre;
        this.edad = edad;
        Categoria = categoria;
        this.tiempoCarrera = tiempoCarrera;
    }
    //geters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public double getTiempoCarrera() {
        return tiempoCarrera;
    }

    public void setTiempoCarrera(double tiempoCarrera) {
        this.tiempoCarrera = tiempoCarrera;
    }
    @Override
    public String toString() {
        return "Participante{" +
                "Nombre='" + nombre + '\'' +
                ", Edad=" + edad +
                ", Categoria='" + Categoria + '\'' +
                ", Tiempo=" + tiempoCarrera +
                '}';
    }
}
