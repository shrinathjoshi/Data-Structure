package com.util.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.util.BinarySearchTree.BinarySearchTree.TreeNode;

/**
 * @author Shrinath Joshi
 * BinarySearchTree.java 
 */
public class BinarySearchTree<T  extends Comparable<T>> {

    private TreeNode<T> root;

    public class TreeNode<T>{
        private T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
        public T getData(){
            return this.data;
        }
        
        public void setData(T data) {
        	this.data = data;
        }
    }
    
    public TreeNode<T> getRoot(){
    	return this.root;
    }

    public int compare(T x, T y)
    {
        return x.compareTo(y);
    }

    public void insert(T value){
    	TreeNode<T> newElement = new TreeNode<T>(value);

        if(this.root == null)
        {
            this.root = newElement;
            return;
        }
        TreeNode<T> temp = this.root;
        while(temp!=null){
            if(this.compare(temp.getData(),newElement.getData()) >= 0) {
            	if(temp.left == null) {
            		temp.left = newElement;
            		return ;
            	}
            	else 
            		temp=temp.left;
            }
            else
            {
            	if(temp.right == null) {
            		temp.right = newElement;
            		return;
            	}	
            	else 
            		temp=temp.right;
            }
        }    
    }

    public void delete(T element) {
    	deleteNode(root,element);
    }
    
    private void deleteNode(BinarySearchTree<T>.TreeNode<T> root, T element) {
    	if(root ==  null)
    		return;
    	
    	TreeNode<T> parent=root;
    	TreeNode<T> nodeToDelete = search(element);
   
    	if(nodeToDelete == null)
    	{
    		System.out.println("Node not found");
    		return;
    	}
    	
    	//Node to be deleted is a leaf node
    	if(nodeToDelete.left == null && nodeToDelete.right == null)
    	{
    		if(root == nodeToDelete)
        	{
    			root=null;
    			return;
        	}
    		
    		parent = getFather(root,nodeToDelete);
    		if(parent.left == nodeToDelete)
    			parent.left=null;
    		else 
    			parent.right=null;
    		return;
    	}
    	
  /*  	// Node to be deleted has only one child
    	if(nodeToDelete.left !=null && nodeToDelete.right ==null) {
    		parent.left=nodeToDelete.left;
    		return;
    	}
    	if(nodeToDelete.right !=null && nodeToDelete.left ==null) {
    		parent.right=nodeToDelete.right;
    		return;
    	}
    	
    	// Node to be deleted has two children
    	TreeNode<T> minFromRightTree = getMinimum(nodeToDelete.right); 
    	T val = minFromRightTree.getData();
    	delete(minFromRightTree.getData());
    	nodeToDelete.setData(val);
*/		
    	
    	if(nodeToDelete.left != null) {
    		TreeNode<T> maxFromLeftSubtree = getMax(nodeToDelete.left);
    		T value = maxFromLeftSubtree.getData();
    		delete(value);
    		nodeToDelete.setData(value);
    		return;
    	}
   	
    	if(nodeToDelete == root)
    	{
    		root=root.right;
    		return;
    	}
    	parent = getFather(root, nodeToDelete);
    	if(nodeToDelete == parent.left)
    		parent.left = nodeToDelete.right;
    	else
    		parent.right=nodeToDelete.right;
	}

    
	private BinarySearchTree<T>.TreeNode<T> getMax(BinarySearchTree<T>.TreeNode<T> root) {
	
		if(root == null) return null;
		
		TreeNode<T> temp = root;
		while(temp.right!=null)
			temp=temp.right;
		
		return temp;
	}

	private BinarySearchTree<T>.TreeNode<T> getFather(BinarySearchTree<T>.TreeNode<T> root,
			BinarySearchTree<T>.TreeNode<T> nodeToDelete) {

		TreeNode<T> father = root;
		if(root == nodeToDelete)
			return null;
		
		while(father!=null)
		{
			if(father.left == nodeToDelete || father.right == nodeToDelete)
				return father;
			if(compare(father.getData(), nodeToDelete.getData())>0)
				father=father.left;
			else
				father=father.right;
		}
		return null;
		}

	private BinarySearchTree<T>.TreeNode<T> getMinimum(BinarySearchTree<T>.TreeNode<T> root) {
		
		if(root == null) return null;
		TreeNode<T> temp = root;
		while(temp.left!=null) {
			temp=temp.left;
		}
		return temp;
	}

	private BinarySearchTree<T>.TreeNode<T> getParent(BinarySearchTree<T>.TreeNode<T> nodeToDelete) {
		return getParentofNode(root,nodeToDelete);
	}

	private BinarySearchTree<T>.TreeNode<T> getParentofNode(BinarySearchTree<T>.TreeNode<T> root2,
			BinarySearchTree<T>.TreeNode<T> nodeToDelete) {

		if(root == null) return null;
		
		TreeNode<T> temp = root;
		while(temp!=null) {
		
		}
		return null;
	}

