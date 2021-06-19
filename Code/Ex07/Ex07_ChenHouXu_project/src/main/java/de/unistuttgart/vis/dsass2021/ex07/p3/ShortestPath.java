package de.unistuttgart.vis.dsass2021.ex07.p3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

//Siyu Chen (3494095) st169719@stud.uni-stuttgart.de
//Xuefeng Hou (3502673) st175367@stud.uni-stuttgart.de
//Leqi Xu (3556962) st176119@stud.uni-stuttgart.de

public class ShortestPath<N,E> implements IShortestPath<N,E> {

	private final IWeightedGraph<N,E> graph;
	private final int startNode;
	private double[] D;
	private int[] P;

	
	/* syntactic sugar function to conveniently create shortest path objects from graphs */
	public static <N,E> ShortestPath<N, E> calculateFor(IWeightedGraph<N, E> g, int startNode){
		return new ShortestPath<>(g, startNode);
	}
	

	/**
	 * Initializes the shortest path for weighted graph <tt>graph</tt> from
	 * starting node <tt>startNode</tt>. Calls the bellmanFord(graph,
	 * startNode) method to execute the Bellman Ford algorithm.
	 * 
	 * @param graph       the weighted graph
	 * @param startNode the starting node
	 */
	public ShortestPath(IWeightedGraph<N,E> graph, int startNode) {
		this.graph = graph;
		this.startNode = startNode;
		bellmanFord(this.graph, this.startNode);
	}

	@Override
	public void bellmanFord(IWeightedGraph<N, E> graph, int startnode) {
		this.D = new double[graph.numberOfNodes()];
		this.P = new int[graph.numberOfNodes()];
		for(int index = 0; index < this.D.length; index++){
			this.D[index] = Double.POSITIVE_INFINITY;
		}
		this.D[startnode] = 0;
		for(int i = 0; i < graph.numberOfNodes(); i ++){
			Iterator<IEdge<E>> edgeIterator = graph.edgeIterator();
			while (edgeIterator.hasNext()){
				IEdge<E> edge = edgeIterator.next();
				if(this.D[edge.getSource()] + edge.getWeight() < this.D[edge.getDestination()]){
					this.D[edge.getDestination()] = this.D[edge.getSource()] + edge.getWeight();
					this.P[edge.getDestination()] = edge.getSource();
				}
			}
		}
	}

	@Override
	public boolean hasNegativeCycle() {
		Iterator<IEdge<E>> edgeIterator = this.graph.edgeIterator();
		while (edgeIterator.hasNext()){
			IEdge<E> edge = edgeIterator.next();
			if(this.D[edge.getSource()] + edge.getWeight() < this.D[edge.getDestination()]){
				return true;
			}
		}
		return false;
	}

	@Override
	public double distanceTo(int destination) {
		if(this.hasNegativeCycle()){
			throw new IllegalStateException();
		}else{
			return D[destination];
		}
	}

	@Override
	public boolean existsPathTo(int destination) {
		try{
			if(this.distanceTo(destination) < Double.POSITIVE_INFINITY){
				return true;
			}else{
				return false;
			}
		}catch (Exception e){
			return true;
		}
	}

	@Override
	public Iterable<IEdge<E>> pathTo(int destination) {
		if(!existsPathTo(destination)){
			return null;
		}
		if(hasNegativeCycle()){
			throw new IllegalStateException();
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

}
