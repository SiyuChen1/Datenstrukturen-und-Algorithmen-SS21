package de.unistuttgart.vis.dsass2021.ex07.p1;

import de.unistuttgart.vis.dsass2021.ex07.p3.*;
import org.junit.Test;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;



public class BirminghamRoutePlanning {

    @Test
    public void ShortestPathToTheater(){
        WeightedGraph<MetaData.JunctionDetails, MetaData.StreetDetails> weightedGraph = GraphLoader.loadBirminghamStreetGraph();

        ShortestPath<MetaData.JunctionDetails, MetaData.StreetDetails> shortestPath =
                ShortestPath.calculateFor(weightedGraph, MetaData.NODE_GURLEY_CIRCLE);
        System.out.println("Shortest path from Gurley circle to alabama theater is:" + shortestPath.distanceTo(MetaData.NODE_ALABAMA_THEATRE) + "m");
        Iterator<IEdge<MetaData.StreetDetails>> iterator = shortestPath.pathTo(MetaData.NODE_ALABAMA_THEATRE).iterator();
        float time = 0;
        float factor = 0.44704f;
        while (iterator.hasNext()){
            MetaData.StreetDetails streetDetails = iterator.next().getMetaData();
            time += streetDetails.length/(streetDetails.maxspeed*factor);
        }
        System.out.println("the time is:" + time + "s");
        //    Shortest path from curley circle to alabama theater is:14755.6450881958m
        //    the time is:873.1459s
    }

    @Test
    public void ShortestPathToTheaterUsingTimeAsWeight(){
        WeightedGraph<MetaData.JunctionDetails, MetaData.StreetDetails> weightedGraph = GraphLoader.loadBirminghamStreetGraph();

        ShortestPath<MetaData.JunctionDetails, MetaData.StreetDetails> shortestPath =
                ShortestPath.calculateFor(weightedGraph, MetaData.NODE_GURLEY_CIRCLE);
        System.out.println("Shortest time from Gurley circle to alabama theater is:" + shortestPath.distanceTo(MetaData.NODE_ALABAMA_THEATRE) + "s");
//        1. using distance as weight
//            Shortest path from curley circle to alabama theater is:14755.6450881958m
//            the time is:873.1459s
//        2. using time as weight
//        Shortest time from Gurley circle to alabama theater is:782.8084272464856s

//        So we can see time saving
    }

    @Test
    public void ShortestPathToUniversity(){
        WeightedGraph<MetaData.JunctionDetails, MetaData.StreetDetails> weightedGraph = GraphLoader.loadBirminghamStreetGraph();

        ShortestPath<MetaData.JunctionDetails, MetaData.StreetDetails> shortestPath =
                ShortestPath.calculateFor(weightedGraph, MetaData.NODE_GURLEY_CIRCLE);
        System.out.println("Shortest path from Gurley circle to university is:" + shortestPath.distanceTo(MetaData.NODE_UNIVERSITY) + "m");
        Iterator<IEdge<MetaData.StreetDetails>> iterator = shortestPath.pathTo(MetaData.NODE_UNIVERSITY).iterator();
        float time = 0;
        float factor = 0.44704f;
        while (iterator.hasNext()){
            MetaData.StreetDetails streetDetails = iterator.next().getMetaData();
            time += streetDetails.length/(streetDetails.maxspeed*factor);
        }
        System.out.println("the time is:" + time + "s");
//        Shortest path from Gurley circle to university is:15528.995034217834m
//        the time is:974.48987s
    }

    @Test
    public void ShortestPathToUniversityUsingTimeAsWeight(){
        WeightedGraph<MetaData.JunctionDetails, MetaData.StreetDetails> weightedGraph = GraphLoader.loadBirminghamStreetGraph();

        ShortestPath<MetaData.JunctionDetails, MetaData.StreetDetails> shortestPath =
                ShortestPath.calculateFor(weightedGraph, MetaData.NODE_GURLEY_CIRCLE);
        System.out.println("Shortest time from Gurley circle to university is:" + shortestPath.distanceTo(MetaData.NODE_UNIVERSITY) + "s");
//        1. using distance as weight
//        Shortest path from Gurley circle to university is:15528.995034217834m
//        the time is:974.48987s
//        2. using time as weight
//        Shortest time from Gurley circle to university is:854.1261739868285s

//        So we can see time saving
    }

