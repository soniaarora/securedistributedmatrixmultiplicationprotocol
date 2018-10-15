package com.uw.tacoma.thirdpartyinitializer;

import com.uw.tacoma.dto.CorrelatedData;

import java.util.Random;

public class ThirdPartyInitializer {

    private int numOfParties;
    private int u1, u2, v1, v2,w1,w2, q = 11;

    public ThirdPartyInitializer() {
        numOfParties = 2;
    }

    public CorrelatedData getCorrelatedData(int u, int v) {

        int w = u * v;
        CorrelatedData correlatedData = new CorrelatedData();

        while(u != (u1 + u2) % q ) {

            u1 = randomNumberInRange(1,q-1);
            u2 = randomNumberInRange(1,q-1);

        }
        while(v != (v1 +v2) % q){

            v1 = randomNumberInRange(1,q-1);
            v2 = randomNumberInRange(1,q-1);
        }
        while(w != (w1 +w2)%q){

            w1 = randomNumberInRange(1,q-1);
            w2 = randomNumberInRange(1,q-1);
        }
        correlatedData.setU1(u1);
        correlatedData.setU2(u2);
        correlatedData.setV1(v1);
        correlatedData.setV2(v2);
        correlatedData.setW1(w1);
        correlatedData.setW2(w2);

        System.out.println("u1:"+u1);
        System.out.println("u1:"+u2);
        System.out.println("u1:"+v1);
        System.out.println("u1:"+v2);
        System.out.println("u1:"+w1);
        System.out.println("u1:"+w2);
        return correlatedData;
    }

    private int randomNumberInRange(int min, int max) {
        // TODO Auto-generated method stub
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;

    }
}
