package com.puerto_de_carga.puerto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.puerto_de_carga.barco.Barco;
import com.puerto_de_carga.capitan.Capitan;

public class Puerto {
    private ArrayList<Barco> barcos = new ArrayList<>();

    public Puerto(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                String alphanumeric = fields[0];
                int name = Integer.parseInt(fields[1]);
                int normaldist = Integer.parseInt(fields[2]);
                double currency = Double.parseDouble(fields[3]);
                String guid = fields[4];
                String name2 = fields[5];
                String name1 = fields[6];
                int numberrange = Integer.parseInt(fields[7]);

                Capitan capitan = new Capitan(guid, name2, name1, numberrange);
                Barco barco = new Barco(alphanumeric, name, normaldist, currency, capitan);
                this.barcos.add(barco);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String asString() {
        String toReturn = "";
        for (Barco barco : barcos) {
            String barcoAsString = barco.asString();
            toReturn = toReturn + "\n" + barcoAsString;
        }
        return toReturn;
    }

    public double totalCarga() {
        int tiempoPromedio = 15;
        double totalPuerto = 0.0;
        for (Barco barco : barcos) {
            double totalBarco = barco.getCostoAlquilerPorHora() * tiempoPromedio;
            totalPuerto = totalPuerto + totalBarco;
        }
        return totalPuerto;
    }

    public ArrayList<Barco> barcosConCapitanMayorDe18() {
        ArrayList<Barco> barcosMas18 = new ArrayList<>();
        for (Barco barco : barcos) {
            if (barco.getCapitan().getAntiguedad() > 18) {
                barcosMas18.add(barco);
            }
        }

        return barcosMas18;
    }

    public double cargaPromedioPosicionesPares(){
        ArrayList<Barco> barcosPosicionesPares = new ArrayList<>();
        double cargaTotal = 0.0; 
        
        for (Barco barco : barcos) {
            if (barco.getNroMuelleDeCarga() % 2 == 0) {
                barcosPosicionesPares.add(barco);
                cargaTotal = cargaTotal + barco.getCapCarga();
            }
        }

        if (barcosPosicionesPares.size() == 0){
            return 0.0;
        }

        return cargaTotal / barcosPosicionesPares.size();

    }

}
