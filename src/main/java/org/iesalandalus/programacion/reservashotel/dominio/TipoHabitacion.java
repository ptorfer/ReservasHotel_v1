package org.iesalandalus.programacion.reservashotel.dominio;

public enum TipoHabitacion {

    SUITE("SUITE", 4),

    SIMPLE("SIMPLE",1),

    DOBLE("DOBLE",2),

    TRIPLE("TRIPLE",3);


    //Atributos
    private String descripcion;
    private int numeroMaximoPersonas;

    //Constructor
    TipoHabitacion(String descripcion,int numeroMaximoPersonas) {
        this.descripcion = descripcion;
        this.numeroMaximoPersonas = numeroMaximoPersonas;
    }

    //M�todo Get
    public int getNumeroMaximoPersonas() {
        return numeroMaximoPersonas;
    }

    //M�todo to String

    @Override
    public String toString() {
        return String.format("Tipo de Habitaci�n:%s, n�mero de personas: %s",
        this.descripcion, getNumeroMaximoPersonas());
    }
}
