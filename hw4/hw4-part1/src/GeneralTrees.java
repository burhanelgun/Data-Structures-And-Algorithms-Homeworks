import javax.swing.tree.TreeNode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *Genel tree leri implement etmek icin kullanilan bir classtir Binary treeden exten olmustur
 * @param <E> tutulan veri E generic tipinde olabilir
 */
public class GeneralTrees<E> extends BinaryTree<E> {
    /**
     * Tree ye item eklemek icin kullanilir
     * @param parentItem eklenmek istenen itemin parentidir
     * @param childItem eklenmek istenen elmanin kendisidir
     * @return eger add islemi gerceklesirse true , eger gerceklesmezse false return edilir.
     */
    public boolean add(E parentItem,E childItem ){
        Node<E> childNode = new Node<E>(childItem);
        Node<E> parentNode = new Node<E>(parentItem);


        if(root==null){
            Node<E> tempNode = new Node<E>(parentItem);

            root=tempNode;
            root.left=childNode;
            return true;
        }


        Node<E> newNode = root;

        while(true){

            if(postOrderSearch(parentNode.data,root)!=null){
                newNode = levelOrderSearch(parentNode.data,root);

                if(newNode.left==null){
                    newNode.left=childNode;
                    return true;
                }
                else{
                    while(true) {

                        if (newNode.left == null) {
                            while(true){
                                if(newNode.right==null){
                                    newNode.right = childNode;
                                    break;
                                }
                                else{
                                    newNode=newNode.right;
                                }
                            }
                            return true;
                        }
                        newNode = newNode.left;
                    }
                }
            }
            else{
                return false;
            }
        }
    }

    /**
     * postOrder seklinde general bir tree yi gezerek istenilen elemani aramak icin kullanilan methodtur
     * @param name aranilan elemanin kendisidir
     * @param node root gonderilir
     * @return eger aranen eleman tree de varsa o elemanin Node referansi return edilir, yoksa null return edilir
     */
    public Node postOrderSearch(E name, Node node){
        if(node != null){

            Node foundNode = postOrderSearch(name, node.left);

            if(node.data==name){
                return node;
            }

            if(foundNode == null) {
                foundNode = postOrderSearch(name, node.right);
            }

            return foundNode;

        }
        else {
            return null;
        }
    }

    /**
     * general bir treenin icinde postorder seklinde gezmek icin kullanilir
     * @param node root gonderilir
     */
    public void postOrderTraverse(Node node)
    {
        if (node == null)
            return;
        postOrderTraverse(node.left);
        System.out.print(node.data + " ");
        postOrderTraverse(node.right);
    }

    /**
     * general bir teenin icinde preOrderTraverse seklinde gezmek icin kullanilan methodtur
     * @param node root gonderilir
     */
    public void preOrderTraverse(Node node)
    {
        if (node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);

    }

    /**
     * Ekrana level level agaci basan methodtur
     * @param node root gonderilir
     */
    public void printTree(Node node) {

        Queue<Node> currentLevel = new LinkedList<Node>();
        Queue<Node> nextLevel = new LinkedList<Node>();

        currentLevel.add(node);

        while (!currentLevel.isEmpty()) {
            Iterator<Node> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                Node currentNode = iter.next();
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                System.out.print(currentNode.data + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node>();

        }

    }

    /**
     * general bir tree nin icinde levelOrder traverse seklinde dolasarak aranilan elemani bulmak icin kullanilan methodtur.
     * @param name aranilan elemanin kendisidir
     * @param node root gonderilir
     * @return eger aranilan eleman bulunduysa o elemanin oldugu bir Node referansi return edilir, eger bulunmadiysa null return edilir.
     */
    public Node levelOrderSearch(E name, Node node){
        if(node != null){

            Node<E> b = node;
            while(b!=null){
                Node<E> c = b;
                while(true){
                    if(c==null){
                        break;
                    }
                    if(c.data==name){
                        return c;
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
     * general bir tree nin icinde levelOrder traverse seklinde gezmek icin kullanilan methodtur
     * @param node root gonderilir
     */
    public void levelOrderTraverse(Node node)
    {
        if (node == null)
            return;
        Node<E> b = node;
        while(b!=null){
            Node<E> c = b;
            while(true){
                if(c==null){
                    break;
                }
                System.out.print(c.data + " ");
                c=c.right;
            }
            b=b.left;
        }
    }



}
