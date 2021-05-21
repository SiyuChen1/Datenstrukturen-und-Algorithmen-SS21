package de.unistuttgart.vis.dsass2021.ex03.p1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// author: Siyu Chen (3494095) st169719@stud.uni-stuttgart.de
//         Xuefeng Hou (3502673) st175367@stud.uni-stuttgart.de
//         Leqi Xu (3556962) st176119@stud.uni-stuttgart.de

public class SimpleList<T extends Comparable<T>> implements ISimpleListIterable<T> {

	class SimpleIterator<T> implements Iterator<T>{
		List<T> list;
		int current = 0;

		public SimpleIterator(List<T> l){
			this.list = l;
		}

		@Override
		public boolean hasNext() {
			if(current < list.size()){
				return true;
			}
			return false;
		}

		@Override
		public T next() {
			T data = list.get(current);
			current += 1;
			return data;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Unsupported method of SimpleListIterator");
		}
	}

	class SimpleSkippingIterator<T> implements Iterator<T>{
		List<T> list;
		int nNeighbour;
		int current = 0;

		public SimpleSkippingIterator(List<T> l, int n){
			this.nNeighbour = n;
			this.list = l;
		}

		@Override
		public boolean hasNext() {
			if(current < list.size()){
				return true;
			}
			return false;
		}

		@Override
		public T next() {
			T data = list.get(current);
			current += nNeighbour;
			return data;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Unsupported method of SimpleListIterator");
		}
	}
	
	/** Do not modify the existing methods and signatures */
	private final List<T> list;
	
	public SimpleList() {
		list = new ArrayList<T>();
	}
	
	@Override
	public void append(T element) {
		list.add(element);
	}
	
	@Override
	public int size() {
		return list.size();
	}
	
	@Override
	public T get(int index) {
		return list.get(index);
	}

	@Override
	public Iterator<T> iterator() {
		return new SimpleIterator<>(this.list);
	}

	@Override
	public Iterator<T> skippingIterator(int n) {
		return new SimpleSkippingIterator<>(this.list, n);
	}
}
