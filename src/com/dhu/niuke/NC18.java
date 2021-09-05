package com.dhu.niuke;

import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class NC18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = sc.nextInt();
            }
        }

        NC18 nc = new NC18();
        int[][] ans = nc.rotateMatrix(mat,n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    public int[][] rotateMatrix(int[][] mat, int n) {

        if(mat.length == 0)
            return new int[][]{};
        int row = mat.length;
        int col = mat[0].length;

        int[][] ans = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                ans[i][j] = mat[n-1-j][i];
            }
        }
        return ans;
    }
}
