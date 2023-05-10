import java.io.IOException;
import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String email, password, name;
        User user = new User();
        Login loggedin = new Login();
        Catalog catalog = new Catalog();
        ShoppingCart cart = new ShoppingCart();
        int firstInput, secondInput;
        boolean exist = false;

        System.out.println("Welcome to our store TOFFEE <3\n"
                + "What do you want to do today?\n"
                + "1. Register\n2. Login\n3. View catalog\n4. Order options\n5. Exit");
        firstInput = sc.nextInt();

        while (!exist) {
            switch (firstInput) {
                case 1:
                    System.out.print("Enter your email: ");
                    email = sc.next();
                    System.out.print("Enter your password: ");
                    password = sc.next();
                    System.out.print("Enter your name: ");
                    name = sc.next();
                    user.register(email, password, name);
                    System.out.println("What else you wanna do? ");
                    firstInput = sc.nextInt();
                    break;

                case 2:
                    if (!loggedin.getIsLoggedIn()) {
                        System.out.print("Enter your email: ");
                        email = sc.next();
                        System.out.print("Enter your password: ");
                        password = sc.next();
                        loggedin = user.login(email, password);
                    } else {
                        System.out.println("You are already logged in!\n");
                    }
                    System.out.println("What else you wanna do? ");
                    firstInput = sc.nextInt();
                    break;

                case 3:
                    catalog.viewCatalog();
                    System.out.println("\nWhat else you wanna do? ");
                    firstInput = sc.nextInt();
                    break;

                case 4:
                    if (loggedin.getIsLoggedIn()) {
                        System.out.println(
                                "1. View shoppingcart\n2. Add item to shoppingcart\n3. Remove item from shoppingcart\n"
                                        + "4. Change quantity of item\n5. Checkout your order\n");
                        secondInput = sc.nextInt();
                        switch (secondInput) {
                            case 1:
                                cart.viewCart();
                                break;
                            case 2:
                                System.out.print("\nEnter the number of the item you want to add to the cart? ");
                                int index = sc.nextInt();
                                System.out.print("How many do you want to add? ");
                                int quantity = sc.nextInt();
                                cart.addItem(catalog.getItem(index), quantity);
                                break;
                            case 3:
                                System.out.print("\nEnter the number of the item you want to remove from the cart? ");
                                index = sc.nextInt();
                                cart.removeItem(catalog.getItem(index));
                                break;
                            case 4:
                                System.out.print("\nEnter the number of the item you want to change the quantity of? ");
                                index = sc.nextInt();
                                System.out.print("Enter the new quentity: ");
                                quantity = sc.nextInt();
                                cart.changeQuantity(catalog.getItem(index), quantity);
                                break;
                            case 5:
                                break;
                        }
                    } else {
                        System.out.println("You are not logged in, please login first\n");
                    }
                    System.out.println("What else you wanna do? ");
                    firstInput = sc.nextInt();
                    break;
                case 5:
                    System.out.println("See you next time ;)");
                    exist = true;
                    break;
            }
        }
    }
}