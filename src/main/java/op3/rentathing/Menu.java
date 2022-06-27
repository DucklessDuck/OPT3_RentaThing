package op3.rentathing;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Scanner scanner;
    private User user;
    private ProductList productList;
    private Drill drill;
    private PassengerCar car;
    private Truck truck;
    public Menu(User user){
        this.user = user;
    }

    //Asks for credentials and gives to method logIn();
    private void askLogin(){
        new Scanner(System.in);
        System.out.println("Enter username: ");
        String givenUsername = scanner.nextLine();
        System.out.println("Enter password: ");
        String givenPassword = scanner.nextLine();

        logIn(givenUsername, givenPassword);
    }


    //Prints menu when user found and given correct credentials
    private void logIn(String username, String password){
        for(User user : user.users){
            if(username.equals(user.getUsername())){
                if (password.equals((user.getPassword()))){
                    menu();
                }
                else{
                    System.out.println("Incorrect Password. ");
                }
            }
            else{
                System.out.println("Incorrect Username. ");
            }
        }
        System.out.println("User not found. ");
    }

    private void logOut(){
        askLogin();
    }

    public int getChoice(){
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    //Backend of main menu
    public void menu(){
        boolean loop = true;
        try{
            while(loop){
                user.getUsername();
                printMainMenu();
                switch (getChoice()){
                    case 0:
                        logOut();
                    case 1:
                        user.getUsername();
                        printProducts();
                        askProductDetails();
                        menu();
                    case 2:
                        user.getUsername();
                        int choiceCategory = getCategoryChoice();
                        int choiceEdit = getEditManage();
                        manageProduct(choiceCategory, choiceEdit);
                }
            }
        } catch (InputMismatchException e){
            System.out.println("Invalid try again. ");
        }
    }

    //Prints main menu
    public void printMainMenu(){
        System.out.println( """
                    1. Overview
                    2. Manage(Employees Only)
                    0. Logout
                    """);
    }

    //Prints manage menu
    public int getCategoryChoice(){
        int choice = 0;
        System.out.println("Choose category or exit with number 0");
        System.out.println( """
                    Categories: 
                    1. Drill
                    2. Passenger Car
                    3. Truck
                    """);
        try{
            choice = getChoice();

        }catch(InputMismatchException e){
            System.out.println("Invalid input, try again. ");
        }
        return choice;
    }

    public int getEditManage(){
        int choice = 0;
        System.out.println( """
                    Edit
                    1. Add
                    2. Remove
                    3. Edit variables
                    """);
        try{
            choice = getChoice();

        }catch(InputMismatchException e){
            System.out.println("Invalid input, try again. ");
        }
        return choice;
    }

    public void manageProduct(int choiceCategory, int choiceEdit){
        int id = 0;

       switch(choiceEdit) {
           case 1:
               System.out.println("Add product");
               switch (choiceCategory) {
                   case 0:
                       menu();
                   case 1:
                       productList.addProductToList(drill.createProduct());
                   case 2:
                       productList.addProductToList(car.createProduct());
                   case 3:
                       productList.addProductToList(truck.createProduct());
               }

           case 2:
               System.out.println("Remove product ");
               printProducts();
               System.out.println("Enter productID to remove product: ");
               id = scanner.nextInt();
               productList.removeProductFromList(productList.getProductById(id));

           case 3:
               System.out.println("Edit product ");
               printProducts();
               System.out.println("Enter productID to edit product: ");
               id = scanner.nextInt();
               printProductDetails(productList.getProductById(id));

               printDetailEditMenu();
               int choice = getChoice();
               switch(choice){
                   case 1:
                       System.out.println("Enter new brand name: ");
                       String newBrand = scanner.nextLine();
                       productList.getProductById(id).setBrand(newBrand);

                   case 2:
                       System.out.println("Enter new description: ");
                       String newDescription = scanner.nextLine();
                       productList.getProductById(id).setBrand(newDescription);
               }
           case 4:
               System.out.println("Get notification when product available ");
               if(askNotify()){
                   productList.getProductById(id).registerObserver((Observer)user);
               }
               else {
                   menu();
               }

       }

    }

    //Prints all products
    public void printProducts(){
        for(Product product : productList.getAllProducts()){
            System.out.println(product.getId() + ". " + product.getBrand() + "Available: "  + product.getAvailability());
            askProductDetails();
        }
    }

    public void printProductDetails(Product product){
        System.out.println("ID: " + product.getId());
        System.out.println("Brand: " + product.getBrand());
        System.out.println("Description: " + product.getDescription());
        System.out.println("Rent per day: " + product.getRent());
        System.out.println("Insurance per day: " + product.getInsurancePerDay());
        System.out.println("Available: " + product.getAvailability());
    }

    public void printDetailEditMenu(){
        System.out.println( """
                    Edit
                    1. Edit brand
                    2. Edit description
                    """);
    }

    public void askProductDetails(){
        try {
            System.out.println("Enter number to view details or number 0 to exit: ");
            int choiceNumber = getChoice();
            printProductDetails(productList.getProductById(choiceNumber));
        }catch(InputMismatchException e){
            System.out.println("Invalid try again: ");
        }
    }

    public Boolean askNotify(){
        System.out.println("Want to get notified when product is available? ");
        System.out.println("Y/N? ");
        String choice = scanner.nextLine();
        if(choice.equals("Y")){
            return true;
        }
        else{
            return false;
        }
    }

    public String askBrand(){
        System.out.println("Enter brandname: ");
        return scanner.nextLine();
    }

    public String askDescription(){
        System.out.println("Enter description: ");
        return scanner.nextLine();
    }

    public String askType(){
        System.out.println("Enter type of product: ");
        return scanner.nextLine();
    }

    public Integer askWeight(){
        System.out.println("Enter weight of vehicle: ");
        return scanner.nextInt();
    }

    public Integer askPayload(){
        System.out.println("Enter weight of payload: ");
        return scanner.nextInt();
    }


}
