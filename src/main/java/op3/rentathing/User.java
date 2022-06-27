package op3.rentathing;

import java.util.ArrayList;

public class User {
    private String username;
    protected String password;
    private Boolean adminRights;

    public ArrayList<User> users = new ArrayList<>();

    public User(String username, String password, Boolean adminRights){
        this.username = username;
        this.password = password;
        this.adminRights = adminRights;
        addStandardUsers();
    }

    public void addStandardUsers(){
        users.add(new User("Kevin", "123", true));
        users.add(new User("Employee1", "234", false));
        users.add(new User("Employee2", "321", true));
    }

    public String getUsername(){
        return username;
    }

    protected String getPassword(){
        return password;
    }

    public void addEmployee(String username, String password){
        users.add(new User(username, password, true));
    }

    public void addCustomer(){
        users.add(new User(username, password, false));
    }

}
