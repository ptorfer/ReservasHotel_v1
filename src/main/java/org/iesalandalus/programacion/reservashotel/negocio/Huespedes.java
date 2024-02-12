/**
 * @author: Patricia Torres Fernandez
 * Date: 05/02/2024
 * Time: 20:49
 */

package org.iesalandalus.programacion.reservashotel.negocio;

public class Huespedes {

    //Atributos
    private int capacidad;

    private int tamano;

    private huesped[] coleccionHuespedes;

    //Constructor:
    public Huespedes(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("ERROR: La capacidad debe ser" +
                    " mayor que cero.");
        }
        this.capacidad = capacidad;
        coleccionHuespedes = new Huesped[capacidad];
        tamano = 0;
    }

    //Métodos
    public Huesped[] get() {
        return copiaProfundaHuespedes();
    }

    private Huesped [] copiaProfundaHuespedes(){
        Huesped[] copiaHuespedes = new Huesped[capacidad];
        for (int i = 0; !tamanoSuperado(i); i++) {
            copiaHuespedes[i] = new Huesped(coleccionHuespedes[i]);
        }
        return copiaHuespedes;
    }




}
