public class AddClassMessage implements Message {
    int value;
    public AddClassMessage(int value) {
        this.value = value;
    }

    public int getCourse() {
        return value;
    }
}
