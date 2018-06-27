import static org.junit.jupiter.api.Assertions.*;

class GeneralTreesTest {

    @org.junit.jupiter.api.Test
    void add() {
        System.out.println("*********************ADD METHOD TESTING**************************");
        System.out.println("FIRST TREE");
        System.out.println("***********");

        GeneralTrees<Integer> a =new GeneralTrees<Integer>();

        a.add(1,2);
        System.out.println("parent: 1, child: 2 eklenmiştir");
        a.printTree(a.root);
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();


        a.add(1,4);
        System.out.println("parent: 1, child: 4 eklenmiştir");
        a.printTree(a.root);
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        a.add(1,7);
        System.out.println("parent: 1, child: 7 eklenmiştir");
        a.printTree(a.root);
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        a.add(2,3);
        System.out.println("parent: 2, child: 3 eklenmiştir");
        a.printTree(a.root);
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        a.add(2,6);
        System.out.println("parent: 2, child: 6 eklenmiştir");
        a.printTree(a.root);
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        a.add(3,5);
        System.out.println("parent: 3, child: 5 eklenmiştir");
        a.printTree(a.root);
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        a.add(3,9);
        System.out.println("parent: 3, child: 9 eklenmiştir");
        a.printTree(a.root);
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        a.add(3,10);
        System.out.println("parent: 3, child: 10 eklenmiştir");
        a.printTree(a.root);
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        a.add(5,12);
        System.out.println("parent: 5, child: 12 eklenmiştir");
        a.printTree(a.root);
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        a.add(5,14);
        System.out.println("parent: 5, child: 14 eklenmiştir");
        a.printTree(a.root);
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        a.add(9,17);
        System.out.println("parent: 9, child: 17 eklenmiştir");
        a.printTree(a.root);
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        a.add(9,18);
        System.out.println("parent: 9, child: 18 eklenmiştir");
        a.printTree(a.root);
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.println();

        System.out.println("***************************************************");
        System.out.println();
        System.out.println();

        System.out.println("SECOND TREE");
        System.out.println("************");
        GeneralTrees<Integer> b =new GeneralTrees<Integer>();

        b.add(3,4);
        System.out.println("parent: 3, child: 4 eklenmiştir");
        b.printTree(b.root);
        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();


        b.add(4,21);
        System.out.println("parent: 4, child: 21 eklenmiştir");
        b.printTree(b.root);
        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        b.add(21,25);
        System.out.println("parent: 21, child: 25 eklenmiştir");
        b.printTree(b.root);
        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        b.add(25,29);
        System.out.println("parent: 25, child: 29 eklenmiştir");
        b.printTree(b.root);
        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        b.add(29,27);
        System.out.println("parent: 29, child: 27 eklenmiştir");
        b.printTree(b.root);
        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        b.add(29,34);
        System.out.println("parent: 29, child: 34 eklenmiştir");
        b.printTree(b.root);
        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        b.add(29,42);
        System.out.println("parent: 29, child: 42 eklenmiştir");
        b.printTree(b.root);
        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        b.add(42,54);
        System.out.println("parent: 42, child: 54 eklenmiştir");
        b.printTree(b.root);
        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        b.add(29,30);
        System.out.println("parent: 29, child: 30 eklenmiştir");
        b.printTree(b.root);
        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        b.add(34,66);
        System.out.println("parent: 34, child: 66 eklenmiştir");
        b.printTree(b.root);
        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        b.add(34,69);
        System.out.println("parent: 34, child: 69 eklenmiştir");
        b.printTree(b.root);
        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();
        System.out.println("**********************************");
        System.out.println();

        b.add(34,71);
        System.out.println("parent: 34, child: 71 eklenmiştir");
        b.printTree(b.root);
        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();
        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();
        System.out.println();

        System.out.println("*******************************************************************************");
        System.out.println();
        System.out.println();


    }

