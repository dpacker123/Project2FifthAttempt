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
        var userInput = new Scanner(System.in); // creates scanner for user input
        while(true){
            Menu();   //prompts the visual menu for the user
            var userChoice = userInput.nextInt(); // saves user response as an integer
            switch (userChoice){
                case 1:
                    addCustomer(userInput);
                case 2:
                    selectCustomer(userInput);
                    break;
                case 3:
                    ManageCustomer();
                case 4:
                    userInput.nextLine(); //needed to eat previous input
                    System.exit(4);
            }
        }
    }

    private void ManageCustomer() {
        var userInput = new Scanner(System.in); // Creates Scanner for user input allowing user to interact
        while(true){
            SecondMenu();
            var userChoice = userInput.nextInt();
            switch (userChoice){
                case 1:
                    addAddress(userInput);
                case 2:
                    makeOrder(userInput);
                case 3:
                    Menu();
                    userInput.nextInt(); //eats user input
                    break;
            }
        }
    }

    private void makeOrder(Scanner userInput) {
        System.out.println("Place Holder");
    }

    private void addAddress(Scanner userInput) {
        System.out.println("place Holder");
    }

    private void SecondMenu() {
        System.out.println("=============================================");
        System.out.println("Please select one of the following choices:");
        System.out.println("      [1] Add an Address");
        System.out.println("      [2] Make an Order");
        System.out.println("      [3] Go Back");
        System.out.println("=============================================");
    }



    private void selectCustomer(Scanner userInput) {
        userInput.nextLine(); //                      eats previous call for next int
        System.out.println("Please type the name of the Customer you would like the Customer ID for");
        var selectCust = userInput.nextLine();//saves user input as a string
        for(Customer cust : Customers){
            var customerNames = cust.getName();
            System.out.println("" +customerNames);
            if(customerNames.contains(selectCust)){
                System.out.println("Yes! we do have " +selectCust +" in our System");
                subMenu();
            }
            else{
                System.out.println("I'm sorry but we do not have " +selectCust + " in our System");
                subMenu();
            }

        }


    }


    public void addCustomer(Scanner userInput) {
        userInput.nextLine(); //                    eats \n from previous call
        System.out.println("Please type the name of the customer you would like to add");
        var newCustomer = userInput.nextLine();
        var cust = new ArrayList<Customer>();
        var numberpicker = new Random();
        var pick = numberpicker.nextInt(); // randomly generates a number for the customerID
        cust.add(new Customer(newCustomer, pick));// adds new customer to the Customer array list
        System.out.println("Thank you for adding " +newCustomer + " to the list.");
        System.out.println(""+newCustomer+ "'s customer ID is:  " +pick);
        subMenu(); // Fluff I added to make the program feel better




    }
    private void subMenu(){ // Little sub menu I created which allows the user to either return to the main menu or exit the program
        var userInput = new Scanner(System.in);
        System.out.println("Would you like to exit?");
        System.out.println("     [1] No");
        System.out.println("     [2] Yes");
        while(true){
            var userChoice = userInput.nextInt();
            switch (userChoice){
                case 1:
                    Menu();
                case 2:
                    System.exit(2);
            }

        }
    }


    private void Menu() {
        System.out.println("=============================================");
        System.out.println("      [1] Add a new Customer");
        System.out.println("      [2] Select a Customer");
        System.out.println("      [3] Manage a Customer");
        System.out.println("      [4[ Exit the program");
        System.out.println("=============================================");
    }



    public static void main(String[] args) { // runs the store :)
        new Customer("John", 123);
        new Customer("Jared", 456); // I cannot for the life of me get the Customer.txt file to work
        new Customer("Jordan", 789);
        Store store = new Store();
        store.runStore();



    }
}
