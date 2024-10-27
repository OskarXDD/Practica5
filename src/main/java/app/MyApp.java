package app;

import Listas.*;
import ed.*;
import tools.*;


public class MyApp {
    private ListaDinamica<Experto> expertos;
    
    public MyApp() {
        this.expertos = new ListaDinamica<>();
    }

    public void agregarExperto(String nombre, String especialidad, String areasInteres, String ubicacionFija, String contacto, String telefonoContacto) throws ExcepcionDeListaLlena {
        Experto experto = new Experto(nombre, especialidad, areasInteres, ubicacionFija, contacto, telefonoContacto);
        expertos.add(experto);
        TJOption.imprimePantalla("Experto agregado exitosamente");
    }
    
    public void actualizarDatosExperto(String nombre) {
        try {
            Experto experto = buscarExperto(nombre);

            if (experto != null) {
                String nuevaEspecialidad = TJOption.leerString("Ingrese nueva especialidad del experto (deje en blanco si no desea cambiar): ");
                if (!nuevaEspecialidad.isEmpty()) {
                    experto.setEspecialidad(nuevaEspecialidad);
                }

                String nuevasAreasInteres = TJOption.leerString("Ingrese nuevas áreas de interés del experto (deje en blanco si no desea cambiar): ");
                if (!nuevasAreasInteres.isEmpty()) {
                    experto.setAreasInteres(nuevasAreasInteres);
                }

                String nuevaUbicacionFija = TJOption.leerString("Ingrese nueva ubicación fija del experto (deje en blanco si no desea cambiar): ");
                if (!nuevaUbicacionFija.isEmpty()) {
                    experto.setUbicacionFija(nuevaUbicacionFija);
                }

                String nuevoContacto = TJOption.leerString("Ingrese nuevo nombre del contacto (deje en blanco si no desea cambiar): ");
                if (!nuevoContacto.isEmpty()) {
                    experto.setContacto(nuevoContacto);
                }

                String nuevoTelefonoContacto = TJOption.leerString("Ingrese nuevo teléfono del contacto (deje en blanco si no desea cambiar): ");
                if (!nuevoTelefonoContacto.isEmpty()) {
                    experto.setTelefonoContacto(nuevoTelefonoContacto);
                }

                TJOption.imprimePantalla("Datos del experto actualizados exitosamente");
            }
        } catch (ExcepcionDeElementoNoEncontrado e) {
            TJOption.imprimeError("Error: " + e.getMessage());
        } catch (ExcepcionDeListaVacia e) {
            TJOption.imprimeError("La lista de expertos está vacía");
        }
    }

    public void eliminarExperto(String nombre) throws ExcepcionDeElementoNoEncontrado, ExcepcionDeListaVacia {
            Experto experto = buscarExperto(nombre);
            if (experto != null) {
                expertos.deleteItem(experto);
                TJOption.imprimePantalla("Experto eliminado exitosamente");
            }
    }
    
    public void listarExpertos() throws ExcepcionDeElementoNoEncontrado{
        try {
        if (expertos.isEmpty()) {
            throw new ExcepcionDeListaVacia("No hay expertos para mostrar");
        }

        StringBuilder salida = new StringBuilder("Lista de Expertos:\n\n");
        for (int i = 1; i <= expertos.size(); i++) {
            Experto experto = expertos.getItem(i);
            salida.append(experto.toString());
        }
        
        Menus.panelScroll(salida.toString());
        
    } catch (ExcepcionDeListaVacia e) {
        TJOption.imprimeError("Error: " + e.getMessage());
    }
   }

