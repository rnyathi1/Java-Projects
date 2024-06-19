package com.company;

public class Main {

    public static void main(String[] args) {

        int[] arr = {0,1,1,2,3,4,5,6,7};
        int number = 6;
        int low = 0;
        int high = arr.length;
        System.out.println(binarySearch(arr,number,low,high));

    }

    public static int binarySearch(int[] arr, int n, int low, int high){

        if(high >= low){
            int mid = low + (high - low) / 2;
            System.out.println(mid);
            if (arr[mid] == n) return mid;
            if(n > mid){
                return binarySearch(arr,n,mid+1,high);
            }
            return binarySearch(arr,n,low,mid -1 );

        }

        return -1;
    }

}
