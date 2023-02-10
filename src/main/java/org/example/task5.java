package org.example;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] adjList =new ArrayList[n];
        int[] d = new int[n];
        int[] korobki = new int[n];
        d[0]=n;

        for (int i=0; i<n; i++){
            adjList[i] = new ArrayList<>();

        }

        for (int i=0; i<n-1; i++){
            int left = sc.nextInt()-1;
            int right = sc.nextInt()-1;
            adjList[left].add(right);
            adjList[right].add(left);
        }
        int q = sc.nextInt();
        ArrayList<Integer>[] vkx = new ArrayList[q];
        for (int i=0; i<q; i++){
            vkx[i] = new ArrayList<>();
        }

        for (int i = 0; i < q; i++) {
            vkx[i].add(sc.nextInt()-1);
            vkx[i].add(sc.nextInt());
            vkx[i].add(sc.nextInt());
        }
        bfs(adjList, d);

        for (int i = 0; i < vkx.length; i++) {

            razdatKorobki(adjList, korobki, d ,vkx[i].get(0) ,vkx[i].get(1),vkx[i].get(2) );
        }
        for (int i = 0; i < korobki.length; i++) {
            System.out.print(korobki[i]+" ");
        }
    }
    private static void bfs(ArrayList<Integer>[] adjList, int[] d ){
        boolean[] visited = new boolean[adjList.length];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(0);
        visited[0]=true;
        while(!Q.isEmpty()){
            int curr = Q.poll();
            for (int i = 0; i < adjList[curr].size() ; i++) {
                int currVer = adjList[curr].get(i);
                if(!visited[currVer]){
                    int h = d[curr];
                    d[currVer] = h - 1;
                    visited[currVer]=true;
                    Q.add(currVer);
                }
            }
        }

    }
    private static void razdatKorobki(ArrayList<Integer>[] adjList,int[] korobki, int[] d, int v, int k, int x){
        boolean[] visited = new boolean[adjList.length];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(v);
        visited[v]=true;
        korobki[v]+=x;
        while(!Q.isEmpty()){
            int curr = Q.poll();
            for (int i = 0; i < adjList[curr].size() ; i++) {
                int currVer = adjList[curr].get(i);
                if(!visited[currVer] && d[currVer]<d[v] && d[currVer] >=d[v]-k){
                    korobki[currVer]=korobki[currVer] +x;
                    visited[currVer]=true;
                    Q.add(currVer);
                }
            }
        }

    }
}
