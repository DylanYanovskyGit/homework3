import java.util.ArrayList;

public class model {
     String name = "default name";
     int value;
     ArrayList<Integer> classes = new ArrayList<>();

    public void setValue(int value) {
        if (value > 0) {
            this.value = value;
        }
    }

    public void addClass(int value) {
        this.classes.add(value);
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Integer> getValues() {
        return (ArrayList<Integer>) classes.clone();
    }
}
