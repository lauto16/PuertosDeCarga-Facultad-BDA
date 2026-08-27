package com.puerto_de_carga.capitan;

public class Capitan {
    // - Capitan: abstraccion que representa a una persona a cargo de una
    // embarcación, se conocen un identificador, un nombre, apellido y la antigüedad
    // en el cargo
    private String idCapitan;
    private String nombre;
    private String apellido;
    private int antiguedad;

    public Capitan(String idCapitan, String nombre, String apellido, int antiguedad) {
        this.idCapitan = idCapitan;
        this.nombre = nombre;
        this.apellido = apellido;
        this.antiguedad = antiguedad;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

}
