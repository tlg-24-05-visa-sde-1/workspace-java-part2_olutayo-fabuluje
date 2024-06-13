package com.duckrace.app;

import com.duckrace.Reward;

import java.util.Scanner;

public class DuckRaceApp {



    private final Board board = Board.getInstance();
    private final Scanner scanner = new Scanner(System.in);


    public void execute() {
        welcome();
        showBoard();
        int id = promptForID();
        updateBoard(id, reward);
        showBoard();

    }



    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;
    }



}
