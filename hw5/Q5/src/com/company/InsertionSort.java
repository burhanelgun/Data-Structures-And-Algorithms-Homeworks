package com.company;

class InsertionSort
{
    /*Function to sort array using insertion sort*/
    public static <T extends Comparable<T>> void sort(T[] table) {
        for (int nextPos = 1; nextPos < table.length; nextPos++) {
            // Invariant: table[0 . . . nextPos ‐ 1] is sorted.
            // Insert element at position nextPos
            // in the sorted subarray.
            insert(table, nextPos);
            //        } // End for.    }
            // End sort.
        }
    }
    private static <T extends Comparable<T>> void insert(T[] table,int nextPos) {
        T nextVal = table[nextPos];
        // Element to insert.

        while (nextPos > 0 && nextVal.compareTo(table[nextPos - 1]) < 0) {
            table[nextPos] = table[nextPos - 1];
            // Shift down
            nextPos--;
            // Check next smaller element.        }
            // Insert nextVal at nextPos.
            table[nextPos] = nextVal;
            // }
        }
    }

    /* A utility function to print array of size n*/
    static void printArray(Integer arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Driver method
    public static void main(String args[])
    {
        Integer arr[] = {12, 11, 13, 5, 6};

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        printArray(arr);
    }
}
/* This code is contributed by Rajat Mishra. */
