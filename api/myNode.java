package api;

public class myNode implements NodeData, Comparable<myNode>{
    private GeoLocation location;
    private  int key;
    private double weight;
    private String info;
    private  int tag;

    public myNode(GeoLocation location, int key, double weight, String info, int tag) {
        this.location = location;
        this.key = key;
        this.weight = weight;
        this.info = info;
        this.tag = tag;

    }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public GeoLocation getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.location=p;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight=w;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info=s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag=t;
    }

    @Override
    public int compareTo(myNode o) {
        return Double.compare(this.weight, o.getWeight());
    }
}

