package com.github.yyy123454321.statistics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Size: ");

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        double[] num = new double[length];

        for(int i = 0; i < length; i++) num[i] = sc.nextDouble();

        System.out.println(Statistics.get(num).toJSONString());
    }
}
