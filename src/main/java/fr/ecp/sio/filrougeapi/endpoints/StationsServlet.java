package fr.ecp.sio.filrougeapi.endpoints;

import fr.ecp.sio.filrougeapi.data.DataRepository;
import fr.ecp.sio.filrougeapi.data.DataUtils;
import fr.ecp.sio.filrougeapi.model.Station;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * A servlet to handle requests for a list of stations receives by URLs /stations.
 * This servlet send the list and statistics of AvailableBikes and AvailableBikesStands
 *
 */
public class StationsServlet extends ApiServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataRepository rep = DataUtils.getRepository();

        int limit;
        int offset;
        String name = req.getParameter("name");

        //Get the limit and offset parameters in the request URL and parse their value in Int
        if (req.getParameter("limit") != null){
            limit = Integer.parseInt(req.getParameter("limit"));
        } else{limit = 0;}

        if (req.getParameter("offset") != null){
            offset = Integer.parseInt(req.getParameter("offset"));
        } else{offset = 0;}

        /*
        * Three tests here:
        * Get all stations with parameters (limit ant offset) (URL /stations?limit=2&offset=2)
        * Get only the stations that name or part of name is inquire in the URL /stations?name="name_in_the_batabase"
        * Get all the stations in the stable with the URL /stations
        * */
        List<Station> stationslist;

        if (limit!= 0 || offset != 0){
            stationslist = rep.getStations(limit, offset);
        }else if (name != null){
            stationslist = rep.getStationByName(name);
        }else{
            stationslist = rep.getStations();
        }

        //Results to send to the request
        //These results would be translate in an object document (Json), thanks to method "sendResponse" in class "ApiServlet"
        FinalResult finalResult = new FinalResult();
        finalResult.setStations(stationslist);
        finalResult.calculateStats();

        sendResponse(finalResult, resp);
    }

}
