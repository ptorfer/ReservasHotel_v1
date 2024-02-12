/**
 * @author: Patricia Torres Fernandez
 * Date: 05/02/2024
 * Time: 20:55
 */

package org.iesalandalus.programacion.reservashotel.negocio;

import java.rmi.AlreadyBoundException;

public class Habitaciones {

    //Atributos
    private int capacidad;

    private int tamano;

    private Habitacion [] coleccionHabitaciones; /* He creado el atributo
    coleccionHabitaciones donde contiene una colección de la clase Habitacion
    y se representa con []. */

    //Constructor
    public Habitaciones (int capacidad){
        if(capacidad<=0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser " +
                    "mayor que cero.")
        }
        this.capacidad = capacidad;
        coleccionHabitaciones = new Habitacion [capacidad];
        tamano = 0;
    }

    //Métodos
    public Habitacion [] get() {
        return copiaProfundaHabitaciones();
    }

    private Habitacion [] copiaProfundaHabitaciones{
        Habitacion [] copiaProfundaHabitaciones = new Habitacion [capacidad];
        for (int i=0; !tamanoSuperado(i); i++){
            copiaHabitaciones[i] = new Habitacion (coleccionHabitaciones[i]);
        }
        return copiaHabitaciones;
    }

    public int getTamano(){
        return tamano;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public void insertar(Habitacion habitacion){
        if (habitacion == null)
            throw new NullPointerException("ERROR: No se puede insertar " +
                    "una habitación nula.");
        int indice =buscarIndice(habitacion);
        if (capacidadSuperada(indice)) {
            throw new IllegalArgumentException("ERROR: No se aceptan más habitaciones.")
        }
        if (tamanoSuperado(indice)) {
            coleccionHabitaciones[indice] = new Habitacion(habitacion);
            tamano++
        }else {
            throw new IllegalArgumentException("ERROR: Ya existe una habitación con ese identificador.");
        }
    }

    private int buscarIndice(Habitacion habitacion) {
        if (habitacion == null)
            throw new NullPointerException("ERROR: No se puede buscar el índice" +
                    " de un huésped nulo.");
        int indice = 0;
        boolean habitacionBusqueda = false;
        while (!tamanoSuperado(indice)) && !habitacionBusqueda) {
            if (get()[indice].equals(habitacion)) {
                habitacionBusqueda = true;
            }else {
                indice++;
            }
        }
        return indice;
    }

    private boolean tamanoSuperado(int indice){
        return indice >= getTamano();
    }

    private boolean capacidadSuperada(int indice){
        return indice >= getCapacidad();
    }

    public Habitacion buscar(Habitacion habitacion){
        int indice = buscarIndice(habitacion);
            if (tamanoSuperado(indice)){
                return null;
            }else {
                return new Habitacion(get()[indice]);
            }
    }

    public void borrar(Habitacion habitacion){
        if (habitacion == null)
            throws new NullPointerException ("ERROR: No se puede borrar " +
                "una habitación nula.");

        int indice = buscarIndice(habitacion);
            if (tamanoSuperado(indice)) {
                throw new IllegalArgumentException("ERROR: No existe ninguna " +
                        "habitación como la indicada.")
            }else {
                desplazarUnaPosicionHaciaIzquierda(indice);
            }
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice){
        int i;
        for (i=indice; !tamanoSuperado(i); i++) {
            coleccionHabitaciones[i] = coleccionHabitaciones [i+1];
        }
        coleccionHabitaciones[i] = null;
        tamano--;
    }


}
