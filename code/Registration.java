import java.util.Scanner;
import java.util.regex.Pattern;
import javax.mail.MessagingException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 *  This class is used to register a new user
 *
 */
public class Registration {
    // instance variables
    private String email;
    private String password;
    private String name;
    private boolean exist = false;

    // constructor
    public Registration() {
    }

    /**
     *  this method is used to check if email is valid
     * @param email
     * @return true if email is valid
     *         false if email is invalid
     */
    // regex functions for email and password
    public static boolean isValidEmail(String email) {
        // Regular expression pattern for email validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // Match the input email with the pattern
        return pattern.matcher(email).matches();
    }

    /**
     *  this method is used to check if password is strong enough
     * @param password
     * @return true if password is strong enough
     *         false if password is not strong enough
     */
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

    /**
     * this method is used to get the email
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * this method is used to get the password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     *  this method is used to get the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    // setters

    /**
     * this method is used to set the email
     * @param email
     */
    public void setEmail(String email) {
        while (!isValidEmail(email)) {
            Scanner cin = new Scanner(System.in);
            System.out.print("Invalid email address, please enter a valid email: ");
            email = cin.next();
        }
        this.email = email;
    }

    /**
     *  this method is used to set the password
     * @param password
     */
    public void setPassword(String password) {
        while (!isStrongPassword(password)) {
            Scanner cin = new Scanner(System.in);
            System.out.println("Strong password conditions: \n " +
                    "It should have a minimum length of 8 characters.\n " +
                    "It should contain at least one uppercase letter. \n " +
                    "It should contain at least one lowercase letter. \n " +
                    "It should contain at least one digit. \n " +
                    "It should contain at least one special character (e.g., !@#$%^&*(),.\"?:{}|<>).");
            System.out.print("Not strong password, please enter a strong one: ");
            password = cin.next();
        }
        this.password = password;
    }

    /**
     *  this method is used to set the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  this method is used to check if data is valid
     * @return true if data is valid
     *         false if data is invalid
     */
    // check if data is valid
    public boolean checkData() {
        if (isValidEmail(email) && isStrongPassword(password)) {
            return true;
        }
        return false;
    }

    /**
     * this method is used to check if email already exists
     * @param e
     * @return true if email already exists
     *         false if email does not exist
     * @throws IOException
     */
    // check if email already exists
    public boolean isExist(String e) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("registrationData.txt"));
            String line, word = "";
        while ((line = reader.readLine()) != null) {
            // search for email
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ' ') {
                    word = line.substring(0, i);
                    break;
                }
            }
            // check if email already exists
            if ((e.equals(word))) {
                System.out.println("Email already exists!");
                this.exist = true;
            }
        }
        reader.close();
        return exist;
    }

    /**
     *  this method is used to save data
     * @throws IOException
     */
    public void saveData() throws IOException {
        if (checkData()) {
            BufferedReader reader = new BufferedReader(new FileReader("registrationData.txt"));
            String fileContent = "", line, word = "";

            // read file content
            while ((line = reader.readLine()) != null) {
                fileContent += line + "\n";
                // search for email
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ' ') {
                        word = line.substring(0, i);
                        break;
                    }
                }
            }
            // if email does not exist save data
            if (!isExist(getEmail())) {
                fileContent += getEmail() + " " + getPassword() + " " + getName();
            }
            reader.close();

            // write data
            BufferedWriter writer = new BufferedWriter(new FileWriter("registrationData.txt"));
            writer.write(fileContent);
            writer.close();
        }
    }

    /**
     *  this method is used to check if email is valid
     * @param email
     * @return true if email is valid
     *         false if email is invalid
     * @throws IOException
     */
    // otp
    public boolean otp(String email) throws IOException {
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
            return true;
        } else {
            System.out.println("Registration Failed :(");
            return false;
        }
    }
}
