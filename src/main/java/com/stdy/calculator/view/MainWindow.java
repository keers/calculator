package com.stdy.calculator.view;

import com.stdy.calculator.core.CalculateTask;
import com.stdy.calculator.core.Calculator;
import com.stdy.calculator.core.LexParser;
import com.stdy.calculator.core.RPNmaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * User: sergeikirsanov
 * Date: 3/1/12
 * Time: 7:37 PM
 */
public class MainWindow extends JFrame implements ActionListener {
    private static final String EXIT_BUTTON = "exit";
    private static final String GO_BUTTON = "go";

    private JTextField expressionField;
    private JTextField resultField;

    private JButton goButton;
    private JButton exitButton;


    public MainWindow() {
        super("Calculator");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 2));

        panel.add(new JLabel("expression:"));

        expressionField = new JTextField();
        panel.add(expressionField);

        panel.add(new JLabel("result:"));

        resultField = new JTextField();
        panel.add(resultField);

        goButton = new JButton(GO_BUTTON);

        panel.add(goButton);

        goButton.addActionListener(this);

        exitButton = new JButton(EXIT_BUTTON);
        panel.add(exitButton);
        exitButton.addActionListener(this);

        add(panel);

        System.out.println("SwingUtilities.isEventDispatchThread(): " + SwingUtilities.isEventDispatchThread());


        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (GO_BUTTON.equals(actionEvent.getActionCommand())) {
            String expression = expressionField.getText();

            CalculateTask calculateTask = new CalculateTask(expression, resultField);

            calculateTask.execute();
        } else if (EXIT_BUTTON.equals(actionEvent.getActionCommand())) {
            System.exit(0);
        }

    }
}
