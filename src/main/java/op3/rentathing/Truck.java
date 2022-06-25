package op3.rentathing;

public class Truck extends Product{

    private Integer weight, payload;

    //Constructor of class
    public Truck(int productId, String brand, String category, Long description, Double rent, Double insurance, Boolean availability, Integer weight, Integer payload) {
        super(productId, brand, category, description, rent, insurance, availability);
        this.weight = weight;
        this.payload = payload;
    }

    //Override createProduct() based on class Truck
    @Override
    public Truck createProduct(int productId, String brand, String category, Long description) {
        Integer weight = askWeight();
        Integer payload = askPayload();
        return new Truck(productId, brand, category, description, calculateRent(payload), calculateInsurance(weight), true, weight, payload);
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
