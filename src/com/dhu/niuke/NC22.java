package com.dhu.niuke;

public class NC22 {

    public void merge(int A[], int m, int B[], int n) {

        int len = m;
        int[] C = new int[len];
        for(int i=0;i<len;++i)
            C[i] = A[i];

        int pa = 0;
        int pb = 0;

        int k = 0;
        while(pa < m && pb < n){
            if(C[pa] < B[pb]){
                A[k++] = C[pa];
                pa = pa + 1;
            }else{
                A[k++] = B[pb];
                pb = pb + 1;
            }
        }

        while(pa < m){
            A[k++] = C[pa];
            pa = pa + 1;
        }

        while(pb < n){
            A[k++] = B[pb];
            pb = pb + 1;
        }

    }
}
