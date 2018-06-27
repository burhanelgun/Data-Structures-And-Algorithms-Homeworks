import java.util.Vector;

public class main {
    public static void main(String[] args){
        MDSTree<Vector<Integer>> MDST= new MDSTree<>();
        Vector<Integer> item1 = new Vector<>();
        Vector<Integer> item2 = new Vector<>();
        Vector<Integer> item3 = new Vector<>();
        Vector<Integer> item4 = new Vector<>();
        Vector<Integer> item5 = new Vector<>();
        Vector<Integer> item6 = new Vector<>();

        item1.add(40);
        item1.add(45);
        item1.add(10);

        item2.add(70);
        item2.add(10);
        item2.add(16);

        item3.add(15);
        item3.add(70);
        item3.add(26);

        item4.add(26);
        item4.add(35);
        item4.add(100);

        item5.add(29);
        item5.add(80);
        item5.add(50);

        item6.add(99);
        item6.add(98);
        item6.add(97);

        System.out.println();
        System.out.println("**********************ADD METHOD TESTING*****************************");
        MDST.add(item1);
        System.out.println("(40,45,10) luk bir vektör oluşturuldu.Ve tree ye eklendi" );
        MDST.add(item2);
        System.out.println("(70,10,16) lık bir vektör oluşturuldu.Ve tree ye eklendi" );
        MDST.add(item3);
        System.out.println("(15,70,26) lık bir vektör oluşturuldu.Ve tree ye eklendi" );
        MDST.add(item4);
        System.out.println("(26,35,100) lük bir vektör oluşturuldu.Ve tree ye eklendi" );
        MDST.add(item5);
        System.out.println("(29,80,50) lik bir vektör oluşturuldu.Ve tree ye eklendi" );
        System.out.println("*********************************************************************");
        System.out.println();


        System.out.println("**********************TRAVERSE TESTING*******************************");
        System.out.print("PreOrder Traverse =");
        MDST.printPreorder(MDST.root);
        System.out.println();

        System.out.print("PostOrder Traverse =");
        MDST.printPostorder(MDST.root);
        System.out.println();

        System.out.print("LevelOrder Traverse =");
        MDST.printLevelOrder(MDST.root);
        System.out.println();
        System.out.println("*********************************************************************");
        System.out.println();

        System.out.println("********************DELETE METHOD TESTING****************************");
        MDST.delete(item5);
        System.out.println("(29,80,50) lık vektör tree den silindi(delete methoduyla)" );
        System.out.print("Kontrol etmek için levelOrder Traverse şeklinde print edilir= ");
        MDST.printLevelOrder(MDST.root);
        System.out.println();
        System.out.println("*********************************************************************");
        System.out.println();

        System.out.println("*********************REMOVE METHOD TESTING***************************");
        MDST.remove(item2);
        System.out.println("(70,10,16) lik vektör tree den silindi(remove methoduyla)" );
        System.out.print("Kontrol etmek için levelOrder Traverse şeklinde print edilir= ");
        MDST.printLevelOrder(MDST.root);
        System.out.println();
        System.out.println("*********************************************************************");
        System.out.println();


        System.out.println("*********************CONTAINS METHOD TESTING***************************");
        System.out.println("(40,45,10) lik vektör tree de varmı diye kontrol edilir(vardır)(constains methoduyla)" );
        System.out.println("MDST.contains(40,45,10) = " + MDST.contains(item1));
        System.out.println();
        System.out.println("(99,98,97) lik vektör tree de varmı diye kontrol edilir(yoktur)(constains methoduyla)" );
        System.out.println("MDST.contains(99,98,97) = " + MDST.contains(item6));
        System.out.println("***********************************************************************");
        System.out.println();


        System.out.println("*********************FIND METHOD TESTING***************************");
        System.out.println("(15,70,26) lik vektör tree de varmı diye kontrol edilir(vardır)(constains methoduyla)" );
        System.out.println("MDST.contains(15,70,26) = " + MDST.find(item3));
        System.out.println();
        System.out.println("(99,98,97) lik vektör tree de varmı diye kontrol edilir(yoktur)(constains methoduyla)" );
        System.out.println("MDST.contains(99,98,97) = " + MDST.find(item6));
        System.out.println("***********************************************************************");





    }
}
