package de.unistuttgart.vis.dsass2021.ex04.p3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// author: Siyu Chen (3494095) st169719@stud.uni-stuttgart.de
//         Xuefeng Hou (3502673) st175367@stud.uni-stuttgart.de
//         Leqi Xu (3556962) st176119@stud.uni-stuttgart.de

public class BinarySearchTree<T extends Comparable<T>> implements
		IBinarySearchTreeIterable<T> {

	private volatile IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	@Override
	public void insert(T t) {
		this.root = this.insert(this.root, t);
	}

	private IBinaryTreeNode<T> insert(IBinaryTreeNode<T> node, T t) {
		if (node == null) {
			IBinaryTreeNode<T> newNode = new BinaryTreeNode<>();
			newNode.setValue(t);
			return newNode;
		}
		if (t.compareTo(node.getValue()) < 0) {
			node.setLeftChild(this.insert(node.getLeftChild(), t));
		} else if (t.compareTo(node.getValue()) > 0) {
			node.setRightChild(this.insert(node.getRightChild(), t));
		}
		return node;
	}

	@Override
	public IBinaryTreeNode<T> getRootNode() {
		return this.root;
	}

    public Iterator<T> iterator(TreeTraversalType traversalType){
	    switch (traversalType){
            case INORDER:
                return new InOrderIterator<T>(this.root);
            case PREORDER:
                return new PreOrderIterator<T>(this.root);
            case POSTORDER:
                return new PostOrderIterator<>(this.root);
            case LEVELORDER:
                return new LevelOrderIterator<>(this.root);
            default:
                return new InOrderIterator<T>(this.root);
        }
    }

    private class PreOrderIterator<T extends Comparable<T>> implements Iterator<T>{
	    private Stack<IBinaryTreeNode<T> > stack;

	    public PreOrderIterator(IBinaryTreeNode<T> rootNode){
            stack = new Stack<>();
            stack.push(rootNode);
        }

        @Override
        public T next() {
            IBinaryTreeNode<T> temp = stack.pop();
            if(temp.getRightChild() != null){
                stack.push(temp.getRightChild());
            }
            if(temp.getLeftChild() != null){
                stack.push(temp.getLeftChild());
            }
            return temp.getValue();
        }

        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unsupported method of PreOrderIterator");
        }
    }

    private class InOrderIterator<T extends Comparable<T>> implements Iterator<T>{
	    private Stack<IBinaryTreeNode<T>> stack;

	    public InOrderIterator(IBinaryTreeNode<T> rootNode){
	        stack = new Stack<>();
	        IBinaryTreeNode<T> temp = rootNode;
	        stack.push(temp);
	        while (temp.getLeftChild()!= null){
	            stack.push(temp.getLeftChild());
	            temp = temp.getLeftChild();
            }
        }

        @Override
        public T next() {
            IBinaryTreeNode<T> topNode = stack.pop();
            IBinaryTreeNode<T> temp = topNode.getRightChild();
            if(temp != null){
                stack.push(temp);
                while (temp.getLeftChild() != null){
                    stack.push(temp.getLeftChild());
                    temp = temp.getLeftChild();
                }
            }
            return topNode.getValue();
        }

        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unsupported method of InOrderIterator");
        }
    }

    private class PostOrderIterator<T extends Comparable<T>> implements Iterator<T>{
	    private Stack<IBinaryTreeNode<T>> s1;
        private Stack<IBinaryTreeNode<T>> s2;

        public PostOrderIterator(IBinaryTreeNode<T> rootNode){
	        s1 = new Stack<>();
	        s2 = new Stack<>();
	        s1.push(rootNode);
	        while (!s1.empty()){
	            IBinaryTreeNode<T> temp = s1.pop();
	            s2.push(temp);
	            if(temp.getLeftChild() != null){
	                s1.push(temp.getLeftChild());
                }
	            if(temp.getRightChild() != null){
	                s1.push(temp.getRightChild());
                }
            }
        }

        @Override
        public T next() {
            return s2.pop().getValue();
        }

        @Override
        public boolean hasNext() {
            return !s2.empty();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unsupported method of PostOrderIterator");
        }
    }

    private class LevelOrderIterator<T extends Comparable<T>> implements Iterator<T>{
	    private Queue<IBinaryTreeNode<T>> queue;

	    public LevelOrderIterator(IBinaryTreeNode<T> rootNode){
	        queue = new LinkedList<>();
	        queue.add(rootNode);
        }

        @Override
        public T next() {
            IBinaryTreeNode<T> temp = queue.remove();
            if(temp.getLeftChild() != null){
                queue.add(temp.getLeftChild());
            }
            if(temp.getRightChild() != null){
                queue.add(temp.getRightChild());
            }
            return temp.getValue();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Unsupported method of LevelOrderIterator");
        }
    }

}
