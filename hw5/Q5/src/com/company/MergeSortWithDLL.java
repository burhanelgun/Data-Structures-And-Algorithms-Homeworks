package com.company;

/**
 *mergeSortu double linked list ile implement eden classtır.İçerisinde Double linked list vardır ve merge sort fonksiyonu bu linked listi kullanarak impelement edilmiştir.
 */
class MergeSortWithDLL {
    /**
     * Listenin başını tutar
     */
    public Node head;
    /**
     * Listenin sonunu tutar
     */
    private Node tail;
    /**
     * Listeninin size ını tutar
     */
    private int size;

    /**
     * Doble linked list teki her bir Node u temsil eden classtır.
     */
    public class Node {
        /**
         * Node 'un içinde tuttuğu veridir.
         */
        int data;
        /**
         * Node un nextini gösterir
         */
        Node next = null;
        /**
         * Node un previus unu gösterir
         */
        Node prev = null;

        /**
         * gelen parametreye göre o parametreyi içeren Node oluşturur
         * @param d Node içerisinde bulunan data dır.
         */
        Node(int d) {
            data = d;
        }

        /**
         * Bir yere yeni bir node eklemek istediğimizde kullanılan methodtur
         * @param data node içindeki data
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
     * Listenin sonuna elemaan eklemek için kullanılan methodtur.
     * @param data listenin sonuna eklenmek istenen elemanın kendisidir.
     */
    public void addLast(int data) {

        Node a = new Node(data, null, tail); // nexti null, previous u tail olan bir Node oluşturuldu
        if(tail != null) {
            tail.next = a; // ve en sona eklendi
        }
        tail = a; // eğer tail null sa tail yerine eklendi.
        if(head == null) {
            head = a; // eğer head nullsa head in yerine eklendi
        }
        size++; // size 1 arttırıldı
    }

    /**
     * Listeyi ekrana bastırmak için kullanılan methodtur
     * @param node head gönderilir
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
     * Listeyi ortadan iki farklı parçaya bölen methodtur
     * @param head head gönderilir
     * @return Node return edilir
     */
    Node split(Node head) {
        Node ilk = head;
        Node son = head;
        while (ilk.next != null && ilk.next.next != null) { // listeyi ortadan iki farklı listeye böler
            ilk = ilk.next.next;
            son = son.next;
        }
        Node a = son.next;
        son.next = null;
        return a;
    }

    /**
     * mergeSort için helper methodtur
     * @return mergeSort methodunu çalıştırır head parametresi ile
     */
    Node mergeSort(){
        return mergeSort(head); // helper methodtur
    }

    /**
     * Sağ ve sol yarım parçalar recursive olarak meergeSort methoduna gönderilir
     * Double Linked Listi kullanarak mergeSort işlemi yapılır
     * @param node paremetre olarak gelen Node tan başlanır
     * @return merge methodu return edlir
     */
    Node mergeSort(Node node) {

        if (node == null || node.next == null) {
            return node;
        }
        Node second = split(node); // ikinci parçaya ayırır listeyi

        node = mergeSort(node); // ilk parçayı merge sorta gönderir
        second = mergeSort(second); // ikinci parçayı mergeSorta gönderir

        return merge(node, second); // sıralı iki parçadan oluşan listeyi birleştiren methodtur
    }

    /**
     * iki ayrı sorted double linked listi birleştiren methodtur
     * @param first ilk double linked list(sorted)
     * @param second ikinci double linked list(sorted)
     * @return birleştirilmiş olan linked listin head i ni return eder.
     */
    Node merge(Node first, Node second) {
        if (first == null) { // ilk linked list boşsa ikinci linked listin nodu return edilir
            return second;
        }
        if (second == null) { // İkinci linked list boşsa ilk linked list return edilir
            return first;
        }
        if (first.data < second.data) { // hangisinin datası daha kuçukse başa o gelir
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