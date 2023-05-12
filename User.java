import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Scanner;

/**
 *  This class is used to register and login a user
 */
public class User {
    // constructor
    public User() {

    }

    /**
     *  this method is used to register a new user
     * @param email
     * @param password
     * @param name
     * @throws IOException
     */
    public void register(String email, String password, String name) throws IOException {
        Registration x = new Registration();
        if (!x.isExist(email)) {
            x.setEmail(email);
            x.setPassword(password);
            x.setName(name);
            if (x.otp(email)) {
                x.saveData();
            }
        }
    }

    /**
     *  this method is used to login a user
     * @param email
     * @param password
     * @return
     * @throws IOException
     */
    public Login login(String email, String password) throws IOException {
        Login x = new Login();
        x.confirmLogin(email, password);
        Scanner sc = new Scanner(System.in);
        while (!x.getIsLoggedIn()) {
            System.out.print("Enter correct email: ");
            email = sc.nextLine();

            System.out.print("Enter correct password: ");
            password = sc.nextLine();

            x.confirmLogin(email, password);
        }

        return x;
    }
}
