import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *  this class is for logged in user
 */
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
    /**
     *  this method returns name of logged in user
     * @return name of logged in user
     */
    public String getName() {
        return name;
    }

    /**
     *  this method returns phone number of logged in user
     * @return phone number of logged in user
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // setters

    /**
     *  this method sets name of logged in user
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *  this method sets phone number of logged in user
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        Scanner sc = new Scanner(System.in);
        while (!isValidPhone(phoneNumber)) {
            System.out.println("Phone number is invalid");
            System.out.print("Enter correct phone number: ");
            phoneNumber = sc.nextLine();
        }
        this.phoneNumber = phoneNumber;
    }

    /**
     *  this method sets email of logged in user
     * @param e
     */
    public void setEmail(String e) {
        this.email = e;
    }

    /**
     *  this method sets password of logged in user
     * @param p
     */
    public void setPassword(String p) {
        this.password = p;
    }

    /**
     *  this method validates phone number
     * @param phoneNumber
     * @return
     */
    // validate phone number
    public static boolean isValidPhone(String phoneNumber) {
        String regex = "^\\+?0\\d{10}$"; // Regular expression for Egyptian phone numbers

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
