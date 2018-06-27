import com.sun.xml.internal.ws.api.model.MEP;

public class Main {
    public static void main(String[] args) {

        AverageRunTimeAnalysis a = new AverageRunTimeAnalysis();
        MergeSort ms = new MergeSort();
        QuickSort qs = new QuickSort();
        HeapSort hs = new HeapSort();
        InsertionSort is = new InsertionSort();

        double[] MergeSortTimes = new double[100];
        double[] MergeSortDLLTimes = new double[100];
        double[] QuickSortTimes = new double[100];
        double[] HeapSortTimes = new double[100];
        double[] InsertionSortTimes = new double[100];

//0= 2000 // 1= 4.000 // 2 = 8.000 // 3= 16.000 // 4= 32.000// 5 = 64.000 // 6 = 128.000 // 7= 256.000// 8 = 512.000 // 9= 1.000.0024

        int i = 0;

        for (int j = 0; j < 100; j++) {
            if (j% 10 == 0) {
                i = j/ 10;
            }
            //System.out.println("Size = " + (Integer) Math.pow(2, i + 1) * 1000);
            Integer[] arr = a.generateRandomArray((int) Math.pow(2, i + 1) * 10);
            MergeSortWithDLL.Node b = a.generateRandomDLL(j*10);

            Integer[] msArr = new Integer[(int) Math.pow(2, i + 1) * 10];
            Integer[] qsArr  = new Integer[(int) Math.pow(2, i + 1) * 10];
            Integer[] hsArr  = new Integer[(int) Math.pow(2, i + 1) * 10];
            Integer[] isArr  = new Integer[(int) Math.pow(2, i + 1) * 10];

            //MergeSortWithDLL.Node b = obj.generateWorstCaseDLL(size);
            System.arraycopy( arr, 0, qsArr, 0, arr.length );
            System.arraycopy( arr, 0, hsArr, 0, arr.length );
            System.arraycopy( arr, 0, isArr, 0, arr.length );
            System.arraycopy( arr, 0, msArr, 0, arr.length );

            MergeSortWithDLL list = new MergeSortWithDLL();
            double startTimeMergeSortDLL = System.nanoTime();
            b = list.mergeSort(b);
            double endTimeMergeSortDLL = System.nanoTime();
            double timeMergeSortDLL = (endTimeMergeSortDLL - startTimeMergeSortDLL) / 1000; //saliseye çevrilir;
            MergeSortDLLTimes[j] = timeMergeSortDLL;
            //System.out.println("Insertion Sort : " + timeMergeSortDLL);

            double startTimeQuickSort = System.nanoTime();
            qs.sort(qsArr);
            double endTimeQuickSort = System.nanoTime();
            double timeQuickSort = (endTimeQuickSort - startTimeQuickSort) / 1000; //saliseye çevrilir;
            QuickSortTimes[j] = timeQuickSort;
            //System.out.println("Quick Sort : " + timeQuickSort);

            double startTimeMergeSort = System.nanoTime();
            ms.sort(msArr);
            double endTimeMergeSort = System.nanoTime();
            double timeMergeSort = (endTimeMergeSort - startTimeMergeSort) / 1000; //saliseye çevrilir;
            MergeSortTimes[j] = timeMergeSort;
            //System.out.println("Merge Sort : " + timeMergeSort);


            double startTimeHeapSort = System.nanoTime();
            hs.sort(hsArr);
            double endTimeHeapSort = System.nanoTime();
            double timeHeapSort = (endTimeHeapSort - startTimeHeapSort) / 1000; //saliseye çevrilir;
            HeapSortTimes[j] = timeHeapSort;
            //System.out.println("Heap Sort : " + timeHeapSort);


            double startTimeInsertionSort = System.nanoTime();
            is.sort(isArr);
            double endTimeInsertionSort = System.nanoTime();
            double timeInsertionSort = (endTimeInsertionSort - startTimeInsertionSort) / 1000; //saliseye çevrilir;
            InsertionSortTimes[j] = timeInsertionSort;
            //System.out.println("Insertion Sort : " + timeInsertionSort);

        }


        double[] AverageMergeSort = new double[10];
        double[] AverageHeapSort = new double[10];
        double[] AverageInsertionSort = new double[10];
        double[] AverageQuickSort = new double[10];
        double[] AverageMergeDLLSort = new double[10];

       for(int k = 0;k<100;k++){

           AverageMergeSort[k/10]+=MergeSortTimes[k];
           AverageHeapSort[k/10]+=HeapSortTimes[k];
           AverageQuickSort[k/10]+=QuickSortTimes[k];
           AverageInsertionSort[k/10]+=InsertionSortTimes[k];
           AverageMergeDLLSort[k/10]+=MergeSortDLLTimes[k];
       }
       for(int k= 0; k<10;k++){
           AverageMergeSort[k]=AverageMergeSort[k]/10.0;
           AverageHeapSort[k]=AverageHeapSort[k]/10.0;
           AverageInsertionSort[k]=AverageInsertionSort[k]/10.0;
           AverageQuickSort[k]=AverageQuickSort[k]/10.0;
           AverageMergeDLLSort[k]=AverageMergeDLLSort[k]/10.0;
       }

        for(int k=0;k<10;k++){
           System.out.println("Size = "+(int) Math.pow(2, (k + 1)) * 10);
           System.out.printf("AQS : %.3f ,  AHS : %.3f ,  AIS : %.3f ,  AMS : %.3f ,  AmSDLL : %.3f\n",AverageQuickSort[k],AverageHeapSort[k],AverageInsertionSort[k],AverageMergeSort[k],AverageMergeDLLSort[k]);
          // System.out.print("AQS : " + AverageQuickSort[k] + " , " + "AHS : " + AverageHeapSort[k] + " , " + "AIS : " + AverageInsertionSort[k] + " , " + "AMS : " + AverageMergeSort[k] + ", AmSDLL : "+ AverageMergeDLLSort[k]+ "\n ");

       }
    }
}