package com.stdy.calculator.core;

import com.stdy.calculator.view.MainWindow;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Launcher {

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        new MainWindow();
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

        /*

        try {

            String inputString;
            FileReader reader = new FileReader("calculator/input.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            inputString =  bufferedReader.readLine();
            reader.close();

            System.out.println("Input string: " + inputString);

            LexParser lexParser = new LexParser();

            lexParser.parse(inputString);

            System.out.println("Input Tokens: " + lexParser.getTokens());

            RPNmaker rpn = new RPNmaker();

            rpn.compose(lexParser.getTokens());

            System.out.println("RPN: " + rpn.getTokens());
            
            Calculator calculator = new Calculator();
            String result = calculator.calculate(rpn.getTokens());

            System.out.println("Result: " + result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

*/
    }
}
