package MachineCoding;

import java.util.*;

class Main {

    public static void main(String[] args) {

        Map<String, Integer> players = new HashMap<>();
        // player1, player2
        players.put("player1", -1);
        players.put("player2", -1);

        boolean gameOver = false;
        int size = 100;
        int onboardingRoleMark = 1;

        Map<Integer, Integer> snakes = new HashMap<>();
        Map<Integer, Integer> ladders = new HashMap<>();

        snakes.put(99, 11);
        snakes.put(55, 22);
        snakes.put(24, 2);
        snakes.put(80, 40);

        ladders.put(4, 30);
        ladders.put(42, 80);
        ladders.put(30, 60);
        ladders.put(56, 92);

        SnakeAndLadder board = new SnakeAndLadder(snakes, ladders, size);

        boolean turn = true;
        int value;
        // Two Players
        while (!gameOver) {

            String currentPlayer = turn ? "player1" : "player2";

            value = board.rollDice();

            if (players.get(currentPlayer) != -1) {

                // Logic
                int playerUpdatedScore = players.get(currentPlayer) + value;

                if (playerUpdatedScore <= size) {

                    playerUpdatedScore = board.getUpdatedScore(playerUpdatedScore);

                    players.put(currentPlayer, playerUpdatedScore);

                }

                if (playerUpdatedScore == size) {
                    System.out.println(currentPlayer + " won ");
                    gameOver = true;
                }

            } else if (value == onboardingRoleMark) {
                players.put(currentPlayer, 0);
            }

            turn = !turn;

        }
        ;
    }

}

class SnakeAndLadder {

    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    private int size;

    SnakeAndLadder(
            Map<Integer, Integer> snakes,
            Map<Integer, Integer> ladders,
            int size) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.size = size;
    }

    public int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }

    public int getUpdatedScore(
            int playerUpdatedScore) {
        if (snakes.containsKey(playerUpdatedScore)) {
            return snakes.get(playerUpdatedScore);
        }

        if (ladders.containsKey(playerUpdatedScore)) {
            return ladders.get(playerUpdatedScore);
        }

        return playerUpdatedScore;
    }

}
