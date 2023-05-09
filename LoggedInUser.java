import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LoggedInUser extends User{
    // instance variables
    private String name;
    private String phoneNumber;
    private String email;
    private String password;

    // constructor
    public LoggedInUser(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }
    public LoggedInUser() {
        this.name = "";
        this.phoneNumber = "";
    }

    // getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        Scanner sc = new Scanner(System.in);
        while (!isValidPhone(phoneNumber)) {
            System.out.println("Phone number is invalid");
            System.out.print("Enter correct phone number: ");
            phoneNumber = sc.nextLine();
        }
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    // validate phone number
    public static boolean isValidPhone(String phoneNumber) {
        String regex = "^\\+?0\\d{10}$"; // Regular expression for Egyptian phone numbers

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
