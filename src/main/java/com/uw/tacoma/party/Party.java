package com.uw.tacoma.party;

import java.util.Random;

public class Party {

    private int data;
    private int data1, data2;
    private int q = 11, u, v;

    public Party(int data, int u, int v){

        this.data = data;
        this.u = u;
        this.v = v;

        while(data != (data1 + data2)% q){

            data1 = randomNumberInRange(1,q-1);
            data2 = randomNumberInRange(1, q-1);
        }
    }

    public int shareData(){
        return data2;

    }

    public int[] localCalculation(int shareData, boolean useForD)
    {
        int[] localComputes = new int[2];
        int d, e;

        if(!useForD) {
            d = data1 - u;
            e = shareData - v;
        }
        else
        {
            d = shareData - u;
            e = data1 - v;
        }
        localComputes[0] = d;
        localComputes[1] = e;

        return localComputes;
    }

    public int computeZ(int d, int e, int w){

        int z = w +(e*u) + (d*v) + (d*e);
        return z;
    }
    private int randomNumberInRange(int min, int max) {
        // TODO Auto-generated method stub
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
