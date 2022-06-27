package op3.rentathing;

import java.util.ArrayList;

public abstract class Product implements Subject{

    //Variables that are saved in Object "Product"
    private static int productId = 0;
    private String brand, description;
    private Double rent, insurancePerDay;;
    private Boolean availability;
    private ArrayList<Observer> observers;

    ProductList productList;

    //Constructor of Product
    public Product(String brand, String description, Double rent, Double insurancePerDay, Boolean availability){
        this.productId = createUniqueId();
        this.brand = brand;
        this.description = description;
        this.rent = rent;
        this.insurancePerDay = insurancePerDay;
        this.availability = availability;
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer){
        observers.add(observer);
    }
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    public void notifyObserver(){
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).update(this.availability);
        }
    }

    //Creates a new object product based on variables passengerCar (Using the factory method pattern).
    public abstract Product createProduct();

    public int createUniqueId(){
        return productId++;
    }

    public int getId(){
        return productId;
    }

    public String getBrand() {
        return brand;
    }

    public Product getProduct(){
        return this;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }


    public Double getRent() {
        return rent;
    }

    public Double getInsurancePerDay() {
        return insurancePerDay;
    }

    public void setInsurancePerDay(Double insurancePerDay) {
        this.insurancePerDay = insurancePerDay;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
        notifyObserver();
    }


}
