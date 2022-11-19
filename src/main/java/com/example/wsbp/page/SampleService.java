package com.example.wsbp.page;

import java.util.Random;

public class SampleService implements ISampleService{
    public int makeRandInt(){
        var rand = new Random();
        var n = rand.nextInt(10);
        return n;
    }
}
