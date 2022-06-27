package op3.rentathing;

public class Truck extends Product{

    private Integer weight, payload;

    private Menu menu;

    //Constructor of class
    public Truck(String brand, String description, Integer weight, Integer payload) {
        super(brand, description, 0.10 * payload, 0.01 * weight, true);
        this.weight = weight;
        this.payload = payload;
    }

    //Override createProduct() based on class Truck
    @Override
    public Truck createProduct() {
        return new Truck(menu.askBrand(), menu.askDescription(), menu.askWeight(), menu.askPayload());
    }

}
