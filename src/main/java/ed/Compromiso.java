/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed;

public class Compromiso implements Comparable<Compromiso>{
    private String fechaInicio;
    private String fechaFin;
    private String ubicacion;
    private String actividades;
    private String encargado;
    private String telefonoEncargado;

    public Compromiso(String fechaInicio, String fechaFin, String ubicacion, String actividades, String encargado, String telefonoEncargado) {
        this.fechaInicio = ajustarFormatoFecha(fechaInicio);
        this.fechaFin = ajustarFormatoFecha(fechaFin);
        this.ubicacion = ubicacion;
        this.actividades = actividades;
        this.encargado = encargado;
        this.telefonoEncargado = telefonoEncargado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getActividades() {
        return actividades;
    }

    public String getEncargado() {
        return encargado;
    }

    public String getTelefonoEncargado() {
        return telefonoEncargado;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public void setTelefonoEncargado(String telefonoEncargado) {
        this.telefonoEncargado = telefonoEncargado;
    }

    private String ajustarFormatoFecha(String fecha) {
        if (fecha.contains("-")) {
            return fecha.replace("-", "/");
        }
        return fecha;
    }
    
    public boolean chocaCon(Compromiso otro) {
        return (this.fechaInicio.compareTo(otro.fechaFin) <= 0)
                && (this.fechaFin.compareTo(otro.fechaInicio) >= 0) 
               && this.ubicacion.equals(otro.ubicacion);
    }

    @Override
    public String toString() {
        return "Compromiso desde " + fechaInicio + " hasta " + fechaFin +
               "\nUbicación: " + ubicacion +
               "\nActividades: " + actividades +
               "\nEncargado: " + encargado +
               "\nTeléfono del encargado: " + telefonoEncargado + "\n\n";
    }
    
    @Override
    public int compareTo(Compromiso otro) {
        return this.ubicacion.compareTo(otro.ubicacion);
    }
}


