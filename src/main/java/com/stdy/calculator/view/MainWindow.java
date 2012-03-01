package com.stdy.calculator.view;

import javax.swing.*;
import java.awt.*;

/**
 * User: sergeikirsanov
 * Date: 3/1/12
 * Time: 7:37 PM
 */
public class MainWindow extends JFrame {

    public MainWindow() {
        super("Calculator");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 2));

        panel.add(new JLabel("expression:"));
        panel.add(new JTextField("tf"));
        panel.add(new JLabel("result:"));
        panel.add(new JTextField("tf2"));
        panel.add(new JButton("go"));
        panel.add(new JButton("exit"));


        /*
            //Create and set up the content pane.
            BorderDemo newContentPane = new BorderDemo();
            newContentPane.setOpaque(true); //content panes must be opaque
            frame.setContentPane(newContentPane);
        */

        add(panel);


        pack();
        setVisible(true);
    }

}
