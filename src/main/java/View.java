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
        newGraph.add(textField);
        newGraph.add(new JLabel("green"));
        newGraph.add(new JLabel("blue"));
        newGraph.add(new JLabel("red"));
        newGraph.add(textField2);
        newGraph.add(textField3);
        newGraph.paintImmediately(new Rectangle());
        newGraph.setVisible(true);
        newGraph.paintImmediately(new Rectangle(100, 100));
        this.add(newGraph);
        this.pack();

        this.studentNameLabel = new JLabel(name);
        this.allClassesLabel = new JLabel(classes.toString());

        this.textField = new JTextField(10);


        updateNameButton.addActionListener(e -> {

                    textField.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int value = Integer.parseInt(e.toString().trim());
                            Message msg = new NewNameMessage(value);
                            try {
                                queue.put(msg);
                                newGraph.repaint(new Rectangle(100, value));
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }
                    });
                    textField2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int value2 = Integer.parseInt(e.toString().trim());
                            Message msg2 = new NewNameMessage(value2);
                            try {
                                queue.put(msg2);
                                newGraph.repaint(new Rectangle(100, value2));
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }
                    });

                    textField3.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int value3 = Integer.parseInt(e.toString().trim());
                            Message msg3 = new NewNameMessage(value3);
                            try {
                                queue.put(msg3);
                                newGraph.repaint(new Rectangle(100, value3));
                            } catch (InterruptedException exception) {
                                exception.printStackTrace();
                            }
                        }
                    });
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
