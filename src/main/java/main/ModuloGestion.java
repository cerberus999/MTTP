
package main;

import ed.ListaCDE;
import ed.NodoDE;
import registros.Cliente;
import registros.PaqueteTuristico;
import registros.Registro;
import registros.Reserva;
import registros.Servicio;
import registros.Transporte;
import registros.Usuario;

public class ModuloGestion {
        

    //Selecciona el archivo destino de guardado
    private static String seleccionarDestino(int clase) {
        String res = "";
        switch (clase) {
            case 1 -> res = "Clientes";
            case 2 -> res = "PaquetesTuristicos";
            case 3 -> res = "Reservas";
            case 4 -> res = "Servicios";
            case 5 -> res = "Transporte";
            case 6 -> res = "Usuarios";
        }
        return res;
    }

    //Crea un registro dependiendo de la clase asignada a un numero
    public static Registro crearRegistro(String[] datos, int clase) {
        Registro r = null;
        switch (clase) {
            case 1 -> r = new Cliente(datos);
            case 2 -> r = new PaqueteTuristico(datos);
            case 3 -> {
                Cliente aux = (Cliente) buscarRegistro(Main.listaClientes, 1, new String[]{"INGRESE CI DEL CLIENTE:\n"});
                r = new Reserva(datos[0], aux);
            }
            case 4 -> r = new Servicio(datos);
            case 5 -> {
                String[] data = new String[]{datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]};
                r = new Transporte(data, datos[6], datos[7], Integer.parseInt(datos[8]));
            }
            case 6 -> r = new Usuario(datos);
        }
        return r;
    }

    //Imprime los datos del objeto con el nombre del dato
    static void imprimirDatos(Registro r) {
        System.out.println(r.toString());
    }

    //Introduce un objeto en la posicion que corresponde mediante parametros ya determinados por su respectiva clase
    private static void almacenamientoOrdenado(Registro reg, ListaCDE<Registro> lista) {
        NodoDE<Registro> aux = null;
        if (lista.isEmpty()) {
            lista.add(reg);
        } else if (reg.compareTo(lista.getPosition(0)) < 0) {
            lista.add(0, reg);
        } else if (reg.compareTo(lista.getPosition(lista.size() - 1)) > 0) {
            lista.add(reg);
        } else {
            int[] limites = {0, lista.size() - 1};
            almacenamientoOrdenado(limites, aux, reg, lista);
        }
    }

    //Introduce un objeto en la posicion que corresponde mediante parametros ya determinados por su respectiva clase
    //Parte recursiva
    private static void almacenamientoOrdenado(int[] limites, NodoDE<Registro> aux, Registro reg, ListaCDE<Registro> lista) {
        int index = limites[0] + (limites[1] - limites[0]) / 2;
        aux = lista.getNodo(index, aux);
        if (reg.compareTo(aux.getDato()) == 0) {
            System.out.println("El usuario ya existe!!");
        } else if (reg.compareTo(aux.getSig().getDato()) < 0 && reg.compareTo(aux.getDato()) > 0) {
            lista.add(aux.getIndex() + 1, reg);
        } else if (reg.compareTo(aux.getSig().getDato()) >= 0) {
            almacenamientoOrdenado(new int[]{index, limites[1]}, aux, reg, lista);
        } else if (reg.compareTo(aux.getDato()) <= 0) {
            almacenamientoOrdenado(new int[]{limites[0], index}, aux, reg, lista);
        }
    }

    //Crea un objeto para la busqueda de datos requerida
    public static Registro crearObjetoDeBusqueda(String dato, int clase) {
        Registro r = null;
        switch (clase) {
            case 1 -> r = new Cliente(dato);
            case 2 -> r = new PaqueteTuristico(dato);
            case 3 -> r = new Reserva(dato);
            case 4 -> r = new Servicio(dato);
            case 5 -> r = new Transporte(dato);
            case 6 -> r = new Usuario(dato);
        }
        return r;
    }

    //Con datos recopilados en seleccionar() crea un objeto para guardarse posteriormente en su lista respectiva
    static void registrar(String[] texto, int clase, ListaCDE<Registro> lista) {
        String[] datos = new String[texto.length];
        Main.lector.nextLine();
        for (int i = 0; i < texto.length; i++) {
            System.out.print(texto[i]);
            datos[i] = Main.lector.nextLine();
        }
        Registro r = crearRegistro(datos, clase);
        String archivo = seleccionarDestino(clase);
        almacenamientoOrdenado(r, lista);
        GuardadoPersistente.guardarLista(lista, archivo);
    }

    //Dato o datos separados por una coma (,) pasaran a ser buscados en su respectiva "lista"
    static Registro buscarRegistro(ListaCDE<Registro> lista, int clase, String[] texto) {
        String datosBusqueda = "";
        Main.lector.nextLine();
        for (int i = 0; i < texto.length - 1; i++) {
            System.out.print(texto[i]);
            datosBusqueda += Main.lector.nextLine() + ",";
        }
        System.out.print(texto[texto.length - 1]);
        datosBusqueda += Main.lector.nextLine();
        Registro aux = crearObjetoDeBusqueda(datosBusqueda, clase);
        Registro res = null;
        if (!lista.isEmpty()) {
            if (aux.compareTo(lista.getPosition(0)) < 0 || aux.compareTo(lista.getPosition(lista.size() - 1)) > 0) {
                res = null;
            } else {
                int[] limites = {0, lista.size()};
                res = buscarRegistro(limites, null, aux, lista);
            }
        }
        return res;
    }

    //Realiza una busqueda en las listas de manera recursiva
    private static Registro buscarRegistro(int[] limites, NodoDE<Registro> aux, Registro comparador, ListaCDE<Registro> lista) {
        Registro res = null;
        int index = limites[0] + (limites[1] - limites[0]) / 2;
        aux = lista.getNodo(index, aux);
        if (comparador.compareTo(aux.getSig().getDato()) < 0 && comparador.compareTo(aux.getDato()) > 0) {
            res = null;
        } else if (comparador.compareTo(aux.getDato()) == 0) {
            res = aux.getDato();
        } else if (comparador.compareTo(aux.getDato()) >= 0) {
            res = buscarRegistro(new int[]{index, limites[1]}, aux, comparador, lista);
        } else if (comparador.compareTo(aux.getAnt().getDato()) <= 0) {
            res = buscarRegistro(new int[]{limites[0], index}, aux, comparador, lista);
        }
        return res;
    }

    //Imprime en consola una lista con todos los datos almacenados de forma persistente hasta el momento
    static void imprimirListaDeDatos(ListaCDE<Registro> lista) {
        NodoDE<Registro> aux = null;
        for (int i = 0; i < lista.size(); i++) {
            aux = lista.getNodo(i, aux);
            System.out.println(aux.getDato().toStringList());
        }
    }
    
}
