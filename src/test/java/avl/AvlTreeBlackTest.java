package avl;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Comparator;

import static org.junit.Assert.*;

public class AvlTreeBlackTest {
    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    };
    @Test
    @DisplayName("")
    public void validSearchNode(){
        Object searchedItem = 4;
    }

    @Test
    public void testInsertSingleNode() {
        AvlTree<Integer> tree = new AvlTree<>(null);
        tree.insert(5);
        assertEquals(5, (int) tree.top.getItem());
    }

    @Test
    public void testInsertMultipleNodes() {
        AvlTree<Integer> tree = new AvlTree<>(comparator);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        assertEquals(5, (int) tree.top.getItem());
        assertEquals(3, (int) tree.top.getLeft().getItem());
        assertEquals(7, (int) tree.top.getRight().getItem());
    }

    @Test
    public void testSearchExistingNode() {
        AvlTree<Integer> tree = new AvlTree<>(null);
        tree.insert(5);
        AvlNode<Integer> node = tree.search(5);
        assertNotNull(node);
        assertEquals(5, (int) node.getItem());
    }

    @Test
    public void testSearchNonExistingNode() {
        AvlTree<Integer> tree = new AvlTree<>(null);
        tree.insert(5);
        AvlNode<Integer> node = tree.search(10);
        assertNull(node);
    }

    @Test
    public void testDeleteLeafNode() {
        AvlTree<Integer> tree = new AvlTree<>(null);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.delete(3);
        assertEquals(5, (int) tree.top.getItem());
        assertNull(tree.top.getLeft());
        assertEquals(7, (int) tree.top.getRight().getItem());
    }

    @Test
    public void testDeleteNodeWithALeftChild() {
        AvlTree<Integer> tree = new AvlTree<>(null);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.delete(5);
        assertEquals(7, (int) tree.top.getItem());
        assertEquals(3, (int) tree.top.getLeft().getItem());
        assertNull(tree.top.getRight());
    }

    @Test
    public void testDeleteNodeWithARightChild() {
        AvlTree<Integer> tree = new AvlTree<>(null);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.delete(7);
        assertEquals(5, (int) tree.top.getItem());
        assertEquals(3, (int) tree.top.getLeft().getItem());
        assertNull(tree.top.getRight());
    }
}
