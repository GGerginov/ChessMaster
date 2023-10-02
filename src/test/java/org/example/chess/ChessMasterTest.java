package org.example.chess;

import org.example.domain.Position;
import org.example.exception.InvalidPositionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class ChessMasterTest {

    private ChessMaster chessMaster;

    @BeforeEach
    public void setUp() {
        chessMaster = new ChessMaster();
    }

    @Test
    void testPlayChessWhenStartPositionIsTarget() throws InvalidPositionException {
        Position startPosition = new Position.Builder().x(3).y(3).build();
        int moves = chessMaster.playChess(startPosition);
        assertEquals(0, moves);
    }

    @Test
    void testPlayChessWhenStartPositionCanReachTarget() throws InvalidPositionException {
        Position startPosition = new Position.Builder().x(1).y(1).build();
        int moves = chessMaster.playChess(startPosition);
        assertTrue(moves > 0);
    }

    @Test
    void testPlayChessWhenStartPositionNotWithinTheBoard() {

        Position startPosition = new Position.Builder().x(0).y(0).build();

        assertThrows(InvalidPositionException.class,() -> chessMaster.playChess(startPosition));
    }

    @Test
    void testIsValidPositionWithValidPosition() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Position validPosition = new Position.Builder().x(2).y(2).build();
        Method isValidPosition = ChessMaster.class.getDeclaredMethod("isValidPosition", Position.class);
        isValidPosition.setAccessible(true);
        boolean isValid = (boolean) isValidPosition.invoke(chessMaster, validPosition);
        assertTrue(isValid);
    }

    @Test
    void testIsValidPositionWithInvalidPosition() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Position invalidPosition = new Position.Builder().x(4).y(4).build();
        Method isValidPosition = ChessMaster.class.getDeclaredMethod("isValidPosition", Position.class);
        isValidPosition.setAccessible(true);
        boolean isValid = (boolean) isValidPosition.invoke(chessMaster, invalidPosition);
        assertFalse(isValid);
    }

    @Test
    void testIsTargetReachedWhenPositionIsAtTarget() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Position targetPosition = new Position.Builder().x(3).y(3).build();
        Method isTargetReached = ChessMaster.class.getDeclaredMethod("isTargetReached", Position.class);
        isTargetReached.setAccessible(true);
        boolean isReached = (boolean) isTargetReached.invoke(chessMaster, targetPosition);
        assertTrue(isReached);
    }

    @Test
    void testIsTargetReachedWhenPositionIsNotAtTarget() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Position nonTargetPosition = new Position.Builder().x(2).y(2).build();
        Method isTargetReached = ChessMaster.class.getDeclaredMethod("isTargetReached", Position.class);
        isTargetReached.setAccessible(true);
        boolean isReached = (boolean) isTargetReached.invoke(chessMaster, nonTargetPosition);
        assertFalse(isReached);
    }
}