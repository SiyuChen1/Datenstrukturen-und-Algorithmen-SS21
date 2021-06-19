package de.unistuttgart.vis.dsass2021.ex05.p2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import de.unistuttgart.vis.dsass2021.ex05.p1.Rectangle;
import de.unistuttgart.vis.dsass2021.ex05.p2.CollisionMap;

public class CollisionMapTest {
    @Test
    public void testFillCollisionMap(){
        Rectangle rectangle = new Rectangle(10,10, 20, 10);
        Rectangle rectangle1 = new Rectangle(20, 15, 20, 10);
        Set<Rectangle> rectangleSet = new HashSet<>();
        rectangleSet.add(rectangle);
        rectangleSet.add(rectangle1);
        CollisionMap collisionMap = new CollisionMap(rectangleSet);
        List<Rectangle>[][] map = collisionMap.getMap();
        System.out.println(map[0][0]);
        System.out.println(map[50][50]);
        System.out.println(map[99][99]);
    }

    @Test
    public void testCollide(){
        Rectangle rectangle = new Rectangle(10,10, 20, 10);
        Rectangle rectangle1 = new Rectangle(20, 15, 20, 10);
        Rectangle rectangle2 = new Rectangle(18, 12, 20, 10);
        Set<Rectangle> rectangleSet = new HashSet<>();
        rectangleSet.add(rectangle);
        rectangleSet.add(rectangle1);
        CollisionMap collisionMap = new CollisionMap(rectangleSet);
        boolean flag = collisionMap.collide(rectangle2);
        assertEquals(true, flag);
        Rectangle rectangle3 = new Rectangle(33, 12, 2, 2);
        assertEquals(false, collisionMap.collide(rectangle3));
    }
}
