import java.util.Objects;

public abstract class Authenticator {

    public Authenticator(){

    }

    public boolean authenticate(String username, String password){
        return Objects.equals(getPassword(getLogin(username)), password);
    }
    public abstract String getLogin(String username);
    public abstract String getPassword(String username);
}