	public TreeNode<T> search(T element) {
    	return searchElement(root,element);
    }
    
    private TreeNode<T> searchElement(BinarySearchTree<T>.TreeNode<T> root, T element) {
		if(root == null)
			return null;
		else
		{
			TreeNode<T> temp = root;
			while(temp!= null) {
				
				if(compare(temp.getData(),element) == 0) 
					return temp;
				if(compare(temp.getData(),element)>0)
					temp=temp.left;
				else
					temp=temp.right;	
			}
			return null;
		}
	}

	public void inorder(){
        inorderRecursive(root);
        inorderIterative(root);
	}
    
    public void preorder() {
    	preorderRecursive(root);
    	preorderIterative(root);
    }
    
    public void postorder() {
    	postorderRecursive(root);
    	postorderInterative(root);
    }
    public void inorderRecursive(TreeNode<T> root){
        if(root!= null)
        {
            inorderRecursive(root.left);
            System.out.print(root.getData()+" ");
            inorderRecursive(root.right);
        }
    }

    public void preorderRecursive(TreeNode<T> root){
        if(root!= null)
        {
            System.out.print(root.getData()+" ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    public void postorderRecursive(TreeNode<T> root){
        if(root!= null)
        {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.getData()+" ");
        }
    }

    public TreeNode<T> findSuccessor(T node){
    	return getSucessor(root,node);
    }

	private BinarySearchTree<T>.TreeNode<T> getSucessor(BinarySearchTree<T>.TreeNode<T> root,
			T node) {
		
		if(root == null) return null;
		TreeNode<T> current = search(node);
		if(current == null)
		{
			System.out.println("Node not present");
			return null;
		}

		if(current.right != null) {
			return getMinimum(current.right);
		}
		
		TreeNode<T> successor = null;
		TreeNode<T> ancestor = root;
		while(ancestor!=null) {
			if(compare(ancestor.getData(), current.getData())>0)
			{
				successor = ancestor;
				ancestor=ancestor.left;
			}
			else
				ancestor=ancestor.right;
		}
		return successor;
	}

	public BinarySearchTree<T>.TreeNode<T> findPredecessor(T node) {
		return getPredecessor(root,node);
	}

	private BinarySearchTree<T>.TreeNode<T> getPredecessor(BinarySearchTree<T>.TreeNode<T> root, T node) {
		if(root == null) return null;
		TreeNode<T> current = search(node);
		if(current == null) {
			System.out.println(" Node not found");
			return null;
		}
		
		if(current.left != null) {
			return getMax(current.left);
		}
		
		TreeNode<T> predecessor = null;
		TreeNode<T> ancestor = root;
		while(ancestor != null) {
			if(compare(ancestor.getData(), node)<0) {
				predecessor=ancestor;
				ancestor=ancestor.right;
			}
			else
				ancestor=ancestor.left;	
		}
		return predecessor;
		
	}
	
	
	public void preorderIterative(TreeNode<T> root) {
		if(root == null) return ;
		
		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		stack.add(root);
		TreeNode<T> temp=root;
		
		while(!stack.isEmpty()) {
			
			while(temp!= null)
			{
				System.out.print(temp.getData()+" ");
				if(temp.left != null)
				{
					stack.add(temp.left);
				}
				temp=temp.left;
			}
			
			TreeNode<T> top = stack.pop();
			if(top.right!=null) {
				stack.add(top.right);
				temp=top.right;
			}
		}
	       System.out.println();
		
	}
	
	public void inorderIterative(TreeNode<T> root) {
		
		if(root == null) return ;
		
		Stack<TreeNode<T>> stack =new Stack<TreeNode<T>>();
		stack.add(root);
		
		TreeNode<T> temp = root;
		while(!stack.isEmpty()) {
			
			while(temp.left!=null) {
				stack.add(temp.left);
				temp=temp.left;
			}
			
			TreeNode<T> top = stack.pop();
			System.out.print(top.getData()+" ");
			
			if(top.right != null) {
				stack.add(top.right);
				temp=top.right;
			}
			
		}
	    System.out.println();
	}
	
	
	public void postorderInterative(TreeNode<T> root) {
		
		if(root == null) return ;
		
		List<TreeNode<T>> visited = new ArrayList<TreeNode<T>>();
		Stack<TreeNode<T>> stack = new Stack<>();
		stack.add(root);
		TreeNode<T> temp = root;
		
		while(!stack.isEmpty()) {
			
			while(temp.left != null)
			{
				stack.add(temp.left);
				temp=temp.left;
			}
			
			TreeNode<T> top = stack.peek();
			
			if(top.right == null || visited.contains(top.right)) {
				System.out.print(top.getData()+" ");
				visited.add(stack.pop());
			}
			else
			{
				temp=top.right;
				stack.add(top.right);
			}
			
		}
		
	}

}