package op3.rentathing;

import java.util.ArrayList;

public class UserList {

    private ArrayList<User> users;

    public UserList(){
        users = new ArrayList<>();
        User user1 = new User("Kevin", "123", true);
        User user2 = new User("Employee1", "234", false);
        User user3 = new User("Employee2", "321", true);
        addUser(user1);
        addUser(user2);
        addUser(user3);

    }

    public User getUser(String username){
        for (User user : users){
            if (username.equalsIgnoreCase(user.getUsername())){
                return user;
            }
            else {
                return null;
            }
        }
        return null;
    }

    public void addUser(User user){
        users.add(user);
    }

    public ArrayList<User> getUserList(){
        return users;
    }

}
