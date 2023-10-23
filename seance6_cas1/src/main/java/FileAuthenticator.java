import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;

public class FileAuthenticator extends Authenticator{
    private static final int USERNAME = 1;
    private static final int PASSWORD = 2;

    @Override
    public String getLogin(String username) {
        return getData(username, USERNAME);
    }

    @Override
    public String getPassword(String username) {
        return getData(username, PASSWORD);
    }

    private String getData(String username, int index) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/users.txt"));
            String line = null;
            while((line = reader.readLine()) != null) {
                var data = line.split(";");
                if (Set.of(line.split(";")).contains(username)) {
                    return data[index];
                }
            }
        } catch (Exception err) {

        }
        return null;
    }
}
