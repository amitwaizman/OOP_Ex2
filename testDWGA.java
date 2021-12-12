package api;


import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testDWGA {
    //C:\Users\rivka\IdeaProjects\Ex2\src\api\G1.json
    //C:\Users\rivka\IdeaProjects\Ex2\src\api\G2.json
    //C:\Users\rivka\IdeaProjects\Ex2\src\api\G3.json
    DirectedWeightedGraphAlgorithms g1 = new DWGA();
    DirectedWeightedGraphAlgorithms g2 = new DWGA();
    DirectedWeightedGraphAlgorithms g3 = new DWGA();
    public testDWGA() {
        g1.load("C:\\Users\\USER\\IdeaProjects\\Ex2\\src\\data\\G1.json");
        g2.load("C:\\Users\\USER\\IdeaProjects\\Ex2\\src\\data\\G2.json");
        g3.load("C:\\Users\\USER\\IdeaProjects\\Ex2\\src\\data\\G3.json");
    }
    @Test
    void isConnect() {
        boolean connected1 = g1.isConnected();
        boolean connected2 = g2.isConnected();
        boolean connected3 = g3.isConnected();
        assertEquals(connected1, true);
        assertEquals(connected2, true);
        assertEquals(connected3, true);
    }

    @Test
    void shortestPathDist() {
        double s1 = g1.shortestPathDist(0,3) ;
        double s2 = g2.shortestPathDist(10,3);
        double s3 = g3.shortestPathDist(10,40);
        assertEquals(s1, 4.096793421922225, 0.001);
        assertEquals(s2, 8.662358036732094, 0.001);
        assertEquals(s3, 7.200591524604432, 0.001);

    }

    @Test
    void shortestPath() {
        List<NodeData> s1 = g1.shortestPath(0,3) ;
        List<NodeData> s2 = g2.shortestPath(10,3);
        List<NodeData> s3 = g3.shortestPath(10,40);
        assertEquals(s1.size(), 4);
        assertEquals(s2.size(), 7);
        assertEquals(s3.size(), 7);
    }

    @Test
    void center() {
        NodeData c1 = g1.center();
        NodeData c2 = g2.center();
        NodeData c3 = g3.center();
        assertEquals(c1.getKey(), 8);
        assertEquals(c2.getKey(), 0);
        assertEquals(c3.getKey(), 40);

    }
    @Test
    void tsp(){
        NodeData n1 = g1.getGraph().getNode(0);
        NodeData n2 = g1.getGraph().getNode(3);
        NodeData n3 = g1.getGraph().getNode(5);
        List<NodeData> tsp = new ArrayList<>();
        tsp.add(n1);
        tsp.add(n2);
        tsp.add(n3);
        List<NodeData> t1 = g1.tsp(tsp);
        List<NodeData> t2 = g2.tsp(tsp);
        List<NodeData> t3 = g3.tsp(tsp);
        assertEquals(t1.size(), 6);
        assertEquals(t2.size(), 6);
        assertEquals(t3.size(), 5);
    }

    @Test
    void save() {
        boolean l1 = g1.save("C:\\Users\\USER\\IdeaProjects\\Ex2\\src\\data\\G1.json");
        boolean l2 = g2.save("C:\\Users\\USER\\IdeaProjects\\Ex2\\src\\data\\G2.json");
        boolean l3 = g3.save("C:\\Users\\USER\\IdeaProjects\\Ex2\\src\\data\\G3.json");
        assertEquals(l1, true);
        assertEquals(l2, true);
        assertEquals(l3, true);
    }

    @Test
    void load() {
        boolean l1 = g1.load("C:\\Users\\USER\\IdeaProjects\\Ex2\\src\\data\\G1.json");
        boolean l2 = g2.load("C:\\Users\\USER\\IdeaProjects\\Ex2\\src\\data\\G2.json");
        boolean l3 = g3.load("C:\\Users\\USER\\IdeaProjects\\Ex2\\src\\data\\G3.json");
        assertEquals(l1, true);
        assertEquals(l2, true);
        assertEquals(l3, true);

    }

}




