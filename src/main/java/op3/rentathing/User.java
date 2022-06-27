package op3.rentathing;

import java.util.ArrayList;

public class User {
    private Menu menu;
    private String username;
    protected String password;
    private Boolean adminRights;

    public ArrayList<User> users = new ArrayList<>();

    public User(String username, String password, Boolean adminRights){
        this.username = username;
        this.password = password;
        this.adminRights = adminRights;
        users.add(new User("Kevin", "123", true));
        users.add(new User("Employee1", "234", false));
        users.add(new User("Employee2", "321", true));
    }

    public User getUser(String username){
        for (User user : users){
            if (username.equalsIgnoreCase(user.getUsername())){
                return user;
            }
            else {
                System.out.println("User not found. ");
            }
        }
        return null;
    }
    public void logIn(String username, String password){
        for(User user : users){
            if(username.equalsIgnoreCase(user.getUsername())){
                if (password.equals((user.getPassword()))){
                    menu.menu();
                }
                else{
                    System.out.println("Incorrect Password. ");
                }
            }
            else{
                System.out.println("Incorrect Username. ");
            }
        }
        System.out.println("User not found. ");
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
