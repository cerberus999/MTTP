package main;

import registros.*;
import ed.*;
import java.util.Scanner;
import vista.*;

public class Main {

    public static final Scanner lector = new Scanner(System.in);
    public static ListaCDE<Registro> listaClientes = null;
    private static ListaCDE<Registro> listaPaquetesTuristicos = null;
    private static ListaCDE<Registro> listaReservas = null;
    private static ListaCDE<Registro> listaServicios = null;
    private static ListaCDE<Registro> listaTransportes = null;
    private static ListaCDE<Registro> listaUsuarios = null;
        
    //Recupera listas e inicializa el programa(Imprime la intefaz y espera por una eleccion)
    public static void main(String[] args) {
        listaClientes = GuardadoPersistente.recuperarLista("Clientes");
        listaPaquetesTuristicos = GuardadoPersistente.recuperarLista("PaquetesTuristicos");
        listaReservas= GuardadoPersistente.recuperarLista("Reservas");
        listaServicios = GuardadoPersistente.recuperarLista("Servicios"); 
        listaTransportes = GuardadoPersistente.recuperarLista("Transporte");
        listaUsuarios = GuardadoPersistente.recuperarLista("Usuarios");
        
        int sec;
        do {
            imprimirInterfaz();
            sec = lector.nextInt();
            selecOpcMenu(sec);
        } while (sec != 19);
    }
    
    //Imprime una interfaz para consola
    private static void imprimirInterfaz() {
        System.out.println("--------------------NOVASOFT--------------------");
        System.out.println("                 MENÚ VER 0.1");
        System.out.println("***********AGENCIA DE VIAJES***********");
        System.out.println("1.-  REGISTRAR UN CLIENTE");
        System.out.println("2.-  BUSCAR CLIENTE(CI)");
        System.out.println("3.-  IMPRIMIR LISTA DE CLIENTES");
        System.out.println("4.-  REGISTRAR USUARIO");
        System.out.println("5.-  IMPRIMIR USUARIOS");
        System.out.println("6.-  REGISTRAR PAQUETE TURISTICO");
        System.out.println("7.-  IMPRIMIR PAQUETES TURISTICOS");
        System.out.println("8.-  REGISTRAR RESERVA");
        System.out.println("9.-  IMPRIMIR RESERVA");
        System.out.println("10.- REGISTRAR SERVICIO");
        System.out.println("11.- IMPRIMIR SERVICIOS");
        System.out.println("12.- REGISTRAR TRANSPORTE");
        System.out.println("13.- IMPRIMIR TRANSPORTES");
        System.out.println("14.- BUSCAR PAQUETE TURISTICO");
        System.out.println("15.- BUSCAR RESERVA");
        System.out.println("16.- BUSCAR SERVICIO");
        System.out.println("17.- BUSCAR TRANSPORTE");
        System.out.println("18.- BUSCAR USUARIO");
        System.out.println("19.- CERRAR GESTOR");
    }
    
