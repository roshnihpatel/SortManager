package com.sparta.rp.display;

import java.util.Random;
import java.util.Scanner;

public class RandomArrayGenerator {
    public static int[] getArrayOfSelectedLength(int length) {
        Random rando = new Random();
        int[] randomArray = new int[length];
        for (int i = 0; i < length; i++) {
            randomArray[i] = rando.nextInt(1001);
        }
        return randomArray;

    }
}
