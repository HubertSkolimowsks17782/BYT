public class Main {
    public static void main(String[] args) {

        ObjectPool pool = ObjectPool.getInstance();
        User user1 = new User();
        User user2 = new User();

        //1
        user1.takeFromPool(pool);
        user1.takeFromPool(pool);
        user1.returnToPool(pool);
        user1.returnToPool(pool);

        //2
        user2.takeFromPool(pool);
        user2.returnToPool(pool);

        System.out.println();
        System.out.println("User1 objects: " + user1.getListSize());
        System.out.println("User2 objects: " + user2.getListSize());
        System.out.println("Objects in pool: " + pool.getListSize());
        ObjectPool.printNumber();


    }

}

