package de.unistuttgart.vis.dsass2021.ex03.p3;

import java.util.LinkedList;
import java.util.Queue;

// author: Siyu Chen (3494095) st169719@stud.uni-stuttgart.de
//         Xuefeng Hou (3502673) st175367@stud.uni-stuttgart.de
//         Leqi Xu (3556962) st176119@stud.uni-stuttgart.de
public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {
    private BinaryTreeNode<T> head;
    private BinaryTreeNode<T> nullNode;

	public BinarySearchTree() {
		head = new BinaryTreeNode<>();
		nullNode = new BinaryTreeNode<>();
		head.setRightChild(nullNode);
		nullNode.setLeftChild(nullNode);
		nullNode.setRightChild(nullNode);

	}

    @Override
    public void insert(T t) {
	    IBinaryTreeNode<T> parent = head;
	    IBinaryTreeNode<T> child = head.getRightChild();
	    if(child.equals(nullNode)){
            IBinaryTreeNode<T> newNode = new BinaryTreeNode<>();
            newNode.setValue(t);
            newNode.setLeftChild(nullNode);
            newNode.setRightChild(nullNode);
            head.setRightChild(newNode);
        }else{
            while (!child.equals(nullNode)){
                parent = child;
                int res = child.getValue().compareTo(t);
                if(res == 0){
                    return;
                }else if(res == -1){
                    child = child.getRightChild();
                }else {
                    child = child.getLeftChild();
                }
            }
            IBinaryTreeNode<T> newNode = new BinaryTreeNode<>();
            newNode.setValue(t);
            newNode.setLeftChild(nullNode);
            newNode.setRightChild(nullNode);
            if(parent.getValue().compareTo(t) > 0){
                parent.setLeftChild(newNode);
            }else{
                parent.setRightChild(newNode);
            }
        }
    }

    @Override
    public boolean isFull() {
        Queue<IBinaryTreeNode<T>> queue = new LinkedList<>();
        if(head.getRightChild().equals(nullNode)){
            return false;
        }else{
            queue.add(head.getRightChild());
            while (!queue.isEmpty()){
                IBinaryTreeNode current = queue.remove();
                if(!current.getLeftChild().equals(nullNode) && !current.getRightChild().equals(nullNode)){
                    queue.add(current.getLeftChild());
                    queue.add(current.getRightChild());
                }else if(current.getLeftChild().equals(nullNode) && current.getRightChild().equals(nullNode)){}
                else{
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public IBinaryTreeNode<T> getRootNode() {
	    if(head.getRightChild().equals(nullNode)){
	        return null;
        }
	    return head.getRightChild();
    }
}
