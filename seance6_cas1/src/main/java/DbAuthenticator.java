import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class DbAuthenticator extends Authenticator{

    private static final int USERNAME = 0;
    private static final int PASSWORD = 1;
    private final Map<String, String[]> db = Map.ofEntries(
            Map.entry("user1@gmail.com", new String[]{"user1", "1234"}),
            Map.entry("user2@gmail.com", new String[]{"user2", "P@ssw0rd"}),
            Map.entry("user3@gmail.com", new String[]{"user2", "root"})
    );

    @Override
    public String getLogin(String username) {
        // simulation d'un SELECT en db
        var user = this.db.get(username);
        return user == null ? null : user[USERNAME];
    }

    @Override
    public String getPassword(String username) {
        // simulation d'un SELECT en db
        var user = this.db.values()
                .stream()
                .filter(val -> Objects.equals(val[USERNAME], username)) // récupération du tableau concernant l'username
                .findFirst();
        return user.map(usr -> usr[PASSWORD]).orElse(null);
    }
}
