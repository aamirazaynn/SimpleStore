import java.io.IOException;
import java.util.Scanner;

public class User {
    // constructor
    public User() {

    }

    // register user
    public void register(String email, String password) throws IOException {
        Registration x = new Registration(email, password);
        x.saveData();
    }

    // login user
    public Login login(String email, String password) throws IOException {
        Login x = new Login();
        x.login(email, password);
        Scanner sc = new Scanner(System.in);
        while(!x.getIsLoggedIn()) {
            System.out.print("Enter correct email:");
            email = sc.nextLine();

            System.out.print("Enter correct password:");
            password = sc.nextLine();

            x.login(email, password);
        }

        return x;
    }
}
