
package fr.ecp.sio.filrougeapi.data;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

/**
 * A UserRepository to simulate a user database
 * Return the list of all users
 */
public class DummyUserRepository implements UserRepository {


    @Override
    public List<VelibUser> getVelibUser() throws IOException {

        List<VelibUser> users =  new ArrayList<>();
        users.add(new VelibUser("tonton", "tonton"));
        users.add(new VelibUser("tonton1", "tonton"));
        users.add(new VelibUser("tonton2", "tonton"));
        users.add(new VelibUser("tonton3", "tonton"));
        users.add(new VelibUser("tonton4", "tonton"));

        return users;
    }
}

