public class App {
    public static void main(String[] args) {
        Authenticator authenticator = new FileAuthenticator();
        if (authenticator.authenticate("user1@gmail.com", "1234")){
            System.out.println("user authenticated");
        } else {
            System.out.println("user non authenticated");
        }
    }
}
