
package main;

import ed.ListaCDE;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import registros.Registro;

public class GuardadoPersistente {

    //Recupera los datos almacenados de manera persitente en una lista
    public static ListaCDE<Registro> recuperarLista(String nombre) {
        ListaCDE<Registro> ret = new ListaCDE<>();
        try (final ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombre + ".txt"))) {
            ret = (ListaCDE<Registro>) entrada.readObject();
            entrada.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return ret;
    }

    //Realiza el guardado de forma persistente de los datos en una lista
    public static void guardarLista(ListaCDE<Registro> lista, String nombre) {
        try (final ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombre + ".txt"))) {
            salida.writeObject(lista);
            salida.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
