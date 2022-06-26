package op3.rentathing;

public class PassengerCar extends Product {
    private Integer weight;

    //Constructor of class
    public PassengerCar(String brand, String description, Integer weight) {
        super(brand, description, 50.0, weight * 0.01, true);
        this.weight = weight;
    }

    //Override createProduct() based on class PassengerCar
    @Override
    public Product createProduct(String brand, String description){
       Integer weight = Menu.askWeight();
       return new PassengerCar(brand, description, weight);
    }


    //Getters and setters for modifying data and data gathering
    @Override
    public Double getRent() {
        return super.getRent();
    }

    @Override
    public Double getInsurancePerDay() {
        return super.getInsurancePerDay();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight){
       this.weight = weight;
    }

    //Extra method for Insurance since it is based on weight of the car
    public Double calculateInsurance(Integer weight){
        return weight * 0.01;
    }

}
