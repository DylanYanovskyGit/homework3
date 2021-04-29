
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class App {
    public static void main(String[] args) {

        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        model model = new model();
        BarGraph graph = new BarGraph(model);
        View view = new View(queue, model.name, model.getValues(), graph);
        Controller controller = new Controller(queue, model, view);
        controller.mainLoop();
    }
}
