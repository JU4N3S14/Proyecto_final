package clases;

public class Participante
{

    private String nombre;
    private int numero;
    private Categoria categoria;

    //controlador

    public Participante(String nombre, int numero, Categoria categoria) {
        this.nombre = nombre;
        this.numero = numero;
        this.categoria = categoria;
    }

    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nombre + " (#" + numero + ")";
    }
}

