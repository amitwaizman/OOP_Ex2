package api;

import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMyEdge {
    EdgeData e1;
    EdgeData e2;

    public testMyEdge() {
        e1 = new myEdge(0, 1, 1.5);
        e2 = new myEdge(1, 0, 2.5);
    }

    @Test
    void getSrc() {
        assertEquals(e1.getSrc(), 0);
        assertEquals(e2.getSrc(), 1);
    }

    @Test
    void getDest() {
        assertEquals(e1.getDest(), 1);
        assertEquals(e2.getDest(), 0);
    }

    @Test
    void getWeight() {
        assertEquals(e1.getWeight(), 1.5);
        assertEquals(e2.getWeight(), 2.5);
    }

    @Test
    void getInfo() {
        e1.setInfo("1");
        assertEquals(e1.getInfo(), "1");
    }

    @Test
    void setInfo() {
        e1.setInfo("2");
        assertEquals(e1.getInfo(), "2");
        e1.setInfo("3");
        assertEquals(e1.getInfo(), "3");
    }

    @Test
    void getTag() {
        e1.setTag(1);
        assertEquals(e1.getTag(), 1);
    }

    @Test
    void setTag() {
        e1.setTag(2);
        assertEquals(e1.getTag(), 2);
        e1.setTag(1);
        assertEquals(e1.getTag(), 1);
    }

}
