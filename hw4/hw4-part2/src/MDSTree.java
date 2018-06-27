import java.util.Vector;

/**
 * BinaryTree den Extend olmus ve SearchTree yi implement eden bir class tir
 * MultidimensionalSearchTree yapisini temsil etmektedir.
 * @param <E> nodelarin icinde tutulan datanin tipidir
 */
public class MDSTree<E> extends BinaryTree<Vector<Integer>> implements SearchTree<E> {
    /**
     * dimensionSizeadli data field Tree nin kac dimensionlu oldugunu tutar
     */
    int dimensionSize;

    /**
     * No parameter constuructor default olarak dimensionSize i 3 yapar
     */
    MDSTree(){
        this.dimensionSize=3;
    }

    /**
     * gelen parametreye gore dimensionSizea atama yapar
     * @param dimensionSize Tree nin kac dimensionlu oldugu bilgisidir
     */
    MDSTree(int dimensionSize){
        this.dimensionSize=dimensionSize;
    }

    /**
     * Tree ye bir eleman eklenmek istenildiginde kullanilan methodtur
     * @param item tree ye eklenmek istenen paremetredir
     * @return eger add islemi yapildiysa true, eger add islemi yapilmadiysa false dondurur
     */
    public boolean add(E item){
        Vector<Integer> a = (Vector<Integer>) item;

        if(root==null){
            root=new Node(a);
            return true;
        }
        else{
            Node curr = root;
            int i = 0;
            while(true){
                while(i<dimensionSize){
                    if(i==0) {
                        if (getLevelHelper(root, curr.data) % dimensionSize == 0) {
                            if (a.get(dimensionSize) < (Integer) curr.data.get(dimensionSize-1)) {
                                if (curr.left != null)
                                    curr = curr.left;
                                else {
                                    curr.left = new Node(a);
                                    return true;
                                }
                            } else if (a.get(dimensionSize-1) > (Integer) curr.data.get(dimensionSize-1)) {
                                if (curr.right != null)
                                    curr = curr.right;
                                else {
                                    curr.right = new Node(a);
                                    return true;
                                }
                            } else {
                                curr.left = new Node(a);
                                return true;
                            }
                        }
                        i++;

                    }
                    else{
                        if(getLevelHelper(root,curr.data)%dimensionSize==i){

                            if (a.get(i-1) <(Integer)curr.data.get(i-1)) {
                                if (curr.left != null)
                                    curr = curr.left;
                                else {
                                    curr.left = new Node(a);
                                    return true;
                                }
                            } else if (a.get(i-1) >(Integer)curr.data.get(i-1)) {
                                if (curr.right != null)
                                    curr = curr.right;
                                else {
                                    curr.right = new Node(a);
                                    return true;
                                }
                            } else {
                                curr.left = new Node(a);
                                return true;
                            }
                        }
                        i++;
                    }
                }


            }
        }
    }

    /**
     * Bir elaman tree de bulunuyormu diye sorgu yapilmak istenirse kullanilan methodtur.
     * @param target tree de olup oladiginin sorgulandigu elemandir
     * @return eger target , tree de bulunuyorsa true, bulunmuyorsa false dondurur
     */
    public boolean contains(E target){
        Vector<Integer> a = (Vector<Integer>) target;

        Node node = root;
        if(node != null){

            Node b = node;
            while(b!=null){
                Node c = b;
                while(true){
                    if(c==null){
                        break;
                    }
                    if(c.data==a){
                        return true;
                    }
                    c=c.right;
                }
                b=b.left;
            }
            return false;

        }
        else {
            return false;
        }

    }

    /**
     * Bir elaman tree de bulunuyormu diye sorgu yapilmak istenirse kullanilan methodtur.
     * @param target tree de olup oladiginin sorgulandigu elemandir
     * @return eger target , tree de bulunuyorsa target , bulunmuyorsa null dondurulur
     */
    public E find(E target){
        Vector<Integer> a = (Vector<Integer>) target;

        Node node = root;
        if(node != null){

            Node b = node;
            while(b!=null){
                Node c = b;
                while(true){
                    if(c==null){
                        break;
                    }
                    if(c.data==a){
                        if(c.data.get(0)==null){
                            return null;
                        }
                        else{
                            return (E)c.data;
                        }
                    }
                    c=c.right;
                }
                b=b.left;
            }
            return null;

        }
        else {
            return null;
        }
    }

