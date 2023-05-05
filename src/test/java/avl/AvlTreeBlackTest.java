package avl;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AvlTreeBlackTest {
    @Test
    @DisplayName("Con un árbol vacío se inserta un único nodo, entonces sería el primero")
    public void validInsertSingleNode(){
        AvlTree arbol = new AvlTree(null);
        arbol.insert(4);
        Object itemExpected = 4;

        assertEquals(itemExpected,arbol.top.getItem());
    }

    @Test
    @DisplayName("Con un árbol vacío se inserta un único nodo, entonces sería el primero")
    public void validInsertThreeNodes(){
        AvlTree arbol = new AvlTree(comparator);
        arbol.insert(4);
        arbol.insert(8);
        arbol.insert(2);
        Object itemExpectedMiddle = 4;
        Object itemExpectedFirst = 8;
        Object itemExpectedLast = 2;

        assertEquals(itemExpectedFirst,arbol.top.getItem());
        assertEquals(itemExpectedMiddle,arbol.top.getLeft().getItem());
        assertEquals(itemExpectedLast,arbol.top.getLeft().getLeft().getItem());
    }

    @Test
    @DisplayName("")
    public void validDeleteNode(){

    }
}
