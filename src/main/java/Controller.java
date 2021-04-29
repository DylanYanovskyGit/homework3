import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Message> queue;
    model model;
    View view;

    public Controller(BlockingQueue<Message> queue, model model, View view) {
        this.queue = queue;
        this.model = model;
        this.view = view;
    }

    public void mainLoop() {
        while (view.isDisplayable()) {
            Message message = null;
            try {
                message = queue.take();
            } catch (InterruptedException exception) {
                // do nothing
            }

            if(message.getClass() == NewNameMessage.class) {
                // button updateStudentName was clicked
                NewNameMessage nameMessage = (NewNameMessage) message;
                model.setValue(nameMessage.value); // update model
                view.updateValueInView(model.getValue()); // update view
            }
            else if(message.getClass() == AddClassMessage.class) {
                // button addClass was clicked
                // update model and view
                AddClassMessage classMessage = (AddClassMessage) message;
                model.addClass(classMessage.getCourse());
                view.updateListOfClassesInView(model.getValues());
            }

        }
    }
}



