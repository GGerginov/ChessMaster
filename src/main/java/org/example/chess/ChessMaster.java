package org.example.chess;

import org.example.domain.Position;
import org.example.exception.InvalidPositionException;

import java.util.*;

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

    public int playChess(Position startPosition) throws InvalidPositionException {

        if (!isValidPosition(startPosition)) throw new InvalidPositionException("Start position is not within the 3x3 chess board.");
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


    private boolean isValidPosition(Position position) {
        return position.getX() > 0 &&
                position.getX() <= BOARD_SIZE &&
                position.getY() > 0 &&
                position.getY() <= BOARD_SIZE;
    }

    private boolean isTargetReached(Position position) {
        return position.getX() == TARGET_X && position.getY() == TARGET_Y;
    }

}
