package com.iron.man;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: sergeikirsanov
 * Date: 12/25/11
 * Time: 10:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class LexParser {

    private ArrayList<Token> tokens;

    public LexParser() {
        tokens = new ArrayList<Token>();
    }

    public void parse(String input) {
        char cur;
        StringBuffer buf = new StringBuffer();
//        TokenType type;
        for (int i = 0; i < input.length(); i++) {
            cur = input.charAt(i);

            //TODO: Add multi symbol operands

            if ('0' <= cur && cur <= '9') {
                buf.append(cur);
//                type = TokenType.OPERAND;

                tokens.add(new Token(String.valueOf(cur), TokenType.OPERAND));
            } else if (cur == '-' || cur == '+' || cur == '*' || cur == '/') {
                tokens.add(new Token(String.valueOf(cur), TokenType.OPERATOR));

            } else if (cur == '(' || cur == ')') {
                tokens.add(new Token(String.valueOf(cur), TokenType.BRACKET));
            }   else {
                //throw error
            }


        }
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }
}
