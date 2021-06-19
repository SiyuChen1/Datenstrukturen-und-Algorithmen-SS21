// SOLUTION
package de.unistuttgart.vis.dsass2021.ex06.p4;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public abstract class AbstractSortCheckerList<T extends Comparable<T>> implements ISimpleList<T> {
	private List<T> list;
	
	private List<List<T>> snapshotList;
	
	private boolean creatingSnapshots;
	
	private boolean finishedSorting;
	
	public AbstractSortCheckerList() {
		this.list = new ArrayList<T>();
		this.snapshotList = new LinkedList<List<T>>();
		this.creatingSnapshots = false;
		this.setFinishedSorting(false);
	}

	public boolean isFinishedSorting() {
		return finishedSorting;
	}

	public void setFinishedSorting(boolean finishedSorting) {
		this.finishedSorting = finishedSorting;
	}

	@Override
	public void append(T element) {
		this.list.add(element);
		this.setFinishedSorting(false);
		this.recomputeSnapshots();
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public T get(int index) {
		return list.get(index);
	}
	
	@Override
	public void swap(int i, int j) {
		if (i == j) {
			return;
		}
		T tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
		
		if (this.creatingSnapshots) {
			List<T> snapshot = new ArrayList<T>(list.size());
			snapshot.addAll(this.list);
			this.snapshotList.add(snapshot);
		} else {
			this.assertSnapshot();
			if (this.snapshotList.size() == 0) {
				this.setFinishedSorting(true);
			}
		}
	}
	
	private void recomputeSnapshots() {
		// Clear old snapshots
		this.snapshotList.clear();
		// Make a copy of the original list
		List<T> orgList = new ArrayList<T>();
		orgList.addAll(this.list);
		// Sort and create snapshots
		this.creatingSnapshots = true;
		this.sort();
		this.creatingSnapshots = false;
		// Move back the original list
		this.list.clear();
		this.list.addAll(orgList);
	}

	protected abstract void sort();

	private void assertSnapshot() {
		assertTrue("Expected " + snapshotList.get(0) + 
				"\nActual   " + list,
				list.equals(snapshotList.get(0)));
		this.snapshotList.remove(0);
	}

	
}
