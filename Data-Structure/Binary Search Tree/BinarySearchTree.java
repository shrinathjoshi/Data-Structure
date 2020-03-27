package com.util.BinarySearchTree;

/**
 * BinarySearchTree.java 
 * @author Shrinath Joshi
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
    	TreeNode<T> nodeToDelete = root;
    	while(nodeToDelete != null) {
    		if(compare(nodeToDelete.getData(),element) > 0) {
    			nodeToDelete=nodeToDelete.left;
    		}
    		else if(compare(nodeToDelete.getData(),element) < 0) {
    			nodeToDelete=nodeToDelete.right;
    		}
    		else break;
    	}

    	if(nodeToDelete == null)
    	{
    		System.out.println("Node not found");
    		return;
    	}
    	
    	//Node to be deleted is a leaf node
    	
    	// check if root node is to be deleted
    	
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
		// TODO Auto-generated method stub
		if(root == null) return null;
		TreeNode<T> temp = root;
		while(temp.right!=null)
			temp=temp.right;
		
		return temp;
	}

	private BinarySearchTree<T>.TreeNode<T> getFather(BinarySearchTree<T>.TreeNode<T> root,
			BinarySearchTree<T>.TreeNode<T> nodeToDelete) {

		TreeNode<T> q =root;
		if(root == nodeToDelete)
			return null;
		while(q!=null)
		{
			if(q.left == nodeToDelete || q.right == nodeToDelete)
				return q;
			if(compare(q.getData(), nodeToDelete.getData())>0)
				q=q.left;
			else
				q=q.right;
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

	public boolean search(T element) {
    	return searchElement(root,element);
    }
    
    private boolean searchElement(BinarySearchTree<T>.TreeNode<T> root, T element) {
		if(root == null)
			return false;
		else
		{
			TreeNode<T> temp = root;
			while(temp!= null) {
				
				if(compare(temp.getData(),element) == 0) 
					return true;
				if(compare(temp.getData(),element)>0)
					temp=temp.left;
				else
					temp=temp.right;	
			}
			return false;
		}
	}

	public void inorder(){
        inorderRecursive(root);
    }
    
    public void preorder() {
    	preorderRecursive(root);
    }
    
    public void postorder() {
    	postorderRecursive(root);
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



}