package BussinessRules;

import Data.*;

import java.util.ArrayList;

/**
 * Created by Esteban on 5/8/2016.
 * All rights reserved
 */
public class GenerateStations {
    //Atributos
    public ArrayList<Station> stationsData;

    //Constructor
    public GenerateStations() {
        this.stationsData = new ArrayList();
    }

    /**Crea las estaciones que se encontrarán en
     * la root 1
     */
    private void root1StationsIn() {
        stationsData.add(new Station("La Estrella", "Metro", 1));
        stationsData.add(new Station("Sabaneta", "Metro", 1));
        stationsData.add(new Station("Itagui", "Metro", 1));
        stationsData.add(new Station("Envigado", "Metro", 1));
        stationsData.add(new Station("Ayura", "Metro", 1));
        stationsData.add(new Station("Eeafit","Metro",1));
        stationsData.add(new Station("Aguacatala", "Metro", 1));
        stationsData.add(new Station("Poblado", "Metro", 1));
        stationsData.add(new Station("Industriales", "Metro", 1));
        stationsData.add(new Station("Exposiciones", "Metro", 1));
        stationsData.add(new Station("San antonio", "Metro", 1));
    }
    /**Crea las estaciones que se encontrarán en
     * la root 2
     */
    private void root2StationsIn() {
        stationsData.add(new Station("Cisneros", "Metro", 2));
        stationsData.add(new Station("Suramericana", "Metro", 2));
        stationsData.add(new Station("Estadio", "Metro", 2));
        stationsData.add(new Station("Floresta", "Metro", 2));
        stationsData.add(new Station("Santa Lucia", "Metro", 2));
        stationsData.add(new Station("San Javier", "Metro Cable", 2));
        stationsData.add(new Station("Juan XXIII", "Metro Cable", 2));
        stationsData.add(new Station("Vallejuelos", "Metro Cable", 2));
        stationsData.add(new Station("La Aurora", "Metro Cable", 2));
    }

    /**Crea las estaciones que se encontrarán en
     * la root 3
     */
    private void root3StationsIn() {
        stationsData.add(new Station("Parque Berrio", "Metro", 3));
        stationsData.add(new Station("Prado", "Metro", 3));
        stationsData.add(new Station("Hospital", "Metro", 3));
        stationsData.add(new Station("Universidad", "Metro", 3));
        stationsData.add(new Station("Caribe", "Metro", 3));
        stationsData.add(new Station("Tricentenario", "Metro", 3));
        stationsData.add(new Station("Acevedo", "Metro", 3));
    }

    /**Crea las estaciones que se encontrarán en
     * la root 4
     */
    private void root4StationsIn() {
        stationsData.add(new Station("Andalucia", "Metro Cable", 4));
        stationsData.add(new Station("Popular", "Metro Cable", 4));
        stationsData.add(new Station("Santo Domingo", "Metro Cable", 4));
        stationsData.add(new Station("Arvi", "Metro Cable", 4));
    }

    /**Crea las estaciones que se encontrarán en
     * la root 5
     */
    private void root5StationsIn()
    {
        stationsData.add(new Station("Madera", "Metro", 5));
        stationsData.add(new Station("Bello", "Metro", 5));
        stationsData.add(new Station("Niquia", "Metro", 5));
    }


    /**
     * Inicializa los 5 métodos que crean
     * las raices del mapa.
     */
    public void startAllRoots() {
        root1StationsIn();
        root2StationsIn();
        root3StationsIn();
        root4StationsIn();
        root5StationsIn();
    }
}