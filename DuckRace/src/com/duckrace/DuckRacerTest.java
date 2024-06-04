package com.duckrace;

import java.util.Collection;

public class DuckRacerTest {

    public static void main(String[] args) {
        DuckRacer racer1 = new DuckRacer(1, "Amir");

        racer1.win(Reward.DEBIT_CARD);
        racer1.win(Reward.DEBIT_CARD);
        racer1.win(Reward.PRIZES);
        racer1.win(Reward.DEBIT_CARD);

        System.out.println(racer1);  // toString() automatically called

        // I CAN CHEAT, and get more Rewards without actually "win()ning"
        Collection<Reward> rewards = racer1.getRewards();
        System.out.println();   // it's 7 now!!! HA!!!

        racer1.win(Reward.DEBIT_CARD);
        System.out.println(rewards);
    }
}
