package op3.rentathing;

public class User {
    private Menu menu;
    private String username;
    protected String password;
    private Boolean adminRights;


    public User(String username, String password, Boolean adminRights){
        this.username = username;
        this.password = password;
        this.adminRights = adminRights;
    }


    public String getUsername(){
        return username;
    }

    protected String getPassword(){
        return password;
    }


}
