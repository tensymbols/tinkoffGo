package org.example;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int capacity = sc.nextInt();
        int mid = (capacity % 2 == 1) ? capacity/2 + 1: capacity/2;
        int midAdd = (capacity % 2 == 0) ? 1 : 0;
        int left = mid;
        int right = mid+midAdd;

        for( int cnt=0; cnt < n; cnt++){
            if(cnt % capacity ==0) {
                left = mid;
                right= mid;
                System.out.println(left);
            }
            else if(mid-left<=right-(mid+midAdd)) {
                left = left-1;
                System.out.println(left);
            }else{
                right = right+1;
                System.out.println(right);
            }

        }
    }
}