package fr.ecp.sio.filrougeapi.model;

/**
 * A POJO to log in and have authorization
 */
public class VelibUser {

    private String login;
    private String mdp;

    public VelibUser(String login, String mdp){
        this.login = login;
        this.mdp =  mdp;
    }


    //To obtain identifier of user
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    //To obtain password of user
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {this.mdp = mdp;}
}
