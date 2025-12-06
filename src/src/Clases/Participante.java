package Clases;

public class Participante {

    private String nombre;
    private int edad;
    private String categoria;
    private String documento;
    private double tiempoCarrera;

    public Participante(String nombre, int edad, String categoria, String documento) {
        this.nombre = nombre;
        this.edad = edad;
        this.categoria = categoria;
        this.documento = documento;
        this.tiempoCarrera = 0; // se inicia en 0
    }

    // getters y setters
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getEdad()
    {
        return edad;
    }
    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    public String getCategoria()
    {
        return categoria;
    }
    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    public String getDocumento()
    {
        return documento;
    }
    public void setDocumento(String documento)
    {
        this.documento = documento;
    }

    public double getTiempoCarrera()
    {
        return tiempoCarrera;
    }
    public void setTiempoCarrera(double tiempoCarrera)
    {
        this.tiempoCarrera = tiempoCarrera;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "Nombre='" + nombre + '\'' +
                ", Edad=" + edad +
                ", Documento='" + documento + '\'' +
                ", Categoria='" + categoria + '\'' +
                ", Tiempo=" + tiempoCarrera +
                '}';
    }
}