package com.company;

/**
 *mergeSortu double linked list ile implement eden classtir.Icerisinde Double linked list vardir ve merge sort fonksiyonu bu linked listi kullanarak impelement edilmistir.
 */
public class MergeSortWithDLL {
    /**
     * Listenin basini tutar
     */
    public Node head;
    /**
     * Listenin sonunu tutar
     */
    private Node tail;
    /**
     * Listeninin size ini tutar
     */
    private int size;

    /**
     * Doble linked list teki her bir Node u temsil eden classtir.
     */
    public class Node {
        /**
         * Node 'un icinde tuttugu veridir.
         */
        int data;
        /**
         * Node un nextini gosterir
         */
        Node next = null;
        /**
         * Node un previus unu gosterir
         */
        Node prev = null;

        /**
         * gelen parametreye gore o parametreyi iceren Node olusturur
         * @param d Node icerisinde bulunan data dir.
         */
        Node(int d) {
            data = d;
        }

        /**
         * Bir yere yeni bir node eklemek istedigimizde kullanilan methodtur
         * @param data node icindeki data
         * @param next nodeun nexti
         * @param prev node un previus u
         */
        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Listenin sonuna elemaan eklemek icin kullanilan methodtur.
     * @param data listenin sonuna eklenmek istenen elemanin kendisidir.
     */
    public void addLast(int data) {

        Node a = new Node(data, null, tail); // nexti null, previous u tail olan bir Node olusturuldu
        if(tail != null) {
            tail.next = a; // ve en sona eklendi
        }
        tail = a; // eger tail null sa tail yerine eklendi.
        if(head == null) {
            head = a; // eger head nullsa head in yerine eklendi
        }
        size++; // size 1 arttirildi
    }

    /**
     * Listeyi ekrana bastirmak icin kullanilan methodtur
     * @param node head gonderilir
     */
    void print(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
    }

    /**
     * Listeyi ortadan iki farkli parcaya bolen methodtur
     * @param head head gonderilir
     * @return Node return edilir
     */
    Node split(Node head) {
        Node ilk = head;
        Node son = head;
        while (ilk.next != null && ilk.next.next != null) { // listeyi ortadan iki farkli listeye boler
            ilk = ilk.next.next;
            son = son.next;
        }
        Node a = son.next;
        son.next = null;
        return a;
    }

    /**
     * mergeSort icin helper methodtur
     * @return mergeSort methodunu calistirir head parametresi ile
     */
    Node mergeSort(){
        return mergeSort(head); // helper methodtur
    }

    /**
     * Sag ve sol yarim parcalar recursive olarak meergeSort methoduna gonderilir
     * Double Linked Listi kullanarak mergeSort islemi yapilir
     * @param node paremetre olarak gelen Node tan baslanir
     * @return merge methodu return edlir
     */
    Node mergeSort(Node node) {

        if (node == null || node.next == null) {
            return node;
        }
        Node second = split(node); // ikinci parcaya ayirir listeyi

        node = mergeSort(node); // ilk parcayi merge sorta gonderir
        second = mergeSort(second); // ikinci parcayi mergeSorta gonderir

        return merge(node, second); // sirali iki parcadan olusan listeyi birlestiren methodtur
    }

    /**
     * iki ayri sorted double linked listi birlestiren methodtur
     * @param first ilk double linked list(sorted)
     * @param second ikinci double linked list(sorted)
     * @return birlestirilmis olan linked listin head i ni return eder.
     */
    Node merge(Node first, Node second) {
        if (first == null) { // ilk linked list bossa ikinci linked listin nodu return edilir
            return second;
        }
        if (second == null) { // Ikinci linked list bossa ilk linked list return edilir
            return first;
        }
        if (first.data < second.data) { // hangisinin datasi daha kucukse basa o gelir
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

}