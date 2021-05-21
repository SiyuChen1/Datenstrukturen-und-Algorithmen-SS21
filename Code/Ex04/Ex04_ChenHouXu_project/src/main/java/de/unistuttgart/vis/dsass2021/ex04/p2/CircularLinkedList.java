package de.unistuttgart.vis.dsass2021.ex04.p2;

// author: Siyu Chen (3494095) st169719@stud.uni-stuttgart.de
//         Xuefeng Hou (3502673) st175367@stud.uni-stuttgart.de
//         Leqi Xu (3556962) st176119@stud.uni-stuttgart.de
public class CircularLinkedList<T extends Comparable<T>> implements ICircularLinkedList<T> {
	private ILinkedListNode<T> head;
	private int length = 0;

	public CircularLinkedList(){
		head = null;
		length = 0;
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public void append(T element) {
		ILinkedListNode<T> newNode = new LinkedListNode<>();
		newNode.setElement(element);
		if(length == 0){
			newNode.setNext(newNode);
			newNode.setPrev(newNode);
			head = newNode;
			length += 1;
		}else{
			head.getPrev().setNext(newNode);
			newNode.setPrev(head.getPrev());
			newNode.setNext(head);
			head.setPrev(newNode);
			length += 1;
		}
	}

	@Override
	public T get(int index) {
		ILinkedListNode<T> tempNode;
		int loc = index % length;

		if(loc <0){
			loc += length;
		}

		if (loc > (int) (length / 2)) {
			tempNode = head.getPrev();
			for(int i = length -1; i > loc; i --){
				tempNode = tempNode.getPrev();
			}
			return tempNode.getElement();
		}else {
			tempNode = head;
			for(int i = 0;i < loc; i++){
				tempNode = tempNode.getNext();
			}
			return tempNode.getElement();
		}
	}

	@Override
	public ILinkedListNode<T> getHead() {
		return head;
	}
}
