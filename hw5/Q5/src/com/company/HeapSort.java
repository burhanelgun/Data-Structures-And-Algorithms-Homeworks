package com.company;

// Java program for implementation of Heap Sort
public class HeapSort
{
    public static <T extends Comparable<T>> void sort(T[] table) {
        buildHeap(table);
        shrinkHeap(table);
    }
    private static <T extends Comparable<T>> void buildHeap(T[] table) {
        int n = 1;
        while (n < table.length) {
            n++;
            int child = n - 1;
            int parent = (child - 1) / 2;
            while (parent >= 0  && table[parent].compareTo(table[child]) < 0) { swap(table, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }
    private static <T extends Comparable<T>> void shrinkHeap(T[] table) {
        int n = table.length;
        while (n > 0) {
            n--;
            swap(table, 0, n);
            int parent = 0;
            while (true) {
                int leftChild = 2 * parent + 1;
                if (leftChild >= n) {
                    break;
                }
                int rightChild = leftChild + 1;
                int maxChild = leftChild;
                if (rightChild < n && table[leftChild].compareTo(table[rightChild]) < 0) {
                    maxChild = rightChild;
                }
                if (table[parent].compareTo(table[maxChild]) < 0) {
                    swap(table, parent, maxChild);

                    parent = maxChild;
                } else {
                    break;
                }
            }
        }
    }
    private static <T extends Comparable<T>> void swap(T[] table,  int i, int j) {
        T temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }


    /* A utility function to print array of size n */
    static void printArray(Integer arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        Integer arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
