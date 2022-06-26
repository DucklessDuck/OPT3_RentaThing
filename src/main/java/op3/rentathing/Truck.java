package op3.rentathing;

public class Truck extends Product{

    private Integer weight, payload;

    //Constructor of class
    public Truck(String brand, String description, Integer weight, Integer payload) {
        super(brand, description, 0.10 * payload, 0.01 * weight, true);
        this.weight = weight;
        this.payload = payload;
    }

    //Override createProduct() based on class Truck
    @Override
    public Truck createProduct(String brand, String description) {
        Integer weight = Menu.askWeight();
        Integer payload = Menu.askPayload();
        return new Truck(brand, description, weight, payload);
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

    public void setPayload(Integer payload){
        this.payload = payload;
    }

    //Extra method for Insurance since it is based on weight of truck itself
    public Double calculateInsurance(Integer weight){
        return weight * 0.01;
    }
    //Extra method for rent since it is based on weight of payload
    public Double calculateRent(Integer payload){
        return payload * 0.10;
    }

}
