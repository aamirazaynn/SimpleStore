import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Registration {
    private String address;
    private String email;
    private String password;

    public Registration() throws IOException {
        // String e, p;
        // Scanner cin = new Scanner(System.in);
        // System.out.println("Enter your address: ");
        // this.address = cin.nextLine();
        // System.out.println("Enter your email: ");
        // e = cin.nextLine();
        // setEmail(e);
        // System.out.print("Enter a password: ");
        // p = cin.nextLine();
        // setPassword(p);

        // if(checkData()) {
        try {
            FileWriter myWriter = new FileWriter("registrationData.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException Z) {
            System.out.println("An error occurred.");
            Z.printStackTrace();
        }
        // }
    }

    // regex functions for email and password
    public static boolean isValidEmail(String email) {
        // Regular expression pattern for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // Match the input email with the pattern
        return pattern.matcher(email).matches();
    }

    public static boolean isStrongPassword(String password) {
        // Minimum length of 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Contains at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Contains at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;
        }

        return true;
    }

    // getters
    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        while (!isValidEmail(email)) {
            Scanner cin = new Scanner(System.in);
            System.out.print("Invalid email address, please enter a valid email: ");
            email = cin.nextLine();
        }
        this.email = email;
    }

    public void setPassword(String password) {
        while (!isStrongPassword(password)) {
            Scanner cin = new Scanner(System.in);
            System.out.println("Strong password conditions: \n " +
                    "It should have a minimum length of 8 characters.\n " +
                    "It should contain at least one uppercase letter. \n " +
                    "It should contain at least one lowercase letter. \n " +
                    "It should contain at least one digit. \n " +
                    "It should contain at least one special character (e.g., !@#$%^&*(),.\"?:{}|<>).");
            System.out.println("Not strong password, please enter a strong one: ");
            password = cin.nextLine();
        }
        this.password = password;
    }

    public boolean checkData() {
        if (isValidEmail(email) && isStrongPassword(password)) {
            return true;
        }
        return false;
    }

}
