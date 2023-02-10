package org.example;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

public class task4 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] efs = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            efs[i] = sc.nextInt();
            sum+=efs[i];
        }

        Arrays.sort(efs);

        if(sum<m) {
            System.out.println(-1);
            return;
        }
        int k =0;
        int sumLeft = sum;
        int planksLeft = m;
        int maxIndex = n;
        while(true){
            for(int i = maxIndex-1; i>=0;i--){
                int mx = max(0, efs[i]-(maxIndex-i)+1);

                if(sumLeft-efs[i]<planksLeft-mx) {
                    maxIndex-=maxIndex-i-1;
                    break;
                }
                sumLeft-=efs[i];
                planksLeft-=mx;
                efs[i]=0;
            }
            k++;
            if(planksLeft<=0) break;
        }
        System.out.println(k);
    }
}
