package de.unistuttgart.vis.dsass2021.ex08.p2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Siyu Chen (3494095) st169719@stud.uni-stuttgart.de
//Xuefeng Hou (3502673) st175367@stud.uni-stuttgart.de
//Leqi Xu (3556962) st176119@stud.uni-stuttgart.de

public class ShortestPath<N,E> extends AbstractShortestPath<N, E> {

	private final IWeightedGraph<N,E> graph;
	private final int startNode;
	private double[] D;
	private int[] P;

	public class Entry implements Comparable<Entry> {
		private int key;
		private double value;

		public Entry(int key, double value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public Double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		@Override
		public int compareTo(Entry other) {
			return this.getValue().compareTo(other.getValue());
		}
	}
	
	/* syntactic sugar function to conveniently create shortest path objects from graphs */
	public static <N,E> ShortestPath<N, E> calculateFor(IWeightedGraph<N, E> g, int startNode){
		return new ShortestPath<>(g, startNode);
	}
	
	/**
	 * Initializes the shortest path for weighted graph <tt>graph</tt> from
	 * starting node <tt>startNode</tt>. Calls the dijkstra(graph,
	 * startNode) method to execute the Dijkstra algorithm.
	 * 
	 * @param graph			the weighted graph
	 * @param startNode		the starting node
	 */
	public ShortestPath(IWeightedGraph<N,E> graph, int startNode) {
		this.graph = graph;
		this.startNode = startNode;
		dijkstra(this.graph, this.startNode);
	}

	@Override
	public void dijkstra(IWeightedGraph<N, E> graph, int startnode) {
		this.D = new double[this.graph.numberOfNodes()];
		this.P = new int[this.graph.numberOfNodes()];

		for(int index = 0; index < this.graph.numberOfNodes();index ++){
			this.D[index] = Double.POSITIVE_INFINITY;
		}
		this.D[startnode] = 0;

		PriorityQueue<Entry> priorityQueue = new PriorityQueue<>();

		ArrayList<Entry> arrayList = new ArrayList<>();

		for(int index = 0; index < this.graph.numberOfNodes();index ++){
			Entry entry = new Entry(index, this.D[index]);
			arrayList.add(index, entry);
			priorityQueue.add(arrayList.get(index));
		}

		while (!priorityQueue.isEmpty()){
			int current = priorityQueue.poll().getKey();
			Iterator<IEdge<E>> iterator = this.graph.outgoingEdges(current);
			while (iterator.hasNext()){
				IEdge<E> edge = iterator.next();
				if(this.D[current] + edge.getWeight() < this.D[edge.getDestination()]){
					this.D[edge.getDestination()] = this.D[current] + edge.getWeight();
					priorityQueue.remove(arrayList.get(edge.getDestination()));
					arrayList.get(edge.getDestination()).setValue(this.D[edge.getDestination()]);
					priorityQueue.offer(arrayList.get(edge.getDestination()));
					this.P[edge.getDestination()] = current;
				}
			}
		}
	}

	@Override
	public double distanceTo(int destination) {
		if(this.existsPathTo(destination)){
			return this.D[destination];
		}else{
			throw new IllegalStateException();
		}
	}

	@Override
	public boolean existsPathTo(int destination) {
		if(this.D[destination] < Double.POSITIVE_INFINITY){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Iterable<IEdge<E>> pathTo(int destination) {
		if(!existsPathTo(destination)){
			return null;
		}

		LinkedList<Integer> path = new LinkedList<>();
		int index = destination;
		path.addFirst(index);
		while (this.P[index] != this.startNode){
			index = this.P[index];
			path.addFirst(index);
		}
		path.addFirst(this.P[index]);

		IEdge<E>[] edgeList = new IEdge[path.size()-1];

		Iterator<IEdge<E>> edgeIterator = this.graph.edgeIterator();
		while (edgeIterator.hasNext()){
			IEdge<E> edge = edgeIterator.next();
			for(int i = 0; i < path.size()-1; i ++){
				if(edge.getSource() == path.get(i) && edge.getDestination() == path.get(i+1)){
					edgeList[i] = edge;
				}
			}
		}

		ArrayList<IEdge<E>> arrayList = new ArrayList<>();

		for(int i= 0; i<edgeList.length; i ++){
			arrayList.add(edgeList[i]);
		}
		return arrayList;
	}

	public double[] getD() {
		return D;
	}

	@Override
	public Set<Integer> closestPointsBetween(ShortestPath<N, E> other, int count) {
		int lenOther = other.D.length;
		int len = this.D.length;
		if(len != lenOther){
			return null;
		}
		if(count <1){
			return null;
		}

		PriorityQueue<Entry> priorityQueue = new PriorityQueue<>();

		for(int index = 0; index < len; index ++){
			priorityQueue.add(new Entry(index, Math.abs(this.D[index] - other.getD()[index]) + (this.D[index] + other.getD()[index])));
//			priorityQueue.add(new Entry(index, Math.abs(this.D[index] - other.getD()[index])));
		}
		Set<Integer> nodeSet = new TreeSet<>();
		for(int i = 0; i <count;i ++){
			Entry entry = priorityQueue.poll();
			System.out.println(entry.getKey() + ", " + entry.getValue());
			nodeSet.add((Integer) entry.getKey());
		}
		return nodeSet;
	}
}
