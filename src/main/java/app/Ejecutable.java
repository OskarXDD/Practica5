package app;

import Listas.*;
import tools.*;


public class Ejecutable {
 
    public static void main(String[]args) throws ExcepcionDeListaLlena, ExcepcionDeElementoNoEncontrado, ExcepcionDeListaVacia{
        menu();
    }
    
    public static void menu() throws ExcepcionDeListaLlena, ExcepcionDeElementoNoEncontrado, ExcepcionDeListaVacia{
        MyApp app = new MyApp();
        boolean ns=true;
        do{
            var opc = Menus.desplegable("Agregar Experto,Actualizar Datos de Experto,"
                    + "Eliminar Experto,Listar Expertos,Agregar Compromiso,Actualizar Compromiso,"
                    + "Eliminar Compromiso,Listar Agenda de un Experto,Salir");
            switch(opc){
                case"Agregar Experto":
                    app.agregarExperto(TJOption.leerString("Ingrese nombre del experto: "), 
                            TJOption.leerString("Ingrese especialidad del experto: "), 
                            TJOption.leerString("Ingrese areas de interes del experto: "), 
                            TJOption.leerString("Ingrese ubicacion fija del experto: "), 
                            TJOption.leerString("Ingrese nombre del contacto: "), 
                            TJOption.leerString("Ingrese telefono del contacto: "));
                    break;
                    
                case"Actualizar Datos de Experto":
                    app.actualizarDatosExperto(TJOption.leerString("Ingrese nombre del experto: "));
                    break;
                    
               case"Eliminar Experto":
                    app.eliminarExperto(TJOption.leerString("Ingrese nombre del experto a eliminar: "));
                    break;
                    
               case"Listar Expertos":
                    app.listarExpertos();
                    break;
                    
                case"Agregar Compromiso":
                    app.agregarCompromiso(TJOption.leerString("Ingrese nombre del experto: "));
                    break;
                    
                case"Actualizar Compromiso":
                    app.actualizarCompromiso(TJOption.leerString("Ingrese nombre del experto: "));
                    break;
                    
                case"Eliminar Compromiso":
                    app.eliminarCompromiso(TJOption.leerString("Ingrese nombre del experto: "));
                    break;
                    
                case"Listar Agenda de un Experto":
                    app.listarAgenda(TJOption.leerString("Ingrese nombre del experto a mostrar: "));
                    break;
                    
                case"Salir": ns=false;
                    break;
            }
        }while(ns!=false);
    }
}
