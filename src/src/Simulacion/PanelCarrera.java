package Simulacion;
import Clases.Participante;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PanelCarrera extends JPanel
{
    List<Participante> participantes;
    private HashMap<Participante, Integer> posiciones;
    private HashMap<Participante, Integer> velocidades;
    private Image imagenPato;
    private Image imagenPista;
    private final int Meta_X = 700;
    private boolean carreraFinalizada = false;

    public PanelCarrera (List<Participante> participantes){
        this.participantes = participantes;
        posiciones = new HashMap<>();
        velocidades = new HashMap<>();
        try{
            imagenPato = new ImageIcon("src/Recursos/pato_.PNG").getImage();
            imagenPista = new ImageIcon("src/Recursos/Pista.png").getImage();
        } catch (Exception e){
            System.out.println("Error al cargar las imagenes: " + e.getMessage());
        }

        Random r = new Random();
        int y = 50;

        // Inicializar posiciones y velocidades
        for(Participante p : participantes){
            posiciones.put(p, 20); // todos empiezan en x=0
            int velocidad = 5 + (int)(Math.random() * 6); // velocidad entre 5 y 10
            velocidades.put(p, velocidad);
            y += 50; // espacio entre corredores
        }

    }

    public void mover(){
        if (carreraFinalizada) return;
        for(Participante p : participantes){
            int posActual = posiciones.get(p);
            int velocidad = velocidades.get(p);
            int nuevaPos = posActual + velocidad;
            posiciones.put(p, nuevaPos);

            // Verificar si ha llegado a la meta
            if(nuevaPos >= Meta_X){
                carreraFinalizada = true;
            }
        }
    }

    public boolean isFinalizada(){
        return carreraFinalizada;
    }

    public Participante getGanador(){
        Participante ganador = null;
        int maxPos = -1;
        for(Participante p : participantes){
            int pos = posiciones.get(p);
            if(pos > maxPos){
                maxPos = pos;
                ganador = p;
            }
        }
        return ganador;
    }

    public void reiniciarCarrera(){
        posiciones.clear();
        velocidades.clear();
        carreraFinalizada = false;

        Random r = new Random();
        for(Participante p : participantes){
            posiciones.put(p, 20); // todos empiezan en x=0
            int velocidad = 5 + (int)(Math.random() * 6); // velocidad entre 5 y 10
            velocidades.put(p, velocidad);
        }
    }

    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        // Fondo pista
        if (imagenPista != null) {
            g.drawImage(imagenPista, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        // Meta
        g.setColor(Color.RED);
        g.fillRect(Meta_X, 0, 10, getHeight());

        // Patos
        int y = 50;
        for (Participante p : participantes) {
            int x = posiciones.get(p);

            if (imagenPato != null) {
                g.drawImage(imagenPato, x, y, 40, 40, this);
            } else {
                g.setColor(Color.BLUE);
                g.fillOval(x, y, 30, 30);
            }

            g.setColor(Color.BLACK);
            g.drawString(p.getNombre(), x, y - 5);
            y += 60;
        }
    }

}
