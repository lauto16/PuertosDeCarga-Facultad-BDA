package com.puerto_de_carga.barco;

import com.puerto_de_carga.capitan.Capitan;

public class Barco {
    // - Barco: qde una embarcacion se conoce matricula, numero de muelle de carga,
    // capacidad de carga permitida en toneladas, costo alquiler por hora de amarre
    // y quien comanda la nave
    private String matricula;
    private int nroMuelleDeCarga;
    private int capCarga;
    private double costoAlquilerPorHora;
    private Capitan capitan;

    public Barco(String matricula, int nroMuelleDeCarga, int capCarga, double costoAlquilerPorHora, Capitan capitan) {
        this.matricula = matricula;
        this.nroMuelleDeCarga = nroMuelleDeCarga;
        this.capCarga = capCarga;
        this.costoAlquilerPorHora = costoAlquilerPorHora;
        this.capitan = capitan;
    }

    public String asString() {
        return "matricula: " + matricula + " - nroMuelleDeCarga: " + nroMuelleDeCarga + " - capCarga: " + capCarga
                + " - costoAlquilerPorHora: " + costoAlquilerPorHora + " - capitan: " + capitan.getNombre() + " "
                + capitan.getApellido();
    }

    public int getCapCarga() {
        return capCarga;
    }

    public Capitan getCapitan() {
        return capitan;
    }

    public double getCostoAlquilerPorHora() {
        return costoAlquilerPorHora;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getNroMuelleDeCarga() {
        return nroMuelleDeCarga;
    }

}
