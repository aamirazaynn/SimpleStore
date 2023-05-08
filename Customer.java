import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Customer {
    // instance variables
    private String address;
    private String phone;
    private String email;
    private String password;
    private boolean isLoggedIn = false;

    // constructor
    public Customer() {

    }

    // getters
    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    // setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // register user
    public void register() {

    }

    // login user
    public void login(String e, String p) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("registrationData.txt"));
        String line, word1 = "", word2 = "";

        // read file content
        while ((line = reader.readLine()) != null) {
            // search for email and password
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ' ') {
                    word1 = line.substring(0, i);
                    word2 = line.substring(i + 1, line.length());
                    break;
                }
            }
            
            // compare email and password
            if ((e.equals(word1)) && (p.equals(word2))) {
                this.email = e;
                this.password = p;
                System.out.println("Login successful!");
                isLoggedIn = true;
                break;
            }
        }
        reader.close();
        
        // compare email and password
        if (!e.equals(word1) && !p.equals(word2)) {
            System.out.println("Wrong email or password!");
        } else if (!e.equals(word1) && p.equals(word2)) {
            System.out.println("Wrong email!");
        } else if (e.equals(word1) && !p.equals(word2)) {
            System.out.println("Wrong password!");
        }
    }
}
