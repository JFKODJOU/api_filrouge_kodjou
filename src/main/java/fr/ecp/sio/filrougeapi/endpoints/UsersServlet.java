package fr.ecp.sio.filrougeapi.endpoints;


import fr.ecp.sio.filrougeapi.data.DataUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * A servlet to verified login and password of users
 * This servlet receives requests to URLs /auth/token?log=xxxx&&pwd=xxxx
 */
public class UsersServlet extends ApiServlet {
    // HttpServlet has protected doXxx() methods that correspond to HTTP verbs (GET, POST...).
    // These methods receive objects to represent both the request (to inspect or read from) and the response (to write to).
    // Default implementation sends a 400 error, so we must override doGet() to support GET requests and NOT call super implementation.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login;
        String pwd ;
        try {
            // We get the login and password of the user from the path of the URL of the request (http://localhost:8080/auth/token?log=xxx&&pwd=xxx).
            //  The user parameters are verified in the "DummyDataRepository" through the "UserRepository"
            // If user is verified, the token is sending to the base class
            //TODO: A real users database can be implement
            login = req.getParameter("log");;
            pwd = req.getParameter("pwd");
            List<VelibUser> users =  DataUtils.getUserRepository().getVelibUser();
            for (VelibUser vu:users){
                if(login.equals(vu.getLogin()) && pwd.equals(vu.getMdp())){
                    sendResponse(DataUtils.getToken(), resp);
                    return;
                }
            }
            resp.sendError(400, "Invalid User : "+login);
        } catch (Exception ex) {
            // Path is not a valid log or pwd, this is a "client" error (4XX code).
            resp.sendError(400, "Invalid User : "+ex.getMessage());
            return;
        }


    }

}
