package de.unistuttgart.vis.dsass2021.ex04.p3;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class BinarySearchTreeTest {

    @Test
    public void testPreOrderIterator(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(12);
        binarySearchTree.insert(3);
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
        binarySearchTree.insert(14);

        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalType.PREORDER);
        assertEquals(new Integer(8), iterator.next());
        assertEquals(new Integer(4), iterator.next());
        assertEquals(new Integer(3), iterator.next());
        assertEquals(new Integer(7), iterator.next());
        assertEquals(new Integer(12), iterator.next());
        assertEquals(new Integer(10), iterator.next());
        assertEquals(new Integer(14), iterator.next());
    }

    @Test
    public void testInOrderIterator(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(12);
        binarySearchTree.insert(2);
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
        binarySearchTree.insert(14);
        binarySearchTree.insert(3);

        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalType.INORDER);
        assertEquals(new Integer(2), iterator.next());
        assertEquals(new Integer(3), iterator.next());
        assertEquals(new Integer(4), iterator.next());
        assertEquals(new Integer(7), iterator.next());
        assertEquals(new Integer(8), iterator.next());
        assertEquals(new Integer(10), iterator.next());
        assertEquals(new Integer(12), iterator.next());
        assertEquals(new Integer(14), iterator.next());
    }

    @Test
    public void testPostOrderIterator(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(12);
        binarySearchTree.insert(2);
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
        binarySearchTree.insert(14);
        binarySearchTree.insert(3);

        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalType.POSTORDER);
        assertEquals(new Integer(3), iterator.next());
        assertEquals(new Integer(2), iterator.next());
        assertEquals(new Integer(7), iterator.next());
        assertEquals(new Integer(4), iterator.next());
        assertEquals(new Integer(10), iterator.next());
        assertEquals(new Integer(14), iterator.next());
        assertEquals(new Integer(12), iterator.next());
        assertEquals(new Integer(8), iterator.next());
    }

    @Test
    public void testLevelOrderIterator(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(8);
        binarySearchTree.insert(4);
        binarySearchTree.insert(12);
        binarySearchTree.insert(2);
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
        binarySearchTree.insert(14);
        binarySearchTree.insert(3);

        Iterator<Integer> iterator = binarySearchTree.iterator(TreeTraversalType.LEVELORDER);
        assertEquals(new Integer(8), iterator.next());
        assertEquals(new Integer(4), iterator.next());
        assertEquals(new Integer(12), iterator.next());
        assertEquals(new Integer(2), iterator.next());
        assertEquals(new Integer(7), iterator.next());
        assertEquals(new Integer(10), iterator.next());
        assertEquals(new Integer(14), iterator.next());
        assertEquals(new Integer(3), iterator.next());
    }
}
