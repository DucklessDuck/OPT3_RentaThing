package op3.rentathing;

import java.util.Scanner;

public class Drill extends Product{

    private String type;


    //Constructor of class
    public Drill(int productId, String brand, String category, Long description, Double rent, Double insurancePerDay, Boolean availability, String type) {
        super(productId, brand, category, description, rent, insurancePerDay, availability);
        this.type = type;
    }

    //Creates a new object product based on variables drill (part of the factory method pattern)
    @Override
    public Drill createProduct(int productId, String brand, String category, Long description){
        String type = productList.askType();
        return new Drill(productId, brand, category, description, getRent(), getInsurancePerDay(), true, type);
    }

    //Getters and setters for modifying and information gathering
    @Override
    public Double getRent() {
        return 5.0;
    }

    @Override
    public Double getInsurancePerDay() {
        return 1.0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
}
