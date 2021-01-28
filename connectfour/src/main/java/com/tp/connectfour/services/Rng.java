package com.tp.connectfour.services;

import java.util.Random;

public class Rng {
    static Random rng = new Random();
    public static int nextInt( int incMin, int incMax ){
        return incMin + rng.nextInt(incMax - incMin + 1);
    }
    public static void reSeed(long seed) {
        rng = new Random(seed);
    }
}