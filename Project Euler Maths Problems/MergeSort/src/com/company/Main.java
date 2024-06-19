package com.company;

import java.util.Arrays;
import java.util.Collections;

public class Main {


    public static void main(String[] args) {
	// Initialising an Array
       int [] arr = {4,2,6,7,1,8};

        int[] merged = mergeSort(arr,0,arr.length - 1);

        for(int x : merged) System.out.println(x);
    }

    public static int[] sortTwolists(int[] fh, int[] sh){
        int[] sorted = new int[fh.length + sh.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < fh.length && j < sh.length){
            if(fh[i] > sh[j]){
                sorted[k] = sh[j];
                j++;
                k++;
            } else{
                sorted[k] = fh[i];
                i++;
                k++;
            }

        }
        if(i == fh.length){
            while(j< sh.length){
                sorted[k] = sh[j];
                j++;
                k++;
            }
        }
        if(j == sh.length){
            while(i< fh.length){
                sorted[k] = fh[i];
                i++;
                k++;
            }
        }

        return sorted;
    }

    public static int[] mergeSort(int[] arr , int low,int high){

        if(low == high){
            return new int[]{arr[low]};
        }
        int mid = (low + high) / 2;

        int[] fh = mergeSort(arr,low,mid);
        int[] sh = mergeSort(arr,mid+1,high);

        int[] merged = sortTwolists(fh,sh);

        return merged;

    }

}
