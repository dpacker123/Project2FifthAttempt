package comp.comp152;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Store {
    private ArrayList<Customer> Customers;
    private ArrayList<Order> Orders;

    public Store(){
        Customers = new ArrayList<Customer>();
        Orders = new ArrayList<Order>();


    }
    public void runStore(){
        System.out.println(Customers);
        var userInput = new Scanner(System.in);                             // creates scanner for user input
        while(true){
            Menu();                                                         //prompts the visual menu for the user
            var userChoice = userInput.nextInt();                      // saves user response as an integer
            switch (userChoice){
                case 1:
                    addCustomer(userInput);
                case 2:
                    selectCustomer(userInput);
                    break;
                case 3:
                    ManageCustomer();
                case 4:
                    userInput.nextLine();                                  //needed to eat previous input
                    System.exit(4);
            }
        }
    }

    private void ManageCustomer() {
        var userInput = new Scanner(System.in);                            // Creates Scanner for user input allowing
        while(true){                                                       // user to interact
            SecondMenu();
            var userChoice = userInput.nextInt();
            switch (userChoice){
                case 1:
                    addAddress(userInput);
                case 2:
                    makeOrder(userInput);
                case 3:
                    Menu();
                    userInput.nextInt();                                    // eats user input
                    break;
            }
        }
    }

    private void makeOrder(Scanner userInput) {
        userInput.nextLine(); // eats previous user input
        System.out.println("Please place a new order");
        var newOrder = userInput.nextLine();
        var newORD = new ArrayList<Order>();
        System.out.println("Thank you for placing the order of " +newOrder);
        subMenu();
    }

    private void addAddress(Scanner userInput) {
        userInput.nextLine();                                                 // eats previous input
        System.out.println("Please enter the address you would like to add");
        var newAddress = userInput.nextLine();
        System.out.println("Please enter the city");
        var newCity = userInput.nextLine();                            // Saves user input to each part of
        System.out.println("Please enter the state");                         // Shipping Address
        var newState = userInput.nextLine();
        System.out.println("Please enter the zip code");
        var newZipCode = userInput.nextLine();
        ShippingAddress newAdd = new ShippingAddress(newAddress, null, newCity, newState, newZipCode); // Adds user input to a new shipping address
        System.out.println("Thanky you for adding " +newAddress+ "," + newCity+ " " + newState + "," +newZipCode +" to our shipping address");
        subMenu();
    }

    private void SecondMenu() {                                               // This menu is prompted when the user
        System.out.println("=============================================");  // selects manage customer
        System.out.println("Please select one of the following choices:");
        System.out.println("      [1] Add an Address");
        System.out.println("      [2] Make an Order");
        System.out.println("      [3] Go Back");
        System.out.println("=============================================");
    }

    private void selectCustomer(Scanner userInput) {
        userInput.nextLine();                                     // eats previous call for next int
        System.out.println("Please type the name of the Customer you would like the Customer ID for");
        var selectCust = userInput.nextLine();             //saves user input as a string
        for (Customer cust : Customers) {
            var customerNames = cust.getName();            // This is supposed to get the list of customer names
            System.out.println("" + customerNames);               // This doesn't quite work, but I'm not sure why :(
            if (customerNames.contains(selectCust)) {
                System.out.println("Yes! we do have " + selectCust + " in our System");
                subMenu();                                        // Simple if statement that checks user input
            }                                                     // against the "getName()" list in customer
            else {
                System.out.println("I'm sorry but we do not have " + selectCust + " in our System");
                subMenu();
            }
        }
    }


    public void addCustomer(Scanner userInput) {
        userInput.nextLine();                                       // eats \n from previous call
        System.out.println("Please type the name of the customer you would like to add");
        var newCustomer = userInput.nextLine();
        var cust = new ArrayList<Customer>();
        var numberpicker = new Random();
        var pick = numberpicker.nextInt();                     // randomly generates a number for the customerID
        cust.add(new Customer(newCustomer, pick));                  // adds new customer to the Customer array list
        System.out.println("Thank you for adding " +newCustomer + " to the list.");
        System.out.println(""+newCustomer+ "'s customer ID is:  " +pick);
        subMenu();                                                  // Fluff I added to make the program feel better
    }
    private void subMenu(){                                         // Little sub menu I created which allows
        var userInput = new Scanner(System.in);                     // the user to either return to the main menu
        System.out.println("Would you like to exit?");              // or exit the program
        System.out.println("     [1] No");
        System.out.println("     [2] Yes");
        while(true){
            var userChoice = userInput.nextInt();
            switch (userChoice){
                case 1:
                    Menu();
                case 2:
                    System.exit(2);                            // Not quite sure how the exit program works
            }                                                        // in regards to the "status"
        }
    }


    private void Menu() {                                            // Basic menu, very easy
        System.out.println("=============================================");
        System.out.println("      [1] Add a new Customer");
        System.out.println("      [2] Select a Customer");
        System.out.println("      [3] Manage a Customer");
        System.out.println("      [4[ Exit the program");
        System.out.println("=============================================");
    }



    public static void main(String[] args) {                           // runs the store :)
        new Customer("John", 123);
        new Customer("Jared", 456);                  // I cannot for the life of me get the
        new Customer("Jordan", 789);                 // Customer.txt file to work so I did this
        Store store = new Store();
        store.runStore();
    }
}
