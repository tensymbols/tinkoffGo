package org.example;


import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int mod = n % k;

        int min =(n/k) * (n/k) * (k-mod) + (n/k+1)*(n/k+1) * mod;

        int max = (n-(k-1))* (n-(k-1)) + (k-1);
        System.out.println(min+" "+max);
    }
}