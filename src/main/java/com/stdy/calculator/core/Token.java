package com.stdy.calculator.core;

/**
 * Created by IntelliJ IDEA.
 * User: sergeikirsanov
 * Date: 12/25/11
 * Time: 10:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Token {
    private TokenType type;

    private String value;

    public Token(String value, TokenType type) {
        this.value = value;
        this.type = type;
    }


    public TokenType getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
