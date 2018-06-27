package com.company;

import java.util.Random;

public class AverageRunTimeAnalysis{

    Integer[] generateWorstCaseArray(int size){
        Integer[]  randomIntsArray = new Integer[size];

        for (int i = size,j=0; j<size&& i>0;i--,j++){
            randomIntsArray[j]=i;
        }
        //printArray(randomIntsArray);
        return randomIntsArray;

    }
    public MergeSortWithDLL.Node generateWorstCaseDLL(int size){
        MergeSortWithDLL list = new MergeSortWithDLL();
        Random rand = new Random();
        for (int i = size; 0<i;i--){
            list.addLast(i);
        }
        return list.head;
    }


    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}