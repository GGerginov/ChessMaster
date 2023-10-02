package org.example.chess;

import org.example.domain.Position;
import org.example.exception.InvalidPositionException;

import java.util.*;

/**
 * The ChessMaster class represents a chess game master that controls the movement of a knight on a 3x3 chessboard.
 * It provides methods to play the chess game and determine the number of moves required for the knight to reach a target position.
 */
public class ChessMaster {

    private static final Integer BOARD_SIZE = 3;
    private static final int TARGET_X = 3;
    private static final int TARGET_Y = 3;
    private final Queue<Position> positions = new LinkedList<>();
    private static final int[][] MOVES = {
            {-2, -1}, {-2, 1},
            {-1, -2}, {-1, 2},
            {1, -2}, {1, 2},
            {2, -1}, {2, 1}
    };

    private final Set<Position> visited = new HashSet<>();


    /**
     * Plays the chess game starting from the given startPosition and returns the number of moves required for the knight to reach the target position.
     * If the target position is reached, the method returns the number of moves. If the target position cannot be reached, the method returns -1.
     *
     * @param startPosition The starting position of the knight on the chessboard.
     * @return The number of moves required for the knight to reach the target position, or -1 if the target position cannot be reached.
     * @throws InvalidPositionException If the start position is not within the 3x3 chessboard.
     */
    public int playChess(Position startPosition) throws InvalidPositionException {

        if (!isValidPosition(startPosition))
            throw new InvalidPositionException("Start position is not within the 3x3 chess board.");
        positions.add(startPosition);
        visited.add(startPosition);

        int moves = 0;

        while (!positions.isEmpty()) {
            Position current = positions.poll();

            if (isTargetReached(current)) return moves;

            for (int[] move : MOVES) {
                Position newPosition = new Position.Builder()
                        .x(current.getX() + move[0])
                        .y(current.getY() + move[1])
                        .build();

                if (isValidPosition(newPosition) && !visited.contains(newPosition)) {

                    positions.add(newPosition);

                    visited.add(newPosition);
                }
            }

            moves++;
        }

        return -1;
    }


    /**
     * Checks if the given position is a valid position on the chessboard.
     *
     * @param position The position to check.
     * @return True if the position is valid, false otherwise.
     */
    private boolean isValidPosition(Position position) {
        return position.getX() > 0 &&
                position.getX() <= BOARD_SIZE &&
                position.getY() > 0 &&
                position.getY() <= BOARD_SIZE;
    }

    /**
    Checks if the given position is the target position.

    @param position The position to check.
    @return True if the position is the target position, false otherwise.
    */
    private boolean isTargetReached(Position position) {
        return position.getX() == TARGET_X && position.getY() == TARGET_Y;
    }

}
