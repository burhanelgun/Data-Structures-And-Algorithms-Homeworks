package com.company;

public class Main {

    public static void worstCaseTest(int size){
        AverageRunTimeAnalysis obj = new AverageRunTimeAnalysis();
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();
        HeapSort hs = new HeapSort();
        InsertionSort is = new InsertionSort();

        double[] MergeSortTimes = new double[4];
        double[] MergeSortDLLTimes = new double[4];
        double[] QuickSortTimes = new double[4];
        double[] HeapSortTimes = new double[4];
        double[] InsertionSortTimes = new double[4];

        Integer[] arr = obj.generateWorstCaseArray(size);
        Integer[] qsArr = new Integer[size];
        Integer[] hsArr = new Integer[size];
        Integer[] isArr= new Integer[size] ;
        Integer[] msArr= new Integer[size] ;

        MergeSortWithDLL.Node b = obj.generateWorstCaseDLL(size);
        System.arraycopy( arr, 0, qsArr, 0, arr.length );
        System.arraycopy( arr, 0, hsArr, 0, arr.length );
        System.arraycopy( arr, 0, isArr, 0, arr.length );
        System.arraycopy( arr, 0, msArr, 0, arr.length );


        double startTimeMergeSort = System.nanoTime();
        ms.sort(msArr);
        double endTimeMergeSort = System.nanoTime();
        double timeMergeSort = (endTimeMergeSort - startTimeMergeSort) / 1000; //saliseye çevrilir;
        MergeSortTimes[0] = timeMergeSort;
        System.out.println("Worst Case Merge Sort : " + timeMergeSort);

        double startTimeHeapSort = System.nanoTime();
        hs.sort(hsArr);
        double endTimeHeapSort = System.nanoTime();
        double timeHeapSort = (endTimeHeapSort - startTimeHeapSort) / 1000; //saliseye çevrilir;
        HeapSortTimes[0] = timeHeapSort;
        System.out.println("Worst Case Heap Sort : " + timeHeapSort);

        double startTimeInsertionSort = System.nanoTime();
        is.sort(isArr);
        double endTimeInsertionSort = System.nanoTime();
        double timeInsertionSort = (endTimeInsertionSort - startTimeInsertionSort) / 1000; //saliseye çevrilir;
        InsertionSortTimes[0] = timeInsertionSort;
        System.out.println("Worst Case Insertion Sort : " + timeInsertionSort);

        double startTimeQuickSort = System.nanoTime();
        qs.sort(qsArr);
        double endTimeQuickSort = System.nanoTime();
        double timeQuickSort = (endTimeQuickSort - startTimeQuickSort) / 1000; //saliseye çevrilir;
        QuickSortTimes[0] = timeQuickSort;
        System.out.println("Worst Case Quick Sort : " + timeQuickSort);

        MergeSortWithDLL list = new MergeSortWithDLL();
        double startTimeMergeSortDLL = System.nanoTime();
        b = list.mergeSort(b);
        double endTimeMergeSortDLL = System.nanoTime();
        double timeMergeSortDLL = (endTimeMergeSortDLL - startTimeMergeSortDLL) / 1000; //saliseye çevrilir;
        MergeSortDLLTimes[0] = timeMergeSortDLL;
        System.out.println("Worst Case Merge Sort DLL : " + timeMergeSortDLL);


    }
    public static void main(String[] args) {
        System.out.println("SIZE : 100");
        worstCaseTest(100);

        System.out.println("SIZE : 1000");
        worstCaseTest(1000);

        System.out.println("SIZE : 5000");
        worstCaseTest(5000);

        System.out.println("SIZE : 10000");
        worstCaseTest(6000);


    }

}
