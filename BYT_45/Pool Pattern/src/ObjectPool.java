import java.util.ArrayList;
import java.util.List;

public class ObjectPool {
    private static ObjectPool instance = null;
    private static List<Object> myList = null;
    private static int numberOfObjects = 0;

    private ObjectPool() {
        myList = new ArrayList<>();
    }
    public static ObjectPool getInstance() {
        if (instance == null)
            instance = new ObjectPool();
        return instance;
    }
    public static void printNumber() {
        System.out.println("Total number of objects: " + numberOfObjects);
    }
    public void addObject(Object obj) {
        if (myList.size() < 10) {
            myList.add(obj);
        }
    }
    public Object takeObject() {
        if (myList.isEmpty() && !ObjectLimitReached()) {
            numberOfObjects++;
            return new Object();
        } else if (!myList.isEmpty()) {
            Object tmp = myList.get(myList.size() - 1);
            myList.remove(myList.size() - 1);
            return tmp;
        } else {
            return null;
        }
    }
    public int getListSize() {
        return myList.size();
    }
    public boolean ObjectLimitReached() {
        return numberOfObjects >= 500;

    }

}
