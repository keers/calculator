package com.iron.man;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sergeikirsanov
 * Date: 12/25/11
 * Time: 11:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    private LinkedList<Token> stack;

    public Calculator() {
        stack = new LinkedList<Token>();
    }

    public String calculate(List<Token> rpnInput) {
//        TODO: add input checking
        for (Token token : rpnInput) {
            if (token.getType() == TokenType.OPERAND) {
                stack.addFirst(token);
            } else if (token.getType() == TokenType.OPERATOR) {
                if (token.getValue().equals("+")) {
                    Integer first = Integer.valueOf(stack.removeFirst().getValue());
                    Integer second = Integer.valueOf(stack.removeFirst().getValue());

                    stack.addFirst(new Token(String.valueOf(first + second), TokenType.OPERAND));
                } else if (token.getValue().equals("*")) {
                    Integer first = Integer.valueOf(stack.removeFirst().getValue());
                    Integer second = Integer.valueOf(stack.removeFirst().getValue());

                    stack.addFirst(new Token(String.valueOf(first * second), TokenType.OPERAND));
                } else if (token.getValue().equals("/")) {
                    Integer first = Integer.valueOf(stack.removeFirst().getValue());
                    Integer second = Integer.valueOf(stack.removeFirst().getValue());

                    stack.addFirst(new Token(String.valueOf(second / first), TokenType.OPERAND));
                } else if (token.getValue().equals("-")) {
                    Integer first = Integer.valueOf(stack.removeFirst().getValue());
                    Integer second = Integer.valueOf(stack.removeFirst().getValue());

                    stack.addFirst(new Token(String.valueOf(second - first), TokenType.OPERAND));
                }
            }
        }

        return stack.removeFirst().getValue();
    }
}
