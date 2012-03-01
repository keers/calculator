package com.iron.man;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testRPNSimple() {
        Assert.assertEquals("458*+", composeRPN("4+5*8"));

        Assert.assertEquals("45*8+", composeRPN("4*5+8"));


    }

    @Test
    public void testRPNWithBrackets() {
        Assert.assertEquals("45+8*", composeRPN("(4+5)*8"));

        Assert.assertEquals("45+83-*", composeRPN("(4+5)*(8-3)"));

//        Assert.assertEquals("2", calculate("((12-2)/10+3)/2"));
    }

    @Test
    public void calculateTesting() {
        Assert.assertEquals("28", calculate("4*5+8"));

        Assert.assertEquals("2", calculate("((6-2)/4+3)/2"));

    }

    private String composeRPN(String input) {
        LexParser lexParser = new LexParser();

        lexParser.parse(input);

        RPNmaker rpn = new RPNmaker();
        rpn.compose(lexParser.getTokens());

        StringBuffer resultBuffer = new StringBuffer();
        for (Token token : rpn.getTokens()) {
            resultBuffer.append(token.getValue());
        }
        return resultBuffer.toString();
    }

    private String calculate(String input) {
        LexParser lexParser = new LexParser();

        lexParser.parse(input);

        RPNmaker rpn = new RPNmaker();
        rpn.compose(lexParser.getTokens());

        Calculator calculator = new Calculator();
        return calculator.calculate(rpn.getTokens());
    }
}
