package op3.rentathing;

public class PassengerCar extends Product {
    private Integer weight;
    private Menu menu;

    //Constructor of class
    public PassengerCar(String brand, String description, Integer weight) {
        super(brand, description, 50.0, weight * 0.01, true);
        this.weight = weight;
    }

    //Override createProduct() based on class PassengerCar
    @Override
    public Product createProduct(){
       return new PassengerCar(menu.askBrand(), menu.askDescription(), menu.askWeight());
    }


    //Getters and setters for modifying data and data gathering
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
