import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class View extends JFrame {

    BlockingQueue<Message> queue;
    JTextField textField;
    JTextField textField2;
    JTextField textField3;
    JButton updateNameButton;
    JButton resetButton;
    BarGraph newGraph;
    JLabel label;
    JLabel label2;
    JLabel label3;
    JLabel printer;

    JLabel studentNameLabel;
    JLabel allClassesLabel;

    public View(BlockingQueue<Message> queue, String name, ArrayList<Integer> classes, BarGraph graph) {
        this.queue = queue;


        textField = new JTextField("0");
        textField2 = new JTextField("0");
        textField3 = new JTextField("0");
        newGraph = graph;
        updateNameButton = new JButton("update");
        newGraph.add(updateNameButton);
        newGraph.setLayout(new FlowLayout());
        newGraph.setSize(200, 200);
        newGraph.setVisible(true);
        resetButton = new JButton("reset");
        newGraph.add(resetButton);
        newGraph.add(new JLabel("green"));
        newGraph.add(new JLabel("blue"));
        newGraph.add(new JLabel("red"));
        newGraph.add(textField);
        newGraph.add(textField2);
        newGraph.add(textField3);
        newGraph.paintImmediately(new Rectangle());
        newGraph.setVisible(true);
        newGraph.paintImmediately(new Rectangle(100, 100));
        this.add(newGraph);
        this.pack();

        this.studentNameLabel = new JLabel(name);
        this.allClassesLabel = new JLabel(classes.toString());



        updateNameButton.addActionListener(e -> {

                    String theNum = textField.getText().trim();
                    String num2 = textField2.getText().trim();
                    String num3 = textField3.getText().trim();
                    printer = new JLabel("The Heights of the bars are: ");
                    label = new JLabel("Green: " + theNum);
                    label2 = new JLabel("Blue: " + num2);
                    label3 = new JLabel("Red: " + num3);
                    this.add(label);
                    this.add(label2);
                    this.add(label3);
                    this.pack();
            System.out.println(theNum);
            System.out.println(num2);
            System.out.println(num3);


                });


        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queue.clear();
                textField.setText("0");
                textField2.setText("0");
                textField3.setText("0");
            }
        });



        this.add(updateNameButton);
       // this.add(addClassButton);

        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateValueInView(int value) {
        Rectangle rectangle = new Rectangle();
        rectangle.setSize(100, value);
        newGraph.paint(getGraphics().create());
    }

    public void updateListOfClassesInView(ArrayList<Integer> classes) {
        this.allClassesLabel.setText(classes.toString());
    }
}
