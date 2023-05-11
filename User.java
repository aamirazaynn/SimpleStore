import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Scanner;

public class User {
    // constructor
    public User() {

    }

    // register user
    public void register(String email, String password, String name) throws IOException {
        Registration x = new Registration();
        if (!x.isExist(email)) {
            x.setEmail(email);
            x.setPassword(password);
            x.setName(name);
            OTP otp = new OTP();
            otp.setRECEIVER(email);
            try {
                otp.sendOTP();
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            System.out.print("Enter OTP: ");
            Scanner sc = new Scanner(System.in);
            int otpInput = sc.nextInt();
            if (otp.checkOTP(otpInput)) {
                x.saveData();
            } else {
                System.out.println("Registration Failed :(");
            }
        }
    }

    // login user
    public Login login(String email, String password) throws IOException {
        Login x = new Login();
        x.login(email, password);
        Scanner sc = new Scanner(System.in);
        while (!x.getIsLoggedIn()) {
            System.out.print("Enter correct email: ");
            email = sc.nextLine();

            System.out.print("Enter correct password: ");
            password = sc.nextLine();

            x.login(email, password);
        }

        return x;
    }
}
