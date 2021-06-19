package de.unistuttgart.vis.dsass2021.ex05.p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import de.unistuttgart.vis.dsass2021.ex05.p1.Point;
import de.unistuttgart.vis.dsass2021.ex05.p1.QuadTree;
import de.unistuttgart.vis.dsass2021.ex05.p1.QuadTreeElement;
import de.unistuttgart.vis.dsass2021.ex05.p1.Rectangle;
import de.unistuttgart.vis.dsass2021.ex05.p1.SimpleQuadTree;


public class SimpleQuadTreeTest {
    class PointQuadTreeElement implements QuadTreeElement{
        Point point;

        PointQuadTreeElement(Point p){
            point = p;
        }

        @Override
        public Point getPosition(){
            return point;
        }
    }
    @Test
    public void testComputeBoundingBox(){
        List<QuadTreeElement> list = new LinkedList<>();
        list.add(new PointQuadTreeElement(new Point(1,1)));
        list.add(new PointQuadTreeElement(new Point(3,4)));
        list.add(new PointQuadTreeElement(new Point(4,4)));
        list.add(new PointQuadTreeElement(new Point(5,4)));
        list.add(new PointQuadTreeElement(new Point(2,4)));
        SimpleQuadTree<QuadTreeElement> simpleQuadTree = new SimpleQuadTree<QuadTreeElement>(list,4);
        Rectangle boundingBox = simpleQuadTree.getBoundingBox();
        assertEquals(1, boundingBox.getX(), 1e-5);
        assertEquals(1, boundingBox.getY(), 1e-5);
        assertEquals(4, boundingBox.getWidth(), 1e-5);
        assertEquals(3, boundingBox.getHeight(), 1e-5);
    }

    @Test
    public void testCreateQuadTree(){
        List<QuadTreeElement> list = new LinkedList<>();
        list.add(new PointQuadTreeElement(new Point(1,1)));
        list.add(new PointQuadTreeElement(new Point(5,5)));
        list.add(new PointQuadTreeElement(new Point(3.2f,3.2f)));
        list.add(new PointQuadTreeElement(new Point(3.7f,3.2f)));
        list.add(new PointQuadTreeElement(new Point(3.2f,3.7f)));
        list.add(new PointQuadTreeElement(new Point(3.7f,3.7f)));
        SimpleQuadTree<QuadTreeElement> simpleQuadTree = new SimpleQuadTree<QuadTreeElement>(list,4);
    }

    @Test
    public void testRangeQuery(){
        List<QuadTreeElement> list = new LinkedList<>();

        Point p1 = new Point(1,1);
        Point p2 = new Point(5,5);
        Point p3 = new Point(2.2f,2.2f);
        Point p4 = new Point(3.4f,3.4f);
        Point p5 = new Point(4,4);

        list.add(new PointQuadTreeElement(p1));
        list.add(new PointQuadTreeElement(p2));
        list.add(new PointQuadTreeElement(p3));
        list.add(new PointQuadTreeElement(p4));
        list.add(new PointQuadTreeElement(p5));
        SimpleQuadTree<QuadTreeElement> simpleQuadTree = new SimpleQuadTree<QuadTreeElement>(list,4);
        List<QuadTreeElement> pointQuadTreeElementsList = new LinkedList<>();
        Rectangle query = new Rectangle(2,2, 1.5f, 1.5f);
        simpleQuadTree.rangeQuery(pointQuadTreeElementsList, query);
        assertEquals(true, pointQuadTreeElementsList.get(0).getPosition().equals(p3));
        assertEquals(true, pointQuadTreeElementsList.get(1).getPosition().equals(p4));
    }

}
