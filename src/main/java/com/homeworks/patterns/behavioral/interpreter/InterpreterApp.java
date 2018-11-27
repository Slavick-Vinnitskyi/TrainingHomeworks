package com.homeworks.patterns.behavioral.interpreter;

public class InterpreterApp {
    public static void main(String[] args) {
        Context context = new Context();

        Expression expression = context.evaluate("4+2");
        System.out.println(expression.interpret());
    }
}

interface Expression {
    int interpret();
}

/**
 * TerminalExpression(Final)
 */
class NumberExpression implements Expression {

    private int number;

    NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

/**
 * NoTerminalExpression(not final)
 */
class MinusExpression implements Expression {
    private Expression left;
    private Expression right;

    MinusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

/**
 * NoTerminalExpression(not final)
 */
class PlusExpression implements Expression {
    private Expression left;
    private Expression right;

    PlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

/**
 * Context хранит состояние выражения
 */
class Context {
    Expression evaluate(String s) {
        int pos = s.length() - 1;
        while (pos > 0) {
            if (Character.isDigit(s.charAt(pos))) {
                pos--;
            } else {
                Expression left = evaluate(s.substring(0, pos));
                Expression right = new NumberExpression(Integer.valueOf((s.substring(pos + 1, s.length()))));
                char operator = s.charAt(pos);
                switch (operator) {
                    case '-':
                        return new MinusExpression(left, right);
                    case '+':
                        return new PlusExpression(left, right);
                    default:
                        throw new IllegalArgumentException("Unsupported operator!!!");
                }
            }
        }
        int result = Integer.valueOf(s);
        return new NumberExpression(result);
    }
}