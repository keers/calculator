package com.iron.man;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: sergeikirsanov
 * Date: 12/25/11
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Launcher {

    public static void main(String[] args) {

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
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
