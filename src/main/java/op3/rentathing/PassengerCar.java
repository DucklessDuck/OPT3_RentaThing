package op3.rentathing;

public class PassengerCar extends Product {
    private Integer weight;

    //Constructor of class
    public PassengerCar(int id, String brand, String category, Long description, Double rent, Double insurancePerDay, Boolean availability, Integer weight) {
        super(id, brand, category, description, rent, insurancePerDay, availability);
        this.weight = weight;
    }

    //Override createProduct() based on class PassengerCar
    @Override
    public Product createProduct(int id, String brand, String category, Long description){
       Integer weight = productList.askWeight();
       return new PassengerCar(id, brand, category, description, getRent(), calculateInsurance(weight), true, weight);
    }


    //Getters and setters for modifying data and data gathering
    @Override
    public Double getRent() {
        return 50.0;
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
