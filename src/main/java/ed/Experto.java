/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed;

import Listas.*;

public class Experto implements Comparable<Experto>{
    private String nombre;
    private String especialidad;
    private String areasInteres;
    private String ubicacionFija;
    private String contacto;
    private String telefonoContacto;
    private ListaDinamica<Compromiso> compromisos;

    public Experto(String nombre, String especialidad, String areasInteres, String ubicacionFija, String contacto, String telefonoContacto) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.areasInteres = areasInteres;
        this.ubicacionFija = ubicacionFija;
        this.contacto = contacto;
        this.telefonoContacto = telefonoContacto;
        this.compromisos = new ListaDinamica<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getAreasInteres() {
        return areasInteres;
    }

    public String getUbicacionFija() {
        return ubicacionFija;
    }

    public String getContacto() {
        return contacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setAreasInteres(String areasInteres) {
        this.areasInteres = areasInteres;
    }

    public void setUbicacionFija(String ubicacionFija) {
        this.ubicacionFija = ubicacionFija;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public void agregarCompromiso(Compromiso nuevoCompromiso) throws ExcepcionDeListaLlena {
         this.compromisos.add(nuevoCompromiso);
    }

   public void eliminarCompromiso(Compromiso compromiso) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
        if (compromisos.isEmpty()) {
            throw new ExcepcionDeListaVacia("No hay compromisos para eliminar.");
        }

        if (!compromisos.search(compromiso)) {
            throw new ExcepcionDeElementoNoEncontrado("El compromiso no fue encontrado.");
        }

        compromisos.deleteItem(compromiso); 
    }
    
    public ListaDinamica<Compromiso> getCompromisos() {
        return compromisos;
    }

    @Override
    public int compareTo(Experto otro) {
        return this.nombre.compareTo(otro.nombre); 
    }
    
    @Override
    public String toString() {
        return "Experto: " + nombre +
               "\nEspecialidad: " + especialidad +
               "\nÁreas de Interés: " + areasInteres +
               "\nUbicación: " + ubicacionFija +
               "\nContacto: " + contacto +
               "\nTeléfono: " + telefonoContacto + "\n\n";
    }

}
