public class UpdateMessages implements Message{
    String number;

    public UpdateMessages(String number)
    {
        this.number = number;
    }
    public String getNumber()
    {
        return number;
    }
}
