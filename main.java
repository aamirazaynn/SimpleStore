import java.io.IOException;
import java.util.Scanner;

public class Main{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        User x = new User();
        int input;
        String email, password, name, phoneNumber;

        boolean exist = false;
        Login y = new Login();
        System.out.println("Welcome to our store TOFFEE <3\n"
                            + "What do you want to do today?\n"
                            + "1.Register\n2.Login\n3.View catalog\n4.Exit");
        input = sc.nextInt();
        while(!exist) {
            switch (input) {
                case 1:
                    System.out.print("Enter your email: ");
                    email = sc.next();
                    System.out.print("Enter your password: ");
                    password = sc.next();
                    x.register(email, password);
                    System.out.println("What else you wanna do? ");
                    input = sc.nextInt();
                    break;
                case 2:
                    System.out.print("Enter your email: ");
                    email = sc.next();
                    System.out.print("Enter your password: ");
                    password = sc.next();
                    y = x.login(email, password);
                    System.out.println("What else you wanna do? ");
                    input = sc.nextInt();
                    break;
                case 3:
                    if (y.getIsLoggedIn()) {
                    Catalog z = new Catalog();
                    z.viewCatalog();
                        System.out.println("What else you wanna do? ");
                        input = sc.nextInt();
                    break;
                    }
                    else {
                        System.out.println("You are not logged in");
                        System.out.println("What else you wanna do? ");
                        input = sc.nextInt();
                        break;
                    }
                case 4:
                    System.out.println("See you next time ;)");
                    exist = true;
                    break;
            }

        }
    }
}