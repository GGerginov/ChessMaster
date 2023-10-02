package org.example;

import org.example.domain.Position;
import org.example.exception.InvalidPositionException;
import org.example.chess.ChessMaster;

public class Main {


    public static void main(String[] args) {

        ChessMaster chessMaster = new ChessMaster();

        Position startPosition = new Position.Builder().x(-1).y(-1).build();

        int result = 0;
        try {
            result = chessMaster.playChess(startPosition);
        } catch (InvalidPositionException e) {
            System.err.println(e.getMessage());
        }

        if (result >=0){
            System.out.printf("Hell Yeah! The knight reaches the final cell in %d moves",result);
        }
        else{
            System.out.println("Oh no ! The knight can not reach the final cell");
        }


    }
}