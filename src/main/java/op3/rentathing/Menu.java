package op3.rentathing;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    private ProductList productList;
    private Drill drill;
    private PassengerCar car;
    private Truck truck;
    UserList users;
    User user;

    public Menu(){
        this.users = new UserList();
        this.productList = new ProductList();
    }

    //Asks for credentials and gives to method logIn();
    public void askLogin(){
        String givenUsername = getUsername();
        try {
            user = users.getUser(givenUsername);
        }catch(NullPointerException e){
            System.out.println("User not found. ");
            askLogin();
        }
        try {
            System.out.println("Enter password: ");
            String givenPassword = scanner.nextLine();
            logIn(user, givenUsername, givenPassword);
        }catch(NullPointerException e){
            System.out.println("Wrong password. ");
            askLogin();
        }
    }

    public void logIn(User user, String username, String password){

        if(username.equalsIgnoreCase(user.getUsername())){
            if (password.equals((user.getPassword()))){
                menu(user);
            }
            else{
                System.out.println("Incorrect Password. ");
            }
        }
        else{
            System.out.println("Incorrect Username. ");
        }
        System.out.println("User not found. ");
    }

    //Prints menu when user found and given correct credentials
    private void logOut(){
        askLogin();
    }

    public int getChoice(){
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    //Backend of main menu
    public void menu(User user){
        boolean loop = true;
        try{
            while(loop){
                System.out.println(user.getUsername());
                printMainMenu();
                switch (getChoice()){
                    case 0:
                        logOut();
                    case 1:
                        System.out.println(user.getUsername());
                        printProducts();
                        askProductDetails();
                    case 2:
                        System.out.println(user.getUsername());
                        manageProduct(user);
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
        int choice;
        System.out.println( """
                    Categories: 
                    1. Drill
                    2. Passenger Car
                    3. Truck
                    """);
        try{
            System.out.println("Choose category or exit with number 0");
            return getChoice();

        }catch(InputMismatchException e){
            System.out.println("Invalid input, try again. ");
        }
        return getChoice();
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

    public void manageProduct(User user){
        int id = 0;
        System.out.println("Enter number of edit option or exit with 0: ");
        int choiceEdit = getEditManage();
        int choiceCategory;
       switch(choiceEdit) {
           case 1:
               choiceCategory = getCategoryChoice();
               switch (choiceCategory) {
                   case 0:
                       menu(user);
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
                   menu(user);
               }
       }
    }

    //Prints all products
    public void printProducts(){
        ArrayList<Product> allProducts = productList.getAllProducts();
        int i = 0;
        for(Product product : allProducts){
            System.out.println(i + ". " + product.getBrand() + "  Available: "  + product.getAvailability());
            i++;
        }
        askProductDetails();
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

    public void printUsers(){
        int i = 1;
        for (User user : users.getUserList()){
            i++;
            System.out.println( i + ". " + user.getUsername());
        }
    }

    public void askProductDetails(){
        try {
            System.out.println("Enter number to view details or number 0 to exit: ");
            int choiceNumber = getChoice();
            if(choiceNumber != 0){
                printProductDetails(productList.getProductById(choiceNumber));
                System.out.println(" ");
                System.out.println("Go back? Press enter");
                printProducts();
            }
            else {
                menu(user);
            }


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

    public String getUsername(){
        printUsers();
        System.out.println("Enter username: ");
        return scanner.nextLine();
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
