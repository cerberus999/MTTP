package main;

import registros.Usuario;
import registros.*;
import ed.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

    private static final Scanner lector = new Scanner(System.in);
    private static ListaCDE<Registro> listaClientes = null;
    private static ListaCDE<Registro> listaUsuarios = null;

    public static void main(String[] args) {
        listaClientes = recuperarLista(listaClientes, "Clientes");
        listaUsuarios = recuperarLista(listaUsuarios, "Usuarios");
        int sec;
        do {
            sec = 0;
            printInterface();
            sec = lector.nextInt();
            select(sec);
        } while (sec != 6);
    }

    private static void printInterface() {
        System.out.println("--------------------NOVASOFT--------------------");
        System.out.println("                 MENÚ VER 0.1");
        System.out.println("AGENCIA DE VIAJES ***********");
        System.out.println("1.- REGISTRAR UN CLIENTE");
        System.out.println("2.- BUSCAR CLIENTE(CI)");
        System.out.println("3.- IMPRIMIR LISTA DE CLIENTES");
        System.out.println("4.- REGISTRAR USUARIO");
        System.out.println("5.- IMPRIMIT USUARIOS5");
        System.out.println("6.- CERRAR GESTOR");
    }

    private static void select(int select) {
        String[] texto;
        switch (select) {
            case 1:
                texto = new String[]{"INGRESE CI:\n", "INGRESE NOMBRE:\n", "INGRESE APELLIDOS:\n",
                    "INGRESE TELEFONO DE REFERENCIA:\n", "INGRESE EMAIL:\n"};
                registrarCliente(texto);
                break;
            case 2:
                System.out.println("Ingrese el nro de carnet que desea buscar:");
                lector.nextLine();
                Registro buscado = buscarRegistro(lector.nextLine());
                if (buscado != null) {
                    printDatos(buscado);
                } else {
                    System.out.println("El cliente no fue encontrado");
                }
                break;
            case 3:
                printDataList(listaClientes);
                break;
            case 4:
                texto = new String[]{"INGRESE LOGIN:\n", "INGRESE CONTRASEÑA:\n", "INGRESE NOMBRE COMPLETO:\n",
                    "INGRESE TELEFONO DE REFERENCIA:\n"};
                registrarUsuario(texto);
                break;
            case 5:
                printDataList(listaUsuarios);
                break;
        }
    }

    private static void registrarUsuario(String[] texto) {
        String[] datos = new String[4];
        lector.nextLine();
        for (int i = 0; i < 4; i++) {
            System.out.print(texto[i]);
            datos[i] = lector.nextLine();
        }
        Usuario usr = new Usuario(datos);
        listaUsuarios.add(usr);
        //almacenamientoOrdenado(usr);
        guardarLista(listaUsuarios, "Usuarios");
    }

    private static void registrarCliente(String[] texto) {
        String[] datos = new String[5];
        lector.nextLine();
        for (int i = 0; i < 5; i++) {
            System.out.print(texto[i]);
            datos[i] = lector.nextLine();
        }
        Cliente cli = new Cliente(datos);
        almacenamientoOrdenado(cli);
        guardarLista(listaClientes, "Clientes");
    }

    private static void almacenamientoOrdenado(Cliente cli) {
        NodoDE<Registro> aux = null;
        if (listaClientes.isEmpty()) {
            listaClientes.add(cli);
        } else if (cli.compareTo(listaClientes.getPosition(0)) < 0) {
            listaClientes.add(0, cli);
        } else if (cli.compareTo(listaClientes.getPosition(listaClientes.size() - 1)) > 0) {
            listaClientes.add(cli);
        } else {
            int[] limites = {0, listaClientes.size() - 1};
            almacenamientoOrdenado(limites, aux, cli);
        }
    }

    private static void almacenamientoOrdenado(int[] limites, NodoDE<Registro> aux, Cliente cli) {
        int index = limites[0] + (limites[1] - limites[0]) / 2;
        aux = listaClientes.getNodo(index, aux);
        if (cli.compareTo(aux.getDato()) == 0) {
            System.out.println("El usuario ya existe!!");
        } else if (cli.compareTo(aux.getSig().getDato()) < 0 && cli.compareTo(aux.getDato()) > 0) {
            listaClientes.add(aux.getIndex() + 1, cli);
        } else if (cli.compareTo(aux.getSig().getDato()) >= 0) {
            almacenamientoOrdenado(new int[]{index, limites[1]}, aux, cli);
        } else if (cli.compareTo(aux.getDato()) <= 0) {
            almacenamientoOrdenado(new int[]{limites[0], index}, aux, cli);
        }
    }

    private static Registro buscarRegistro(String CI) {
        Registro aux = new Cliente(new String[]{CI, "", "", "", ""});
        Registro res = null;
        if (!listaClientes.isEmpty()) {
            if (aux.compareTo(listaClientes.getPosition(0)) < 0 || aux.compareTo(listaClientes.getPosition(listaClientes.size() - 1)) > 0) {
                res = null;
            } else {
                int[] limites = {0, listaClientes.size()};
                res = buscarRegistro(limites, null, aux);
            }
        }
        return res;
    }

    private static Registro buscarRegistro(int[] limites, NodoDE<Registro> aux, Registro comparador) {
        Registro res = null;
        int index = limites[0] + (limites[1] - limites[0]) / 2;
        aux = listaClientes.getNodo(index, aux);
        if (comparador.compareTo(aux.getSig().getDato()) < 0 && comparador.compareTo(aux.getDato()) > 0) {
            res = null;
        } else if (comparador.compareTo(aux.getDato()) == 0) {
            res = aux.getDato();
        } else if (comparador.compareTo(aux.getDato()) >= 0) {
            res = buscarRegistro(new int[]{index, limites[1]}, aux, comparador);
        } else if (comparador.compareTo(aux.getAnt().getDato()) <= 0) {
            res = buscarRegistro(new int[]{limites[0], index}, aux, comparador);
        }
        return res;
    }

    private static void printDatos(Registro r) {
        Cliente c = (Cliente) r; 
        System.out.println("CI:" + c.getCI()
                + "\nNombre Completo: " + c.getNombre() + c.getApellidos()
                + "\nNumero de telefono: " + c.getNumeroTelf()
                + "\neMail: " + c.geteMail());
    }

    private static void printDataList(ListaCDE<Registro> lista) {
        NodoDE<Registro> aux = null;
        for (int i = 0; i < lista.size(); i++) {
            aux = lista.getNodo(i, aux);
            System.out.println(aux.getDato().toStringList());
        }
    }

    public static void guardarLista(ListaCDE<Registro> lista, String nombre) {
        try ( ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombre + ".txt"))) {
            salida.writeObject(lista);
            salida.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ListaCDE<Registro> recuperarLista(ListaCDE<Registro> lista, String nombre) {
        ListaCDE<Registro> ret = new ListaCDE<Registro>();
        try ( ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombre + ".txt"))) {
            ret = (ListaCDE<Registro>) entrada.readObject();
            entrada.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return ret;
    }
}