    public void agregarCompromiso(String nombreExperto) throws ExcepcionDeListaLlena{
        try {
            Experto experto = buscarExperto(nombreExperto);
            if (experto == null) return;

            String fechaInicio = ajustarFormatoFecha(TJOption.leerString("Ingrese fecha de fin del compromiso (DD/MM/YYYY o DD-MM-YYYY): "));
            String fechaFin = ajustarFormatoFecha(TJOption.leerString("Ingrese fecha de fin del compromiso (DD/MM/YYYY o DD-MM-YYYY): "));
            String ubicacion = TJOption.leerString("Ingrese ubicación del compromiso: ");
            String actividades = TJOption.leerString("Ingrese actividades del compromiso: ");
            String encargado = TJOption.leerString("Ingrese nombre del encargado: ");
            String telefonoEncargado = TJOption.leerString("Ingrese teléfono del encargado: ");

            Compromiso nuevoCompromiso = new Compromiso(fechaInicio, fechaFin, ubicacion, actividades, encargado, telefonoEncargado);

            for (int i = 1; i <= experto.getCompromisos().size(); i++) {
                Compromiso compromiso = experto.getCompromisos().getItem(i);
                if (nuevoCompromiso.chocaCon(compromiso)) {
                    TJOption.imprimeError("El compromiso choca con un compromiso existente del experto");
                    return;
                }
            }

            for (int j = 1; j <= expertos.size(); j++) {
                Experto otroExperto = expertos.getItem(j);
                if (!otroExperto.equals(experto)) { 
                    for (int k = 1; k <= otroExperto.getCompromisos().size(); k++) {
                        Compromiso compromiso = otroExperto.getCompromisos().getItem(k);
                        if (nuevoCompromiso.chocaCon(compromiso)) {
                            TJOption.imprimeError("El compromiso choca con un compromiso existente de otro experto");
                            return;
                        }
                    }
                }
            }

            experto.agregarCompromiso(nuevoCompromiso);
            TJOption.imprimePantalla("Compromiso agregado exitosamente");

        } catch (ExcepcionDeElementoNoEncontrado e) {
            TJOption.imprimeError("Error: " + e.getMessage());
        } catch (ExcepcionDeListaVacia e) {
            TJOption.imprimeError("La lista de expertos está vacía");
        }
    }
    
    public void actualizarCompromiso(String nombreExperto){
       try {
            Experto experto = buscarExperto(nombreExperto);
            if (experto == null) return;

            String ubicacion = TJOption.leerString("Ingrese ubicación del compromiso a actualizar: ");

            Compromiso compromisoExistente = buscarCompromisoPorUbicacion(experto, ubicacion);
            if (compromisoExistente == null) {
                TJOption.imprimeError("No se encontró el compromiso con la ubicación especificada");
                return;
            }

            String nuevaFechaInicio = TJOption.leerString("Ingrese nueva fecha de inicio del compromiso (deje en blanco si no desea cambiar): ");
            if (!nuevaFechaInicio.isEmpty()) {
                compromisoExistente.setFechaInicio(nuevaFechaInicio);
            }

            String nuevaFechaFin = TJOption.leerString("Ingrese nueva fecha de fin del compromiso (deje en blanco si no desea cambiar): ");
            if (!nuevaFechaFin.isEmpty()) {
                compromisoExistente.setFechaFin(nuevaFechaFin);
            }

            String nuevaUbicacion = TJOption.leerString("Ingrese nueva ubicación del compromiso (deje en blanco si no desea cambiar): ");
            if (!nuevaUbicacion.isEmpty()) {
                compromisoExistente.setUbicacion(nuevaUbicacion);
            }

            String nuevasActividades = TJOption.leerString("Ingrese nuevas actividades del compromiso (deje en blanco si no desea cambiar): ");
            if (!nuevasActividades.isEmpty()) {
                compromisoExistente.setActividades(nuevasActividades);
            }

            String nuevoEncargado = TJOption.leerString("Ingrese nuevo nombre del encargado (deje en blanco si no desea cambiar): ");
            if (!nuevoEncargado.isEmpty()) {
                compromisoExistente.setEncargado(nuevoEncargado);
            }

            String nuevoTelefonoEncargado = TJOption.leerString("Ingrese nuevo teléfono del encargado (deje en blanco si no desea cambiar): ");
            if (!nuevoTelefonoEncargado.isEmpty()) {
                compromisoExistente.setTelefonoEncargado(nuevoTelefonoEncargado);
            }

            verificarConflictos(experto, compromisoExistente);

        } catch (ExcepcionDeElementoNoEncontrado e) {
            TJOption.imprimeError("Error: " + e.getMessage());
        } catch (ExcepcionDeListaVacia e) {
            TJOption.imprimeError("La lista de expertos está vacía");
        }
    }

