public class NewNameMessage implements Message {
    int value;

    public NewNameMessage(int str) {
        this.value = str;
    }

    public int getName() {
        return value;
    }
}

