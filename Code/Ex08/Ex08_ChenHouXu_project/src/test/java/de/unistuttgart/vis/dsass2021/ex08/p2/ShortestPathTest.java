package de.unistuttgart.vis.dsass2021.ex08.p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import de.unistuttgart.vis.dsass2021.ex08.p2.GraphLoader;
import de.unistuttgart.vis.dsass2021.ex08.p2.IEdge;
import de.unistuttgart.vis.dsass2021.ex08.p2.IWeightedGraph;
import de.unistuttgart.vis.dsass2021.ex08.p2.MetaData;
import de.unistuttgart.vis.dsass2021.ex08.p2.ShortestPath;
import de.unistuttgart.vis.dsass2021.ex08.p2.StreetGraph;
import de.unistuttgart.vis.dsass2021.ex08.p2.WeightedGraph;

public class ShortestPathTest {
    @Test
    public void testPathTo(){
        WeightedGraph<String, String> weightedGraph = GraphLoader.loadExampleGraph();
        ShortestPath<String, String> shortestPath = ShortestPath.calculateFor(weightedGraph, 2);
        System.out.println(shortestPath.existsPathTo(4));
        System.out.println(shortestPath.distanceTo(4));
        System.out.println(shortestPath.pathTo(6));
    }
}
