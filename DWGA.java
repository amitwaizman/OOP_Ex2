package api;

import com.google.gson.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DWGA implements DirectedWeightedGraphAlgorithms {
    private DirectedWeightedGraph dwg;


    public DWGA() {
        this.dwg = new DWG();

    }

    @Override
    public void init(DirectedWeightedGraph g) {
        this.dwg = g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.dwg;
    }

    @Override
    public DirectedWeightedGraph copy() {
        DirectedWeightedGraph copy = new DWG();
        for (int i = 0; i < this.dwg.nodeSize(); i++) {
            copy.addNode(this.dwg.getNode(i));
        }
        for (int i = 0; i < this.dwg.nodeSize(); i++) {
            for (int j = 0; j < this.dwg.nodeSize(); j++) {
                EdgeData e = this.dwg.getEdge(i, j);
                if (e != null) {
                    copy.connect(e.getSrc(), e.getDest(), e.getWeight());
                }
            }

        }
        return copy;
    }

    // Checks if the graph is Connected
    @Override
    public boolean isConnected() {
        if (dwg.nodeSize() == 0) {
            return false;
        }
        if (bfs(dwg) == true) {
            DWG g = transfor();
            if (bfs(g) == true)
                return true;
        }
        return false;
    }

    //this function Switches the edge directions
    private DWG transfor() {
        Iterator a = this.dwg.edgeIter();
        DWG d = new DWG();
        while (a.hasNext()) {
            EdgeData B = (EdgeData) a.next();
            d.addNode(this.dwg.getNode(B.getSrc()));
            d.addNode(this.dwg.getNode(B.getDest()));
            d.connect(B.getDest(), B.getSrc(), B.getWeight());
        }
        return d;
    }
/*The BFS algorithm controls all the graph nodes accessible from S. The test is performed
At nodes in the order of distance from s: For each distance layer, the test will be performed at
all nodes in the same layer before moving on to the next layer.*/

    private boolean bfs(DirectedWeightedGraph g) {
        Queue<NodeData> q = new LinkedList<NodeData>();
        changeZero(g);
        Iterator<NodeData> A = g.nodeIter();
        NodeData a = g.getNode(A.next().getKey());
        g.getNode(a.getKey()).setTag(1); //gray
        q.add(a);
        while (!q.isEmpty()) {
            NodeData out1 = q.remove();
            Iterator b = g.edgeIter(out1.getKey());
            if (b != null) {
                while (b.hasNext()) {
                    EdgeData c = (EdgeData) b.next();
                    int d = c.getDest();
                    if (g.getNode(d)!=null){
                    if (g.getNode(d).getTag() == 0) {
                        g.getNode(d).setTag(1);
                        q.add(g.getNode(d));
                    }
                    }
                }
            }
        }
        return visited(g);
    }

    //this function Checks if we have visited  the node
    private boolean visited(DirectedWeightedGraph g) {
        Iterator<NodeData> nodeIter = g.nodeIter();
        while (nodeIter.hasNext()) {
            NodeData a = (NodeData) nodeIter.next();
            if (a.getTag() == 0) {
                return false;
            }
        }
        return true;
    }

    //Turns the entire tag of the node to 0
    private void changeZero(DirectedWeightedGraph g) {
        Iterator<NodeData> nodeIter = g.nodeIter();
        while (nodeIter.hasNext()) {
            NodeData change = (NodeData) nodeIter.next();
            g.getNode(change.getKey()).setTag(0);
        }

    }


    @Override
    public double shortestPathDist(int src, int dest) {
       HashMap<Integer,NodeData> ANS =Dijkstra(this.dwg.getNode(src));
       if(ANS.size()==0){
           return Double.MAX_VALUE;
       }
        return this.dwg.getNode(dest).getWeight();
    }


    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        if (src == dest) {
            return null;
        }
        HashMap<Integer, NodeData> p = Dijkstra(this.dwg.getNode(src));
        List<NodeData> s = new ArrayList<>();
        NodeData n = p.get(dest);
        if(n==null){
            return  null;
        }
        if (n.getWeight() == Double.MAX_VALUE) {
            s.add(this.dwg.getNode(src));
            return s;
        }
        s.add(0, this.dwg.getNode(dest));
        while (n.getKey() != src) {
            s.add(0, n);
            n = p.get(n.getKey());
        }
        s.add(0, this.dwg.getNode(src));
        return s;
    }

    //Calculates the shortest path between the src and all the other vertices in the graph
    private HashMap<Integer, NodeData> Dijkstra(NodeData src) {
        changeMaxVal();
        changeZero(this.dwg);
        HashMap<Integer, NodeData> parents = new HashMap<Integer, NodeData>();
        PriorityQueue<myNode> q = new PriorityQueue<myNode>();
        src.setWeight(0);
        q.add((myNode) src);
        while (!(q.isEmpty())) {
            NodeData node = q.poll();
            if (q.peek() != null && q.peek().getWeight() < node.getWeight()) {
                q.add((myNode) node);
                node = q.poll();
            }
            node.setTag(1);
            Iterator<EdgeData> edge = this.dwg.edgeIter(node.getKey());
            if (!edge.hasNext()){
                changeMaxVal();
            } else{
                while (edge.hasNext()) {
                    EdgeData e = edge.next();
                    NodeData dest = this.dwg.getNode(e.getDest());
                    double w = e.getWeight() + node.getWeight();
                    if (dest!=null) {
                        if (w < dest.getWeight()) {
                            dest.setWeight(w);
                            if (parents.containsKey(dest.getKey())) {
                                parents.replace(dest.getKey(), node);
                            } else {
                                parents.put(dest.getKey(), node);
                                q.add((myNode) dest);
                            }
                        }
                    }
                }
            }
        }

        return parents;
    }
