package api;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMyNode {


    NodeData n1;
    NodeData n2;

    public testMyNode() {
        GeoLocation gg = new gl(0, 1, 2);
        n1 = new myNode(gg, 0, 0, "", 0);
        n2 = new myNode(gg, 1, 0, "", 0);
    }

    @Test
    void getKey() {
        assertEquals(n1.getKey(), 0);
        assertEquals(n2.getKey(), 1);
    }

    @Test
    void getLocation() {
        GeoLocation g1 = n1.getLocation();
        assertEquals(g1.x(), 0);
        assertEquals(g1.y(), 1);
        assertEquals(g1.z(), 2);
        GeoLocation g2 = n2.getLocation();
        assertEquals(g2.x(), 0);
        assertEquals(g2.y(), 1);
        assertEquals(g2.z(), 2);
    }

    @Test
    void setLocation() {
        GeoLocation g = new gl(1, 2, 3);
        n1.setLocation(g);
        GeoLocation g1 = n1.getLocation();
        assertEquals(g1.x(), 1);
        assertEquals(g1.y(), 2);
        assertEquals(g1.z(), 3);
    }

    @Test
    void getWeight() {
        assertEquals(n1.getWeight(), 0);
        assertEquals(n2.getWeight(), 0);
    }

    @Test
    void setWeight() {
        n1.setWeight(1);
        n2.setWeight(2);
        assertEquals(n1.getWeight(), 1);
        assertEquals(n2.getWeight(), 2);
    }

    @Test
    void getInfo() {
        assertEquals(n1.getInfo(), "");
        assertEquals(n2.getInfo(), "");
    }

    @Test
    void setInfo() {
        n1.setInfo("n1");
        n2.setInfo("n2");
        assertEquals(n1.getInfo(), "n1");
        assertEquals(n2.getInfo(), "n2");
    }

    @Test
    void getTag() {
        assertEquals(n1.getTag(), 0);
        assertEquals(n2.getTag(), 0);
    }

    @Test
    void setTag() {
        n1.setTag(-1);
        n2.setTag(1);
        assertEquals(n1.getTag(), -1);
        assertEquals(n2.getTag(), 1);

    }

}
