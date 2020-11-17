package main;

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
    private static ListaCDE<Registro> listaPaquetesTuristicos = null;
    private static ListaCDE<Registro> listaReservas = null;
    private static ListaCDE<Registro> listaServicios = null;
    private static ListaCDE<Registro> listaTransportes = null;
    private static ListaCDE<Registro> listaUsuarios = null;
    
    private static void printInterface() {
        System.out.println("--------------------NOVASOFT--------------------");
        System.out.println("                 MENÚ VER 0.1");
        System.out.println("***********AGENCIA DE VIAJES ***********");
        System.out.println("1.- REGISTRAR UN CLIENTE");
        System.out.println("2.- BUSCAR CLIENTE(CI)");
        System.out.println("3.- IMPRIMIR LISTA DE CLIENTES");
        System.out.println("4.- REGISTRAR USUARIO");
        System.out.println("5.- IMPRIMIR USUARIOS");
        System.out.println("6.- REGISTRAR PAQUETE TURISTICO");
        System.out.println("7.- IMPRIMIR PAQUETES TURISTICOS");
        System.out.println("8.- REGISTRAR RESERVA");
        System.out.println("9.- IMPRIMIR RESERVA");
        System.out.println("10.- REGISTRAR SERVICIO");
        System.out.println("11.- IMPRIMIR SERVICIOS");
        System.out.println("12.- REGISTRAR TRANSPORTE");
        System.out.println("13.- IMPRIMIR TRANSPORTES");
        System.out.println("14.- CERRAR GESTOR");
    }
    
    public static void main(String[] args) {
        listaClientes = recuperarLista("Clientes");
        listaPaquetesTuristicos = recuperarLista("PaquetesTuristicos");
        listaReservas= recuperarLista("Reservas");
        listaServicios = recuperarLista("Servicios"); 
        listaTransportes = recuperarLista("Transporte");
        listaUsuarios = recuperarLista("Usuarios");
        int sec;
        do {
            printInterface();
            sec = lector.nextInt();
            select(sec);
        } while (sec != 14);
    }

    private static void select(int select) {
        String[] texto;
        switch (select) {
            case 1:
                texto = new String[]{"INGRESE CI:\n", "INGRESE NOMBRE:\n", "INGRESE APELLIDOS:\n",
                    "INGRESE TELEFONO DE REFERENCIA:\n", "INGRESE EMAIL:\n"};
                registrar(texto,1,listaClientes);
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
                    "INGRESE TELEFONO DE REFERENCIA:\n", "INGRESE EL CARGO QUE OCUPA:\n"};
                registrar(texto,6,listaUsuarios);
                break;
            case 5:
                printDataList(listaUsuarios);
                break;
            case 6:
                texto = new String[]{"INGRESE DEPARTAMENTO:\n", "INGRESE PRECIO:\n", "INGRESE NOMBRE DEL PAQUETE TURISTICO:\n",
                    "INGRESE DESCRIPCION:\n", "INGRESE PORCENTAJE DE DESCUENTO:\n","INGRESE DESCRIPCION DEL DESCUENTO\n"};
                registrar(texto,2,listaPaquetesTuristicos);
                break;
            case 7:
                printDataList(listaPaquetesTuristicos);
                break;
            case 8:
                texto = new String[]{"INGRESE NUMERO DE PERSONAS:\n", "INGRESE CI DEL CLIENTE:\n"};
                registrar(texto,3,listaReservas);
                break;
            case 9:
                printDataList(listaReservas);
                break;
            case 10:
                texto = new String[]{"INGRESE UBICACION:\n", "INGRESE NOMBRE DE LA EMPRESA:\n", "INGRESE NUMERO DE TELEFONO:\n",
                    "INGRESE PRECIO:\n", "INGRESE EL PORCENTAJE DE DESCUENTO:\n", "INGRESE LA DESCRIPCION DEL DESCUENTO\n"};
                registrar(texto,4,listaServicios);
                break;
            case 11:
                printDataList(listaServicios);
                break;
            case 12:
                texto = new String[]{"INGRESE UBICACION:\n", "INGRESE NOMBRE DE LA EMPRESA:\n", "INGRESE NUMERO DE TELEFONO:\n",
                    "INGRESE PRECIO:\n", "INGRESE EL PORCENTAJE DE DESCUENTO:\n", "INGRESE LA DESCRIPCION DEL DESCUENTO\n",
                    "INGRESE DESTINO:\n", "INGRESE FECHA Y HORA DE SALIDA:\n","INGRESE CANTIDAD DE ASIENTOS DISPONIBLES\n"};
                registrar(texto,5,listaTransportes);
                break;
            case 13:
                printDataList(listaTransportes);
                break;
        }
    }
    
    private static void registrar(String[] texto, int clase, ListaCDE<Registro> lista) {
        String archivo = "";
        String[] datos = new String[texto.length];
        lector.nextLine();
        for (int i = 0; i < texto.length; i++) {
            System.out.print(texto[i]);
            datos[i] = lector.nextLine();
        }
        Registro r = null;
        switch(clase){
            case 1:
                r = new Cliente(datos);
                archivo = "Clientes";
                break;
            case 2:
                r = new PaqueteTuristico(datos[0],Integer.parseInt(datos[1]),datos[2],datos[3],Integer.parseInt(datos[4]),datos[5]);
                archivo = "PaquetesTuristicos";
                break;
            case 3:
                Cliente aux = (Cliente) buscarRegistro(datos[2]);
                r = new Reserva(datos[0],datos[1],aux);
                archivo = "Reservas";
                break;
            case 4:
                r = new Servicio(datos);
                archivo = "Servicios";
                break;
            case 5:
                String[] data = new String[]{datos[0],datos[1],datos[2],datos[3],datos[4],datos[5]};
                r = new Transporte(data,datos[6],datos[7],Integer.parseInt(datos[8]));
                archivo = "Transporte";
                break;
            case 6:
                r = new Usuario(datos);
                archivo = "Usuarios";
                break;
        }
        almacenamientoOrdenado(r, lista);
        guardarLista(lista, archivo);
    }
   
    private static void almacenamientoOrdenado(Registro reg,ListaCDE<Registro> lista) {
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

    private static void almacenamientoOrdenado(int[] limites, NodoDE<Registro> aux, Registro reg,ListaCDE<Registro> lista) {
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

    public static ListaCDE<Registro> recuperarLista(String nombre) {
        ListaCDE<Registro> ret = new ListaCDE<>();
        try ( ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(nombre + ".txt"))) {
            ret = (ListaCDE<Registro>) entrada.readObject();
            entrada.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return ret;
    }
    
    private static boolean validarRango(int a, int b, int n){
        boolean res = true;
        if(n < a || n > b)
            res = false;
        return res;
    }
    
    private static void registrarUsuario(String[] texto) {
        String[] datos = new String[5];
        lector.nextLine();
        for (int i = 0; i < 5; i++) {
            System.out.print(texto[i]);
            datos[i] = lector.nextLine();
        }
        Usuario usr = new Usuario(datos);
        almacenamientoOrdenado(usr,listaUsuarios);
        guardarLista(listaUsuarios, "Usuarios");
    }

    private static void registrarCliente(String[] texto) {
        String[] datos = new String[5];
        lector.nextLine();
        for (int i = 0; i < 5; i++) {
            System.out.print(texto[i]);
            datos[i] = lector.nextLine(); 
            switch(i){
                case 0:
                datos[i] = datos[i].toUpperCase();
                if(!validarRango(7,9,datos[i].length())){    
                    System.out.println("Carnet no valido");
                    i--;                        
                }
                break;
                case 1:
                datos[i] = datos[i].toUpperCase();
                for(int j=0;j<datos[i].length(); j++){
                    if(validarRango(48,57,datos[i].charAt(j))){
                        System.out.println("Nombre no valido contiene número");
                        i--;
                        j = datos[i].length();
                    }                    
                }
                break;
                case 2:
                datos[i] = datos[i].toUpperCase();    
                for(int j=0;j<datos[i].length(); j++){
                    if(validarRango(48,57,datos[i].charAt(j))){
                        System.out.println("Apellido no valido contiene número");
                        i--;
                        j = datos[i].length();
                    }                    
                }
                break;
                case 3:
                for(int j=0;j<datos[i].length(); j++){
                    if(!validarRango(48,57,datos[i].charAt(j))){
                        System.out.println("telefono no valido contiene letras");
                        i--;
                        j = datos[i].length();
                    }                    
                }
                break;
                case 4:
                boolean aux = false,au = false;    
                for(int j=0;j<datos[i].length(); j++){
                    if(datos[i].charAt(j) == '@'){
                        aux = true;
                    }
                    if(datos[i].charAt(j) == '.'){
                        au = true;
                    }                    
                }
                if(aux == false || au == false){
                    System.out.println("Correo no valido");
                    i--;
                }
                break;
            }
        }
        Cliente cli = new Cliente(datos);
        almacenamientoOrdenado(cli,listaClientes);
        guardarLista(listaClientes, "Clientes");
    }
    
}