import java.util.Random;
import java.util.stream.IntStream;

public class AverageRunTimeAnalysis{

    Integer[] generateRandomArray(int size){
        Random rand = new Random();
        Integer[]  randomIntsArray = new Integer[size];

        for (int i = 0; i<size;i++){
            randomIntsArray[i]=rand.nextInt(1000);
        }

        return randomIntsArray;

    }
    public MergeSortWithDLL.Node generateRandomDLL(int size){
        MergeSortWithDLL list = new MergeSortWithDLL();
        Random rand = new Random();
        for(int i=0;i<size;i++){
            list.addLast(rand.nextInt(1000));
        }
        return list.head;
    }


    static void printArray(double arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}