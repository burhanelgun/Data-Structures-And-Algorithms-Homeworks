import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class MDSTreeTest {

    @org.junit.jupiter.api.Test
    void add() {
        System.out.println("*******************************************ADD METHOD TESTING***********************************");

        System.out.println("Data olarak Integer vektorü tutan bir MDSTree objesi oluşturuldu(default olarak 3 dimensionludur");
        MDSTree<Vector<Integer>> MDST= new MDSTree<>();

        System.out.println();
        System.out.println("MDSTree ye eklenecek olan vektör itemleri oluşturuldu ve bu vektörlere 3 er tane integer değer atandı");
        Vector<Integer> item1 = new Vector<>();
        Vector<Integer> item2 = new Vector<>();
        Vector<Integer> item3 = new Vector<>();
        Vector<Integer> item4 = new Vector<>();
        Vector<Integer> item5 = new Vector<>();
        Vector<Integer> item6 = new Vector<>();

        item1.add(38);
        item1.add(42);
        item1.add(8);

        item2.add(67);
        item2.add(7);
        item2.add(14);

        item3.add(12);
        item3.add(66);
        item3.add(24);

        item4.add(25);
        item4.add(33);
        item4.add(98);

        item5.add(26);
        item5.add(77);
        item5.add(46);


        System.out.println("Item1 = (38,42,8) MDSTree ye add methoduyla eklendi");
        MDST.add(item1);
        System.out.println("Item2 = (67,7,14) MDSTree ye add methoduyla eklendi");
        MDST.add(item2);
        System.out.println("Item3 = (12,66,24) MDSTree ye add methoduyla eklendi");
        MDST.add(item3);
        System.out.println("Item4 = (25,33,98) MDSTree ye add methoduyla eklendi");
        MDST.add(item4);
        System.out.println("Item5 = (26,77,46) MDSTree ye add methoduyla eklendi");
        MDST.add(item5);
        System.out.println();
        System.out.print("PreOrder Traverse =");
        MDST.printPreorder(MDST.root);
        System.out.println();
        System.out.println("*********************************************************************");


    }

    @org.junit.jupiter.api.Test
    void contains() {
        System.out.println("*******************************************CONTAINS METHOD TESTING***********************************");

        System.out.println("Data olarak Integer vektorü tutan bir MDSTree objesi oluşturuldu(default olarak 3 dimensionludur");
        MDSTree<Vector<Integer>> MDST= new MDSTree<>();

        System.out.println();
        System.out.println("MDSTree ye eklenecek olan vektör itemleri oluşturuldu ve bu vektörlere 3 er tane integer değer atandı");
        Vector<Integer> item1 = new Vector<>();
        Vector<Integer> item2 = new Vector<>();
        Vector<Integer> item3 = new Vector<>();
        Vector<Integer> item4 = new Vector<>();
        Vector<Integer> item5 = new Vector<>();
        Vector<Integer> item6 = new Vector<>();

        item1.add(38);
        item1.add(42);
        item1.add(8);

        item2.add(67);
        item2.add(7);
        item2.add(14);

        item3.add(12);
        item3.add(66);
        item3.add(24);

        item4.add(25);
        item4.add(33);
        item4.add(98);

        item5.add(26);
        item5.add(77);
        item5.add(46);

        item6.add(99);
        item6.add(98);
        item6.add(97);



        System.out.println("Item1 = (38,42,8) MDSTree ye add methoduyla eklendi");
        MDST.add(item1);
        System.out.println("Item2 = (67,7,14) MDSTree ye add methoduyla eklendi");
        MDST.add(item2);
        System.out.println("Item3 = (12,66,24) MDSTree ye add methoduyla eklendi");
        MDST.add(item3);
        System.out.println("Item4 = (25,33,98) MDSTree ye add methoduyla eklendi");
        MDST.add(item4);
        System.out.println("Item5 = (26,77,46) MDSTree ye add methoduyla eklendi");
        MDST.add(item5);
        System.out.println();
        System.out.print("PreOrder Traverse =");
        MDST.printPreorder(MDST.root);
        System.out.println();
        System.out.println("(99,98,97) lik vektör tree de varmı diye kontrol edilir(yoktur)(constains methoduyla)" );
        System.out.println("MDST.contains(99,98,97) = " + MDST.contains(item6));
        assertEquals( false,MDST.contains(item6));

        System.out.println("(12,66,24) lik vektör tree de varmı diye kontrol edilir(vardır)(constains methoduyla)" );
        System.out.println("MDST.contains(12,66,24) = " + MDST.contains(item3));
        assertEquals( true,MDST.contains(item3));

        System.out.println("*********************************************************************");
    }

    @org.junit.jupiter.api.Test
    void find() {
        System.out.println("*******************************************FIND METHOD TESTING***********************************");

        System.out.println("Data olarak Integer vektorü tutan bir MDSTree objesi oluşturuldu(default olarak 3 dimensionludur");
        MDSTree<Vector<Integer>> MDST= new MDSTree<>();

        System.out.println();
        System.out.println("MDSTree ye eklenecek olan vektör itemleri oluşturuldu ve bu vektörlere 3 er tane integer değer atandı");
        Vector<Integer> item1 = new Vector<>();
        Vector<Integer> item2 = new Vector<>();
        Vector<Integer> item3 = new Vector<>();
        Vector<Integer> item4 = new Vector<>();
        Vector<Integer> item5 = new Vector<>();
        Vector<Integer> item6 = new Vector<>();

        item1.add(38);
        item1.add(42);
        item1.add(8);

        item2.add(67);
        item2.add(7);
        item2.add(14);

        item3.add(12);
        item3.add(66);
        item3.add(24);

        item4.add(25);
        item4.add(33);
        item4.add(98);

        item5.add(26);
        item5.add(77);
        item5.add(46);

        item6.add(99);
        item6.add(98);
        item6.add(97);



        System.out.println("Item1 = (38,42,8) MDSTree ye add methoduyla eklendi");
        MDST.add(item1);
        System.out.println("Item2 = (67,7,14) MDSTree ye add methoduyla eklendi");
        MDST.add(item2);
        System.out.println("Item3 = (12,66,24) MDSTree ye add methoduyla eklendi");
        MDST.add(item3);
        System.out.println("Item4 = (25,33,98) MDSTree ye add methoduyla eklendi");
        MDST.add(item4);
        System.out.println("Item5 = (26,77,46) MDSTree ye add methoduyla eklendi");
        MDST.add(item5);
        System.out.println();
        System.out.print("PreOrder Traverse =");
        MDST.printPreorder(MDST.root);
        System.out.println();
        System.out.println("(99,98,97) lik vektör tree de varmı diye kontrol edilir(yoktur)(find methoduyla)(null return eder)" );
        System.out.println("MDST.find(99,98,97) = " + MDST.find(item6));
        assertEquals( null,MDST.find(item6));

        System.out.println("(12,66,24) lik vektör tree de varmı diye kontrol edilir(vardır)(find methoduyla)(12,66,24) lük vektör return eder" );
        System.out.println("MDST.find(12,66,24) = " + MDST.find(item3));
        assertEquals( item3,MDST.find(item3));

        System.out.println("*********************************************************************");
    }

    @org.junit.jupiter.api.Test
    void delete() {
        System.out.println("*******************************************DELETE METHOD TESTING***********************************");

        System.out.println("Data olarak Integer vektorü tutan bir MDSTree objesi oluşturuldu(default olarak 3 dimensionludur");
        MDSTree<Vector<Integer>> MDST= new MDSTree<>();

        System.out.println();
        System.out.println("MDSTree ye eklenecek olan vektör itemleri oluşturuldu ve bu vektörlere 3 er tane integer değer atandı");
        Vector<Integer> item1 = new Vector<>();
        Vector<Integer> item2 = new Vector<>();
        Vector<Integer> item3 = new Vector<>();
        Vector<Integer> item4 = new Vector<>();
        Vector<Integer> item5 = new Vector<>();
        Vector<Integer> item6 = new Vector<>();
        Vector<Integer> item7 = new Vector<>();


        item1.add(38);
        item1.add(42);
        item1.add(8);

        item2.add(67);
        item2.add(7);
        item2.add(14);

        item3.add(12);
        item3.add(66);
        item3.add(24);

        item4.add(25);
        item4.add(33);
        item4.add(98);

        item5.add(26);
        item5.add(77);
        item5.add(46);

        item6.add(99);
        item6.add(98);
        item6.add(97);



        System.out.println("Item1 = (38,42,8) MDSTree ye add methoduyla eklendi");
        MDST.add(item1);
        System.out.println("Item2 = (67,7,14) MDSTree ye add methoduyla eklendi");
        MDST.add(item2);
        System.out.println("Item3 = (12,66,24) MDSTree ye add methoduyla eklendi");
        MDST.add(item3);
        System.out.println("Item4 = (25,33,98) MDSTree ye add methoduyla eklendi");
        MDST.add(item4);
        System.out.println("Item5 = (26,77,46) MDSTree ye add methoduyla eklendi");
        MDST.add(item5);
        System.out.println();
        System.out.print("LevelOrder Traverse =");
        MDST.printLevelOrder(MDST.root);
        System.out.println();
        assertEquals(item2,MDST.delete(item2));
        System.out.println("(67,7,14) lük vektör tree den silindi(delete methoduyla)" );
        System.out.print("Kontrol etmek için levelOrder Traverse şeklinde print edilir= ");
        MDST.printLevelOrder(MDST.root);
        System.out.println();
        System.out.println("(67,7,14) lik vektör tree de varmı diye kontrol edilir(vardır)(find methoduyla) null return eder" );
        System.out.println("MDST.find(67,7,14) = " + MDST.find(item2));
        assertEquals( null,MDST.find(item2));



        System.out.println("*********************************************************************");
    }

    @org.junit.jupiter.api.Test
    void remove() {
        System.out.println("*******************************************REMOVE METHOD TESTING***********************************");

        System.out.println("Data olarak Integer vektorü tutan bir MDSTree objesi oluşturuldu(default olarak 3 dimensionludur");
        MDSTree<Vector<Integer>> MDST= new MDSTree<>();

        System.out.println();
        System.out.println("MDSTree ye eklenecek olan vektör itemleri oluşturuldu ve bu vektörlere 3 er tane integer değer atandı");
        Vector<Integer> item1 = new Vector<>();
        Vector<Integer> item2 = new Vector<>();
        Vector<Integer> item3 = new Vector<>();
        Vector<Integer> item4 = new Vector<>();
        Vector<Integer> item5 = new Vector<>();
        Vector<Integer> item6 = new Vector<>();
        Vector<Integer> item7 = new Vector<>();


        item1.add(38);
        item1.add(42);
        item1.add(8);

        item2.add(67);
        item2.add(7);
        item2.add(14);

        item3.add(12);
        item3.add(66);
        item3.add(24);

        item4.add(25);
        item4.add(33);
        item4.add(98);

        item5.add(26);
        item5.add(77);
        item5.add(46);

        item6.add(99);
        item6.add(98);
        item6.add(97);



        System.out.println("Item1 = (38,42,8) MDSTree ye add methoduyla eklendi");
        MDST.add(item1);
        System.out.println("Item2 = (67,7,14) MDSTree ye add methoduyla eklendi");
        MDST.add(item2);
        System.out.println("Item3 = (12,66,24) MDSTree ye add methoduyla eklendi");
        MDST.add(item3);
        System.out.println("Item4 = (25,33,98) MDSTree ye add methoduyla eklendi");
        MDST.add(item4);
        System.out.println("Item5 = (26,77,46) MDSTree ye add methoduyla eklendi");
        MDST.add(item5);
        System.out.println();
        System.out.print("LevelOrder Traverse =");
        MDST.printLevelOrder(MDST.root);
        System.out.println();
        assertEquals(true,MDST.remove(item2));
        System.out.println("(67,7,14) lük vektör tree den silindi(remove methoduyla)" );
        System.out.print("Kontrol etmek için levelOrder Traverse şeklinde print edilir= ");
        MDST.printLevelOrder(MDST.root);
        System.out.println();
        System.out.println("(67,7,14) lik vektör tree de varmı diye kontrol edilir(vardır)(find methoduyla) null return eder" );
        System.out.println("MDST.find(67,7,14) = " + MDST.find(item2));
        assertEquals( null,MDST.find(item2));



        System.out.println("*********************************************************************");
    }
}