package de.unistuttgart.vis.dsass2021.ex04.p2;

// author: Siyu Chen (3494095) st169719@stud.uni-stuttgart.de
//         Xuefeng Hou (3502673) st175367@stud.uni-stuttgart.de
//         Leqi Xu (3556962) st176119@stud.uni-stuttgart.de

public class LinkedListNode<T extends Comparable<T>> implements ILinkedListNode<T>{
    private T data;
    private ILinkedListNode<T> next;
    private ILinkedListNode<T> previous;

    public LinkedListNode(){
        data = null;
        next = null;
        previous = null;
    }

    @Override
    public T getElement() {
        return data;
    }

    @Override
    public ILinkedListNode<T> getNext() {
        return next;
    }

    @Override
    public ILinkedListNode<T> getPrev() {
        return previous;
    }

    @Override
    public void setElement(T element) {
        data = element;
    }

    @Override
    public void setNext(ILinkedListNode<T> next) {
        this.next = next;
    }

    @Override
    public void setPrev(ILinkedListNode<T> prev) {
        this.previous = prev;
    }
}