    @org.junit.jupiter.api.Test
    void postOrderSearch() {
        System.out.println("*********************POSTORDERSEARCH METHOD TESTING**************************");
        System.out.println("FIRST TREE");
        System.out.println("***********");

        GeneralTrees<Integer> a =new GeneralTrees<Integer>();

        a.add(1,2);
        System.out.println("parent: 1, child: 2 eklenmiştir");
        a.add(2,3);
        System.out.println("parent: 2, child: 3 eklenmiştir");
        a.add(3,4);
        System.out.println("parent: 3, child: 4 eklenmiştir");
        a.add(4,5);
        System.out.println("parent: 4, child: 5 eklenmiştir");
        a.add(5,6);
        System.out.println("parent: 5, child: 6 eklenmiştir");
        a.add(6,7);
        System.out.println("parent: 6, child: 7 eklenmiştir");
        a.add(7,8);
        System.out.println("parent: 7, child: 8 eklenmiştir");
        a.add(8,9);
        System.out.println("parent: 8, child: 9 eklenmiştir");
        a.add(9,10);
        System.out.println("parent: 9 child: 10 eklenmiştir");
        a.add(10,11);
        System.out.println("parent: 10, child: 11 eklenmiştir");
        a.add(11,12);
        System.out.println("parent: 11, child: 12 eklenmiştir");
        a.add(12,13);
        System.out.println("parent: 12, child: 13 eklenmiştir");
        a.add(13,14);
        System.out.println("parent: 13, child: 14 eklenmiştir");


        System.out.println();
        System.out.println("Tree 7 içerir mi (postOrderSearch kullanarak)");
        System.out.println("a.postOrderSearch(7,a.root) = " + a.postOrderSearch(7,a.root));
        System.out.println("Tree 7 içerir");
        System.out.println();
        assertEquals(7,a.postOrderSearch(7,a.root).data);

        System.out.println("Tree -99 içerir mi (postOrderSearch kullanarak)");
        System.out.println("a.postOrderSearch(-99,a.root) = " + a.postOrderSearch(-99,a.root));
        System.out.println("Tree -99 içermez");
        assertEquals(null,a.postOrderSearch(-99,a.root));

        System.out.println("***************************************************");
        System.out.println();
        System.out.println();

        System.out.println("SECOND TREE");
        System.out.println("************");
        GeneralTrees<Integer> b =new GeneralTrees<Integer>();
        b.add(14,13);
        System.out.println("parent: 14, child: 13 eklenmiştir");
        b.add(13,12);
        System.out.println("parent: 13, child: 12 eklenmiştir");
        b.add(12,11);
        System.out.println("parent: 12, child: 11 eklenmiştir");
        b.add(11,10);
        System.out.println("parent: 11, child: 10 eklenmiştir");
        b.add(10,9);
        System.out.println("parent: 10, child: 9 eklenmiştir");
        b.add(9,8);
        System.out.println("parent: 9, child: 8 eklenmiştir");
        b.add(8,7);
        System.out.println("parent: 8, child: 7 eklenmiştir");
        b.add(7,6);
        System.out.println("parent: 7, child: 6 eklenmiştir");
        b.add(6,5);
        System.out.println("parent: 6, child: 5 eklenmiştir");
        b.add(5,4);
        System.out.println("parent: 5, child: 4 eklenmiştir");
        b.add(4,3);
        System.out.println("parent: 4, child: 3 eklenmiştir");
        b.add(3,2);
        System.out.println("parent: 3, child: 2 eklenmiştir");


        System.out.println();
        System.out.println("Tree 7 içerir mi (postOrderSearch kullanarak)");
        System.out.println("b.postOrderSearch(7,b.root) = " + b.postOrderSearch(7,b.root));
        System.out.println("Tree 7 içerir");
        System.out.println();
        assertEquals(7,b.postOrderSearch(7,b.root).data);

        System.out.println("Tree -99 içerir mi (postOrderSearch kullanarak)");
        System.out.println("b.postOrderSearch(-99,b.root) = " + b.postOrderSearch(-99,b.root));
        System.out.println("Tree -99 içermez");
        assertEquals(null,b.postOrderSearch(-99,b.root));
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void postOrderTraverse() {
        System.out.println("*********************POSTORDERTRAVERSE METHOD TESTING**************************");
        System.out.println("FIRST TREE");
        System.out.println("***********");

        GeneralTrees<Integer> a =new GeneralTrees<Integer>();

        a.add(1,2);
        System.out.println("parent: 1, child: 2 eklenmiştir");
        a.add(2,3);
        System.out.println("parent: 2, child: 3 eklenmiştir");
        a.add(3,4);
        System.out.println("parent: 3, child: 4 eklenmiştir");
        a.add(4,5);
        System.out.println("parent: 4, child: 5 eklenmiştir");
        a.add(5,6);
        System.out.println("parent: 5, child: 6 eklenmiştir");
        a.add(6,7);
        System.out.println("parent: 6, child: 7 eklenmiştir");
        a.add(7,8);
        System.out.println("parent: 7, child: 8 eklenmiştir");
        a.add(8,9);
        System.out.println("parent: 8, child: 9 eklenmiştir");
        a.add(9,10);
        System.out.println("parent: 9 child: 10 eklenmiştir");
        a.add(10,11);
        System.out.println("parent: 10, child: 11 eklenmiştir");
        a.add(11,12);
        System.out.println("parent: 11, child: 12 eklenmiştir");
        a.add(12,13);
        System.out.println("parent: 12, child: 13 eklenmiştir");
        a.add(13,14);
        System.out.println("parent: 13, child: 14 eklenmiştir");

        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();

        System.out.println("***************************************************");
        System.out.println();
        System.out.println();

        System.out.println("SECOND TREE");
        System.out.println("************");
        GeneralTrees<Integer> b =new GeneralTrees<Integer>();
        b.add(14,13);
        System.out.println("parent: 14, child: 13 eklenmiştir");
        b.add(13,12);
        System.out.println("parent: 13, child: 12 eklenmiştir");
        b.add(12,11);
        System.out.println("parent: 12, child: 11 eklenmiştir");
        b.add(11,10);
        System.out.println("parent: 11, child: 10 eklenmiştir");
        b.add(10,9);
        System.out.println("parent: 10, child: 9 eklenmiştir");
        b.add(9,8);
        System.out.println("parent: 9, child: 8 eklenmiştir");
        b.add(8,7);
        System.out.println("parent: 8, child: 7 eklenmiştir");
        b.add(7,6);
        System.out.println("parent: 7, child: 6 eklenmiştir");
        b.add(6,5);
        System.out.println("parent: 6, child: 5 eklenmiştir");
        b.add(5,4);
        System.out.println("parent: 5, child: 4 eklenmiştir");
        b.add(4,3);
        System.out.println("parent: 4, child: 3 eklenmiştir");
        b.add(3,2);
        System.out.println("parent: 3, child: 2 eklenmiştir");


        System.out.print("post order traverse = " );
        b.postOrderTraverse(b.root);
        System.out.println();

        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void preOrderTraverse() {
        System.out.println("*********************PREORDERTRAVERSE METHOD TESTING**************************");
        System.out.println("FIRST TREE");
        System.out.println("***********");

        GeneralTrees<Integer> a =new GeneralTrees<Integer>();

        a.add(1,2);
        System.out.println("parent: 1, child: 2 eklenmiştir");
        a.add(2,3);
        System.out.println("parent: 2, child: 3 eklenmiştir");
        a.add(3,4);
        System.out.println("parent: 3, child: 4 eklenmiştir");
        a.add(4,5);
        System.out.println("parent: 4, child: 5 eklenmiştir");
        a.add(5,6);
        System.out.println("parent: 5, child: 6 eklenmiştir");
        a.add(6,7);
        System.out.println("parent: 6, child: 7 eklenmiştir");
        a.add(7,8);
        System.out.println("parent: 7, child: 8 eklenmiştir");
        a.add(8,9);
        System.out.println("parent: 8, child: 9 eklenmiştir");
        a.add(9,10);
        System.out.println("parent: 9 child: 10 eklenmiştir");
        a.add(10,11);
        System.out.println("parent: 10, child: 11 eklenmiştir");
        a.add(11,12);
        System.out.println("parent: 11, child: 12 eklenmiştir");
        a.add(12,13);
        System.out.println("parent: 12, child: 13 eklenmiştir");
        a.add(13,14);
        System.out.println("parent: 13, child: 14 eklenmiştir");


        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();

        System.out.println("***************************************************");
        System.out.println();
        System.out.println();

        System.out.println("SECOND TREE");
        System.out.println("************");
        GeneralTrees<Integer> b =new GeneralTrees<Integer>();
        b.add(14,13);
        System.out.println("parent: 14, child: 13 eklenmiştir");
        b.add(13,12);
        System.out.println("parent: 13, child: 12 eklenmiştir");
        b.add(12,11);
        System.out.println("parent: 12, child: 11 eklenmiştir");
        b.add(11,10);
        System.out.println("parent: 11, child: 10 eklenmiştir");
        b.add(10,9);
        System.out.println("parent: 10, child: 9 eklenmiştir");
        b.add(9,8);
        System.out.println("parent: 9, child: 8 eklenmiştir");
        b.add(8,7);
        System.out.println("parent: 8, child: 7 eklenmiştir");
        b.add(7,6);
        System.out.println("parent: 7, child: 6 eklenmiştir");
        b.add(6,5);
        System.out.println("parent: 6, child: 5 eklenmiştir");
        b.add(5,4);
        System.out.println("parent: 5, child: 4 eklenmiştir");
        b.add(4,3);
        System.out.println("parent: 4, child: 3 eklenmiştir");
        b.add(3,2);
        System.out.println("parent: 3, child: 2 eklenmiştir");

        System.out.print("pre order traverse = " );
        b.preOrderTraverse(b.root);
        System.out.println();

        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void levelOrderSearch() {
        System.out.println("*********************LEVELORDERSEARCH METHOD TESTING**************************");
        System.out.println("FIRST TREE");
        System.out.println("***********");

        GeneralTrees<Integer> a =new GeneralTrees<Integer>();

        a.add(1,2);
        System.out.println("parent: 1, child: 2 eklenmiştir");
        a.add(2,3);
        System.out.println("parent: 2, child: 3 eklenmiştir");
        a.add(3,4);
        System.out.println("parent: 3, child: 4 eklenmiştir");
        a.add(4,5);
        System.out.println("parent: 4, child: 5 eklenmiştir");
        a.add(5,6);
        System.out.println("parent: 5, child: 6 eklenmiştir");
        a.add(6,7);
        System.out.println("parent: 6, child: 7 eklenmiştir");
        a.add(7,8);
        System.out.println("parent: 7, child: 8 eklenmiştir");
        a.add(8,9);
        System.out.println("parent: 8, child: 9 eklenmiştir");
        a.add(9,10);
        System.out.println("parent: 9 child: 10 eklenmiştir");
        a.add(10,11);
        System.out.println("parent: 10, child: 11 eklenmiştir");
        a.add(11,12);
        System.out.println("parent: 11, child: 12 eklenmiştir");
        a.add(12,13);
        System.out.println("parent: 12, child: 13 eklenmiştir");
        a.add(13,14);
        System.out.println("parent: 13, child: 14 eklenmiştir");


        System.out.println();
        System.out.println("Tree 7 içerir mi (levelOrderSearch kullanarak)");
        System.out.println("a.levelOrderSearch(7,a.root) = " + a.levelOrderSearch(7,a.root));
        System.out.println("Tree 7 içerir");
        System.out.println();
        assertEquals(7,a.levelOrderSearch(7,a.root).data);

        System.out.println("Tree -99 içerir mi (levelOrderSearch kullanarak)");
        System.out.println("a.levelOrderSearch(-99,a.root) = " + a.levelOrderSearch(-99,a.root));
        System.out.println("Tree -99 içermez");
        assertEquals(null,a.levelOrderSearch(-99,a.root));

        System.out.println("***************************************************");
        System.out.println();
        System.out.println();

        System.out.println("SECOND TREE");
        System.out.println("************");
        GeneralTrees<Integer> b =new GeneralTrees<Integer>();
        b.add(14,13);
        System.out.println("parent: 14, child: 13 eklenmiştir");
        b.add(13,12);
        System.out.println("parent: 13, child: 12 eklenmiştir");
        b.add(12,11);
        System.out.println("parent: 12, child: 11 eklenmiştir");
        b.add(11,10);
        System.out.println("parent: 11, child: 10 eklenmiştir");
        b.add(10,9);
        System.out.println("parent: 10, child: 9 eklenmiştir");
        b.add(9,8);
        System.out.println("parent: 9, child: 8 eklenmiştir");
        b.add(8,7);
        System.out.println("parent: 8, child: 7 eklenmiştir");
        b.add(7,6);
        System.out.println("parent: 7, child: 6 eklenmiştir");
        b.add(6,5);
        System.out.println("parent: 6, child: 5 eklenmiştir");
        b.add(5,4);
        System.out.println("parent: 5, child: 4 eklenmiştir");
        b.add(4,3);
        System.out.println("parent: 4, child: 3 eklenmiştir");
        b.add(3,2);
        System.out.println("parent: 3, child: 2 eklenmiştir");


        System.out.println();
        System.out.println("Tree 7 içerir mi (levelOrderSearch kullanarak)");
        System.out.println("b.levelOrderSearch(7,b.root) = " + b.levelOrderSearch(7,b.root));
        System.out.println("Tree 7 içerir");
        System.out.println();
        assertEquals(7,b.levelOrderSearch(7,b.root).data);

        System.out.println("Tree -99 içerir mi (levelOrderSearch kullanarak)");
        System.out.println("b.levelOrderSearch(-99,b.root) = " + b.levelOrderSearch(-99,b.root));
        System.out.println("Tree -99 içermez");
        assertEquals(null,b.levelOrderSearch(-99,b.root));
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    void levelOrderTraverse() {
        System.out.println("*********************LEVELORDERTRAVERSE METHOD TESTING**************************");
        System.out.println("FIRST TREE");
        System.out.println("***********");

        GeneralTrees<Integer> a =new GeneralTrees<Integer>();

        a.add(1,2);
        System.out.println("parent: 1, child: 2 eklenmiştir");
        a.add(2,3);
        System.out.println("parent: 2, child: 3 eklenmiştir");
        a.add(3,4);
        System.out.println("parent: 3, child: 4 eklenmiştir");
        a.add(4,5);
        System.out.println("parent: 4, child: 5 eklenmiştir");
        a.add(5,6);
        System.out.println("parent: 5, child: 6 eklenmiştir");
        a.add(6,7);
        System.out.println("parent: 6, child: 7 eklenmiştir");
        a.add(7,8);
        System.out.println("parent: 7, child: 8 eklenmiştir");
        a.add(8,9);
        System.out.println("parent: 8, child: 9 eklenmiştir");
        a.add(9,10);
        System.out.println("parent: 9 child: 10 eklenmiştir");
        a.add(10,11);
        System.out.println("parent: 10, child: 11 eklenmiştir");
        a.add(11,12);
        System.out.println("parent: 11, child: 12 eklenmiştir");
        a.add(12,13);
        System.out.println("parent: 12, child: 13 eklenmiştir");
        a.add(13,14);
        System.out.println("parent: 13, child: 14 eklenmiştir");


        System.out.print("level order traverse = " );
        a.levelOrderTraverse(a.root);
        System.out.println();

        System.out.println("***************************************************");
        System.out.println();
        System.out.println();

        System.out.println("SECOND TREE");
        System.out.println("************");
        GeneralTrees<Integer> b =new GeneralTrees<Integer>();
        b.add(14,13);
        System.out.println("parent: 14, child: 13 eklenmiştir");
        b.add(13,12);
        System.out.println("parent: 13, child: 12 eklenmiştir");
        b.add(12,11);
        System.out.println("parent: 12, child: 11 eklenmiştir");
        b.add(11,10);
        System.out.println("parent: 11, child: 10 eklenmiştir");
        b.add(10,9);
        System.out.println("parent: 10, child: 9 eklenmiştir");
        b.add(9,8);
        System.out.println("parent: 9, child: 8 eklenmiştir");
        b.add(8,7);
        System.out.println("parent: 8, child: 7 eklenmiştir");
        b.add(7,6);
        System.out.println("parent: 7, child: 6 eklenmiştir");
        b.add(6,5);
        System.out.println("parent: 6, child: 5 eklenmiştir");
        b.add(5,4);
        System.out.println("parent: 5, child: 4 eklenmiştir");
        b.add(4,3);
        System.out.println("parent: 4, child: 3 eklenmiştir");
        b.add(3,2);
        System.out.println("parent: 3, child: 2 eklenmiştir");


        System.out.print("level order traverse = " );
        b.levelOrderTraverse(b.root);
        System.out.println();

        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }
}