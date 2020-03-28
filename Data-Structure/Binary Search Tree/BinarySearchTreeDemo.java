import com.util.BinarySearchTree.BinarySearchTree;
import com.util.BinarySearchTree.BinarySearchTree.TreeNode;


/**@author Shrinath Joshi
 * BinarySearchTreeDemo
 * 							30
 * 							/ \
 * 						  15	45
 * 						 / \     \
 *						5  17    60	
 *					   /	\	 /	\
 *					  1 	 22	55	 70
 *								 \ 
 * 								  58	
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
        
      System.out.println(); 
       System.out.print("delete 1 - "); bst.delete(1);
       bst.postorder();
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
      
       System.out.println(bst.getRoot().getData());
       System.out.println("Sucessor of 22 is " + bst.findSuccessor(22).getData()); 
       System.out.println("Predecessor of 22 is "+ bst.findPredecessor(22).getData());
       
       bst.inorder();
       System.out.println();
       bst.preorder();
       
    }
}