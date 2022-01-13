package api.GUIG;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MYFram extends JFrame implements ActionListener  {
    List<NodeData> nodeD = new ArrayList<>();

    private JPanel Paneltcp;
    private JLabel tcpSrc;
    private JLabel labelsave;
    private JLabel shorttDIS;
    private JLabel succSave;
    private JTextField tcpTSrc;
    private JButton buttonaddnode;
    private JButton buttonshowtcp;
    List<NodeData> nodes;
    private MenuItem item1;
    private MenuItem item5;
    private MenuItem item2;
    private MenuItem item3;
    private MenuItem item4;
    private MenuItem itemload;
    private MenuItem itemsave;
    private MenuItem item11;
    private MenuItem item22;
    private MenuItem item33;
    private MenuItem item44;
    private MenuBar menuBar;
    private Menu menurun;
    private Menu menuload;
    private Menu menusave;
    private Menu menuset;
    private MYPanal p;
    JFrame f = new JFrame();
    JFrame f1 = new JFrame();
    JFrame f2 = new JFrame();
    JFrame Frambotton;
    JPanel Panelbotton;
    JPanel panel = new JPanel();
    JPanel PanelShorTestPath;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel PanelIsConect = new JPanel();
    JPanel PaneShorTestPathDist;
    private JPanel PanalAddNode;
    private JTextField textweight;
    private JLabel labelweight;
    private JTextField textkey;
    private JLabel labelkey;
    private JTextField textlocationx;
    private JLabel labellocationx;
    private JTextField textlocationy;
    private JLabel labellocationy;
    private JTextField textlocationz;
    private JLabel labellocationz;
    private JButton buttonnode;
    private JLabel shorttttt;
    /////////////////remove
    private JPanel panelremovenode;
    private JTextField textremovekey;
    private JLabel labelremovekey;
    private JButton buttonremovenode;
    /////////////////remove edge
    private JPanel panelremoveedge;
    private JTextField textremovesrc;
    private JLabel labelremovesrc;
    private JTextField textremovedest;
    private JLabel labelremovedest;
    private JButton buttonremoveedge;
    ///////////////////////////////add edge
    private JPanel paneladdedge;
    private JTextField textaddesrc;
    private JLabel labeladdweight;
    private JTextField textaddeweight;
    private JLabel labeladdsrc;
    private JTextField textadddest;
    private JLabel labeladddest;
    private JButton buttonaddedge;
    ///////////////////////////////
    private JTextField text;
    private JTextField text1;
    private JTextField textshort;
    private JTextField textsrc;
    private JTextField textdest;
    private JTextField textbutonD;
    private JTextField textbutonS;
    private JLabel label;
    private JLabel labelbuton;
    private JLabel success;
    private JLabel shortt;
    private JLabel shortsrc;
    private JLabel shortdest;
    private JLabel src;
    private JLabel dest;
    private JLabel success2;
    private JLabel success1;
    private JLabel labeliscon;
    private JButton button;
    private JButton button1;
    private JButton button2;
    private JButton Nbuttonshort;
    private JButton buttonrout;
    private JButton Nbutton2;
    private JButton Nbutton3;
    private JButton Nbutton4;
    DirectedWeightedGraphAlgorithms A;


       public MYFram(DirectedWeightedGraphAlgorithms A) {
        super();
        loadME(A);
        labeliscon = new JLabel("");
        A = new DWGA();
        Frambotton = new JFrame();
        Panelbotton = new JPanel();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paneladdedge = new JPanel();
        PaneShorTestPathDist = new JPanel();
        textshort = new JTextField();

        menuBar = new MenuBar();
        menuload = new Menu("load");
        menurun = new Menu("run");
        menusave = new Menu("save");
        menuset = new Menu("set");
        menuBar.add(menusave);
        menuBar.add(menuload);
        menuBar.add(menuset);
        menuBar.add(menurun);
        this.setMenuBar(menuBar);

        item1 = new MenuItem("isConnect");
        item1.addActionListener(this);
        item11 = new MenuItem("add node");
        item11.addActionListener(this);
        item22 = new MenuItem("add edge");
        item22.addActionListener(this);
        item33 = new MenuItem("remove node");
        item33.addActionListener(this);
        item44 = new MenuItem("remove edge");
        item44.addActionListener(this);
        item2 = new MenuItem("center");
        item2.addActionListener(this);
        item3 = new MenuItem("tcp");
        item3.addActionListener(this);
        item4 = new MenuItem("shortestPath");
        item4.addActionListener(this);
        item5 = new MenuItem("shortestPathDist");
        item5.addActionListener(this);
        itemload = new MenuItem("load me");
        itemload.addActionListener(this);
        itemsave = new MenuItem("save me");
        itemsave.addActionListener(this);


        menuload.add(itemload);
        menusave.add(itemsave);
        menurun.add(item1);
        menurun.add(item2);
        menurun.add(item3);
        menurun.add(item4);
        menurun.add(item5);
        menuset.add(item11);
        menuset.add(item22);
        menuset.add(item33);
        menuset.add(item44);

        shorttDIS = new JLabel("");
        shortt = new JLabel();
        textsrc = new JTextField();
        textdest = new JTextField();
        shortsrc = new JLabel();
        shortdest = new JLabel();
        PaneShorTestPathDist.add(shorttDIS);
        shortsrc = new JLabel("src:");
        PaneShorTestPathDist.add(shortsrc);
        textsrc = new JTextField(5);
        PaneShorTestPathDist.add(textsrc);

        shortdest = new JLabel("dest:");
        textdest = new JTextField(5);
        PaneShorTestPathDist.add(shortdest);
        PaneShorTestPathDist.add(textdest);

        Nbuttonshort = new JButton("Enter");
        Nbuttonshort.addActionListener(this);
        PaneShorTestPathDist.add(Nbuttonshort);

/////////////////////////////////////////rout
        src = new JLabel();
        dest = new JLabel();
        shorttttt = new JLabel("");
        textbutonS = new JTextField();
        textbutonD = new JTextField();
        buttonrout = new JButton();
        PanelShorTestPath = new JPanel();


        PanelShorTestPath.add(shorttttt);
        src = new JLabel("src:");
        PanelShorTestPath.add(src);

        textbutonS = new JTextField(10);
        PanelShorTestPath.add(textbutonS);


        dest = new JLabel("dest:");
        PanelShorTestPath.add(dest);

        textbutonD = new JTextField(10);
        PanelShorTestPath.add(textbutonD);


        buttonrout = new JButton("Enter me");
        buttonrout.addActionListener(this);
        PanelShorTestPath.add(buttonrout);

        this.add(PanelShorTestPath);
        //////////////////////////////////////remove
        panelremovenode = new JPanel();
        textremovekey = new JTextField();
        labelremovekey = new JLabel();
        buttonremovenode = new JButton();

        labelremovekey = new JLabel("key:");
        panelremovenode.add(labelremovekey);
        textremovekey = new JTextField(10);
        panelremovenode.add(textremovekey);

        buttonremovenode = new JButton("Remove Node");
        buttonremovenode.addActionListener(this);
        panelremovenode.add(buttonremovenode);

//        ////////////////////////remove  edege

        panelremoveedge = new JPanel();
        textremovesrc = new JTextField();
        labelremovesrc = new JLabel();
        textremovedest = new JTextField();
        labelremovedest = new JLabel();
        buttonremoveedge = new JButton();

        labelremovesrc = new JLabel("src:");
        panelremoveedge.add(labelremovesrc);
        textremovesrc = new JTextField(10);
        panelremoveedge.add(textremovesrc);

        labelremovedest = new JLabel("dest:");
        panelremoveedge.add(labelremovedest);
        textremovedest = new JTextField(10);
        panelremoveedge.add(textremovedest);


        buttonremoveedge = new JButton("Remove Edge");
        buttonremoveedge.addActionListener(this);
        panelremoveedge.add(buttonremoveedge);


        /////////////////////////add node

        labelkey = new JLabel();
        textkey = new JTextField();
        labelweight = new JLabel();
        textweight = new JTextField();
        labellocationx = new JLabel();
        textlocationx = new JTextField();
        labellocationy = new JLabel();
        textlocationy = new JTextField();
        labellocationz = new JLabel();
        textlocationz = new JTextField();
        buttonnode = new JButton();
        PanalAddNode = new JPanel();

        labelkey = new JLabel("key:");
        PanalAddNode.add(labelkey);
        textkey = new JTextField(10);
        PanalAddNode.add(textkey);

        labelweight = new JLabel("weight:");
        PanalAddNode.add(labelweight);
        textweight = new JTextField(10);
        PanalAddNode.add(textweight);

        labellocationx = new JLabel("locationx:");
        PanalAddNode.add(labellocationx);
        textlocationx = new JTextField(10);
        PanalAddNode.add(textlocationx);

        labellocationy = new JLabel("locationy:");
        PanalAddNode.add(labellocationy);
        textlocationy = new JTextField(10);
        PanalAddNode.add(textlocationy);

        labellocationz = new JLabel("locationz:");
        PanalAddNode.add(labellocationz);
        textlocationz = new JTextField(10);
        PanalAddNode.add(textlocationz);


        buttonnode = new JButton("Add Node");
        buttonnode.addActionListener(this);
        PanalAddNode.add(buttonnode);

//////////////////////////////////////add edge
        paneladdedge = new JPanel();
        textaddesrc = new JTextField();
        labeladdweight = new JLabel();
        textaddeweight = new JTextField();
        labeladdsrc = new JLabel();
        textadddest = new JTextField();
        labeladddest = new JLabel();
        buttonaddedge = new JButton();


        labeladdsrc = new JLabel("src:");
        paneladdedge.add(labeladdsrc);
        textaddesrc = new JTextField(10);
        paneladdedge.add(textaddesrc);


        labeladddest = new JLabel("dest:");
        paneladdedge.add(labeladddest);
        textadddest = new JTextField(10);
        paneladdedge.add(textadddest);

        labeladdweight = new JLabel("weight:");
        paneladdedge.add(labeladdweight);
        textaddeweight = new JTextField(10);
        paneladdedge.add(textaddeweight);


        buttonaddedge = new JButton("Add Edge");
        buttonaddedge.addActionListener(this);
        paneladdedge.add(buttonaddedge);

//////////////////////////////////////////////////////tsp
        tcpSrc = new JLabel();
        tcpTSrc = new JTextField();
        Paneltcp = new JPanel();
        nodes = new ArrayList<>();
        tcpSrc = new JLabel("node:");
        Paneltcp.add(tcpSrc);
        tcpTSrc = new JTextField(10);
        Paneltcp.add(tcpTSrc);

        buttonaddnode = new JButton("add node to list");
        buttonaddnode.addActionListener(this);
        Paneltcp.add(buttonaddnode);

        buttonshowtcp = new JButton("show tcp");
        buttonshowtcp.addActionListener(this);
        Paneltcp.add(buttonshowtcp);
        /////////////////////////////////////////
        f.setSize(500, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);


        f1.setSize(500, 200);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel1.setLayout(null);
        f1.add(panel1);

        f2.setSize(500, 200);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel2.setLayout(null);
        f2.add(panel2);


        button = new JButton("Loading");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(this);
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        text = new JTextField(50);
        text.setBounds(100, 20, 165, 25);
        panel.add(text);

        f.add(panel);
        success1 = new JLabel("");
        success1.setBounds(10, 110, 300, 25);
        this.add(success1);

        succSave = new JLabel("");
        succSave.setBounds(10, 110, 300, 25);
        panel1.add(succSave);
        success2 = new JLabel("");
        success2.setBounds(10, 110, 300, 25);
        panel2.add(success2);


        //////////////////save
        labelsave = new JLabel();
        button1 = new JButton("saving");
        button1.setBounds(10, 80, 80, 25);
        button1.addActionListener(this);
        panel1.add(button1);

        text1 = new JTextField(50);
        text1.setBounds(100, 20, 165, 25);
        panel1.add(text1);


        //////////////////run

        button2 = new JButton("runing");
        button2.setBounds(10, 80, 80, 25);
        button2.addActionListener(this);
        panel2.add(button2);


//        this.addMouseListener(this);
//        this.addMouseMotionListener(this);
        this.setVisible(true);


    }


    public void loadME(DirectedWeightedGraphAlgorithms ans){
          A=ans;
          p = new MYPanal(A);
          this.add(p);
          repaint();
       this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if (str.equals("load me")) {
            label = new JLabel("load");
            label.setBounds(10, 20, 80, 25);
            panel.add(label);
            f.setVisible(true);
        }

        if (str.equals("Loading")) {
            String t = text.getText();
            System.out.println(t);
            boolean a = this.A.load(t);
            f.setVisible(true);
            p = new MYPanal(A);
            this.add(p);
            repaint();
            if (a) {
                this.setContentPane(p);
                System.out.println("good job");
                f.setVisible(false);
                this.setVisible(true);

            } else {
                System.out.println("Try Again");
                success.setText("Try Again");

            }

        }

        if (str.equals("save me")) {
            labelsave = new JLabel("save");
            labelsave.setBounds(10, 20, 80, 25);
            panel1.add(labelsave);
            f1.setVisible(true);
        }
        if (str.equals("saving")) {
            String t = text1.getText();
            boolean a = false;
            a = this.A.save(t);
            if (a) {
                this.remove(f1);
                this.remove(labelsave);
                this.remove(panel1);
                p = new MYPanal(A);
                this.add(p);
                repaint();
                System.out.println("good job");
                f1.setVisible(false);
                this.setVisible(true);
            } else {
                succSave.setText("Try Again");

            }
        }

        if (str.equals("isConnect")) {
            this.remove(PanelShorTestPath);
            this.setContentPane(PaneShorTestPathDist);
            this.remove(panelremovenode);
            this.remove(panelremoveedge);
            this.remove(paneladdedge);
            this.remove(PanalAddNode);
            this.add(PanelIsConect);
            this.setContentPane(PanelIsConect);
            boolean a = this.A.isConnected();
            if (a) {
                this.remove(p);
                labeliscon.setText("TRUE");
                labeliscon.setBounds(10, 20, 80, 50);
                labeliscon.setFont(new Font("MV Boli", Font.TRUETYPE_FONT, 50));
                PanelIsConect.add(labeliscon);
                this.setContentPane(PanelIsConect);
                this.setVisible(true);
            } else {
                this.remove(p);
                labeliscon.setText("False");
                labeliscon.setBounds(10, 20, 80, 50);
                labeliscon.setFont(new Font("MV Boli", Font.TRUETYPE_FONT, 50));
                PanelIsConect.add(labeliscon);
                this.setContentPane(PanelIsConect);
                this.setVisible(true);
            }
        }
        if (str.equals("shortestPathDist")) {
            this.remove(PanelIsConect);
            this.remove(PanelShorTestPath);
            this.remove(panelremovenode);
            this.remove(panelremoveedge);
            this.remove(paneladdedge);
            this.remove(PanalAddNode);
            this.add(PaneShorTestPathDist);
            this.setContentPane(PaneShorTestPathDist);
            this.setVisible(true);
        }
        if (str.equals("Enter")) {
            String a = (String) textsrc.getText();
            String b = (String) textdest.getText();
            PaneShorTestPathDist.remove(textsrc);
            PaneShorTestPathDist.remove(textdest);
            PaneShorTestPathDist.remove(shortsrc);
            PaneShorTestPathDist.remove(Nbuttonshort);
            int src = Integer.parseInt((String) a);
            int dest = Integer.parseInt((String) b);
            double dis = this.A.shortestPathDist(src, dest);
            if(dis!=Double.MAX_VALUE) {
                String aa = String.valueOf(dis);
                textshort = new JTextField(30);
                shortdest.setText("anser:");
                shortdest.setFont(new Font("MV Boli", Font.TRUETYPE_FONT, 20));
                textshort.setText(aa);
                textshort.setFont(new Font("MV Boli", Font.TRUETYPE_FONT, 13));
                PaneShorTestPathDist.add(textshort);
                this.setVisible(true);
            }else{
                shorttDIS.setText("There is no route");
                this.setContentPane(PaneShorTestPathDist);
                this.setVisible(true);
            }
        }

        if (str.equals("center")) {
            this.remove(PaneShorTestPathDist);
            this.remove(PanelIsConect);
            this.remove(PanelShorTestPath);
            this.remove(panelremovenode);
            this.remove(panelremoveedge);
            this.remove(paneladdedge);
            this.remove(PanalAddNode);
            this.remove(p);
            this.update(getGraphics());
            NodeData node = this.A.center();
            p.drawGraph(getGraphics());
            p.drawNode(node, Color.RED, getGraphics());
            this.setVisible(true);

        }
        if (str.equals("shortestPath")) {
            this.remove(PanelIsConect);
            this.remove(PaneShorTestPathDist);
            this.remove(panelremovenode);
            this.remove(panelremoveedge);
            this.remove(paneladdedge);
            this.remove(PanalAddNode);
            this.setContentPane(PanelShorTestPath);
            this.setVisible(true);

        }
        if (str.equals("Enter me")) {
            this.remove(p);
            this.update(getGraphics());
            String a = (String) textbutonS.getText();
            String b = (String) textbutonD.getText();
            int src1 = Integer.parseInt((String) a);
            int dest1 = Integer.parseInt((String) b);
            nodeD = this.A.shortestPath(src1, dest1);
            if (nodeD != null) {
                p.drawGraph(getGraphics());
                p.drawRout(nodeD, getGraphics());
                this.setVisible(true);
            } else {
                shorttttt.setText("There is no route");
                this.setContentPane(PanelShorTestPath);
                this.setVisible(true);
            }
        }

        if (str.equals("tcp")) {
            this.remove(PanelIsConect);
            this.remove(PaneShorTestPathDist);
            this.remove(PanelShorTestPath);
            this.remove(panelremoveedge);
            this.remove(panelremovenode);
            this.remove(paneladdedge);
            this.remove(PanalAddNode);
            this.add(Paneltcp);
            this.setContentPane(Paneltcp);
            this.setVisible(true);

        }
        if (str.equals("add node to list")) {
            this.remove(p);
            this.update(getGraphics());
            String a = (String) tcpTSrc.getText();
            int src1 = Integer.parseInt((String) a);
            NodeData node = this.A.getGraph().getNode(src1);
            nodes.add(node);
        }
        if (str.equals("show tcp")) {
            this.remove(p);
            this.update(getGraphics());
            List<NodeData> tcp = A.tsp(nodes);
            System.out.println(tcp.size());
            p.drawGraph(getGraphics());
            p.drawRout(tcp, getGraphics());

        }

////////////////////////////////////////////////////////////set
        if (str.equals("add node")) {
            this.remove(p);
            this.remove(PanelIsConect);
            this.remove(PaneShorTestPathDist);
            this.remove(PanelShorTestPath);
            this.remove(panelremoveedge);
            this.remove(panelremovenode);
            this.remove(paneladdedge);
            this.add(PanalAddNode);
            this.setContentPane(PanalAddNode);
            this.setVisible(true);

        }

        if (str.equals("Add Node")) {
            this.remove(p);
            this.update(getGraphics());
            String key1 = (String) textkey.getText();
            String weight1 = (String) textweight.getText();
            String loctionx1 = (String) textlocationx.getText();
            String loctionY2 = (String) textlocationy.getText();
            String loctionZ3 = (String) textlocationz.getText();

            int key11 = Integer.parseInt((String) key1);
            double weight11 = Double.parseDouble((String) weight1);
            double loctionx11 = Double.parseDouble((String) loctionx1);
            double loctionY11 = Double.parseDouble((String) loctionY2);
            double loctionZ11 = Double.parseDouble((String) loctionZ3);
            GeoLocation geo = new gl(loctionx11, loctionY11, loctionZ11);
            NodeData ans = new myNode(geo, key11, weight11, "", 0);

            A.getGraph().addNode(ans);
            p.drawGraph(getGraphics());
            this.setVisible(true);
        }
////////////////////////////////////////////////////addedge
        if (str.equals("add edge")) {
            this.remove(p);
            this.remove(PanelIsConect);
            this.remove(PaneShorTestPathDist);
            this.remove(PanelShorTestPath);
            this.remove(panelremoveedge);
            this.remove(panelremovenode);
            this.remove(PanalAddNode);
            this.add(paneladdedge);
            this.setContentPane(paneladdedge);
            this.setVisible(true);
        }

        if (str.equals("Add Edge")) {
            this.remove(p);
            this.update(getGraphics());
            String src1 = (String) textaddesrc.getText();
            String weight1 = (String) textaddeweight.getText();
            String dest1 = (String) textadddest.getText();

            int src11 = Integer.parseInt((String) src1);
            int dest11 = Integer.parseInt((String) dest1);
            double weight11 = Double.parseDouble((String) weight1);

            EdgeData ans = new myEdge(src11, dest11, weight11);
            A.getGraph().connect(src11, dest11, weight11);
            p.drawGraph(getGraphics());
            p.drawEdge(ans, Color.red, getGraphics());

            this.setVisible(true);
        }


////////////////////////remove node////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (str.equals("remove node")) {
            this.remove(PanelIsConect);
            this.remove(PaneShorTestPathDist);
            this.remove(PanelShorTestPath);
            this.remove(panelremoveedge);
            this.remove(paneladdedge);
            this.remove(PanalAddNode);
            this.add(panelremovenode);
            this.setContentPane(panelremovenode);
            this.setVisible(true);
        }


        if (str.equals("Remove Node")) {
            this.remove(p);
            this.update(getGraphics());
            String key1 = (String) textremovekey.getText();
            int key11 = Integer.parseInt((String) key1);
            A.getGraph().removeNode(key11);
            p.drawGraph(getGraphics());
            this.setVisible(true);
        }

        if (str.equals("remove edge")) {
            this.remove(PanelIsConect);
            this.remove(PaneShorTestPathDist);
            this.remove(PanelShorTestPath);
            this.remove(panelremovenode);
            this.remove(paneladdedge);
            this.remove(PanalAddNode);
            this.add(panelremoveedge);
            this.setContentPane(panelremoveedge);
            this.setVisible(true);
        }
        if (str.equals("Remove Edge")) {
            this.remove(p);
            this.update(getGraphics());
            String srcE = (String) textremovesrc.getText();
            int srcE1 = Integer.parseInt((String) srcE);
            String destE = (String) textremovedest.getText();
            int destE1 = Integer.parseInt((String) destE);
            ;
            A.getGraph().removeEdge(srcE1, destE1);
            p.drawGraph(getGraphics());
            this.setVisible(true);

        }

    }


//    public static void main(String[] args) {
//        MYFram A = new MYFram();
//    }
}