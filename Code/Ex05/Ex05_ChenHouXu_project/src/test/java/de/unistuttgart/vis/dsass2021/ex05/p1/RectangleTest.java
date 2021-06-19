package de.unistuttgart.vis.dsass2021.ex05.p1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import de.unistuttgart.vis.dsass2021.ex05.p1.Point;
import de.unistuttgart.vis.dsass2021.ex05.p1.Rectangle;

public class RectangleTest {
    @Test
    public void testExcludePoints(){
        Rectangle rectangle = new Rectangle(10,10,20, 20);
        List<Point> points = new LinkedList<>();
        points.add(new Point(40, 40));
        Rectangle newRectangle = rectangle.excludePoints(points);
        assertEquals(rectangle.getX(), newRectangle.getX(), 1e-5);
        assertEquals(rectangle.getY(), newRectangle.getY(), 1e-5);
        assertEquals(rectangle.getWidth(), newRectangle.getWidth(), 1e-5);
        assertEquals(rectangle.getHeight(), newRectangle.getHeight(), 1e-5);

        points.add(new Point(25,25));
        Rectangle newRectangle2 = rectangle.excludePoints(points);
        assertEquals(rectangle.getX(), newRectangle2.getX(), 1e-5);
        assertEquals(rectangle.getY(), newRectangle2.getY(), 1e-5);
        assertEquals(14, newRectangle2.getWidth(), 1e-5);
        assertEquals(14, newRectangle2.getHeight(), 1e-5);

        points.add(new Point(22,23));
        points.add(new Point(35, 67));
        Rectangle newRectangle3 = rectangle.excludePoints(points);
        assertEquals(rectangle.getX(), newRectangle3.getX(), 1e-5);
        assertEquals(rectangle.getY(), newRectangle3.getY(), 1e-5);
        assertEquals(11, newRectangle3.getWidth(), 1e-5);
        assertEquals(12, newRectangle3.getHeight(), 1e-5);

    }
}
