package com.iron.man;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: sergeikirsanov
 * Date: 12/25/11
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class RPNmaker {
    private ArrayList<Token> tokens;
    private LinkedList<Token> stack;

    public RPNmaker() {
        tokens = new ArrayList<Token>();
        stack = new LinkedList<Token>();
    }

    public void compose(ArrayList<Token> inputTokens) {
        for (Token token : inputTokens) {

            if (token.getType() == TokenType.OPERAND) {
                tokens.add(token);
            } else if (token.getType() == TokenType.BRACKET) {
                if (token.getValue().equals("(")) {
                    stack.addFirst(token);
                } else {
                    Token tmp;

                    while (!stack.isEmpty()) {
                        tmp = stack.removeFirst();
                        if (!tmp.getValue().equals("(")) {
                            tokens.add(tmp);
                        }
                    }
                }
            } else {
                if (stack.isEmpty()) {
                    stack.addFirst(token);
                } else {
                    Token tmp;
                    while (!stack.isEmpty()) {
                        tmp = stack.removeFirst();
                        if (tmp.getValue().equals("(")) {
                            stack.addFirst(tmp);
                            break;
                        }
                        if (tmp.getType() == TokenType.OPERATOR) {
                            if (tmp.getValue().equals("+") || tmp.getValue().equals("-")) {
                                if (token.getValue().equals("*") || token.getValue().equals("/")) {
                                    stack.addFirst(tmp);
                                    break;
                                } else {
                                    tokens.add(tmp);
                                }
                            } else {
                                tokens.add(tmp);
                            }
                        }
                    }
                    stack.addFirst(token);
                }
            }


        }

        while (!stack.isEmpty()) {
            tokens.add(stack.removeFirst());

        }
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

}
