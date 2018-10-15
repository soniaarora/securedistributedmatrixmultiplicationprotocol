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

    public int[] localCalculation(int shareData)
    {
        int[] localcomputes = new int[2];
        int d = data1 - u;
        int e = shareData - v;
         localcomputes[0] = d;
         localcomputes[1] = e;
        return localcomputes;
    }

    public int computeZ(int D, int E, int w1){

        int z1 = w1+E*u+D*v+D*E;
        return z1;
    }
    private int randomNumberInRange(int min, int max) {
        // TODO Auto-generated method stub
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;

    }
}
