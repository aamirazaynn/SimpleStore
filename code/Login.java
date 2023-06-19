import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *  this class is used to login into the system
 */
public class Login {
    // instance variables
    private String email;
    private String password;
    private boolean isLoggedIn = false;

    // constructor
    public Login() {
        this.email = "";
        this.password = "";
    }

    // setters
    /**
     *  this method is used to set the email
     * @param e
     */
    public void setEmail(String e) {
        this.email = e;
    }

    /**
     *  this method is used to set the password
     * @param p
     */
    public void setPassword(String p) {
        this.password = p;
    }

    // getters

    /**
     *  this method is used to get the email
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     *  this method is used to get the password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     *  this method is used to check if the user is logged in
     * @return true if the user is logged in, false otherwise
     */
    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    /**
     *  this method is used to login into the system
     * @param e
     * @param p
     * @throws IOException
     */
    public void confirmLogin(String e, String p) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("registrationData.txt"));
        String line, word1 = "", word2 = "", word3 = "";

        // read file content
        while ((line = reader.readLine()) != null) {
            // search for email and password
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ' ') {
                    word1 = line.substring(0, i);
                    for (int j = i+1; j < line.length(); j++) {
                        if (line.charAt(j) == ' ') {
                            word2 = line.substring(i + 1, j);
                            word3 = line.substring(j + 1, line.length());
                        }
                    }
                    break;
                }
            }

            // compare email and password
            if ((e.equals(word1)) && (p.equals(word2))) {
                this.email = e;
                this.password = p;
                System.out.println("Login successful! , Welcome "+ word3 +":)");
                isLoggedIn = true;
                break;
            }
        }
        reader.close();

        if(!isLoggedIn) {
            System.out.println("Login Failed!");
        }
    }
}