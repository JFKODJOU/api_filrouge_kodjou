package fr.ecp.sio.filrougeapi.data;

/**
 * An utility class that gives access to a DataRepository and UserRepositiry for all the project.
 * This class implements the singleton pattern to always return the same instance for every call to getRepository() or get UserRepository().
 */
public class DataUtils {

    // Singleton: this static field holds the instance when it has been created.
    private static DataRepository sRepository;

    // Singleton: this static field holds the instance when it has been created.
    private static UserRepository userRepository;

    /*
        Get a DataRepository instance.
        In this method we can substitute the actual implementation with another one if needed.
        This behaviour could also be obtained with Dependency Injection.
     */
    public static DataRepository getRepository() {
        // Singleton: create the instance if needed.
        if (sRepository == null) {
            sRepository = new SQLDataRepository();
        }
        return sRepository;
    }

    //
    public static UserRepository getUserRepository() {
        // Singleton: create the instance if needed.
        if (userRepository == null) {
            userRepository = new DummyUserRepository();
        }
        return userRepository;
    }

    //Method that return a static token, that will be send in header of API requests
    //TODO: we can thinks about a mechanism to generate an automatic token
    public static String getToken(){
        return "bonjourceciestletokent";
    }
}
