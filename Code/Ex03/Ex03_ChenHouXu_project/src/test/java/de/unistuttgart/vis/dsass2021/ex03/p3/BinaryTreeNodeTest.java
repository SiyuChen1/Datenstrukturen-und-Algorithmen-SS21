package de.unistuttgart.vis.dsass2021.ex03.p3;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import de.unistuttgart.vis.dsass2021.ex03.p3.BinaryTreeNode;
import de.unistuttgart.vis.dsass2021.ex03.p3.IBinaryTreeNode;

import java.lang.reflect.Field;

public class BinaryTreeNodeTest {

    @Test
    public void testSetValue(){
        BinaryTreeNode<String> node = new BinaryTreeNode<>();
        final String string = "hello";
        node.setValue(string);

        //then
        try {
            Field field = node.getClass().getDeclaredField("value");
            field.setAccessible(true);
            assertEquals("Fields didn't match", field.get(node), "hello");
            System.out.println("success");
        }catch (Exception e){
            System.out.println("failed");
        }
    }

    @Test
    public void testGetValue(){
        final BinaryTreeNode<String> node = new BinaryTreeNode<>();
        final String string = "hello";

        try{
            final Field field = node.getClass().getDeclaredField("value");
            field.setAccessible(true);
            field.set(node, string);
            assertEquals("field wasn't retrieved properly", node.getValue(), string);
            System.out.println("success");
        }catch (Exception e){
            System.out.println("failed");
        }
    }

    @Test
    public void testSetLeftChild(){
        BinaryTreeNode<String> node = new BinaryTreeNode<>();
        BinaryTreeNode<String> leftChildNode = new BinaryTreeNode<>();
        node.setLeftChild(leftChildNode);

        //then
        try {
            Field field = node.getClass().getDeclaredField("leftChild");
            field.setAccessible(true);
            assertEquals("Fields didn't match", field.get(node), leftChildNode);
            System.out.println("success");
        }catch (Exception e){
            System.out.println("failed");
        }
    }

    @Test
    public void testGetLeftChild(){
        final BinaryTreeNode<String> node = new BinaryTreeNode<>();
        final BinaryTreeNode<String> leftChildNode = new BinaryTreeNode<>();

        try{
            final Field field = node.getClass().getDeclaredField("leftChild");
            field.setAccessible(true);
            field.set(node, leftChildNode);
            assertEquals("field wasn't retrieved properly", node.getLeftChild(), leftChildNode);
            System.out.println("success");
        }catch (Exception e){
            System.out.println("failed");
        }
    }

    @Test
    public void testSetRightChild(){
        BinaryTreeNode<String> node = new BinaryTreeNode<>();
        BinaryTreeNode<String> rightChildNode = new BinaryTreeNode<>();
        node.setRightChild(rightChildNode);

        //then
        try {
            Field field = node.getClass().getDeclaredField("rightChild");
            field.setAccessible(true);
            assertEquals("Fields didn't match", field.get(node), rightChildNode);
            System.out.println("success");
        }catch (Exception e){
            System.out.println("failed");
        }
    }

    @Test
    public void testGetRightChild(){
        final BinaryTreeNode<String> node = new BinaryTreeNode<>();
        final BinaryTreeNode<String> rightChildNode = new BinaryTreeNode<>();

        try{
            final Field field = node.getClass().getDeclaredField("rightChild");
            field.setAccessible(true);
            field.set(node, rightChildNode);
            assertEquals("field wasn't retrieved properly", node.getRightChild(), rightChildNode);
            System.out.println("success");
        }catch (Exception e){
            System.out.println("failed");
        }
    }
}
