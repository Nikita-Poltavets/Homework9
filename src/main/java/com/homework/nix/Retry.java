package com.homework.nix;

import java.util.Random;

public class Retry implements Block{

    private static final int MAX_TRYCOUNTER_VALUE = 2;

    @Override
    public void run() throws Exception {
        Random rand = new Random();

        int randomNumber;
        int tryCounter = 0;

        while (tryCounter < MAX_TRYCOUNTER_VALUE) {
            randomNumber = rand.nextInt(100);
            tryCounter++;
            Thread.sleep(100 * tryCounter);
            try {
                if (randomNumber < 50) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                if (tryCounter == MAX_TRYCOUNTER_VALUE) {
                    throw new Exception();
                }
            }
        }
    }
}
