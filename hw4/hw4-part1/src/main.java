public class main{
    public static void main(String[] args){

        System.out.println("Explanation daki örneğin aynısı yapılmıştır ve çıktılar şu şekildedir:");
        GeneralTrees<Integer> a =new GeneralTrees<Integer>();
        a.add(1,2);
        System.out.println("parent: 1, child: 2 eklenmiştir");
        a.add(1,4);
        System.out.println("parent: 1, child: 4 eklenmiştir");
        a.add(1,7);
        System.out.println("parent: 1, child: 7 eklenmiştir");
        a.add(2,3);
        System.out.println("parent: 2, child: 3 eklenmiştir");
        a.add(2,6);
        System.out.println("parent: 2, child: 6 eklenmiştir");
        a.add(3,5);
        System.out.println("parent: 3, child: 5 eklenmiştir");


        System.out.print("pre order traverse = " );
        a.preOrderTraverse(a.root);
        System.out.println();
        System.out.print("post order traverse = " );
        a.postOrderTraverse(a.root);
        System.out.println();
        System.out.print("level order traverse = " );
        a.levelOrderTraverse(a.root);
        System.out.println();

        System.out.println();
        System.out.println("Tree 7 içerir mi (levelOrderSearch kullanarak)");
        System.out.println("a.levelOrderSearch(7,a.root) = " + a.levelOrderSearch(7,a.root));
        System.out.println("Tree 7 içerir");
        System.out.println();

        System.out.println("Tree -99 içerir mi (levelOrderSearch kullanarak)");
        System.out.println("a.levelOrderSearch(-99,a.root) = " + a.levelOrderSearch(-99,a.root));
        System.out.println("Tree -99 içermez");
        System.out.println();
        System.out.println();


        System.out.println("Tree 7 içerir mi (postOrderSearch kullanarak)");
        System.out.println("a.postOrderSearch(7,a.root) = " + a.postOrderSearch(7,a.root));
        System.out.println("Tree 7 içerir");
        System.out.println();

        System.out.println("Tree -99 içerir mi (postOrderSearch kullanarak)");
        System.out.println("a.postOrderSearch(-99,a.root) = " + a.postOrderSearch(-99,a.root));
        System.out.println("Tree -99 içermez");

        StringBuilder b = new StringBuilder();
        a.printTree(a.root);
    }
}