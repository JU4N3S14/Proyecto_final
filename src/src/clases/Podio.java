package clases;

public class Podio
{
    private Resultado primero;
    private Resultado segundo;
    private Resultado tercero;

    public Podio(Resultado primero, Resultado segundo, Resultado tercero) {
        this.primero = primero;
        this.segundo = segundo;
        this.tercero = tercero;
    }

    public Resultado getPrimero() {
        return primero;
    }
    public Resultado getSegundo() {
        return segundo;
    }
    public Resultado getTercero() {
        return tercero;
    }

    @Override
    public String toString() {
        return "1° " + primero.getParticipante().getNombre() + "\n" +
                "2° " + segundo.getParticipante().getNombre() + "\n" +
                "3° " + tercero.getParticipante().getNombre();
    }
}