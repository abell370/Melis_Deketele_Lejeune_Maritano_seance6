import java.util.Objects;

public abstract class Authenticator {

    public Authenticator(){

    }

    public boolean authenticate(String username, String password){
        // vérification que le mot de passe lié à l'username retourné par getLogin correspond au mot de passe encodé
        return Objects.equals(getPassword(getLogin(username)), password);
    }
    public abstract String getLogin(String username);
    public abstract String getPassword(String username);
}