    @Test
    public void ShortestPathToAirport(){
        WeightedGraph<MetaData.JunctionDetails, MetaData.StreetDetails> weightedGraph = GraphLoader.loadBirminghamStreetGraph();

        ShortestPath<MetaData.JunctionDetails, MetaData.StreetDetails> shortestPath =
                ShortestPath.calculateFor(weightedGraph, MetaData.NODE_GURLEY_CIRCLE);
        System.out.println("Shortest path from Gurley circle to airport is:" + shortestPath.distanceTo(MetaData.NODE_AIRPORT) + "m");
        Iterator<IEdge<MetaData.StreetDetails>> iterator = shortestPath.pathTo(MetaData.NODE_AIRPORT).iterator();
        float time = 0;
        float factor = 0.44704f;
        while (iterator.hasNext()){
            MetaData.StreetDetails streetDetails = iterator.next().getMetaData();
            time += streetDetails.length/(streetDetails.maxspeed*factor);
        }
        System.out.println("the time is:" + time + "s");
//        Shortest path from Gurley circle to airport is:9319.256086349487m
//        the time is:574.1509s
    }

    @Test
    public void ShortestPathToAirportUsingTimeAsWeight(){
        WeightedGraph<MetaData.JunctionDetails, MetaData.StreetDetails> weightedGraph = GraphLoader.loadBirminghamStreetGraph();

        ShortestPath<MetaData.JunctionDetails, MetaData.StreetDetails> shortestPath =
                ShortestPath.calculateFor(weightedGraph, MetaData.NODE_GURLEY_CIRCLE);
        System.out.println("Shortest time from Gurley circle to airport is:" + shortestPath.distanceTo(MetaData.NODE_AIRPORT) + "s");
//        1. using distance as weight
//        Shortest path from Gurley circle to airport is:9319.256086349487m
//        the time is:574.1509s
//        2. using time as weight
//        Shortest time from Gurley circle to airport is:559.5551157419206s

//        So we can see time saving
    }

    @Test
    public void ShortestPathToHeathCenter(){
        WeightedGraph<MetaData.JunctionDetails, MetaData.StreetDetails> weightedGraph = GraphLoader.loadBirminghamStreetGraph();

        ShortestPath<MetaData.JunctionDetails, MetaData.StreetDetails> shortestPath =
                ShortestPath.calculateFor(weightedGraph, MetaData.NODE_GURLEY_CIRCLE);
        System.out.println("Shortest path from Gurley circle to health center is:" + shortestPath.distanceTo(MetaData.NODE_HEALTH_CENTER) + "m");
        Iterator<IEdge<MetaData.StreetDetails>> iterator = shortestPath.pathTo(MetaData.NODE_HEALTH_CENTER).iterator();
        float time = 0;
        float factor = 0.44704f;
        while (iterator.hasNext()){
            MetaData.StreetDetails streetDetails = iterator.next().getMetaData();
            time += streetDetails.length/(streetDetails.maxspeed*factor);
        }
        System.out.println("the time is:" + time + "s");
//        Shortest path from Gurley circle to health center is:2397.587043762207m
//        the time is:164.35728s
    }

    @Test
    public void ShortestPathToHeathCenterUsingTimeAsWeight(){
        WeightedGraph<MetaData.JunctionDetails, MetaData.StreetDetails> weightedGraph = GraphLoader.loadBirminghamStreetGraph();

        ShortestPath<MetaData.JunctionDetails, MetaData.StreetDetails> shortestPath =
                ShortestPath.calculateFor(weightedGraph, MetaData.NODE_GURLEY_CIRCLE);
        System.out.println("Shortest time from Gurley circle to health center is:" + shortestPath.distanceTo(MetaData.NODE_HEALTH_CENTER) + "s");
//        1. using distance as weight
//        Shortest path from Gurley circle to health center is:2397.587043762207m
//        the time is:164.35728s
//        2. using time as weight
//        Shortest time from Gurley circle to health center is:164.3572862022237s

//        So we can see time are same
    }
}
