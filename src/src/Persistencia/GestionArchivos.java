package Persistencia;

import java.io.*;
import java.util.ArrayList;

public class GestionArchivos {

    public static <T> void guardar(String ruta, ArrayList<T> datos){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))){
            out.writeObject(datos);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static <T> ArrayList<T> cargar(String ruta){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ruta))){
            return (ArrayList<T>) in.readObject();
        }catch(Exception e){
            return new ArrayList<>();
        }
    }
}
