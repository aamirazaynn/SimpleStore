import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    public void setEmail(String e) {
        this.email = e;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    // getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void login(String e, String p) throws IOException {
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
                System.out.println("Login successful! , Welcome "+word3 +":)");
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