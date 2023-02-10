package org.example;


import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr_1 = new int[n];
        int[] blocks_1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr_1[i]=(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            blocks_1[i]=(sc.nextInt());
        }
        int m = sc.nextInt();

        int[] arr_2 = new int[m];
        int[] blocks_2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr_2[i]=(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            blocks_2[i]=(sc.nextInt());
        }

        int N=0;
        for (int i = 0; i <n; i++) {
            N+=blocks_1[i];
        }

        int[] ARR_1 = new int[N];
        int[] ARR_2 = new int[N];

        int index = 0;
        for (int i = 0; i < arr_1.length; i++) {
            for (int j = 0; j < blocks_1[i]; j++) {

                ARR_1[index] = (arr_1[i]);
                index++;
            }
        }
        index=0;
        for (int i = 0; i < arr_2.length; i++) {
            for (int j = 0; j < blocks_2[i]; j++) {

                ARR_2[index] = (arr_2[i]);
                index++;
            }
        }
        long sumDiff = 0;
        for (int i = 0; i < ARR_1.length; i++) {
            if(ARR_1[i]!=ARR_2[i]){
                sumDiff+=(i+1);
            }
        }
        System.out.println(sumDiff);
    }
}