import java.io.IOException;

public class main{
    public static void main(String[] args) throws IOException {
        // Registration user1 = new Registration("amira@gmail.com", "Am!ra123");
        // user1.saveData();
        // Registration user2 = new Registration("yehia@gmail.com", "Yeh!a123");
        // user2.saveData();

        Customer customer = new Customer();
        customer.login("yehia@gmail.com", "Yeh!a123");
    }
}