package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1 - MAP1");

        System.out.println("Size' 15 olan bir Double Hashing Map Oluşturuldu.");
        MapWithHashTable map1 = new MapWithHashTable(15);
        System.out.println("Double hashing map in içine 7 adet yeni key value pairi eklendi.(put methoduyla)");

        map1.put(new Integer(34),new String("Istanbul"));
        map1.put(new Integer(41),new String("Kocaeli"));
        map1.put(new Integer(6),new String("Ankara"));
        map1.put(new Integer(1),new String("Adana"));
        map1.put(new Integer(26),new String("Eskişehir"));
        map1.put(new Integer(57),new String("Sinop"));
        map1.put(new Integer(35),new String("Izmir"));
        System.out.print("Hash table print edilir.");
        map1.printHashTable();

        System.out.println();
        System.out.println("Keyi 1 olan value değerini get methoduyla alırız ve ekrana basarız");
        System.out.println(" 1 =  "+ map1.get(1));
        System.out.println("Key'i 34 olan pair listeden silinir(34,Istanbul)");
        map1.remove(34);
        System.out.print("Pair silindimi diye map tekrar print edilir");
        map1.printHashTable();
        System.out.print("Silinen pairin(34,Istanbul) keyi mapte bulunuyormu diye konrol edilir(containsKey methoduyla)= ");
        System.out.println(map1.containsKey(34));
        System.out.print("Mapte bulunan bir pairin(41,Kocaeli) keyi mapte bulunuyor mu diye konrol edilir(containsKey methoduyla) = ");
        System.out.println(map1.containsKey(41));

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2 - MAP2");


        System.out.println("Size' 10 olan bir Double Hashing Map Oluşturuldu.");
        MapWithHashTable map2 = new MapWithHashTable(10);
        System.out.println("Double hashing map in içine 5 adet yeni key value pairi eklendi(put methoduyla).");

        map2.put(new Integer(16),new String("Bursa"));
        map2.put(new Integer(61),new String("Trabzon"));
        map2.put(new Integer(51),new String("Niğde"));
        map2.put(new Integer(42),new String("Konya"));
        map2.put(new Integer(39),new String("Kırklareli"));

        System.out.print("Hash table print edilir.");
        map2.printHashTable();

        System.out.println();
        System.out.println("Keyi 42 olan value değerini get methoduyla alırız ve ekrana basarız");
        System.out.println(" 42 =  "+ map2.get(42));
        System.out.println("Key'i 61 olan pair listeden silinir(61,Trabzon)");
        map2.remove(61);
        System.out.print("Pair silindimi diye map tekrar print edilir");
        map2.printHashTable();
        System.out.print("Silinen pairin(61,Trabzon) keyi mapte bulunuyormu diye konrol edilir(containsKey methoduyla)= ");
        System.out.println(map2.containsKey(61));
        System.out.print("Mapte bulunan bir pairin(39,Kırklareli) keyi mapte bulunuyor mu diye konrol edilir(containsKey methoduyla) = ");
        System.out.println(map2.containsKey(39));


    }
}
