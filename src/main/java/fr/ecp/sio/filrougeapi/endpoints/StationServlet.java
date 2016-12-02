package fr.ecp.sio.filrougeapi.endpoints;

import fr.ecp.sio.filrougeapi.data.DataRepository;
import fr.ecp.sio.filrougeapi.data.DataUtils;
import fr.ecp.sio.filrougeapi.model.Station;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet to handle requests for a single station.
 * This servlet receives requests to URLs /stations/{id}.
 */
public class StationServlet extends ApiServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DataRepository rep = DataUtils.getRepository();
        long id;

        try {
            // We get the id of the station from the path of the URL of the request, removing the leading "/".
            id = Long.parseLong(req.getPathInfo().substring(1));

            //TODO: Write a condition to know what you find in the URL (like: /stations?id=xxx). Actually, this proposition only operate with research by name.
            /*if (req.getParameter("id") != null){
                id = Long.parseLong(req.getParameter("id"));
                //id = Long.parseLong(req.getPathInfo().substring(1));
            } else{id = 0;}*/

        } catch (NumberFormatException ex) {
            // Path is not a valid id, this is a "client" error (4XX code).
            resp.sendError(400, "Invalid station id");
            return;
        }


        Station station = rep.getStationByID(id);


        if (station == null) {
            // A station was not found with this id, send a 404 error.
            resp.sendError(404, "Station not found");
        }

        // Use our base class to send the station object serialized in JSON.
        sendResponse(station, resp);

    }


}
