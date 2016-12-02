package fr.ecp.sio.filrougeapi.data;

import java.io.IOException;
import java.util.List;

/**
 * An interface "UserRepository" to interact with the API interface
 */
public interface UserRepository {
    //Getting the list of vilib Users
    List<VelibUser> getVelibUser() throws IOException;

}
