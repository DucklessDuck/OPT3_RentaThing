package op3.rentathing;

import java.util.Scanner;

public class Drill extends Product{

    private String type;


    //Constructor of class
    public Drill(String brand, String description, String type) {
        super(brand, description, 5.0, 1.0,  true);
        this.type = type;
    }

    //Creates a new object product based on variables drill (part of the factory method pattern)
    @Override
    public Drill createProduct(String brand, String description){
        String type = Menu.askType();
        return new Drill(brand, description, type);
    }

    //Getters and setters for modifying and information gathering
    public String getType() {
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
}
