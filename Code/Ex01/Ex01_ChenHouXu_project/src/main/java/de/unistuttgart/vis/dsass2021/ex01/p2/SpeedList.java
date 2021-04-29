package de.unistuttgart.vis.dsass2021.ex01.p2;

import java.lang.reflect.Array;

/**
 * 
 * Nutze diese Klasse, um die Methoden aus dem Interface zu implementieren.
 * Der angezeigte Fehler ist beabsichtigt und kommt vor, weil die Methoden des Interfaces noch nicht implementiert wurden.
 * Mit Rechtsklick auf diesen Fehler kannst du 'add unimplemented methods' anklicken, um dir automatisch eine leere Methoden zu erzeugen.
 * 
 * 
 */

public class SpeedList<T> implements ISpeedList<T> {

	private Node<T> head;
    private int nNeighbour;

    class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> nNext;

        public Node(T data, Node<T> next, Node<T> nNext){
            this.data = data;
            this.next = next;
            this.nNext = nNext;
        }

        public Node(){
            this.data = null;
            this.next = null;
            this.nNext = null;
        }

        public Node(T data){
            this.data = data;
            this.next = null;
            this.nNext = null;
        }


        public Node(Node<T> node){
            this.data = node.getData();
            this.next = getNext();
            this.nNext = getNNext();
        }

        public void setNext(Node<T> next){
            this.next = next;
        }

        public void setnNext(Node<T> nNext){
            this.nNext = nNext;
        }

        public void setData(T data){
            this.data = data;
        }

        public T getData(){
            return this.data;
        }

        public Node<T> getNext(){
            return this.next;
        }

        public Node<T> getNNext(){
            return this.nNext;
        }
    }


    public SpeedList(){
	    head = new Node<>();
	    this.nNeighbour = 8;
    }

    public SpeedList(int nNeighbour){
        head = new Node<>();
        this.nNeighbour = nNeighbour;
    }

    public boolean isEmpty(){
	    return head.getNext() == null;
    }

    public int getNNeighbour(){
        return this.nNeighbour;
    }

    // return the node at the pos
    public Node<T> getNode(int pos){
	    // pos is bigger than the length of the list
	    if(pos > this.size() -1){
	        return null;
        }
	    else{
	        // if pos smaller than nNeighbour
            if(pos < this.getNNeighbour()){
                int index = 0;
                Node<T> node = head.getNext();
                while (index<pos){
                    node = node.getNext();
                    index += 1;
                }
                return node;
            }
            // if pos bigger than nNeighbour
            else{
                int index = 0;
                Node<T> node = head.getNext();
                // use n-th neighbour to speed up iteration
                while (index< pos - this.getNNeighbour()){
                    node = node.getNNext();
                    index += this.getNNeighbour();
                }
                while (index<pos){
                    node = node.getNext();
                    index += 1;
                }
                return node;
            }
        }

    }

    @Override
    public int size() {
	    if(!isEmpty()){
            int len = 0;
            Node<T> node = head;
            // when node has a next node
            while (node.getNext() != null){
                // if node has a n-th neighbour
                // use n-th neighbour to speed up iteration
                if(node.getNNext() != null){
                    node = node.getNNext();
                    len += this.getNNeighbour();
                }
                // else just normal way
                else{
                    node = node.getNext();
                    len += 1;
                }
            }
            return len;
        }
        return 0;
    }

    @Override
    public void append(T t) {
	    int len = this.size();
        Node<T> newNode = new Node<>(t);
	    if(len < this.getNNeighbour() + 1){
	        Node<T> node = head;
	        // get the node which is at the end of the list
	        while (node.getNext() != null){
	            node = node.getNext();
            }
	        node.setNext(newNode);

	        // set n-th neighbour
	        if(len == this.getNNeighbour() - 1){
	            head.setnNext(newNode);
            }
	        if(len == this.getNNeighbour()){
	            head.getNext().setnNext(newNode);
            }
        }else{
            Node<T> node = this.getNode(len- 1 - this.getNNeighbour());
            node.getNNext().setNext(newNode);
            node.getNext().setnNext(newNode);
        }
    }

    @Override
    public void prepend(T t) {
	    int len = this.size();
        Node<T> newNode = new Node<>(t);

        if(len < this.getNNeighbour()- 1){
            newNode.setNext(head.getNext());
            head.setNext(newNode);
            newNode.setnNext(null);
            head.setnNext(null);
        }else if(len == this.getNNeighbour() -1){
            head.setnNext(this.getNode(len-1));
            newNode.setNext(head.getNext());
            head.setNext(newNode);
        }
        else{
            Node<T> nNode = this.getNode(this.nNeighbour -2);
            newNode.setnNext(head.getNNext());
            head.setnNext(nNode);
            newNode.setNext(head.getNext());
            head.setNext(newNode);
        }
    }

    @Override
    public T getElementAt(int pos) {
	    if(pos >= this.size() || pos < 0){
	        throw new IndexOutOfBoundsException("in getElementAt(int pos) failed");
        }
        return this.getNode(pos).getData();
    }

    @Override
    public T getPrevious(int pos) {
	    if(pos >= this.size() || pos <= 0){
	        throw new IndexOutOfBoundsException("in getPrevious(int pos) failed");
        }
        return this.getNode(pos-1).getData();
    }
}