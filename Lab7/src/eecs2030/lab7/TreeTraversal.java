package eecs2030.lab7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * A utility class that provides methods for traversing a binary
 * search tree.
 *
 */
public class TreeTraversal {
	private TreeTraversal() {
		// empty by design
	}

	/**
	 * Returns the list of strings formed by traversing the specified tree using
	 * an inorder traversal.
	 * 
	 * @param tree
	 *            a binary search tree
	 * @return the list of strings formed by traversing the specified tree using
	 *         an inorder traversal
	 */
	public static List<String> inorder(BinarySearchTree<String> tree) {
		return TreeTraversal.inorder(tree.root());
		// YOU SHOULD IMPLEMENT inorder(INode) below
	}
	
	/**
	 * Returns the list of strings formed by traversing the specified tree using
	 * a preorder traversal.
	 * 
	 * @param tree
	 *            a binary search tree
	 * @return the list of strings formed by traversing the specified tree using
	 *         a preorder traversal
	 */
	public static List<String> preorder(BinarySearchTree<String> tree) {
		return TreeTraversal.preorder(tree.root());
		// YOU SHOULD IMPLEMENT preorder(INode) below
	}

	/**
	 * Returns the list of strings formed by traversing the specified tree using
	 * a postorder traversal.
	 * 
	 * @param tree
	 *            a binary search tree
	 * @return the list of strings formed by traversing the specified tree using
	 *         a postorder traversal
	 */
	public static List<String> postorder(BinarySearchTree<String> tree) {
		return TreeTraversal.postorder(tree.root());
		// YOU SHOULD IMPLEMENT postorder(INode) below
	}

	/**
	 * Returns the list of strings formed by traversing the specified tree using
	 * a breadth first traversal. The traversal visits nodes of the tree
	 * starting at the root moving left to right for each level of the tree.
	 * 
	 * @param tree
	 *            a binary search tree
	 * @return the list of strings formed by traversing the specified tree using
	 *         a breadth first traversal
	 */
	public static List<String> breadthFirst(BinarySearchTree<String> tree) {
		List<String> result = new ArrayList<>();
		INode<String> root = tree.root();
		if (root == null) {
			return result;
		}

		// in Java, a LinkedList is a Queue
		// to enqueue a node, use the Queue method add
		// to dequeue a node, use the Queue method remove
		Queue<INode<String>> q = new LinkedList<>();
		q.add(root);
		result.add(root.data());
		breadthFirstH (root , q, result);

		return result;
	}

	private static void breadthFirstH(INode<String> root, Queue<INode<String>> q, List<String> result){
		if (q != null) {
			q.remove(root);
			if (root.left() != null && root.right() != null) {
				q.add(root.left());
				result.add(root.left().data());
				q.add(root.right());
				result.add(root.right().data());
				breadthFirstH(root.left(), q, result);
				breadthFirstH(root.right(), q, result);
			}
			
			if (root.left() == null && root.right() != null) {
				q.add(root.right());
				result.add(root.right().data());
				breadthFirstH(root.right(), q, result);
			}
			
			if (root.left() != null && root.right() == null) {
				q.add(root.left());
				result.add(root.left().data());
				breadthFirstH(root.left(), q, result);
			}
		}
		
	}
	/**
	 * Returns the list of strings formed by traversing a tree having the
	 * specified root using an inorder traversal.
	 * 
	 * @param root
	 *            the root of the tree
	 * @return the list of strings formed by traversing a tree having the
	 *         specified root using an inorder traversal
	 */
	private static List<String> inorder(INode<String> root) {
		List<String> result = new ArrayList<>();
		inorderH(root, result);
		
		return result;
	}
	
	private static void inorderH(INode<String> root, List<String> result) {
		if (root != null) {
			inorderH(root.left(), result);
			result.add(root.data());
			inorderH(root.right(), result);
		}
	}

	/**
	 * Returns the list of strings formed by traversing a tree having the
	 * specified root using a preorder traversal.
	 * 
	 * @param root
	 *            the root of the tree
	 * @return the list of strings formed by traversing a tree having the
	 *         specified root using a preorder traversal
	 */
	private static List<String> preorder(INode<String> root) {
		List<String> result = new ArrayList<>();
		
		preorderH(root, result);
		

		return result;
	}
	
	private static void preorderH(INode<String> root, List<String> result) {
		
		if (root != null) {
			result.add(root.data());
			preorderH(root.left(), result);
			preorderH(root.right(), result);
			
		}
	}

	/**
	 * Returns the list of strings formed by traversing a tree having the
	 * specified root using a postorder traversal.
	 * 
	 * @param root
	 *            the root of the tree
	 * @return the list of strings formed by traversing a tree having the
	 *         specified root using a postorder traversal
	 */
	private static List<String> postorder(INode<String> root) {
		List<String> result = new ArrayList<>();
		postorderH(root, result);
		

		return result;
	}
	
	private static void postorderH(INode<String> root, List<String> result) {
		if (root != null) {
			postorderH(root.left(), result);
			postorderH(root.right(), result);
			result.add(root.data());
		}
	}
}
