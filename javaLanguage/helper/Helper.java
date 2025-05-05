package javaLanguage.helper;

import java.util.Random;

public class Helper {

    public static int[] generateIntArray(int size){
        int[] intArray = new int[size];
        Random random = new Random();
        intArray[0] = random.nextInt(30);
        for(int i = 1; i < intArray.length; i++){
            intArray[i] = intArray[i-1] + random.nextInt(30);
        }
        return intArray;
    }

    public static int log2(int N) {
        return (int)(Math.log(N) / Math.log(2));
    }
}
