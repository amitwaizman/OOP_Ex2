package api.GUIG;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


public class MYPanal extends JPanel {
    LinkedHashMap<String, EdgeData> ansE = new LinkedHashMap<>();
    LinkedHashMap<String, NodeData> ansN = new LinkedHashMap<>();
    int h;
    int w;
    DirectedWeightedGraphAlgorithms A;

    MYPanal(DirectedWeightedGraphAlgorithms G) {
        super();
        this.setPreferredSize(new Dimension(800, 800));
        h = this.getHeight();
        w = this.getWidth();
        A = G;

    }


    public void paint(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.red);
        drawGraph(g);

    }


    private List<EdgeData> edgeslist(List<NodeData> node) {
        List<EdgeData> ans = new ArrayList<>();
        for (int i = 0; i < node.size() - 1; i++) {
            EdgeData e = A.getGraph().getEdge(node.get(i).getKey(), node.get(i + 1).getKey());
            ans.add(e);
        }
        return ans;
    }

    public void drawRout(List<NodeData> node, Graphics g) {
        for (int i = 0; i < node.size(); i++) {
            NodeData point = node.get(i);
            drawNode(point, Color.red, g);

        }
        List<EdgeData> EG = edgeslist(node);
        for (int i = 0; i < EG.size(); i++) {
            EdgeData a = EG.get(i);
            drawEdge(a, Color.red, g);
        }


    }


    public void drawGraph(Graphics g) {
        Iterator<NodeData> points = A.getGraph().nodeIter();
        while (points.hasNext()) {
            NodeData point = points.next();
            g.setColor(new Color(26, 22, 22));
            drawNode(point, Color.BLACK, g);

        }
        Iterator<EdgeData> edge = A.getGraph().edgeIter();
        while (edge.hasNext()) {
            EdgeData point = edge.next();
            g.setColor(new Color(26, 22, 22));
            drawEdge(point, Color.BLACK, g);

        }

    }


    public void drawNode(NodeData node, Color c, Graphics g) {
        Iterator<NodeData> points = A.getGraph().nodeIter();
        h = this.getHeight() - 150;
        w = this.getWidth() - 150;

        double x = node.getLocation().x();
        double y = node.getLocation().y();
        double[] ans = maxmin(points);
        Double xdis = ans[2] - ans[0];
        double xx = ((w / xdis) * (node.getLocation().x() - ans[0]));
        Double ydis = ans[3] - ans[1];
        double yy = ((h / ydis) * (node.getLocation().y() - ans[1]));
        g.setColor(c);
        g.drawString("" + node.getKey(), (int) xx, (int) yy - 2 * 10);
        g.fillOval((int) xx, (int) yy, 10, 10);
    }

    public void drawEdge(EdgeData e, Color c, Graphics g) {
        h = this.getHeight() - 150;
        w = this.getWidth() - 150;
        Iterator<NodeData> points = A.getGraph().nodeIter();
        GeoLocation a = A.getGraph().getNode(e.getSrc()).getLocation();
        GeoLocation b = A.getGraph().getNode(e.getDest()).getLocation();
        double[] ans1 = maxmin(points);
        Double xdis = ans1[2] - ans1[0];
        double xx = ((w / xdis) * (a.x() - ans1[0]));
        double xx2 = ((w / xdis) * (b.x() - ans1[0]));
        Double ydis = ans1[3] - ans1[1];
        double yy = ((h / ydis) * (a.y() - ans1[1]));
        double yy2 = ((h / ydis) * (b.y() - ans1[1]));
        g.setColor(c);
        g.drawLine((int) (xx), (int) (yy + 10), (int) (xx2), (int) (yy2 + 10));

        g.setColor(Color.red);
        if (xx > xx2 && yy > yy2) {
            g.fillOval((int) (xx2 + 5), (int) (yy2 + 6), 4, 5);
        } else if (xx > xx2 && yy < yy2)
            g.fillOval((int) (xx2 + 5), (int) (yy2 - 6), 4, 5);
        else if (xx < xx2 && yy > yy2)
            g.fillOval((int) (xx2 - 5), (int) (yy2 + 6), 4, 5);
        else
            g.fillOval((int) (xx2 - 5), (int) (yy2 - 6), 4, 5);
    }


    public double[] maxmin(Iterator<NodeData> a) {
        double[] ans = new double[4];
        double minx = Integer.MAX_VALUE;
        double miny = Integer.MAX_VALUE;
        double maxX = Integer.MIN_VALUE;
        double maxY = Integer.MIN_VALUE;
        while (a.hasNext()) {
            NodeData node = a.next();
            double x = node.getLocation().x();
            double y = node.getLocation().y();
            double z = node.getLocation().z();
            if (x < minx) {
                minx = x;
            }
            if (y < miny) {
                miny = y;
            }

            if (x > maxX) {
                maxX = x;
            }
            if (y > maxY) {
                maxY = y;
            }
        }

        ans[0] = minx;
        ans[1] = miny;
        ans[2] = maxX;
        ans[3] = maxY;
        repaint();
        return ans;
    }


}