    public void eliminarCompromiso(String nombreExperto){
        try {
            Experto experto = buscarExperto(nombreExperto);
            if (experto == null) return;

            String ubicacion = TJOption.leerString("Ingrese ubicación del compromiso a eliminar: ");
            Compromiso compromisoExistente = buscarCompromisoPorUbicacion(experto, ubicacion);
            if (compromisoExistente == null) {
                return;
            }

            experto.eliminarCompromiso(compromisoExistente);
            TJOption.imprimePantalla("Compromiso eliminado exitosamente");
        } catch (ExcepcionDeElementoNoEncontrado e) {
            TJOption.imprimeError("Error: " + e.getMessage());
        } catch (ExcepcionDeListaVacia e) {
            TJOption.imprimeError("La lista de expertos está vacía");
        }
    }

    public void listarAgenda(String nombreExperto) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
        try {
            Experto experto = buscarExperto(nombreExperto);
            if (experto == null) return;

            if (experto.getCompromisos().isEmpty()) {
                TJOption.imprimePantalla("No hay compromisos para mostrar");
                return;
            }

            StringBuilder salida = new StringBuilder("Agenda de " + experto.getNombre() + ":\n\n");
            for (int i = 1; i <= experto.getCompromisos().size(); i++) {
                Compromiso compromiso = experto.getCompromisos().getItem(i);
                salida.append(compromiso.toString()).append("\n");
            }

            Menus.panelScroll(salida.toString());

        } catch (ExcepcionDeListaVacia e) {
            TJOption.imprimeError("Error: " + e.getMessage());
        }
    }
    
    public String ajustarFormatoFecha(String fecha) {
        if (fecha.contains("-")) {
            return fecha.replace("-", "/");
        }
        return fecha;
    }
    
    public Experto buscarExperto(String nombre) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
        for (int i = 1; i <= expertos.size(); i++) {
            Experto experto = expertos.getItem(i);
            if (experto.getNombre().equals(nombre)) {
                return experto;
            }
        }
        TJOption.imprimeError("El experto " + nombre + " no fue encontrado");
        return null;
    }
    
    private Compromiso buscarCompromisoPorUbicacion(Experto experto, String ubicacion) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
        for (int i = 1; i <= experto.getCompromisos().size(); i++) { 
            Compromiso compromiso = experto.getCompromisos().getItem(i);
            if (compromiso.getUbicacion().equals(ubicacion)) {
                return compromiso;
            }
        }
        TJOption.imprimeError("El evento en esta ubicacion: " + ubicacion + " no fue encontrado");
        return null;
    }
    
    private void verificarConflictos(Experto experto, Compromiso compromiso) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
        Compromiso nuevoCompromiso = new Compromiso(
            compromiso.getFechaInicio(),
            compromiso.getFechaFin(),
            compromiso.getUbicacion(),
            compromiso.getActividades(),
            compromiso.getEncargado(),
            compromiso.getTelefonoEncargado()
        );

        for (int i = 1; i <= experto.getCompromisos().size(); i++) {
            Compromiso c = experto.getCompromisos().getItem(i);
            if (!c.equals(compromiso) && nuevoCompromiso.chocaCon(c)) {
                TJOption.imprimeError("El nuevo compromiso choca con un compromiso existente del experto");
                return;
            }
        }

       for (int j = 1; j <= expertos.size(); j++) {
            Experto otroExperto = expertos.getItem(j);
            if (!otroExperto.equals(experto)) { 
                for (int k = 1; k <= otroExperto.getCompromisos().size(); k++) {
                    Compromiso c = otroExperto.getCompromisos().getItem(k);
                    if (nuevoCompromiso.chocaCon(c)) {
                        TJOption.imprimeError("El nuevo compromiso choca con un compromiso existente de otro experto");
                        return;
                    }
                }
            }
        }

        TJOption.imprimePantalla("Compromiso actualizado exitosamente");
    }
}
