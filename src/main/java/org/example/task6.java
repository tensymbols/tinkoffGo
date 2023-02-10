package org.example;
import java.util.*;


public class task6 {
    public static int contains(int[] arr, int value){
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
    public static void Rec( int[] arr,ArrayList<ArrayList<Integer>> combs,
                            int target, int currIndex, ArrayList<Integer> currComb){
        if(currIndex==arr.length){
            if(target==0){
                combs.add(new ArrayList<>(currComb));
            }
            return;
        }
        if(arr[currIndex]<=target) {
            currComb.add(arr[currIndex]);
            Rec(arr,combs,target-arr[currIndex],currIndex,currComb );
            currComb.remove(currComb.size()-1);

        }
        Rec(arr,combs,target,currIndex+1,currComb );

    }
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        int[] dynamicSum = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
            dynamicSum[i]=arr[i];
        }
        for (int i = 1; i < n; i++) {
            dynamicSum[i] +=dynamicSum[i-1];
        }

        int containsLastDay = contains(dynamicSum, arr[arr.length-1]);

        if(containsLastDay==-1) {
            int[] ds = dynamicSum;
            dynamicSum=new int[n+1];
            for (int i = 0; i < dynamicSum.length-1; i++) {
                dynamicSum[i]=ds[i];
            }
            dynamicSum[n]=arr[arr.length-1];
        }

        Map<Integer, Integer> elements = new HashMap<>();

        for (int i = 0; i < dynamicSum.length; i++) {
            elements.put(dynamicSum[i], i+1);
        }
        ArrayList<ArrayList<Integer>> combs= new ArrayList<>();
        ArrayList<Integer> currComb = new ArrayList<>();
        Rec(dynamicSum,combs, x, 0, currComb);

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < combs.size(); i++) {
            int currSum = 0;
            boolean hasLast = combs.get(i).contains(dynamicSum[n-1]);
            boolean cantUse = false;
            for (var j: combs.get(i)) {
                if((j==arr[n-1])){
                    if(hasLast){

                    }
                    else{
                        cantUse=true;
                        break;
                    }

                }
                else{
                    currSum+=elements.get(j);
                }
            }
            if(cantUse) continue;
            currSum+=combs.get(i).size()-1;

            if(currSum<minSum) minSum = currSum;
        }
        if(minSum==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minSum);
    }
}
