# OOP_Ex2-README
**314635756_206701187**
**Weighted directed graphs**

In this task, interfaces of:

**1.** Interface of a weighted graph DirectedWeightedGraph

**2.** Algorithm interface on graphs (weighted tuner). DirectedWeightedGraphAlgorithms


**myNode:**

A class that contains all the nodes' data.

**myEdge:** 

A class that contains all the data of the edges.

**gl:**

A class that contains the coordinates of the nodes.

**DWG**

class representing a directional weighted graph,
            Class object:
             HashNode - All nodes
             Hashedge - All edges
             inNode - All incoming edges from the k node.
             outNode - All edges exit k
             sizeNode = The number of nodes in the graph
             sizeEdge = The number of edges in a graph
       

**DWGA:**

A class that implements the DirectedWeightedGraphAlgorithms interface
Class object:
DirectedWeightedGraph dwg- Represents a graph.

**GUIG:**
MYFrame A class that extends JFrame implements ActionListener
This class creates a screen that displays the graph along with the operations of save, load, run and set
MYPanal extends JPanel This class uses graphis and it draws the vertices and sides of the graph for us.

**To load the graph you must add the full address of the file**

The red point symbolizes the direction of the arrow
If the user clicks Save "save me" then the file is saved successfully
If the user clicks on "load me" then the graph will be displayed
If the user clicks on run he can select functions running on the graph such as:
-isconnect
-center
-tsp
-shortestPathDist
-shortestPath
If the user dials a set he can select functions that run on the graph such as:
-add node
-add edge
-remove node
-remove edge

Graph size 1000:

![image](https://user-images.githubusercontent.com/93525881/145729020-8345e1a0-3a72-4d6e-b5b7-2ab96ee35ded.png)


Graph size 10000:

![image](https://user-images.githubusercontent.com/93525881/145729074-bb52e84a-e376-40bc-acd5-997ed148dfa8.png)

Graph size 100000:

![image](https://user-images.githubusercontent.com/93525881/145801850-55daa9da-89c1-43a6-bbfc-0714d5fe42b3.png)

We were unable to run the million vertices because of a memory problem

