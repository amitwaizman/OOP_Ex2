package api;

public class gl implements GeoLocation{
    private double x;
    private double y;
    private double z;

    public gl(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double x() {
        return this.x;
    }

    @Override
    public double y() {
        return this.y;
    }

    @Override
    public double z() {
        return this.z;
    }

    @Override
    public double distance(GeoLocation g) {
        double dx= Math.pow((this.x-g.x()),2);
        double dy=Math.pow((this.y-g.y()),2);
        double dz=Math.pow((this.z-g.z()),2);
        double sum = dx+dy+dz;
        return Math.sqrt(sum);
    }
}
