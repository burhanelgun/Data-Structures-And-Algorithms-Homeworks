package com.company;

public class Main {

    public static void main(String[] args) {

        MergeSortWithDLL list = new MergeSortWithDLL();


        list.addLast(27);
        list.addLast(4);
        list.addLast(8);
        list.addLast(5);
        list.addLast(16);
        list.addLast(44);
        list.addLast(56);
        list.addLast(28);
        list.addLast(17);
        list.addLast(26);



        MergeSortWithDLL.Node node = null;
        node = list.mergeSort();
        list.print(node);

    }
}
