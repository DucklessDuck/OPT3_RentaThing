package op3.rentathing;

import java.util.ArrayList;
import java.util.List;

public interface Subject {


    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
