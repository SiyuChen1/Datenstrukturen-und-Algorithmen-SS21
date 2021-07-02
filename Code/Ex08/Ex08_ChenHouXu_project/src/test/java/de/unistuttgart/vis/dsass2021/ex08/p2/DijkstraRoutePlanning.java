package de.unistuttgart.vis.dsass2021.ex08.p2;


import org.junit.Test;

import java.util.Set;

public class DijkstraRoutePlanning {
	
	public static void main(String[] args) {
		StreetGraph g = GraphLoader.loadBirminghamStreetGraph();
		System.out.println("nodes " + g.numberOfNodes() + "  edges " + g.numberOfEdges());
	}


	@Test
	public void testClosestPointsBetween(){
		WeightedGraph<MetaData.JunctionDetails, MetaData.StreetDetails> weightedGraph = GraphLoader.loadBirminghamStreetGraph();

		ShortestPath<MetaData.JunctionDetails, MetaData.StreetDetails> shortestPath =
				ShortestPath.calculateFor(weightedGraph, MetaData.NODE_UNIVERSITY);
		ShortestPath<MetaData.JunctionDetails, MetaData.StreetDetails> otherShortestPath =
				ShortestPath.calculateFor(weightedGraph, MetaData.NODE_HEALTH_CENTER);
		Set<Integer> res = otherShortestPath.closestPointsBetween(shortestPath, 1);
		System.out.println(res);
	}

}
