package de.unistuttgart.vis.dsass2021.ex07.p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import de.unistuttgart.vis.dsass2021.ex07.p3.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.io.*;

public class ShortestPathTest {

	// START SOLUTION
    @Test
    public void testPathTo(){

        WeightedGraph<String, String> weightedGraph = GraphLoader.loadExampleGraph();
        ShortestPath<String, String> shortestPath = ShortestPath.calculateFor(weightedGraph, 2);
        System.out.println(shortestPath.pathTo(3));
    }

	// END SOLUTION

}