    /**
     * Eger tree den bir eleman silinmek isteniyorsa kullanilan methodtur
     * @param target silinmek istenen elemanin kendisidir
     * @return eger target silindiyse target return edilir. Eger silinmediyse null return edilir.
     */
    @Override
    public E delete(E target){

        Vector<Integer> a = (Vector<Integer>) target;
        Node node = root;

        if(node != null){

            Node b = node;
            while(b!=null){
                Node c = b;
                while(true){
                    if(c==null){
                        break;
                    }
                    if(c.data==target){
                        if(c.right==null && c.left==null){
                            c.data.set(0,null);
                            c.data.set(1,null);
                            c.data.set(2,null);
                            c = null;
                            return target;
                        }
                    }
                    c=c.right;
                }
                b=b.left;
            }
        }
        return null;
    }
    /**
     * Eger tree den bir eleman silinmek isteniyorsa kullanilan methodtur
     * @param target silinmek istenen elemanin kendisidir
     * @return eger target silindiyse true return edilir. Eger silinmediyse false return edilir.
     */
    public boolean remove(E target){

        Vector<Integer> a = (Vector<Integer>) target;
        Node node = root;

        if(node != null){

            Node b = node;
            while(b!=null){
                Node c = b;
                while(true){
                    if(c==null){
                        break;
                    }
                    if(c.data==target){
                        if(c.right==null && c.left==null){
                            c.data.set(0,null);
                            c.data.set(1,null);
                            c.data.set(2,null);
                            c = null;
                            return true;
                        }
                    }
                    c=c.right;
                }
                b=b.left;
            }
        }
        return false;
    }

    /**
     * Bir elemanin levelinin ogrenilmesi icin  kullanilan methodtur.
     * @param node bu parametre root alir(recursiveden dolayi gereklidir)
     * @param data levelinin ogrenilmesi istenilen parametredir
     * @param level nerden baslanarak aramanin yapilacaginin belirlendigi parametredir(1 gonderilir recursiveden dolayi gereklidir)
     * @return level return edilir
     */
    int getLevel(Node node, Vector<Integer> data, int level)
    {
        if (node == null)
            return 0;

        if (node.data == data)
            return level;

        int downlevel = getLevel(node.left, data, level + 1);
        if (downlevel != 0)
            return downlevel;

        downlevel = getLevel(node.right, data, level + 1);
        return downlevel;
    }

    /**
     * getLevel methodunun Helper methodur(recursiveden dolayi).Bir elemanin levelinin ogrenilmesi icin  kullanilan methodtur.
     * @param node bu parametre root alir(recursiveden dolayi gereklidir)
     * @param data levelinin ogrenilmesi istenilen parametredir
     * @return level return edilir
     */
    int getLevelHelper(Node node, Vector<Integer> data)
    {
        return getLevel(node, data, 1);
    }

    /**
     *preOrder sekilde traverse ederek tree yi dolasir ve print islemi yapar
     * @param node root alir node olarak
     */
    void printPreorder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node);
        printPreorder(node.left);
        printPreorder(node.right);
    }

    /**
     * postOrder sekilde traverse ederek treeyi dolasir ve print islemi yapar
     * @param node root alir node olarak
     */
    void printPostorder(Node node)
    {
        if (node == null)
            return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node);
    }

    /**
     * levelOrder sekilde traverse ederek tree yi dolasir ve print islemi yapar
     * @param node root alir node olarak
     */
    void printLevelOrder(Node node)
    {
        if (node == null)
            return;
        Node b = node;
        while(b!=null){
            Node c = b;
            while(true){
                if(c==null){
                    break;
                }
                if(c.data.get(0)!=null && c.data.get(1)!=null && c.data.get(2)!=null ) {
                    System.out.print(c.data);
                }
                c=c.right;
            }
            b=b.left;
        }
    }


}

