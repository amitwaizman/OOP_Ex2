package api;

import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDWG {
    DirectedWeightedGraph g = new DWG();

    public testDWG() {
        GeoLocation gg = new gl(0, 1, 2);
        NodeData n1 = new myNode(gg, 0, 0, "", 0);
        NodeData n2 = new myNode(gg, 1, 0, "", 0);
        g.addNode(n1);
        g.addNode(n2);
        g.connect(0, 1, 2);

    }

    @Test
    void getNode() {
        NodeData node = g.getNode(0);
        assertEquals(node.getKey(), 0);
        assertEquals(node.getLocation().x(), 0);
        assertEquals(node.getLocation().y(), 1);
        assertEquals(node.getLocation().z(), 2);
        assertEquals(node.getWeight(), 0);
    }

    @Test
    void getEdge() {
        EdgeData edge = g.getEdge(0, 1);
        assertEquals(edge.getSrc(), 0);
        assertEquals(edge.getDest(), 1);
        assertEquals(edge.getWeight(), 2);
    }

    @Test
    void addNode() {
        GeoLocation gg = new gl(0, 1, 2);
        NodeData n3 = new myNode(gg, 2, 0, "", 0);
        g.addNode(n3);
        NodeData node = g.getNode(2);
        assertEquals(node.getKey(), 2);

    }

    @Test
    void connect() {
        g.connect(1, 2, 2);
        assertEquals(g.getEdge(1, 2).getSrc(), 1);
        assertEquals(g.getEdge(1, 2).getDest(), 2);
        assertEquals(g.getEdge(1, 2).getWeight(), 2);
    }

    @Test
    void removeNode() {
        g.removeNode(0);
        assertEquals(g.getNode(0), null);
        assertEquals(g.getEdge(0, 1), null);

    }

    @Test
    void removeEdge() {
        g.removeEdge(0, 1);
        assertEquals(g.getEdge(0, 1), null);

    }

    @Test
    void nodeSize() {
        int size = g.nodeSize();
        assertEquals(size, 2);
        g.removeNode(0);
        size = g.nodeSize();
        assertEquals(size, 1);
    }

    @Test
    void edgeSize() {
        int size = g.edgeSize();
        assertEquals(size, 1);
        EdgeData e = g.removeEdge(0, 1);
        size = g.edgeSize();
        assertEquals(size, 0);
    }

    @Test
    void getMC() {
        int mc = g.getMC();
        assertEquals(mc, 3);
        g.removeEdge(0, 1);
        mc = g.getMC();
        assertEquals(mc, 4);
        g.removeNode(0);
        mc = g.getMC();
        assertEquals(mc, 5);
    }

}
