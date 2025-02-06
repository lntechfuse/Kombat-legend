package com.example.legendkombat2.Parser;

public class Tokenizer {
    private String input;
    private int currentPosition;

    public Tokenizer(String input) {
        this.input = input;
        this.currentPosition = 0;
    }

    public LexicalToken nextToken() {
        if (currentPosition >= input.length()) {
            return new LexicalToken(LexicalToken.Type.EOF, "");
        }

        char currentChar = input.charAt(currentPosition);

        if (Character.isWhitespace(currentChar)) {
            currentPosition++;
            return nextToken(); // Skip whitespaces
        }

        if (currentChar == '(') {
            currentPosition++;
            return new LexicalToken(LexicalToken.Type.LEFT_PAREN, "(");
        }

        if (currentChar == ')') {
            currentPosition++;
            return new LexicalToken(LexicalToken.Type.RIGHT_PAREN, ")");
        }

        if (Character.isLetterOrDigit(currentChar)) {
            StringBuilder sb = new StringBuilder();
            while (currentPosition < input.length() && Character.isLetterOrDigit(input.charAt(currentPosition))) {
                sb.append(input.charAt(currentPosition));
                currentPosition++;
            }
            return new LexicalToken(LexicalToken.Type.IDENTIFIER, sb.toString());
        }

        if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
            currentPosition++;
            return new LexicalToken(LexicalToken.Type.OPERATOR, String.valueOf(currentChar));
        }

        // Invalid character
        currentPosition++;
        return nextToken(); // Skip invalid characters
    }
}


// Tokenizer class (แยกสตริงเป็น token)