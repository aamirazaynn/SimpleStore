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
                            + "What do you want to do todat?\n"
                            + "1. Register\n2.Login\n3.View catalog\n4.Exit\n");
        input = sc.nextInt();
        while(!exist) {
            switch (input) {
                case 1:
                    System.out.print("Enter your email: ");
                    email = sc.next();
                    System.out.print("Enter your password: ");
                    password = sc.next();
                    x.register(email, password);
                    break;
                case 2:
                    System.out.print("Enter your email: ");
                    email = sc.next();
                    System.out.print("Enter your password: ");
                    password = sc.next();
                    y = x.login(email, password);
                    break;
                case 3:
                    Category z = new Category();
                    z.ViewItems();
                    break;
                case 4:
                    System.out.println("See you next time ;)");
                    exist = true;
                    break;
            }
            System.out.println("What else you wanna do? ");
            input = sc.nextInt();
        }
    }
}