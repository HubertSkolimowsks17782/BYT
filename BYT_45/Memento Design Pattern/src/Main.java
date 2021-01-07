
public class Main {
    public static void main(String[] args) {

        CareTaker careTaker = new CareTaker();
        Originator originator = new Originator();
        originator.setState("First state");
        careTaker.addMemento(originator.createMemento());
        originator.setState("Second state");
        careTaker.addMemento(originator.createMemento());
        originator.setState("Third state");
        careTaker.addMemento(originator.createMemento());
        originator.restore(careTaker.getMemento(0));
        System.out.println(originator.getState());
        originator.restore(careTaker.getMemento(1));
        System.out.println(originator.getState());
        originator.restore(careTaker.getMemento(2));
        System.out.println(originator.getState());
    }
}
