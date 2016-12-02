package fr.ecp.sio.filrougeapi.endpoints;

import fr.ecp.sio.filrougeapi.model.Station;
import java.util.List;

/*
* A class to recover the list of stations and make statistics calculations
*
* */
public class FinalResult {

    private List<Station> stations;

    private int sumAvailableBikes; //Sum of all available bikes on all stations
    private int sumAvailableBikesStands; //sum of all available bikes stands on all stations


    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public void calculateStats() {
        for (Station station: stations) {
            this.sumAvailableBikes += station.getAvailableBikes();
            this.sumAvailableBikesStands += station.getAvailableBikeStands();
        }
    }
}