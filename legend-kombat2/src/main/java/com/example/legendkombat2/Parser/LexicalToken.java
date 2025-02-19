package com.example.legendkombat2.Parser;


public class LexicalToken {
    public enum Type {
        LEFT_PAREN, RIGHT_PAREN, IDENTIFIER, OPERATOR, NUMBER, EOF,KEYWORD,LEFT_BRACE,RIGHT_BRACE
    }

    private Type type;
    private String value;

    public LexicalToken(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {

        return type;
    }

    public String getValue() {
        return value;
    }
}

// LexicalToken class (การจัดการ token ต่างๆ)