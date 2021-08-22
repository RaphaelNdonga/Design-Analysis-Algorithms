package com.designanalysis;

public class AlgorithmAnalysis {
    public static void main(String[] args) {
        System.out.println("Normal append is "+normalAppend("*",10000));
        System.out.println("String builder append is "+stringBuilderAppend("*",10000));

    }
    public static String normalAppend(String input, int number){
        long startTime = System.currentTimeMillis();
        String answer = input;
        for(int i = 0;i<number; i++){
            answer += input;
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime-startTime;
        return answer+" \nelapsed time is "+ elapsedTime;
    }
    public static String stringBuilderAppend(String input, int number){
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0;i<number;i++){
            sb.append(input);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime-startTime;
        return sb.toString()+" \nelapsed time is "+elapsedTime;
    }
}
