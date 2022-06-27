package op3.rentathing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static java.time.temporal.ChronoUnit.DAYS;

public class Renter implements Observer{
    private Product product;
    private User user;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private ArrayList<Renter> rentList;

    public Renter(User user, Product product){
        this.user = user;
        this.product = product;
        startDate = LocalDateTime.now();
        endDate = null;
        rentList = new ArrayList<>();
    }

    public void update(Boolean availability){
        if(availability){
            System.out.println("Product now available! ");
        }
        else {
            System.out.println("Product not available. ");
        }
    }

    //Returns object of class Product
    public Product getProduct(){
        return product;
    }

    //Sets end date of rent
    public void setEndDate(){
        endDate = LocalDateTime.now();
    }

    //Returns list of rented products
    public ArrayList<Product> getRentedProductList(){
        ArrayList<Product> rentedProducts = new ArrayList<>();
        for(Renter rent : rentList){
            rentedProducts.add(rent.getProduct());
        }
        return rentedProducts;
    }

    //Adds product to rentList
    public void rentProduct(User user, Product product){
        rentList.add(new Renter(user, product));
    }

    //Sets date on endDate to compare with startDate to be able to calculate rent
    public void stopRent(Renter recordedRent){
       recordedRent.setEndDate();
    }

    //Returns calculated rent
    public Double calculateRent(Product product){
        Long daysRented = DAYS.between(startDate, endDate);
        return daysRented * product.getRent();
    }

}

