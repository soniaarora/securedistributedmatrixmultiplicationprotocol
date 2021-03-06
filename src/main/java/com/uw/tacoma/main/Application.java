package com.uw.tacoma.main;

import com.uw.tacoma.dto.CorrelatedData;
import com.uw.tacoma.party.Party;
import com.uw.tacoma.thirdpartyinitializer.ThirdPartyInitializer;

public class Application {

    public static void main(String arg[]) {
        int x = 5, y = 4, q = 11;
        ThirdPartyInitializer thirdPartyInitializer = new ThirdPartyInitializer();
        CorrelatedData correlatedData = thirdPartyInitializer.getCorrelatedData(5,2);

        Party party1 = new Party(x, correlatedData.getU1(),correlatedData.getV1());
        int x2 = party1.shareData();

        Party party2 = new Party(y, correlatedData.getU2(), correlatedData.getV2());
        int y2 = party2.shareData();

        int[] localcomputes1 = party1.localCalculation(y2, false);
        int[] localcomputes2 = party2.localCalculation(x2, true );

       int D = (localcomputes1[0] +localcomputes2[0]) % q;
       System.out.println("D:" +D);
       int E = (localcomputes1[1] +localcomputes2[1]) % q;
       System.out.println("D:" +E);

       int z1= party1.computeZ(D, E, correlatedData.getW1()) ;
       System.out.println("Z1:" +z1);

       int z2= party2.computeZ(D,E, correlatedData.getW2());
       System.out.println("Z2:" +z2);

       int Z = (z1+z2) % 11;
       System.out.println("Z:" +Z);

       int zVerify = (x *  y) % q;

    }
}
