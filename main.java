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
                    System.out.print("\nEnter your email: ");
                    email = sc.next();
                    System.out.print("Enter your password: ");
                    password = sc.next();
                    System.out.print("Enter your name: ");
                    name = sc.next();
                    user.register(email, password, name);
                    System.out.println("\n\n1. Register\n2. Login\n3. View catalog\n4. Order options\n5. Exit");
                    System.out.print("What else you wanna do? ");
                    firstInput = sc.nextInt();
                    break;

                case 2:
                    if (!loggedin.getIsLoggedIn()) {
                        System.out.print("\nEnter your email: ");
                        email = sc.next();
                        System.out.print("Enter your password: ");
                        password = sc.next();
                        loggedin = user.login(email, password);
                    } else {
                        System.out.println("\nYou are already logged in!");
                    }
                    System.out.println("\n\n1. Register\n2. Login\n3. View catalog\n4. Order options\n5. Exit");
                    System.out.print("What else you wanna do? ");
                    firstInput = sc.nextInt();
                    break;

                case 3:
                    catalog.viewCatalog();
                    System.out.println("\n\n1. Register\n2. Login\n3. View catalog\n4. Order options\n5. Exit");
                    System.out.print("\nWhat else you wanna do? ");
                    firstInput = sc.nextInt();
                    break;

                case 4:
                    if (loggedin.getIsLoggedIn()) {
                        System.out.println(
                                "\n1. View shoppingcart\n2. Add item to shoppingcart\n3. Remove item from shoppingcart\n"
                                        + "4. Change quantity of item\n5. Checkout your order");
                        secondInput = sc.nextInt();
                        switch (secondInput) {
                            case 1:
                                System.out.println("");
                                cart.viewCart();
                                break;
                            case 2:
                                catalog.viewCatalog();
                                System.out.print("\nEnter the number of the item you want to add to the cart? ");
                                int index = sc.nextInt();
                                if(catalog.validIndex(index)) {
                                    System.out.print("How many do you want to add? ");
                                    int quantity = sc.nextInt();
                                    cart.addItem(catalog.getItem(index), quantity);
                                }
                                break;
                            case 3:
                                catalog.viewCatalog();
                                cart.viewCart();
                                System.out.print("\nEnter the number of the item you want to remove from the cart? ");
                                index = sc.nextInt();
                                if(catalog.validIndex(index)) {
                                    cart.removeItem(catalog.getItem(index));
                                }
                                break;
                            case 4:
                                catalog.viewCatalog();
                                cart.viewCart();
                                System.out.print("\nEnter the number of the item you want to change the quantity of? ");
                                index = sc.nextInt();
                                if(catalog.validIndex(index)) {
                                    System.out.print("Enter the new quantity: ");
                                    int quantity = sc.nextInt();
                                    cart.changeQuantity(catalog.getItem(index), quantity);
                                }
                                break;
                            case 5:
                                System.out.print("\nEnter the address you want to send the order to: ");
                                String address = sc.next();
                                Order order = new Order(address, cart);
                                System.out.println(order.getOrderStatus());
                                System.out.println("to confirm the order, press 1");
                                String confirm = sc.next();
                                if (confirm == "1") {
                                    Payment payment = new Payment();
                                    payment.checkOut(order);
                                    System.out.println(order.getOrderStatus());
                                    System.out.println("Thank you for shopping with us <3\n");
                                } else {
                                    System.out.println("Failed to confirm the order, please try again :(");
                                }
                                
                                break;
                        }
                    } else {
                        System.out.println("You are not logged in, please login first\n");
                    }
                    System.out.println("\n\n1. Register\n2. Login\n3. View catalog\n4. Order options\n5. Exit");
                    System.out.print("What else you wanna do? ");
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