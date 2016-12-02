package fr.ecp.sio.filrougeapi.data;

import fr.ecp.sio.filrougeapi.model.Station;

import java.io.IOException;
import java.util.List;

/**
 * An interface for a "Repository" component that will expose methods to interact with the data layer of our project.
 * All servlets will get an instance of the Repository (with DataUtils).
 */
public interface DataRepository {

    /*
        Get a station by id or by name
        Returns null if the station is not found.
     */
    Station getStationByID(long id) throws IOException;
    List<Station> getStationByName(String name) throws IOException;


    /*
        Get a list of all stations.
        2nd method to get a list of all stations but limited by limit and offset args
     */
    List<Station> getStations() throws IOException;

    List<Station> getStations(int limit, int offset) throws IOException;

}
