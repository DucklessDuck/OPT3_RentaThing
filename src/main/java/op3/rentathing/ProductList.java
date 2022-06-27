package op3.rentathing;

import java.util.ArrayList;

public class ProductList {
    private Menu menu;
    private Product product;
    private static int productId = 1;
    //Using three lists to store from every category
    private ArrayList<Drill> drillList;
    private ArrayList<PassengerCar>passengerCarList;
    private ArrayList<Truck> truckList;

    public ProductList(){
        drillList =  new ArrayList<>();
        passengerCarList =  new ArrayList<>();
        truckList =  new ArrayList<>();
        addStandardItems();
    }

    //Adding a few items to every list
    public void addStandardItems(){
        //Adding drills to drillList
        drillList.add(new Drill("Bosch Traditional drill", "These drills or well-suited for drilling holes, installing small fasteners in wood or drywall, and other basic home projects."
                , "Traditional drill"));
        drillList.add(new Drill("DeWalt Impact Driver", "This type of drill is handy for bigger projects such as building fences, decks, and more."
                , "Impact Driver"));
        drillList.add(new Drill("Makita Hammer Drill", "The hammer drill is designed for heavy-duty yet everyday-type jobs. It’s a drill with a hefty hammer function."
                , "Hammer Drill"));

        //Adding cars to passengerCarList
        passengerCarList.add(new PassengerCar("Honda Civic Type-R 8th Generation", "Honda Type R models are special performance editions of their respective model families. The design of Type R models was originally focused on race conditions, with an emphasis on minimizing weight, and maximizing performance potential."
                , 1320));
        passengerCarList.add(new PassengerCar("BMW M4 Competition Coupé", "BMW M4 Competition is a 4 seater Coupe available at a price of ₹ 1.44 Crore. It is available in 1 variant, 2993 cc engine option and 1 transmission option : Automatic (TC). Other key specifications of the M4 Competition include a Ground Clearance of 120 mm, Kerb Weight of 1725 kg and Bootspace of 440 litres."
                , 1700));
        passengerCarList.add(new PassengerCar("Ford Mustang Mach 1", "The Ford Mustang Mach 1 is a performance-oriented option package of the Ford Mustang muscle car, originally introduced in August 1968 for the 1969 model year"
                , 1776));

        //Adding trucks to truckList
        truckList.add(new Truck("Volvo FH16", "The Volvo FH is a heavy truck range manufactured by the Swedish company Volvo Trucks. It was originally introduced in late 1993 as the FH12 and FH16. FH stands for Forward control High entry, where numbers denominate engine capacity in litres."
                , 25120, 34200));
        truckList.add(new Truck("MAN TGX 26.500", "The MAN TGX 26.500 has climate control and adaptive cruise control. Thanks to the parking heater you always keep the cabin at an ideal temperature. With 2 beds this vehicle is ideal for longer journeys. The digital tachograph registers the driving time and driving speed of the truck."
                , 19000, 23500));
        truckList.add(new Truck("Scania R950", "The new Scania V8 powertrain kickstarts an incredible driving experience. This is where amazing driveability co-exists with outstanding performance, increased uptime and fuel efficiency. By combining the updated engine range with an all-new Opticruise gearbox, fuel savings of up to 6% can be achieved."
                , 19000, 24000));
    }

    public int createUniqueId(){
        return productId++;
    }



    // Search id through every list to get exact product
    public Product getProductById(int id) {
        //Search through drillList
        for (Drill drill : drillList) {
            if (drill.getId() == id) {
                return drill;
            }
        }

        //Search through passengerCarList
        for (PassengerCar car : passengerCarList) {
            if (car.getId() == id) {
                return car;
            }
        }
        //Search through truckList
        for (Truck truck : truckList) {
            if (truck.getId() == id) {
                return truck;
            }
        }
        return null;
    }

    //Only return list of drills
    public ArrayList<Drill> getDrillList(){
        return drillList;
    }

    //Only return list of Passenger cars
    public ArrayList<PassengerCar> getPassengerCarList(){
        return passengerCarList;
    }

    //Only return list of trucks
    public ArrayList<Truck> getTruckList(){
        return truckList;
    }

    //Merge all product in all list and return that list
    public ArrayList<Product> getAllProducts(){
        ArrayList<Product> allProductList = new ArrayList<>();
        allProductList.addAll(getDrillList());
        allProductList.addAll(getPassengerCarList());
        allProductList.addAll(getTruckList());
        return allProductList;
    }

    //Check type before adding product to correct list
    public void addProductToList(Product product){
        if(product instanceof Drill){
            drillList.add((Drill)product);
        }
        if(product instanceof PassengerCar){
            passengerCarList.add((PassengerCar)product);
        }
        if(product instanceof Truck){
            truckList.add((Truck)product);
        }
    }

    //Check type of object before able to remove from one of the lists
    public void removeProductFromList(Product product){
        if(product instanceof Drill){
            int id = product.getId();
            drillList.remove(getProductById(id));
        }
        if(product instanceof PassengerCar){
            int id = product.getId();
            passengerCarList.remove(getProductById(id));
        }
        if(product instanceof Truck){
            int id = product.getId();
            truckList.remove(getProductById(id));
        }
    }

}
