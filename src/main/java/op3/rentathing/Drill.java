package op3.rentathing;


public class Drill extends Product{

    private String type;

    private Menu menu;


    //Constructor of class
    public Drill(String brand, String description, String type) {
        super(brand, description, 5.0, 1.0,  true);
        this.type = type;
    }

    //Creates a new object product based on variables drill (part of the factory method pattern)
    @Override
    public Drill createProduct(){
        return new Drill(menu.askBrand(), menu.askDescription(), menu.askType());
    }

    //Getters and setters for modifying and information gathering
    public String getType() {
        return type;
    }

    public void setType(String type){
        this.type = type;
    }
}
