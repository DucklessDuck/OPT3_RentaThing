package op3.rentathing;

public abstract class Product {

    //Variables that are saved in Object "Product"
    private  int productId = 0;
    private String brand, category;
    private Long description;
    private Double rent, insurancePerDay;;
    private Boolean availability;

    ProductList productList;

    //Constructor of Product
    public Product(int productId, String brand, String category, Long description, Double rent, Double insurancePerDay, Boolean availability){
        this.productId = productId++;
        this.brand = brand;
        this.category = category;
        this.description = description;
        this.rent = rent;
        this.insurancePerDay = insurancePerDay;
        this.availability = availability;
    }

    //Creates a new object product based on variables passengerCar (Using the factory method pattern).
    public abstract Product createProduct(int productId, String brand, String category, Long description);

    public int getId(){
        return productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getDescription() {
        return description;
    }

    public void setDescription(Long description) {
        this.description = description;
    }

    public Double getRent() {
        return rent;
    }
    public void setRent(Double rent) {
        this.rent = rent;
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
    }


}
