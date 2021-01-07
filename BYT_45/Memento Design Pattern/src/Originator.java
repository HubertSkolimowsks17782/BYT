

public class Originator {
    private String state;

    public void setState(String state) {
        System.out.println("Setting state to: " + state);
        this.state = state;
    }
    public String getState() {
        return state;
    }

    public Memento createMemento() {
        System.out.println("Memento created");
        return new Memento(state);
    }

    public void restore(Memento m) {
        state = m.getState();
        System.out.println("Restored: " + state);
    }


}