    //Selecciona una opcion del menu
    private static void selecOpcMenu(int select) {
        String[] texto;
        String noEncontrado = "Registro no encontrado";
        Registro buscado;
        switch (select) {
            case 1:
                texto = new String[]{"INGRESE CI:\n", "INGRESE NOMBRE:\n", "INGRESE APELLIDOS:\n",
                    "INGRESE TELEFONO DE REFERENCIA:\n", "INGRESE EMAIL:\n"};
                ModuloGestion.registrar(texto,1,listaClientes);
                break;
            case 2:
                texto = new String[]{"INGRESE EL NUMERO DE CARNET QUE DESEA BUSCAR:\n"};
                buscado = ModuloGestion.buscarRegistro(listaClientes,1,texto);
                if (buscado != null) 
                    ModuloGestion.imprimirDatos(buscado);
                else 
                    System.out.println(noEncontrado);
                break;
            case 3:
                ModuloGestion.imprimirListaDeDatos(listaClientes);
                break;
            case 4:
                texto = new String[]{"INGRESE EL NOMBRE DEL USUARIO:\n","INGRESE LOS APELLIDOS DEL USUARIO:\n","INGRESE LOGIN:\n", 
                    "INGRESE CONTRASEÑA:\n","INGRESE TELEFONO DE REFERENCIA:\n", "INGRESE EL CARGO QUE OCUPA:\n"};
                ModuloGestion.registrar(texto,6,listaUsuarios);
                break;
            case 5:
                ModuloGestion.imprimirListaDeDatos(listaUsuarios);
                break;
            case 6:
                texto = new String[]{"INGRESE DEPARTAMENTO:\n", "INGRESE PRECIO:\n", "INGRESE NOMBRE DEL PAQUETE TURISTICO:\n",
                    "INGRESE DESCRIPCION:\n", "INGRESE PORCENTAJE DE DESCUENTO:\n","INGRESE DESCRIPCION DEL DESCUENTO\n"};
                ModuloGestion.registrar(texto,2,listaPaquetesTuristicos);
                break;
            case 7:
                ModuloGestion.imprimirListaDeDatos(listaPaquetesTuristicos);
                break;
            case 8:
                texto = new String[]{"INGRESE NUMERO DE PERSONAS:\n"};
                ModuloGestion.registrar(texto,3,listaReservas);
                break;
            case 9:
                ModuloGestion.imprimirListaDeDatos(listaReservas);
                break;
            case 10:
                texto = new String[]{"INGRESE UBICACION:\n", "INGRESE NOMBRE DE LA EMPRESA:\n", "INGRESE NUMERO DE TELEFONO:\n",
                    "INGRESE PRECIO:\n", "INGRESE EL PORCENTAJE DE DESCUENTO:\n", "INGRESE LA DESCRIPCION DEL DESCUENTO\n"};
                ModuloGestion.registrar(texto,4,listaServicios);
                break;
            case 11:
                ModuloGestion.imprimirListaDeDatos(listaServicios);
                break;
            case 12:
                texto = new String[]{"INGRESE UBICACION:\n", "INGRESE NOMBRE DE LA EMPRESA:\n", "INGRESE NUMERO DE TELEFONO:\n",
                    "INGRESE PRECIO:\n", "INGRESE EL PORCENTAJE DE DESCUENTO:\n", "INGRESE LA DESCRIPCION DEL DESCUENTO:\n",
                    "INGRESE DESTINO:\n", "INGRESE FECHA Y HORA DE SALIDA:\n","INGRESE CANTIDAD DE ASIENTOS DISPONIBLES\n"};
                ModuloGestion.registrar(texto,5,listaTransportes);
                break;
            case 13:
                ModuloGestion.imprimirListaDeDatos(listaTransportes);
                break;
            case 14:
                texto = new String[]{"INGRESE EL DEPARTAMENTO DE DESTINO:\n","INGRESE EL PRECIO DEL PAQUETE:\n"};
                buscado = ModuloGestion.buscarRegistro(listaPaquetesTuristicos, 2, texto);
                if (buscado != null) 
                    ModuloGestion.imprimirDatos(buscado);
                else 
                    System.out.println(noEncontrado);
            break;
            case 15:
                texto = new String[]{"INGRESE EL CODIGO DE RESERVA:\n"};
                buscado = ModuloGestion.buscarRegistro(listaReservas, 3, texto);
                if (buscado != null) 
                    ModuloGestion.imprimirDatos(buscado);
                else 
                    System.out.println(noEncontrado);
            break;
            case 16:
                texto = new String[]{"INGRESE EL DEPARTAMENTO DE ORIGEN:\n"};
                buscado = ModuloGestion.buscarRegistro(listaServicios, 4, texto);
                if (buscado != null) 
                    ModuloGestion.imprimirDatos(buscado);
                else 
                    System.out.println(noEncontrado);
                break;
            case 17:
                texto = new String[]{"INGRESE EL DEPARTAMENTO DE ORIGEN\n","INGRESE EL DEPARTAMENTO DE DESTINO:\n",
                "INGRESE EL PRECIO DEL BOLETO:\n"};
                buscado = ModuloGestion.buscarRegistro(listaTransportes, 5, texto);
                if (buscado != null) 
                    ModuloGestion.imprimirDatos(buscado);
                else 
                    System.out.println(noEncontrado);
            break;
            case 18:
                texto = new String[]{"INGRESE EL NOMBRE DE USUARIO:\n","INGRESE EL APELLIDO DEL USUARIO:\n"};
                buscado = ModuloGestion.buscarRegistro(listaUsuarios, 6, texto);
                if (buscado != null) 
                    ModuloGestion.imprimirDatos(buscado);
                else 
                    System.out.println(noEncontrado);
            break;
        }
    }
}