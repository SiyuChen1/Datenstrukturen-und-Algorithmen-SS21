package de.unistuttgart.vis.dsass2021.ex03.p3;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import de.unistuttgart.vis.dsass2021.ex03.p3.BinarySearchTree;
import de.unistuttgart.vis.dsass2021.ex03.p3.BinaryTreeNode;
import de.unistuttgart.vis.dsass2021.ex03.p3.IBinarySearchTree;
import de.unistuttgart.vis.dsass2021.ex03.p3.IBinaryTreeNode;

public class BinarySearchTreeTest {

    @Test
    public void testGetRootNode(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        assertEquals(null, binarySearchTree.getRootNode());
        binarySearchTree.insert(9);
        binarySearchTree.insert(4);
        binarySearchTree.insert(12);
        binarySearchTree.insert(8);
        assertEquals(new Integer(9), binarySearchTree.getRootNode().getValue());
    }

    @Test
    public void testIsFull(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        assertEquals(null, binarySearchTree.getRootNode());
        binarySearchTree.insert(9);
        binarySearchTree.insert(4);
        assertEquals(false, binarySearchTree.isFull());
        binarySearchTree.insert(12);
        assertEquals(true, binarySearchTree.isFull());
        binarySearchTree.insert(13);
        assertEquals(false, binarySearchTree.isFull());
    }
}
