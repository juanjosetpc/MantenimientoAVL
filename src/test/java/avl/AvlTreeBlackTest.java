package avl;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
    @DisplayName("Con un árbol vacío y un comparador nulo se inserta un único nodo, inserta el nodo al no tener que comparar")
    public void validInsertSingleNodeWithComparatorNull(){
        AvlTree arbol = new AvlTree(null);
        arbol.insert(4);
        Object itemExpected = 4;

        assertEquals(itemExpected,arbol.top.getItem());
    }

    @Test
    @DisplayName("Con un árbol vacío y un comparador nulo se inserta un único nodo, inserta el nodo al no tener que comparar")
    public void validInsertSingleNode(){
        AvlTree arbol = new AvlTree(comparator);
        arbol.insertAvlNode(new AvlNode(4));
        Object itemExpected = 4;

        assertEquals(itemExpected,arbol.top.getItem());
    }

    @Test
    @DisplayName("Con un árbol vacío se inserta un único nodo, entonces sería el primero")
    public void invalidInsertNodesWithComparatorNull(){
        AvlTree arbol = new AvlTree(null);
        arbol.insert(4);
        assertThrows(NullPointerException.class,()->arbol.insert(8));
    }

    @Test
    @DisplayName("Con un árbol vacío se inserta un único nodo, entonces sería el primero")
    public void validInsertThreeNodes(){
        AvlTree arbol = new AvlTree(comparator);
        arbol.insert(4);
        arbol.insert(8);
        arbol.insert(2);
        Object itemExpectedFirst = 4;
        Object itemExpectedMiddle = 8;
        Object itemExpectedLast = 2;

        assertEquals(itemExpectedFirst,arbol.top.getItem());
        assertEquals(itemExpectedMiddle,arbol.top.getRight().getItem());
        assertEquals(itemExpectedLast,arbol.top.getLeft().getItem());
    }

    @Test
    public void testSearchExistingNode() {
        AvlTree<Integer> tree = new AvlTree<>(comparator);
        tree.insert(5);
        AvlNode<Integer> node = tree.search(5);
        assertNotNull(node);
        assertEquals(5, (int) node.getItem());
    }

    @Test
    public void testSearchNonExistingNode() {
        AvlTree<Integer> tree = new AvlTree<>(comparator);
        tree.insert(5);
        AvlNode<Integer> node = tree.search(10);
        assertNull(node);
    }

    @Test
    public void testDeleteLeafNode() {
        AvlTree<Integer> tree = new AvlTree<>(comparator);
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
        AvlTree<Integer> tree = new AvlTree<>(comparator);
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
        AvlTree<Integer> tree = new AvlTree<>(comparator);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.delete(7);
        assertEquals(5, (int) tree.top.getItem());
        assertEquals(3, (int) tree.top.getLeft().getItem());
        assertNull(tree.top.getRight());
    }

    @Test
    public void GivenTreeAndNodeThatHasSuccessorWhenUseFindSuccessorItReturnsTheSuccessorNode(){
        AvlTree<Object> tree = new AvlTree<Object>(comparator);
        AvlNode node1 = new AvlNode(5);
        AvlNode node2 = new AvlNode(3);
        AvlNode node3 = new AvlNode(8);

        tree.insertTop(node1);
        tree.insertAvlNode(node2);
        tree.insertAvlNode(node3);

        AvlNode<Integer> expected = node3;
        AvlNode<Integer> actual = tree.findSuccessor(node1);


        assertEquals(expected,actual);
    }

    @Test
    public void noFirstToSearch(){
        AvlTree tree = new AvlTree(comparator);
        assertNull(tree.search(2));
    }
}
