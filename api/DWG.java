package api;
import java.util.*;

public class DWG implements DirectedWeightedGraph{
    private  HashMap<String, NodeData> HashNode = new HashMap<String, NodeData>();
    private  HashMap<String, EdgeData> Hashedge = new HashMap<String, EdgeData>();
    private  HashMap<Integer, HashMap<Integer,EdgeData> > inNode = new HashMap<Integer, HashMap<Integer,EdgeData> >();
    private  HashMap<Integer, HashMap<Integer,EdgeData> > outNode = new HashMap<Integer, HashMap<Integer,EdgeData> >();
    int sizeNode=0;
    int sizeEdge=0;
    int MC=0;


    public DWG() {
        this.HashNode = new HashMap<>();
        this.Hashedge = new HashMap<>();
        this.inNode = new HashMap<>();
        this.outNode = new HashMap<>();
    }


    @Override
    public NodeData getNode(int key) {
        String keyy= String.valueOf(key);
        try {
            return this.HashNode.get(keyy);

        } catch (IndexOutOfBoundsException l) {
            return null;
        }
    }
    @Override
    public EdgeData getEdge(int src, int dest) {
        String Ssrc= String.valueOf(src);
        String Sdest= String.valueOf(dest);
        String ans=Ssrc+"."+Sdest;
        return this.Hashedge.get(ans);
    }

    @Override
    public void addNode(NodeData n) {
        String keyy= String.valueOf(n.getKey());
        this.HashNode.put(keyy,(myNode) n);
        this.sizeNode++;
        this.MC++;
    }

    @Override
    public void connect(int src, int dest, double w) {
        myEdge e= new myEdge(src, dest, w);
        String Ssrc= String.valueOf(src);
        String Sdest= String.valueOf(dest);
        String ans=Ssrc+"."+Sdest;
        this.Hashedge.put(ans, e);
        HashMap<Integer,EdgeData> b = new HashMap<>();
        if (this.inNode.get(dest)!=null){
            b=this.inNode.get(dest);
        }
        b.put(src,e);
        this.inNode.put(dest,b);
        HashMap<Integer,EdgeData> c = new HashMap<>();
        if (this.outNode.get(src)!=null){
            c=this.outNode.get(src);
        }
        c.put(dest,e);
        this.outNode.put(src,c);
        this.sizeEdge++;
        this.MC++;
    }

    private class NodeIterator implements Iterator<NodeData>{
        int mc;
        Iterator<NodeData> iter;
        public NodeIterator()
        {
            mc=MC;
            iter=HashNode.values().iterator();
        }


        @Override
        public boolean hasNext() {
            if (mc!=MC){
                throw new RuntimeException("change the graph");
            }
            return iter.hasNext();
        }

        @Override
        public NodeData next() {
            if (mc!=MC){
                throw new RuntimeException("change the graph");
            }
            return iter.next();
        }

        @Override
        public void remove() {
            if (mc!=MC){
                throw new RuntimeException("change the graph");
            }
            MC++;
            iter.remove();
            removeNode(iter.next().getKey());
        }


    }
    @Override
    public Iterator<NodeData> nodeIter() {

        Iterator<NodeData> iter = new NodeIterator();
        return iter;
    }
    private class EdgeIterator implements Iterator<EdgeData>{
        int mc;
        Iterator<EdgeData> iter;
        public EdgeIterator()
        {
            mc=MC;
            iter=Hashedge.values().iterator();
        }
        public EdgeIterator(int node_id)
        {
            mc=MC;
            iter=outNode.get(node_id).values().iterator();
        }


        @Override
        public boolean hasNext() {
            if (mc!=MC){
                throw new RuntimeException("change the graph");
            }
            return iter.hasNext();
        }

        @Override
        public EdgeData next() {
            if (mc!=MC){
                throw new RuntimeException("change the graph");
            }
            return iter.next();
        }

        @Override
        public void remove() {
            if (mc!=MC){
                throw new RuntimeException("change the graph");
            }
            iter.remove();
            MC++;
            removeEdge(iter.next().getSrc(),iter.next().getDest());

        }


    }


    @Override
    public Iterator<EdgeData> edgeIter() {
        Iterator<EdgeData> e = new EdgeIterator();
        return e;
    }


    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        if (this.outNode.get(node_id)==null){
            return null;
        }
        Iterator <EdgeData> edge = new EdgeIterator(node_id);

        return  edge;
    }


    @Override
    public NodeData removeNode(int key) {
        String keyS = Integer.toString(key);
        this.sizeNode--;
        this.MC++;
        if (this.inNode.get(key)!=null) {
            for (EdgeData e : this.inNode.get(key).values()) {
                String k = String.valueOf(e.getSrc()) +"."+ String.valueOf(e.getDest());
                System.out.println(k);
                this.Hashedge.remove(k);
                this.sizeEdge--;

            }
        }
        if (this.outNode.get(key)!=null) {
            for (EdgeData e : this.outNode.get(key).values()) {
                String k = String.valueOf(e.getSrc()) +"."+ String.valueOf(e.getDest());
                this.Hashedge.remove(k);
                this.sizeEdge--;
            }
        }
        this.inNode.remove(key);
        this.outNode.remove(key);
        return this.HashNode.remove(keyS);

    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        EdgeData e;
        String Ssrc= String.valueOf(src);
        String Sdest= String.valueOf(dest);
        String ans=Ssrc+"."+Sdest;
        this.outNode.get(src).remove(dest);
        this.inNode.get(dest).remove(src);
        e=this.Hashedge.remove(ans);
        if(e!=null){
            this.sizeEdge--;
            this.MC++;
        }
        return e;
    }


    @Override
    public int nodeSize() {
        return this.sizeNode;
    }

    @Override
    public int edgeSize() {
        return this.sizeEdge;
    }

    @Override
    public int getMC() {
        return this.MC;
    }





}