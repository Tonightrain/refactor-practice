package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }


    public int[] evenOrOdd(){
        int[]count={0,0};
        for (int number : numbers){
            if (number % 2 == 0){
                count[0]++;
            }else {
                count[1]++;
            }

        }
        return count;
    }

    public int[] posOrNeg(){
        int[]count={0,0};
        for (int number : numbers){
            if (number >= 0){
                count[0]++;
            }else {
                count[1]++;
            }
        }
        return count;
    }
}
