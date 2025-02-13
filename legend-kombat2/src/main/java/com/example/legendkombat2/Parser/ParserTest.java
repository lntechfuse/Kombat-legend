package com.example.legendkombat2.Parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    @Test
    public void testMoveCommand() {
        // Simulating input for the command "move up"
        String input = "move up";
        Tokenizer tokenizer = new Tokenizer(input);
        Parser parser = new Parser(tokenizer);
        Statement statement = parser.parse();

        // Verify that the statement is of type MoveCommand
        assertTrue(statement instanceof MoveCommand);
        MoveCommand moveCommand = (MoveCommand) statement;
        assertEquals("up", moveCommand.getDirection());
    }

    @Test
    public void testAttackCommand() {
        // Simulating input for the command "shoot down ally"
        String input = "shoot down ally";
        Tokenizer tokenizer = new Tokenizer(input);
        Parser parser = new Parser(tokenizer);
        Statement statement = parser.parse();

        // Verify that the statement is of type AttackCommand
        assertTrue(statement instanceof AttackCommand);
        AttackCommand attackCommand = (AttackCommand) statement;
        assertEquals("down", attackCommand.getDirection());
        assertTrue(attackCommand.getExpression() instanceof InfoExpression);
    }

    @Test
    public void testIfStatement() {
        // Simulating input for the if statement "if x + y then move up else shoot down ally"
        String input = "if x + y then move up else shoot down ally";
        Tokenizer tokenizer = new Tokenizer(input);
        Parser parser = new Parser(tokenizer);
        Statement statement = parser.parse();

        // Verify that the statement is of type IfStatement
        assertTrue(statement instanceof IfStatement);
        IfStatement ifStatement = (IfStatement) statement;
        assertTrue(ifStatement.getThenStatement() instanceof MoveCommand);
        assertTrue(ifStatement.getElseStatement() instanceof AttackCommand);
    }

    @Test
    public void testWhileStatement() {
        // Simulating input for the while statement "while x > 5 move up"
        String input = "while x > 5 move up";
        Tokenizer tokenizer = new Tokenizer(input);
        Parser parser = new Parser(tokenizer);
        Statement statement = parser.parse();

        // Verify that the statement is of type WhileStatement
        assertTrue(statement instanceof WhileStatement);
        WhileStatement whileStatement = (WhileStatement) statement;
        assertTrue(whileStatement.getBody() instanceof MoveCommand);
    }

    @Test
    public void testAssignmentStatement() {
        // Simulating input for the assignment "x = 10"
        String input = "x = 10";
        Tokenizer tokenizer = new Tokenizer(input);
        Parser parser = new Parser(tokenizer);
        Statement statement = parser.parse();

        // Verify that the statement is of type AssignmentStatement
        assertTrue(statement instanceof AssignmentStatement);
        AssignmentStatement assignmentStatement = (AssignmentStatement) statement;
        assertEquals("x", assignmentStatement.getVariable());
        assertTrue(assignmentStatement.getExpression() instanceof NumberExpression);
    }
}