//change Max Value in weight
    private void changeMaxVal() {
        Iterator<NodeData> nodeIter = dwg.nodeIter();
        while (nodeIter.hasNext()) {

            NodeData change = (NodeData) nodeIter.next();
            this.dwg.getNode(change.getKey()).setWeight(Double.MAX_VALUE);
        }

    }

    @Override

    public NodeData center() {
        double w;
        Iterator it = this.dwg.nodeIter();
        double sumMin = Double.MAX_VALUE;
        NodeData min = null;
        int m = 0;
        while (it.hasNext()) {
            NodeData b = (NodeData) it.next();
            List<Double> wMax = new ArrayList<>();
            Iterator iter = this.dwg.nodeIter();
            m++;
            HashMap<Integer, NodeData> k = Dijkstra(b);
            if (k.size()!=0){
                while (iter.hasNext()) {
                    w = 0;
                    NodeData s = (NodeData) iter.next();
                    if (s.getKey() != b.getKey()) {
                        w = this.dwg.getNode(s.getKey()).getWeight();
                    }
                    if (w != Double.MAX_VALUE)
                        wMax.add(w);
                }
                double max = Double.MIN_VALUE;
                for (int i = 0; i < wMax.size(); i++) {
                    if (wMax.get(i) > max) {
                        max = wMax.get(i);
                    }
                }
                if (sumMin > max) {
                    sumMin = max;
                    min = b;
                }
            }
        }
        System.out.println(m);
        return min;
    }


    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        double min = Double.MAX_VALUE;
        List<NodeData> ans = new ArrayList<>();
        List<NodeData> ans2 = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            for (int j = i + 1; j < cities.size(); j++) {
                ans = shortestPath(cities.get(i).getKey(), cities.get(j).getKey());
                boolean a = isFound(cities, ans);
                if (a) {
                    if (min > ans.size())
                        min = ans.size();
                    ans2 = ans;
                }
            }
        }
        for (int i = cities.size() - 1; i > 0; i--) {
            for (int j = i - 1; j > 0; j--) {
                if (cities.get(i)!=cities.get(j)) {
                    ans = shortestPath(cities.get(i).getKey(), cities.get(j).getKey());
                    boolean a = isFound(cities, ans);
                    if (a) {
                        if (min > ans.size()) {
                            min = ans.size();
                            ans2 = ans;
                        }
                    }
                }
            }
        }
        if (ans2.size() == 0) {
            for (int i = 0; i < cities.size() - 1; i++) {
                ans = shortestPath(cities.get(i).getKey(), cities.get(i + 1).getKey());
                for (int j = 0; j < ans.size(); j++) {
                    if (ans2.size()==0){
                        ans2.add(ans.get(j));
                    }
                    if (ans2.size()!=0 && ans.get(j)!=ans2.get(ans2.size()-1))
                        ans2.add(ans.get(j));
                }
            }
        }
        return ans2;
    }

    //Returns if what is in the list  A is in the list B
    private boolean isFound(List<NodeData> a, List<NodeData> b) {
        if (a == null || b == null) {
            return false;
        }
        if (a.size() > b.size()) {
            return false;
        }
        boolean find;
        for (int i = 0; i < a.size(); i++) {
            find = false;
            for (int j = 0; j < b.size() && !find; j++) {
                if (a.get(i).getKey() == b.get(j).getKey()) {
                    find = true;
                }

            }
            if (!find) {
                return false;
            }

        }

        return true;
    }

    @Override
    public boolean save(String file) {
        String graph = "";
        Path f = Paths.get(file);
        Iterator<EdgeData> edge = this.dwg.edgeIter();
        Iterator<NodeData> node = this.dwg.nodeIter();
        graph = "{" + "\n" + "  \"Edges\": [ ";
        while (edge.hasNext()) {
            EdgeData e = edge.next();
            graph += "\n" + "    { ";
            graph += "\r\n" + "       \"src\":" + " " + e.getSrc() + "," +
                    "\r\n" + "       \"w\":" + " " + e.getWeight() + "," +
                    "\r\n" + "       \"dest\":" + " " + e.getDest();
            if (edge.hasNext()) {
                graph += "\n" + "    }, ";
            } else {
                graph += "\n" + "    } ";
            }
        }
        graph += "\n" + " ], ";

        graph += "\n" + "    \"Nodes\" : [ ";
        while (node.hasNext()) {
            NodeData n = node.next();
            graph += "\n" + "    { ";
            String pos = n.getLocation().x() + ","
                    + n.getLocation().y() + ","
                    + n.getLocation().z();
            graph += "\r\n" + "       \"pos\": " + "\"" + pos + "\"" + ",";
            graph += "\r\n" + "       \"id\": " + n.getKey();
            if (node.hasNext()) {
                graph += "\n" + "    }, ";
            } else {
                graph += "\n" + "    } ";
            }
        }
        graph += "\n" + "  ] ";
        graph += "\n" + "} ";

        try {
            Files.write(f, Arrays.asList(graph), StandardCharsets.UTF_8);
        } catch (IOException e) {
            return false;
        }
        return true;
    }


    @Override
    public boolean load(String file) {
        final String json_path = file;
        JsonObject jsonObject = new JsonObject();
        try {
            String json_str = new String(
                    Files.readAllBytes(Paths.get(json_path))
            );
            jsonObject = JsonParser.parseString(json_str).getAsJsonObject();
            JsonElement s = jsonObject.get("Edges");
            JsonElement s1 = jsonObject.get("Nodes");
            JsonArray e = s.getAsJsonArray();
            JsonArray n = s1.getAsJsonArray();

            for (int i = 0; i < e.size(); i++) {
                int src = e.get(i).getAsJsonObject().get("src").getAsInt();
                double w = e.get(i).getAsJsonObject().get("w").getAsDouble();
                int dest = e.get(i).getAsJsonObject().get("dest").getAsInt();
                this.dwg.connect(src, dest, w);

            }

            for (int i = 0; i < n.size(); i++) {
                String[] pos = n.get(i).getAsJsonObject().get("pos").toString().split(",");
                pos[0] = pos[0].substring(1, pos[0].length());
                pos[2] = pos[2].substring(0, pos[2].length() - 1);
                GeoLocation g = new gl(Double.parseDouble(pos[0]), Double.parseDouble(pos[1]), Double.parseDouble(pos[2]));
                myNode node = new myNode(g, n.get(i).getAsJsonObject().get("id").getAsInt(), 0, "", 0);
                this.dwg.addNode(node);


            }
        } catch (IOException e) {

            return false;
        }
        return true;
    }

}