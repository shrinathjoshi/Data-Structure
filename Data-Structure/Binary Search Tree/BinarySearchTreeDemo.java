import com.util.BinarySearchTree.BinarySearchTree;

/**
 * @author Shrinath Joshi BinarySearchTreeDemo.java 30 / \ 15 45 / \ \ 5 17 60 /
 *         \ / \ 1 22 55 70 \ 58
 * 
 * 
 * 
 */
public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        
    	int arr[] = { 30,15,45,5,1,60,17,70,55,58,22};
    	
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
    	for(int i :arr)
    		bst.insert(i);
    	       
    	bst.inorder();
        
       System.out.println(bst.search(20));
       System.out.println(bst.search(2));
       
       System.out.print("delete 1 - "); bst.delete(1);
       bst.inorder();
       System.out.println();

       System.out.print("delete 15 - ");bst.delete(15);
       bst.inorder();
       System.out.println();
       
       System.out.print("delete 5 - ");bst.delete(5);
       bst.inorder();
       System.out.println();
       
       System.out.print("delete 45 - ");bst.delete(45);
       bst.inorder();
       System.out.println();
       
       System.out.print("delete 30 - ");bst.delete(30);
       bst.inorder();
       
        
    }
}

/*
OUTPUT:-
1 5 15 17 22 30 45 55 58 60 70 false
false
delete 1 - 5 15 17 22 30 45 55 58 60 70 
delete 15 - 5 17 22 30 45 55 58 60 70 
delete 5 - 17 22 30 45 55 58 60 70 
delete 45 - 17 22 30 55 58 60 70 
delete 30 - 17 22 55 58 60 70 
*/ 